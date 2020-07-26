# Cake Manager Service
Introduction
-------------
The Cake Manager Service is one of its kind Microservice that has been implemented using the 
latest tech stack i.e. Java 1.8, Springboot 2.3.1.RELEASE, Open API, H2 in-memory database. The
service let's the cake lovers with below cool features 

1. /cakes (GET) : Users can see all the cakes on offer in the Json format & they can download it too
2. / (GET)      : This is the index page which let's users see the cakes in a human readable format with the 
mouth watering pictures of the cakes 
3. /cakes (POST) : Users can add new cakes to the store
4. /swagger-ui.html : Users can see all the Rest endpoints supported & they can try the endpoints out using the 
most user friendly user interface


Design
------

The service has been built using the below components

1. IndexController : It is responsible for responding to the "/" (default) request by returning the cakes in the 
human readable format (HTML). The response is nicely rendered by the browser in a tabular form dispalying the 
title, description & the colourful image of the cake. It leverages the CakeManagerController to retrieve all
the cakes from store in a json format & applies thymeleaf html templates to give the final response back to the 
browser

2. CakeManagerController : It is the main controller that provides 2 restful endpoints which are accessed 
using /cakes . The description of the both is as given below

a. /cakes (GET)     : This endpoint lets users see/download all the available cakes in Json format
b. /cakes (POST)    : This endpoint lets users add their cakes to the store.

3. InitialDataLoad : This component is responsible for loading the initial inventory of all the cakes 
in the database. The source of initial cake data is configurable with the help of property "init.cakes.download.url" 
in src/main/resources/application.properties






