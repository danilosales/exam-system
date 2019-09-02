# Exam System

Caso deseje visualizar esta descrição em inglês, acesse este [link](README.md).

A arquitetura do projeto foi montado utilizando as seguintes tecnologias:

* Spring Boot - para construção da aplicação em java
* H2 - Base de dados em memoria para persistência das instituitções e exames.
* Swagger - Usado para docuemntar os serviços

## Instruções para executar o projeto


Após realizar o download do projeto, executar os seguintes comandos:

```sh
 mvn clean package
```
Este comando acima irá compilar a aplicação que irá gerar um arquivo jar na pasta target. Caso deseje subir a aplicação em um container executar o seguinte comando:

```sh
docker-compose up
```

Caso deseje que se execute em background adicionar o parametro -d ao final:

```sh
docker-compose up -d
```

Caso seje necesário refazer o build utilizar o seguinte comando:

```sh
docker-compose up --build
```

Endereços disponíveis:

* [Documentação dos serviços](http://localhost:8080/swagger-ui.html)

* [URL Base para os serviços](http://localhost:8080/api/)


#### Considerações Finais

* Como a especificação do projeto estava escrito em inglês, acabei escrevendo o código utilizando o inglês, juntamente com a documentação pois não sabia se era um requisito. De qualquer forma escrevi um README.md em português também.

* Em relação as entidades, eu criaria mais duas que seria a do Paciente e Médico para que fique isolado do exame. Sendo assim acabei utilizando o CNPJ para validar se já existia uma instituição cadastrada, e para o Exame utilizei o nome do Paciente, Instituição e procedimento, não utilizei o médico pois o mesmo exame pode ser solicitado por outro médico.

* Uma das regras de	negócio era de que uma instituição não poderia ter acesso aos exames de outra. Para esta regra, pensando em uma estrutura de microserviços poderia aplicar a autenticação através de um API Gateway, com esta informação poderiamos obter a instituição que realizou o login, com isto não haveria necessidade do parâmetro institutionId nas chamadas para excluir um exame e buscar um exame por id.

* Outra possibilidade para a alternativa acima era de se mapear os exames dentro do recurso da instituição (Ex.: /api/institutions/{idInstituicao}/exams), dessa forma não haveria necessidade do parametro institutionId. Não implementei desta forma pois pensei no exame como uma entidade separada, pois caso a regra de negócio mudasse e possa buscar um exame previamente cadastrado por outra entidade sem o desconto em sua carteira, o mesmo não estaria associado a uma instituição.

* Sugestão de utilizar um service discovery e aplicar autenticação aos serviços.


