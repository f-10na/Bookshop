/**
 * 
 */
package coursework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author fionakissi
 *
 */
public class Ebooks extends Books{
	private String format;
	private int numberOfPages;
	public Ebooks(int barcode, String bookType, String title, String language, String genre, LocalDate releaseDate,
			int quantityInStock, double retailPrice,int numberOfPages,String format) {
		super(barcode, bookType, title, language, genre, releaseDate, quantityInStock, retailPrice);
		this.format = format;
		this.numberOfPages = numberOfPages;
	}
	//getters and setters to encapsulate and control access and modification
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	// The 'toString' method has been overridden from the parent class to provide a custom implementation for the 'Ebooks' class.
    // This is an example of Polymorphism, as the method behaves differently in the parent and child class.
	@Override
	public String toString() {
	return String.format("%d, %s, %s, %s, %s, %s, %d, %.2f, %d, %s",
	                getBarcode(), getFormat(), getTitle(), getLanguage(), getGenre(),
	                getReleaseDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
	                getQuantityInStock(), getRetailPrice(), getNumberOfPages(),getFormat());
	    }
	
}
