package com.urlshortener.services;

import com.urlshortener.dto.UrlLongRequest;
import com.urlshortener.entities.Url;
import com.urlshortener.repositories.UrlRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UrlService {

    @Autowired
    private UrlRepository repository;
    @Autowired
    private BaseConverter converter;

    public String convertToShortUrl(UrlLongRequest request){
        Url url = new Url(request.getLongUrl(), request.getExpiresDate());
        var entity = repository.save(url);
        return converter.encode(entity.getId());
    }

    public String getOriginalUrl(String shortUrl){
        var id = converter.decode(shortUrl);
        var entity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no entity with " + shortUrl));

        if(entity.getExpiresDate() != null && entity.getExpiresDate().before(new Date())){
            repository.delete(entity);
            throw new EntityNotFoundException("Link expired!");
        }

        return entity.getLongUrl();
    }

}
