# librarydemo!!!
Created a demo app for CBA.

It exposes the below rest API's

<img width="1507" alt="Screen Shot 2022-03-17 at 8 55 13 pm" src="https://user-images.githubusercontent.com/19218386/158784113-f698a792-fdb4-4c92-bbdc-439efd8d8468.png">


Swagger URL:

http://localhost:8080/swagger-ui/index.html


<h1> App Feature Description</h1>
<div>
<ul>
<li>JDK 17</li>
<li>Maven Build</li>
<li>Spring boot web – (For exposing REST API’s)</li>
<li>Spring boot JPA – (For CRUD operations)</li>
<li>Spring boot Test – (For creating unit test cases)</li>
<li>Spring boot Actuator – (For monitoring the application health)</li>
<li>Spring boot Security – (for securing REST API’s)</li>
<li>Spring boot Validation – ( For native & Custom bean validation)</li>
<li>Spring Kafka – (For producing & Consuming messages for Kafka)</li>
<li>Spring Doc – (for Open API document specification)</li>
<li>Java MySQL Connector – (for accessing MySQL database)</li>
<li>LAMBOG – (For avoid boiler plate code)</li>
<li>GitHub – (For version control )</li>
<li>VS Code – (IDE for web development)</li>
<li>Kafka – For message queues</li>
<li>MySQL – For database</li>
</ul>
</div>


<h1> Java Calss Description</h1>
<div>
<ul>
<li>config/ErrorHandlingControllerAdvice .java - Custom global error handling for Rest API's</li>
<li>config/ISBNValidation. java - Custom Bean Annotation for ISBN number</li>
<li>config/ISBNValidator.java - Custom validation for ISBN number</li>
<li>config/KafkaConsumerConfig.java - Auto configuration for Kafka consumer</li>
<li>config/KafkaProducerConfig. java - Auto configuration for Kafka Producer</li>
<li>config/KafkaTopicConfig. java - Kafka Server and Topic configuration</li>
<li>controller/BookController.java - Exposes rest API's for the library</li>
<li>model/Book. java - Entity/Bean class for Book</li>
<li>model/ValidationErrorResponse. java - Model wrapper for custom error handling</li>
<li>model/Violation. java - Model for custom error handling</li>
<li>presistence/BookRepository.java - Native ORM for CRUD operations</li>
<li>presistence/CustomBookRepo.java - Interface for Custom ORM</li>
<li>presistence/CustomRepoImpl.java - Implementation for Custom ORM</li>
<li>service/BookService. java.  - Controller for exposing API’s</li>
<li>LibrarydemoApplication.java. - Spring boot App initialiser</li>
<li>/resources/application.properties- Application configuration file</li>
<li>/resources/data.sql - SQL queries for inserting Mock Data</li>
<li>/test/LibraryDemoApplicationTest.java - Unit test cases for REST API’s contoller methods</li>
<li>/pom.xml - Maven Build file</li>
</ul>
</div>
 
