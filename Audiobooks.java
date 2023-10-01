package coursework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Audiobooks is a subclass of Books, demonstrating the principle of inheritance in OOP.
//It extends the functionality of the Books class by adding properties and behaviors specific to audiobooks.
public class Audiobooks extends Books {

 // These member variables represent the additional attributes of Audiobook.
 private String format;
 private double length;

 // This constructor is an example of the OOP concept of polymorphism through constructor overloading
 // Also, it calls the superclass constructor using the 'super' keyword for inheritance.
 public Audiobooks(int barcode, String bookType, String title, String language, String genre, LocalDate releaseDate,
                   int quantityInStock, double retailPrice, double length, String format) {
     super(barcode, bookType, title, language, genre, releaseDate, quantityInStock, retailPrice);
     this.format = format;
     this.length = length;
 }

 //getters and setters to control access and modification for encapsulation
 public String getFormat() {
     return format;
 }

 public void setFormat(String format) {
     this.format = format;
 }

 public double getLength() {
     return length;
 }

 public void setLength(double length) {
     this.length = length;
 }

 // The toString method here is overridden from the Object class, demonstrating method overriding,
 // a form of runtime polymorphism in OOP. It allows the Audiobooks class to provide its own implementation.
 @Override
 public String toString() {
     return String.format("%d, %s, %s, %s, %s, %s, %d, %.2f, %.1f, %s",
             getBarcode(), getBookType(), getTitle(), getLanguage(), getGenre(), getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), getQuantityInStock(), getRetailPrice(), getLength(), getFormat());
 }
}

