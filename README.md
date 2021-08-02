# Demo Library Application
 
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

This is a small application with systems monitoring system (Grafana and Prometheus) 

The technology behind it:
* Java 11 / Spring Boot
* Grafana
* Prometheus

## Installing / Getting started

#### Using `docker-compose`

In the terminal run the following command:
```console
$ docker-compose up
``` 


#### Using Maven

First compile an application:

```console
$ mvn clean package
```

Then, You can run:

```console
$ mvn spring-boot:run 
```

## Docs

#### Grafana

http://localhost:3000

#### Prometheus 

http://localhost:9090

#### Library API

http://localhost:8080/swagger-ui.html
