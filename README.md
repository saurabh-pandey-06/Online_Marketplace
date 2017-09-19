# Online Marketplace Application #

***This Project is developed as a part of CSCI-50700-23706,
    Object Oriented Designs And Patterns.
    In this, an Online marketplace will be developed (Like Amazon but much smaller),
    where customers and administrators can interact with the system.
    The scope of this project is to implement an online marketplace using Java RMI
    and MVC design pattern. The project will be completed through multiple assignments.***

## Assignment 1 ##

***In this assignment, the aim is to create a domain model for the online marketplace
    identifying all the entites and their funtionalities in the system. Also, creating
    a working model of Java RMI by implementing it through the use of MVC pattern.***

## Assignment 2 ##

***In this assignment, the aim is to enhance the design of the online marketplace system.
    Here, additional design patterns: Front Controller, Abstract Factory and Command pattern
    are integrated within the system.***

## Assignment 3 ##

***In this assignment, the aim is to implement role based access in the online marketplace system.
    Here, additional design patterns: Authorization pattern, Reflection pattern, Dynamic Proxy pattern
    along with Java annotations are integrated within the system.***

## Assignment 4 ##

***In this assignment, the aim is to analyze the role and importance of concurrency in Java and Java RMI
    along with its impact on the online marketplace system. Also, to implement functionalities like 
    Browse Items, Add Item to Cart, Purchase Items and Adding Items in the System***

## Assignment 5 ##

***In this assignment, the aim is to analyze the role and importance of concurrency and synchronization in Java 
    and Java RMI along with its impact on the online marketplace system. In this, design patterns like Monitor Object, 
    Guarded Suspension, Scoped Locking, Future and Thread-Safe Interface patterns were implemented along with all 
    the functionalities of the System***

## Server Machine ##
***in-csci-rrpc01.cs.iupui.edu - 10.234.136.55***

### Steps To Compile and Run: ###
1. Connect to a session of in-csci-rrpc01.cs.iupui.edu - 10.234.136.55 and checkout latest code from master branch.
2. cd csci50700_spring2017_marketplace/
3. make -f makefileServer (Runs the Makefile for server).
4. After the server makefile runs, all the classes will be compiled and the server will be ready.
5. To run the client, open a session on another machine, say in-csci-rrpc02.cs.iupui.edu - 10.234.136.56.
6. cd csci50700_spring2017_marketplace/
7. make -f makefileClient (Runs the Makefile for client).
8. User is prompted to either log into the system or to register as a customer. Press 1 and select the login option.
9. User is asked to enter a user name and password. Enter the following to login as administrator:
 * Username : Smith.1 and Password : admin1
10. User is taken to the administrator's landing page.
11. User is prompted with choices: 1. Browse Items; 2. Add Items In System; 3. Remove Item From System; 4. Update Item In System; 5. Exit.
12. Choose any option and the corresponding functionality will be performed and system then returns to step 11 (If choice 5 is not chosen).
    ***Note: With option 2 (Similarly with option 4 for some parameters), user will be prompted to enter additional details about the product.
    Please enter data with following data types without any blank spaces.
    ProductID: String (Eg. P5)
    Product Name: String (Eg. Pixel)
    Product Type: String (Eg. Electronic)
    Product Description: String(Eg. SmartPhone) (Similarly with option 4)
    Product Quantity: Int(Eg. 10) (Similarly with option 4)
    Product Price: Double (Eg. 800) (Similarly with option 4)***
    Entering above details, system displays the success message.
12. To run another client, open a session on another machine, say in-csci-rrpc04.cs.iupui.edu - 10.234.136.58.
13. Repeat steps 6 & 7.
14. Steps 8 and 9 are repeated. However, this time use the following credentials to login as customer.
 * Username : Saurabh.6 and Password : customer6
15. User is taken to the customer's landing page.
16. User is prompted with choices: 1. Browse Items; 2. Add Item To Cart; 3. Remove Item From Cart; 4. Purchase Item; 5. Exit.
17. Choose any option and the corresponding functionality will be performed and system then returns to step 16 (If choice 5 is not chosen).
    ***Note: With option 2, user will be prompted to enter additional details.
    Please enter data with following data types without any blank spaces.
    ProductID: String (Eg. P1)
    Quantity: Int (Eg. 2)***
    Entering above details, system displays the success message.
18. System will keep looping until user chooses to exit.

#### NOTE: Entering any incorrect data whenever prompted might terminate the system in some cases. ####

### Current Functionalities: ###
* User Login
* Browsing Items
* Adding Items To Cart
* Removing Items From cart
* Purchasing Items
* Adding Items In System
* Removing Items From system
* Updating Items In system
                           
## Author: ##
***Saurabh Pramod Pandey <br />***
***2000201934 <br />***
***pandey@iupui.edu***
