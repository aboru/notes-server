# Notes

A simple RESTful, JSON API that can power a note-taking application.

### Details

The API lives on an embedded Jetty container which will bind to port :8080 on 
the host machine. The project uses a Gradle wrapper which should work on any 
platform and does not require gradle to be installed. 

#### How To Run

On a *nix system use the following command from the project root.

> $ ./gradlew bootRun

On a Windows system, use the following command from the project root.

> $ gradlew bootRun

#### How To Stop

Make a POST to `localhost:8080/api/shutdown`

> $ curl -X POST localhost:8080/api/shutdown

** Killing the Gradle process using ctrl+c will stop the application context; 
however, in some environments this will not stop the Jetty server which would 
then need to be killed off manually.

If you need to manually kill the process, on *nix you can use `fuser -k 8080/tcp`
