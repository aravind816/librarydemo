INSERT INTO library.book (id,author,createtime,isbn,published,title,updatetime) VALUES
	 (1,'Superman','2022-02-26',1234567890122,'2021-10-26','Batman is irritating.','2022-02-26'),
	 (2,'Batman','2022-02-26',1234567890121,'1990-01-30','Superman is Fake','2022-02-26'),
	 (3,'Joker','2022-02-26',1234567890123,'1999-01-30','I love you Batman','2022-02-26'),
	 (4,'SuperGirl','2022-02-26',1234567890124,'2020-01-30','I love you Batman 1000 times more than Super man','2022-02-26'),
	 (5,'Spiderman','2022-02-27',1234567890125,'2020-02-26','With great power comes great responsibility','2022-02-27');

/*config/ErrorHandlingControllerAdvice .java - Custom global error handling for Rest API's
config/ISBNValidation. java - Custom Bean Annotation for ISBN number
config/ISBNValidator.java - Custom validation for ISBN number
config/KafkaConsumerConfig.java - Auto configuration for Kafka consumer
config/KafkaProducerConfig. java - Auto configuration for Kafka Producer
config/KafkaTopicConfig. java - Kafka Server and Topic configuration
controller/BookController.java - Exposes rest API's for the library
model/Book. java - Entity/Bean class for Book
model/ValidationErrorResponse. java - Model wrapper for custom error handling
model/Violation. java - Model for custom error handling
presistence/BookRepository.java - Native ORM for CRUD operations
presistence/CustomBookRepo.java - Interface for Custom ORM
presistence/CustomRepoImpl.java - Implementation for Custom ORM 
service/BookService. java.  - Controller for exposing API’s
LibrarydemoApplication.java. - Spring boot App initialiser
/resources/application.properties- Application configuration file
/resources/data.sql - SQL queries for inserting Mock Data
/test/LibraryDemoApplicationTest.java - Unit test cases for REST API’s contoller methods
/pom.xml - Maven Build file
*/