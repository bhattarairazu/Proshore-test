
## Documentation

Inorder to run the project, 
- Just clone the project in your current environment.
- Make sure Java with version 1.8 and Maven is installed on the machine.
- Add below properties file in the application.properties inside resource.
```
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

```
#### Library Used
- H2 is used as an in-memory database, so no need to configure the database.
- Hibernate is used as ORM 
- Junit is Used for writing test cases
- Lombork is used to reduce boilerplate code from Model

#### Steps to Run the Project 
- ```mvn clean install ```
   
   It will basically download all the packages jar file from remote server

- ```mvn  test```

    It will basically run the test for the application

- ```mvn clean package```

    This command generates the jar file of the package which is inside /target folder

- ```java -jar <filename.jar>```

    This will run the spring boot application with tomcat as inbuilt server on default port no : 8080
#### To Test the application manually
- Open Postman or any Testing tools
    
    Type the below url in postman and pass the given set of datas as input in json format in request body
    
    ```POST : http:\\localhost:8080\v1\battery\save```

  ```json
  [
      {
        "name": "Cannington",
        "postcode": "6107",
        "capacity": 13500
    },
    {
        "name": "Midland",
        "postcode": "6057",
        "capacity": 50500
    },
    {
        "name": "Hay Street",
        "postcode": "6000",
        "capacity": 23500
    },
    {
        "name": "Mount Adams",
        "postcode": "6525",
        "capacity": 12000
    },
    {
        "name": "Koolan Island",
        "postcode": "6733",
        "capacity": 10000
    },
    {
        "name": "Armadale",
        "postcode": "6992",
        "capacity": 25000
    },
    {
        "name": "Lesmurdie",
        "postcode": "6076",
        "capacity": 13500
    },
    {
        "name": "Kalamunda",
        "postcode": "6076",
        "capacity": 13500
    },
    {
        "name": "Carmel",
        "postcode": "6076",
        "capacity": 36000
    },
    {
        "name": "Bentley",
        "postcode": "6102",
        "capacity": 85000
    },
    {
        "name": "Akunda Bay",
        "postcode": "2084",
        "capacity": 13500
    },
    {
        "name": "Werrington County",
        "postcode": "2747",
        "capacity": 13500
    },
    {
        "name": "Bagot",
        "postcode": "0820",
        "capacity": 27000
    },
    {
        "name": "Yirrkala",
        "postcode": "0880",
        "capacity": 13500
    },
    {
        "name": "University of Melbourne",
        "postcode": "3010",
        "capacity": 85000
    },
    {
        "name": "Norfolk Island",
        "postcode": "2899",
        "capacity": 13500
    },
    {
        "name": "Ootha",
        "postcode": "2875",
        "capacity": 13500
    },
    {
        "name": "Kent Town",
        "postcode": "5067",
        "capacity": 13500
    },
    {
        "name": "Northgate Mc",
        "postcode": "9464",
        "capacity": 13500
    },
    {
        "name": "Gold Coast Mc",
        "postcode": "9729",
        "capacity": 50000
    }]
    ```
    For getting battery stat and list of names sorted alphabetically
    Pass start and end as query paramter inorder to get the inbetween range of batteries

    ```GET: http:\\localhost:8080\v1\battery\postcode?start=10&end=20000```

    The Response format would look like this.

    ```json
    {
    "average": 25416.666666666668,
    "sum": 152500.0,
    "batteriesName": [
        "Akunda Bay",
        "Kent Town",
        "Norfolk Island",
        "Ootha",
        "University of Melbourne",
        "Werrington County"
    ]
    }
```
