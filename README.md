# Deck of Cards
Deck of Cards API

This project has been generated using spring-boot from

## Pre-requisite
- Java 17+
- Maven 3.x

## Api

The current build uses the default port 8080. 

Starting the API from the command line: `mvn spring-boot:run`

Ex: http://locahost:8080/deckofcards

| description                | Entry point               |
|----------------------------|---------------------------|
| show the deck              | GET /deckofcards          |
| current size of the deck   | GET /deckofcards/size     |
| create a new deck of cards | POST /deckofcards         |
| shuffle the deck of cards  | PUT /deckofcards/shuffle  |
| deal one card              | POST /deckofcards/dealone |

A postman file to test the api is available under /src/test/postman