
# ManorHillDemoApplication

This Spring Boot microservice exposes a single API endpoint "/time" that takes a timezone parameter. The API validates that the timezone parameter is within the US timezones and makes a call to the worldtimeapi.org public API to return the abbreviation, timezone, and DateTime fields in JSON format. The application includes unit tests and an integration test, and was built using Java 11 and Spring Boot 2.7.x.




## Steps

- Go to https://start.spring.io/ and select "Maven Project" and "Java" as the project type and language respectively.
- Choose the latest Spring Boot version (2.7.x) and add the following dependencies: "Spring Web" and "Spring Boot DevTools".
- Click "Generate" and download the project as a ZIP file.
- Extract the ZIP file and open the project in your preferred IDE.
- Implement the API endpoint in a new controller class and add validation for the timezone parameter.
- Use the RestTemplate class to make a GET request to the worldtimeapi.org public API and parse the response to return only the required fields.
- Write unit tests for your controller class and an integration test for the API endpoint.
- Build and run the application using Maven.


## Result

- To Run Appplication go to https://timezone-application.netlify.app/
- Choose US timezone as provided in the list and get the result.

![image](https://user-images.githubusercontent.com/86436025/233901209-51df1855-ddfa-432f-a065-ac2c5190c129.png)


- Go to https://example-mhaapplication.onrender.com/time?timezone=America/Chicago
- Below is the result of API response from backend
![image](https://user-images.githubusercontent.com/86436025/233901916-a2b3c692-7b22-420d-8f86-d240510dae56.png)


## Tech Stack

**FrontEnd** Angular, HTML, CSS

**BackEnd** Java, SpringBoot, Docker

**Hosting Sites** Netlify for FrontEnd and render.com for BackEnd


