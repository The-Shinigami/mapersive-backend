# mapersive-backend

# Welcome to the mapersive-backend Documentation

In this documentation, we'll explore the journey of developing the mapersive-backend project, from data analysis to API deployment. The project involves analyzing JSON data, designing a database schema, developing a Spring Boot API, and deploying it using Docker. Follow along as we delve into each step, discussing decisions made, challenges faced, and the solutions crafted. Let's embark on this journey of exploration, development, and deployment together.

## Step 1: Data Analysis
### Analyzing Data with Jupyter Notebook
I utilized a Jupyter Notebook to analyze the provided JSON data. The primary objective was to understand the dataset's structure and content. I extracted valuable insights from the dataset, including information about columns with unique values and their characteristics.

#### Columns with Unique Values
- Policy_id
  - Unique Count: 1200
- Date_of_Purchase
  - Unique Count: 328
- Customer_id
  - Unique Count: 713
- Fuel
  - Unique Values: ['Petrol' 'Diesel' 'CNG']
- VEHICLE_SEGMENT
  - Unique Values: ['B' 'C' 'A']
- Premium
  - Unique Count: 912
- bodily_injury_liability
  - Unique Values: [1 0]
- personal_injury_protection
  - Unique Values: [0 1]
- property_damage_liability
  - Unique Values: [1 0]
- collision
  - Unique Values: [0 1]
- comprehensive
  - Unique Values: [1 0]
- Customer_Gender
  - Unique Values: ['Female' 'Male']
- Customer_Income_group
  - Unique Values: ['25K-$50K' '50K-$75K' '75K-$100K' '0- $25K' '$25-$70K' '>$70K']
- Customer_Region
  - Unique Values: ['South' 'West' 'North' 'East']
- Customer_Marital_status
  - Unique Values: [1 0]

## Step 2: Database Design Decision
After analyzing the data, I faced two options for representing the database schema:

- **Option 1: Normalization into Custom and Insurance Tables**
  - This approach involves breaking down the data into separate tables to optimize storage and minimize data redundancy.

- **Option 2: Single Table Representation**
  - In this approach, all data remains within a single table. Despite potential storage optimization, I noticed that customer information varies from record to record, which could lead to data loss if normalized.

**Conclusion:**
After careful consideration, I have chosen Option 2 (Single Table Representation) as the optimal approach for designing the database schema. This decision ensures data integrity while accommodating the dynamic nature of customer information across records.

## Step 3: Database Selection
### Choosing PostgreSQL as the Relational Database
After considering various database options, I have chosen PostgreSQL as the relational database for this project. PostgreSQL offers several benefits that align well with the project's requirements, including strong support for relational data modeling, ACID compliance, extensibility, and a vibrant open-source community.

## Step 4: API Development
With the database choice in mind, I proceeded with the development of the Spring Boot API. The development process followed these sequential steps:

#### Entity Classes
I started by creating entity classes that correspond to the data model. These classes define the structure of the data that will be stored in the PostgreSQL database. Each entity class is annotated with JPA annotations to facilitate database interaction.

#### DTO (Data Transfer Object) Classes
To separate the internal structure of the application from the external API representation, I created DTO classes. DTOs help ensure a clear separation of concerns and provide a way to control the data exposed through the API.

#### Mapper
I implemented mapper classes to convert between entity objects and DTOs. These mappers ensure a smooth translation between internal data structures and data that is sent and received through the API.

#### Repository
The repository layer includes interfaces that extend Spring Data JPA repositories. These interfaces define methods to interact with the database, such as querying, saving, updating, and deleting records.

#### Services
The service layer contains business logic that handles interactions between the controllers and repositories. It ensures proper validation, transformation, and delegation of tasks.

#### Controller
The controller layer exposes the API endpoints and handles incoming HTTP requests. Each endpoint is mapped to a specific URL and HTTP method. The controller methods use the services to process requests and return appropriate responses.

#### Utilities (Utils)
I created utility classes to handle the representation of API responses. These utility classes encapsulate the structure of response objects and facilitate consistent and standardized responses across the API.

#### API Endpoints
The API development resulted in the creation of four endpoints:

1. **GET /api/insurance**
   - Retrieves a list of insurance records.
2. **POST /api/insurance**
   - Creates a new insurance record.
3. **PUT /api/insurance**
   - Updates an existing insurance record.
4. **DELETE /api/insurance/insuranceId**
   - Deletes an insurance record based on the insurance ID.

## Step 5: API Deployment
#### Generating JAR File
To deploy the Spring Boot API, I generated a JAR (Java Archive) file. The JAR file contains the compiled Java classes, resources, and dependencies required to run the API.

#### Creating Dockerfile
To containerize the API and facilitate deployment across different environments, I created a Dockerfile. The Dockerfile specifies the instructions to build a Docker image that encapsulates the API and its dependencies.

##

## Getting Started

### Prerequisites

To successfully run the mapersive-backend project, ensure you have the following prerequisites installed:

- Java Development Kit (JDK) 17 or later
- Spring Boot CLI 3.2.1 or later
- IntelliJ IDEA (Community or Ultimate Edition)
- PostgreSQL database with the following credentials:
  - Username: postgres
  - Password: PASSWORD
  - Database: myDb

### Clone the Repository

To get the project, you can clone the repository from GitHub using the following command:

- git clone https://github.com/The-Shinigami/mapersive-backend.git
  
### Running the API Locally

- Open IntelliJ IDEA.
- From the welcome screen, choose "Import Project."
- In IntelliJ IDEA, navigate to the "src/main/java" directory.
- Locate the main class MapersiveApplication.
- Right-click on the main class and select "Run MapersiveApplication"
  
**The API should now be accessible at http://localhost:8080.**
