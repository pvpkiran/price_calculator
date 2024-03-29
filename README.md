# Price Calculator
 Given a product and brand, the service will return the price applicable on a specific day. 
 The service expose a REST endpoint to facilitate this.

### Components Used

Java 17  
Springboot  
H2 Database  

### Instructions On How to Run
Springboot application is configured to run on port 9999 with default profile.   
You can kickstart the application by simply running the [PriceCalculatorApplication.java](src/main/java/com/inditex/pricecalculator/PriceCalculatorApplication.java)

The other way is to package the project as and run the jar.   

`
./mvnw clean package     
`  
`
java -jar target/<jar file>
`

Once the application is running you can reach the rest endpoint with the required request body to get the result.  
You can use any REST client to do so. Alternatively if you use intellij IDEA, you can use the attached [http generated_request](spring6-endpoints.http)  

### Tests
Tests are developed using Junit5. There are no unit tests currently. There is an Integration test covering all the scenarios.