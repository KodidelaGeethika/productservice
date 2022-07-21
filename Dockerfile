FROM openjdk:11
ADD target/spring-product-mongo.jar spring-product-mongo.jar
ENTRYPOINT ["java","-jar","spring-product-mongo.jar"]