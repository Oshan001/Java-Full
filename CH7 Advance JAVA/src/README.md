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
![Input Image in folder](multithreading-in-java.png)
* Thread is process
* To multiple process parallely run at a same time
## To create thread :
i.By Inheriting form Thread
ii.By implementing Runnable interface
## Life Cycle of Thread :
## 🧵 Java Thread Life Cycle
![Input Image in folder](Block Diagram of Thread.png)


| **State**        | **Description**                                                      | **Method/Trigger**                                           |
|------------------|----------------------------------------------------------------------|--------------------------------------------------------------|
| **1. New**       | Thread object is created, but not started.                           | `Thread t = new Thread();`                                   |
| **2. Start**     | Calls the `start()` method, moving thread to **Runnable** state.     | `t.start();`                                                 |
| **3. Runnable**  | Thread is ready to run; waiting for CPU.                             | Managed by Thread Scheduler                                  |
| **4. Run**       | When CPU picks the thread, `run()` is executed.                      | Override `run()` method                                      |
| **5. Blocked**   | Thread is blocked (e.g., waiting for a lock).                        | Occurs when accessing a locked synchronized block            |
| **6. Terminated** | Thread finishes execution or is stopped by error.                   |  Happens automatically at end of `run()` or due to exception |

```java
class ThreadDemo implements Runnable {
    Thread t;

    ThreadDemo() {
        t = new Thread(this);
        t.start(); // Fixed: dt -> t
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100); // Fixed: Thread.sleep instead of t.sleep
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadDemo obj = new ThreadDemo();
        ThreadDemo obj1 = new ThreadDemo();
    }
}
```
## Synchronization
* prevent from accusing same resources at a time
#### Type :
**Method Synchronization**
* Synchronizing the entire method to allow only one thread at a time.

**Block Synchronization**
* Synchronizing a specific block of code within a method.<br>
---
eg:
```java
class BankAccount
{
    int Balance =1000;
    public synchronized void withdraw(String n,int amt) {
        if (Balance >= amt) {
            System.out.println("Withdraw Success by :" + n);
            try {
                Thread.sleep(1000);
            }
            catch (Exception e) { }
            Balance -= amt;
        }
        else
        {
            System.out.println("Balance not Enough");
        }
    }
}
```
eg:
```java
class Bankwithdraw extends Thread {
    BankAccount acc;
    String name;
    int amt;

    Bankwithdraw(BankAccount acc, int amt, String name) {
        this.acc = acc;
        this.name = name;
        this.amt = amt; // Corrected from 'a' to 'amt'
    }

    public void run() {
        acc.withdraw(name, amt); // Corrected 'n' to 'name'
    }
}
```
eg:
```java
class Caller
{
    public static void main(String[] args) {
        BankAccount ac = new BankAccount();
        Bankwithdraw obj = new Bankwithdraw(ac,600,"Ram");
        Bankwithdraw obj1 = new Bankwithdraw(ac,500,"Hari");
        obj.start();
        obj1.start();
    }
}
```
---

---
## Design Patten
* Design patterns are proven reusable solution for common problems in Solution design <br>
<u>Types (Creational):</u>

| Pattern Name       | Purpose                                                                         |
|--------------------|---------------------------------------------------------------------------------|
| `Singleton`        | Ensures only one instance of a class is created and provides global access.     |
| `Factory`          | Creates objects without exposing the instantiation logic.                       |
| `Abstract Factory` | Produces families of related objects without specifying concrete classes.       |

#### Example code :
1)Singleton :
![a](Singleton.png)
Singleton is a design pattern that ensures only one object of a class is created and used everywhere.
Example:
Like a TV remote — you only need one remote to control the TV. You don’t create a new one every time.
```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // private constructor
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Caller {
    public static void main(String[] args) {
        Singleton obj = Singleton.getInstance();   //  Correct method call
        Singleton obj1 = Singleton.getInstance();  //  Same instance as above

        // Let's check if both are the same object
        if (obj == obj1) {
            System.out.println("Both are the same instance");
        } else {
            System.out.println("Different instances");
        }
    }
}


```
2)Factory :
![a](Factory.jpg)
Factory pattern is used to create objects without showing the creation logic to the user.
You just tell the factory what you want, and it gives the right object.
Example:
☕ Like ordering a drink from a machine:
You press "Coffee" → it gives coffee.
You press "Tea" → it gives tea.
You don’t know how it’s made — just what you want.
```java
interface Animal {
    void speak();
}

class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

class AnimalFactory {
    public static Animal getAnimal(String type) {
        if ("Dog".equalsIgnoreCase(type)) return new Dog();
        else if ("Cat".equalsIgnoreCase(type)) return new Cat();
        return null;
    }
}
```
<u>Usage :</u>
```java
Animal animal = AnimalFactory.getAnimal("Dog");
animal.speak(); // Output: Woof!
```
3)Abstract Factory :
Abstract Factory pattern provides a way to create a set of related objects (a family) without knowing their exact classes.

Example:
🏭 Like choosing a furniture factory:
You say "Give me Modern furniture" → it gives a Modern chair and table.
Or "Give me Victorian furniture" → you get a Victorian chair and table.
You don’t pick items one by one — the factory gives a whole set based on the style.
```java
// Abstract Products
interface Button {
    void paint();
}

interface Checkbox {
    void render();
}

// Concrete Products for Windows
class WindowsButton implements Button {
    public void paint() {
        System.out.println("Render a Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Render a Windows Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory for Windows
class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}
```
