/**
 * 
 */
package coursework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//'Paperback' is a subclass of the 'Books' class. This is an example of Inheritance, where 'Paperback' inherits the properties and methods of 'Books'.
public class Paperback extends Books {

 // 'condition' and 'numberOfPages' are private attributes of the 'Paperback' class, ensuring these attributes can only be accessed within the 'Paperback' class.
 private String condition;
 private int numberOfPages;

 // This is the constructor for the 'Paperback' class. It first calls the constructor of the parent ('Books') class using 'super',
 // then initialises the 'condition' and 'numberOfPages' attributes
 public Paperback(int barcode, String bookType, String title, String language, String genre, LocalDate releaseDate,
     int quantityInStock, double retailPrice, int numberOfPages, String condition) {
     super(barcode, bookType, title, language, genre, releaseDate, quantityInStock, retailPrice);
     this.condition = condition;
     this.numberOfPages = numberOfPages;
 }

 // The following methods are getters and setters for the 'condition' and 'numberOfPages' attributes.
 // They allow for the attributes to be accessed and modified an application of encapsulatiion
 public String getCondition() {
     return condition;
 }

 public void setCondition(String condition) {
     this.condition = condition;
 }

 public int getNumberOfPages() {
     return numberOfPages;
 }

 public void setNumberOfPages(int numberOfPages) {
     this.numberOfPages = numberOfPages;
 }

 // The 'toString' method is overridden from the 'Books' class to provide a specific implementation for the 'Paperback' class.
 // This is an example of Polymorphism, where the same method behaves differently in the parent and child classes.
 @Override
 public String toString() {
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     return getBarcode() + ", " + getBookType() + ", " + getTitle() + ", " + getLanguage() + ", " + getGenre() + ", " 
     + formatter.format(getReleaseDate()) + ", " + getQuantityInStock() + ", " + getRetailPrice() + ", " 
     + getNumberOfPages() + ", " + getCondition();
 }
 
}

