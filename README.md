# Project 'News'

### Requirements

1. Java 8 installed
2. Prefered IDE installed with ability to install Lombok Plugin
3. Linux OS

__Step 1:__ 
  Make directory "/var/news" : *sudo mkdir /var/news*. This directory will be used for saving log-files which will be 
  created according to date of launching project.

__Step 2:__ 
  Make sure that directory has write privilege for non-root users. Otherwise simply execute *sudo chmode -R a+w /var/news*.

__Step3:__
  Open project in IDE. Install Lombok Plugin and restart IDE. Then while your IDE will be importing libraries enable auto-
  import (it will be proposed to you).
  Build project with *gradle*. In the root directory of the project execute command *./gradlew build* or use built-in IDE 
  command to build with gradle.
  
__Step4:__
  Run project.
  
__Step5:__
  Check status of the server typing *telnet 127.0.0.1 8080*. If you see message *Connected to 127.0.0.1* - server 
  is successfully running.
  
__Step6:__
  Be happy to use this project







