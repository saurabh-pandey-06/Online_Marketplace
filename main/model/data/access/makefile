all: ProductDAO.class AdminDAO.class CustomerDAO.class UserDAO.class ProductDAOImpl.class CustomerDAOImpl.class CartDAOImpl.class AdminDAOImpl.class UserDAOImpl.class

ProductDAO.class: ProductDAO.java
	javac -d ./../../../../out -classpath ./../../../../out ProductDAO.java
AdminDAO.class: AdminDAO.java
	javac -d ./../../../../out -classpath ./../../../../out AdminDAO.java
CustomerDAO.class: CustomerDAO.java
	javac -d ./../../../../out -classpath ./../../../../out CustomerDAO.java
UserDAO.class: UserDAO.java
	javac -d ./../../../../out -classpath ./../../../../out UserDAO.java

ProductDAOImpl.class: ProductDAOImpl.java
	javac -d ./../../../../out -classpath ./../../../../out:./../../../../out/* ProductDAOImpl.java
CustomerDAOImpl.class: CustomerDAOImpl.java
	javac -d ./../../../../out -classpath ./../../../../out:./../../../../out/* CustomerDAOImpl.java
CartDAOImpl.class: CartDAOImpl.java
	javac -d ./../../../../out -classpath ./../../../../out CartDAOImpl.java
AdminDAOImpl.class: AdminDAOImpl.java
	javac -d ./../../../../out -classpath ./../../../../out:./../../../../out/* AdminDAOImpl.java
UserDAOImpl.class: UserDAOImpl.java
	javac -d ./../../../../out -classpath ./../../../../out UserDAOImpl.java
