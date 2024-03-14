# Encurtador de URL com Java e Spring
Este projeto é um encurtador de URL desenvolvido com Java e Spring, permitindo aos usuários converter URLs longas em URLs curtas e redirecionar para os destinos originais. A seguir, você encontrará uma descrição detalhada do projeto, incluindo requisitos funcionais, não funcionais, teoria por trás da conversão de URL, implementação e instruções para configurar e executar o projeto.

## Requisitos Funcionais
- Os usuários devem ser capazes de inserir um URL longo e obter um URL curto correspondente.
- Ao clicar no URL curto, os usuários devem ser redirecionados para o URL longo original.
- Os usuários podem optar por definir uma data de expiração para o URL curto.
- Os usuários devem criar uma conta para usar o serviço (opcional).
- O serviço pode ter limites de uso por usuário (opcional).
- Os usuários podem personalizar seus próprios URLs curtos (opcional).
- O serviço pode fornecer métricas, como links mais visitados (opcional).

## Requisitos Não Funcionais
- O serviço deve estar disponível e operacional 100% do tempo.
- O redirecionamento de URL não deve exceder dois segundos.

## Conversão de URL
O projeto utiliza a conversão de <b>base 62</b> para gerar URLs curtas. Isso permite uma ampla variedade de combinações únicas para os links curtos, garantindo uma distribuição uniforme e evitando colisões. A conversão de base 62 é realizada através de um algoritmo que mapeia números da base 10 para caracteres alfanuméricos ([0-9][az][AZ]).

## Observação
É importante notar que os primeiros links gerados pelo sistema correspondem aos primeiros IDs do banco de dados. Como resultado, esses links serão extremamente curtos, consistindo de apenas algumas letras ou caracteres. À medida que mais links são adicionados ao banco de dados, os links gerados podem se tornar um pouco mais longos, mas ainda respeitando o limite máximo de 7 caracteres estabelecido pelo sistema.

Essa mudança no comprimento dos links ocorre devido à natureza do algoritmo de conversão de base 10 para base 62 utilizado pelo sistema. Conforme mais IDs são gerados e convertidos em links curtos, a distribuição desses IDs se expande, resultando em uma variedade maior de combinações de caracteres alfanuméricos para representar os links curtos.

## Implementação
O projeto foi implementado utilizando o framework Spring Boot e um banco de dados MySQL. A estrutura do projeto inclui pacotes para controladores, entidades, serviços, repositórios, DTOs.
- A classe BaseConverter no pacote de serviços é responsável por converter IDs de base 10 em URLs curtas de base 62 e vice-versa, seguindo o algoritmo mencionado anteriormente.
- A classe UrlService gerencia a lógica de negócios, incluindo a criação de URLs curtas, redirecionamento e manipulação de expiração.
- O controlador UrlController lida com as solicitações HTTP, fornecendo endpoints para criar URLs curtos e redirecionar para URLs originais.

## Configuração e Execução
Para configurar e executar o projeto, siga estas etapas:
1. Clone o repositório do projeto do GitHub.
2. Certifique-se de ter o JDK e o Maven instalados em seu sistema.
3. Configure um banco de dados MySQL e atualize as configurações de banco de dados no arquivo application.properties.
4. Execute o projeto usando o Maven: mvn spring-boot:run.
5. O projeto estará disponível em http://localhost:8080.
