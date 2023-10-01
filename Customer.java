package coursework;
import java.io.*;
import java.util.*;


//The 'Customer' class is extending the 'User' class where Customer' is the child class and 'User' is the parent class.
//'Customer' inherits all attributes and methods of 'User'
public class Customer extends User {
 // 'balance' is a private data member of the 'Customer' class.
 
 private double balance;

 // This is the constructor for the 'Customer' class. It calls the constructor of the parent class 'User' using the 'super' keyword.
 // This constructor also initializes the 'balance' attribute of the 'Customer' class.
 public Customer(int userId, String username, String surname, int houseNumber, String postcode, String city, double balance, String userType) {
     super(userId, username, surname, houseNumber, postcode, city, userType);

     this.balance = balance;
 }
 ArrayList<Books> purchases = new ArrayList<>();
 // The following methods are getter and setter for 'balance'. They are used to access and modify the value of 'balance'.
//allows us to protect them
 public double getBalance() {
     return balance;
 }

 public void setBalance(double balance) {
     this.balance = balance;
 }
 
 @Override
 public String toString() {
     return getUserId() + ", " + getUsername() + ", " + getSurname() + ", " + getHouseNumber() + ", " + getPostcode() + ", " + getCity() + ", " + getBalance() + ", customer";
 }

}

