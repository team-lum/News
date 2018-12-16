# Project 'News'

### Requirements

1. Linux OS (Windows will be supported in next verion) <br/>
2. Java 8, nodejs and npm installed <br/>
3. Prefered IDE installed with ability to install Lombok Plugin <br/>
<hr>

### __Step 1__ 
Make directory "/var/news" : *sudo mkdir /var/news*. This directory will be used for saving log-files which will be created according to date of launching project
<hr>

### __Step 2__ 
Make sure that directory has write privilege for non-root users. Otherwise simply execute *sudo chmode -R a+w /var/news*
<hr>

### __Step3__
Open project in IDE. Install Lombok Plugin and restart IDE. Then while your IDE will be importing libraries enable auto-import (it will be proposed to you).
  
Build project with *gradle*. In the root directory of the project execute command:
- *cd web-front/* <br/>
- *npm install* <br/>
- *cd ..* <br/>
- *./gradlew clean copyWebFront build* <br/>
  <hr>
  
### __Step4__
Run project:
- *java -jar rest-api-service/build/libs/rest-api-service-1.0.0.jar* <br/>
<hr>
  
### __Step5__
Check status of the server typing *telnet 127.0.0.1 8080*. If you see message *Connected to 127.0.0.1* - server is successfully running.
Or just open a [http://localhost:8080](http://localhost:8080) in browser
<hr>
  
### __Step6__
Be happy to use this project


## Docker
To run project with docker (Linux):
- *sudo apt-get install docker-compose* (Or install docker-compose in different way) <br/>
- *./gradlew clean copyWebFront build* (Build project) <br/>
- *sudo docker-compose up* (Build and run docker images. If elk container will fall, follow this [link](https://www.elastic.co/guide/en/elasticsearch/reference/current/vm-max-map-count.html)) <br/>
Or just run: <br/>
-*./gradlew clean copyWebFront build dockerBuild dockerRun* <br/>