# ADVANCE JAVA
## ORM(Object Relation Mapping)
* To map Java object with database
* Database Table to java java object
* ```text
  ORM FRAMEWORK
  * Hibernate
  * JPA
  * Spring Data
  * MyBatis 
  ```
## Hibernate## Hibernate Setup (Using Maven)
1) Create a Maven Project
Use your IDE (e.g., IntelliJ IDEA, Eclipse) to create a new Maven project.
2) Add Dependencies in `pom.xml`
```xml
<dependencies>
  <dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>6.4.4.Final</version>
  </dependency>

  <dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
    <version>3.1.0</version>
  </dependency>

  <dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.33</version>
  </dependency>
</dependencies>
```
3)Create hibernate.cfg.xml inside resource folder
4)create a table
5)create an entity class
6)create a main class to work ORM
##### 📚 Libraries need to Download
* Jakarta Persistence API
* MySQL Connector/J
* Hibernate Core
## Entity Class
```java
@ientity
class employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@column(name = "id")
int id;
@column(name = "emp-name")
String Name;
// getters and setters
   }

```
## <u>Hibernate</u>
```java
class HibernateDemo {
    public static void main(String[] args) throws Exception {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        Employee e = new Employee();
        e.setName("Ram");
        e.setSalary(10000);
        session.persist(e);
        session.getTransaction().commit();
        session.close();
        session = factory.openSession();
        Employee e1 = session.get(Employee.class, 1);
        System.out.println("Name :" + e1.getName());
        session.beginTransaction();
        e1.setSalary(30000);
        session.merge(e1);
        session.getTransaction().commit();
        session.close();
    }
}
```
---
## Web Framework
* Framework design to ease the development of Web Application<br><br>
<u><b>JAVA Base Web Framework : </u></b>
* Spring Boot/ MVC
* JSF(Java Server Faces)
* Struts
<br>
<u><b>Feature :</b></u>
* Security
* Templating
* MVC Patten
* REST
* ORM
--- 


---
## Multi Threading
* Thread is process
* To multiple process parallely run at a same time
* 
---