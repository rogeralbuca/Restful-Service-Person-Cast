# Restful Service Person - Spring Boot - Cast Group
Restful Service using Spring boot, Cast Person Project was built using REST, lightweight web services, easy to maintain and scalable in nature. As it was built in the REST architecture then it is called the RESTful service. The underlying protocol for REST is HTTP, which is the basic web protocol. REST stands for RE Representational State Transfer.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

*Clone or Download* - [Dev Branch](https://github.com/rogeralbuca/Restful-Service-Person-Cast/tree/dev)

### Prerequisites

* [STS](https://spring.io/tools3/sts/) - The Spring Tool Suite 3
* [Postman](https://www.getpostman.com/) - API Development

### Endpoints

|Endpoints|Descriptions|HTTP methods|
|---|---|---|
|/rest/person|List all persons|GET|
|/rest/person/{id}|Find a person by the id |GET|
|/rest/person|Saves a new person|POST|
|/rest/person/|Updates a person|PUT|
|/rest/person/{id}|Deletes one person per id|DELETE|

### Development server

```
http://localhost:8090/rest/person
```

## Built With

* [Spring](http://spring.io/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [h2database](http://h2database.com) - Java SQL database

## Authors

**Roger Albuquerque** - *Initial work* - [rogeralbuca](https://github.com/rogeralbuca/)

See also the list of [contributors](https://github.com/rogeralbuca/Restful-Service-Person-Cast/graphs/contributors) who participated in this project.

## Further help

To get more help go check out the [Spring Guides](http://spring.io/guides).

## Acknowledgments

* Cast Group Recife Team

