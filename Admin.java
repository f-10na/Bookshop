package coursework;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

//The Admin class extends User, meaning that Admin is a subclass of User.
//In object-oriented terms, Admin "is a" User, inheriting all the properties and behaviors of User.
public class Admin extends User {

 // This is the constructor for the Admin class. When an instance of Admin is created,
 // this constructor is called with the specified parameters.
 // The 'super' keyword is used to call the constructor of the parent class (User in this case).
 // This is necessary because Admin is a subclass of User, and we need to ensure that the User part of Admin is properly constructed.
 public Admin(int userId, String username, String surname, int houseNumber, String postcode, String city, String userType) {
     super(userId, username, surname, houseNumber, postcode, city, userType);
 }
 
 @Override
 public String toString() {
     return getUserId() + ", " + getUsername() + ", " + getSurname() + ", " + getHouseNumber() + ", " + getPostcode() + ", " + getCity() + ", " + " " + ", admin";
 }

}
	



