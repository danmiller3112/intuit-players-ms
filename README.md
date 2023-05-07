# Intuit Players Microservice

Hi there.
For run this application:
* 1. mvn clean install
* 2. Just run this application  [PlayersApplication.main()]

Or use the Dockerfile and build a Docker image for this Java SpringBoot microservice:
* placed in the root directory of the project: (Dockerfile)

All settings for this service are located in file [application.properties]
* default url: http://localhost:8080

The service expose two REST endpoints:
* GET /api/players - returns the list of all players.
* GET /api/players/{playerID} - returns a single player by ID.

For testing API a recommend to use a collection for Postman application.
* placed in the root directory of the project: (Intuit.postman_collection.json)

or you can use cURL:

### 1. Retrieve All Players (returns the list of all players)
    curl --location 'http://localhost:8080/api/players'
    
### 2. Retrieve Player By playerId (returns a single player by ID)
    curl --location --globoff 'http://localhost:8080/api/players/{{playerId}}'