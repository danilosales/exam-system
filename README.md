# Exam System

If you wish read the description in portuguese, please [click here](README.pt-BR.md)

The architecture for this project using the following technologies:

* Spring Boot - for build java application.
* H2 - Data base in memory for persistence Healthcare Instituion and Exams.
* Swagger -  Used to describe methods for developers.

## Instructions to run this project


After download project, run the follow command:

```sh
 mvn clean package
```
This command above will compile the application in target folder. If you want to run the application in a docker container, execute this command:

```sh
docker-compose up
```

To run a container in background add -d parameter:

```sh
docker-compose up -d
```

If necessary rebuild a container, execute this command:

```sh
docker-compose up --build
```

Available Interfaces:

* [API documentation](http://localhost:8080/swagger-ui.html)

* [Base URL](http://localhost:8080/api/)


#### Important notes

* Since the project specification was written in English, I write the code in English too, because I didn't know if it waas a requirement. Anyway I wrote another README.md in Portuguese.

* So about the entities, I would crete two more entities: Patient and Physician to be isolated from the exam. Because the actual definition entities, I use CNPJ to validate if there was already a institution in database, and for the exam I used Patient Name, Healthcare Institution and procedure name, I did not use the physician beacause the same exam can be requested by another doctor.

* One of the requirements was that a healthcare institution must not have access to an exam that belongs to other healthcare institution. For this requirement, thinking a microservice could apply authentication through a Gateway API, with this we could get the institution that logged in, so there would be no need for institutionId parameter in delete an exam and get an exam by id.

* Another possibility for the above alternative was to map exams within the institution resource (Ex: /api/institutions/{institutionId}/exams), so there would be no need for the institutionId parameter. I did not implment this altenative, becaise I thought of the exam as a separate entity, because if the requirements changes, you can seek an exam previously registered by another entity without the discount in your budget, it would not be associated with an institution.

* Suggestion of use a service discovery and apply security to access methods.



