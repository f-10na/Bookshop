package coursework;
import java.time.LocalDate;
import java.util.ArrayList;


public class Books 
{
	//private members hidden from other classes but accessed by methods in this class
	private String genre;
	private LocalDate releaseDate;
	private double retailPrice;
	private int barcode;
	private String title;
	private String language;
	private int quantityInStock;
	private String bookType;

	public Books(int barcode,String bookType,String title,String language,String genre,LocalDate releaseDate,int quantityInStock,double retailPrice) 
	{
		//initialise constructors 
		this.genre = genre;
		this.releaseDate = releaseDate;
		this.retailPrice = retailPrice;
		this.barcode = barcode;
		this.title = title;
		this.language = language;
		this.quantityInStock = quantityInStock;
		this.bookType = bookType;
	}
	
	//use getters and setters to encapsulate the information 
	
	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public LocalDate getReleaseDate() {
        return releaseDate;
    }
    
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public double getRetailPrice() {
        return (double) retailPrice;
    }
    
    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }
    
    public int getBarcode() {
        return barcode;
    }
    
    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public int getQuantityInStock() {
        return quantityInStock;
    }
    
    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
	
	

		
}
	
	


