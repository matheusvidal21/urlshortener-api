package com.urlshortener.services;

import org.springframework.stereotype.Service;

@Service
public class BaseConverter {
    private static final String BASE62CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private char[] allowedCharacters = BASE62CHARS.toCharArray();
    private int base = allowedCharacters.length;

    public String encode(long input){
        var encodedString = new StringBuilder();

        if(input == 0){
            return String.valueOf(allowedCharacters[0]);
        }

        while(input > 0){
            encodedString.append(allowedCharacters[(int) (input % base)]);
            input = input / base;
        }

        return encodedString.reverse().toString();
    }

    public long decode(String input){
        var characters = input.toCharArray();
        var length = characters.length;

        var decoded = 0;
        var counter = 1;
        for(int i = 0; i < length; i++){
            decoded += BASE62CHARS.indexOf(characters[i]) * Math.pow(base, length - counter);
            counter++;
        }
        return decoded;
    }

}
