# API-Heroes-Marvel -Spring-WebFlux
API de Gerenciamento de heróis utilizando Spring WebFlux, Reactor, DynamoDB, JUnit e Swagger

## Objetivos

Desenvolver uma API de gerenciamento de heróis utilizando WebFlux, 
tecnologia adotada por empresas como Netflix e Pivotal. Esta API terá um CRUD básico, permitindo cadastrar, listar e excluir heróis do banco de dados.



## Tecnologias

- Java 8
- spring Webflux
- Spring Data
- AWS Dynamodb
- JUnit
- Sl4j
- Reactor


Para executar a API é preciso que o DynamoDB esteja sendo executado localmente. 
Todos os procedimentos para download e execução deste serviço localmente estão disponíveis no site da própria AWS:

https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html

Para execução:

Fazer um fork deste repositório;
Abrir o projeto em sua IDE preferida
Editar o arquivo: src/main/resources/application-sample.properties, inserindo as informações relacionadas à AWS
