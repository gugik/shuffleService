Open command prompt.

To run service-shuffle go to the right package shuffleService\shuffle and run the next command: mvn spring-boot:run

To run service-log go to the right package shuffleService\log and run the next command: mvn spring-boot:run

Send the next HTTP POST request with any number from 1 to 1000:
* url: localhost:8080/test
* body:   {
          "number": 10
          }


Go to started service-log and see the result.
