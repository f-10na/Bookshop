package coursework;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Functions {
//used to read from the Stock.txt to get the book info used in viewbooks and search
	public ArrayList<Books> readFileBooks(String fileName){
		ArrayList<Books> bookList = new ArrayList<Books>();
		Scanner fileScanner = null;
		try {
			File inputFile = new File(fileName);
			fileScanner = new Scanner(inputFile);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			Books book = null;
			while (fileScanner.hasNextLine()) {
				String[] details = fileScanner.nextLine().split(",") ;
				//System.out.println(details[1]);
				if (details[1].trim().equals("paperback")) {
					//System.out.println("TESTING IF THE THING IS WORKY");
					//System.out.println(details[9]);
					book = new Paperback(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),details[3].trim(),details[4].trim(),LocalDate.parse(details[5].trim(),formatter),Integer.parseInt(details[6].trim()),Double.parseDouble(details[7].trim()),Integer.parseInt(details[8].trim()),details[9].trim());
					bookList.add(book); 
				}else if (details[1].trim().equals("audiobook")) {
					//System.out.println(2);
					book = new Audiobooks(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),details[3].trim(),details[4].trim(), LocalDate.parse(details[5].trim(),formatter),Integer.parseInt(details[6].trim()),Double.parseDouble(details[7].trim()),Double.parseDouble(details[8].trim()),details[9].trim());
					bookList.add(book);
				}else if (details[1].trim().equals("ebook")) {
					//System.out.println(3);
					book = new Ebooks(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),details[3].trim(),details[4].trim(),LocalDate.parse(details[5].trim(),formatter),Integer.parseInt(details[6].trim()),Double.parseDouble(details[7].trim()),Integer.parseInt(details[8].trim()),details[9].trim());
					bookList.add(book);
				}
				else {}
				}
				//end of while
			fileScanner.close();
		}
		catch(Exception e) {
			System.err.println("error");
			e.printStackTrace();
		}
		finally {
			if(fileScanner != null) {				
				fileScanner.close();
			}
		}
		return(bookList);
	}
	
	//this file writes to the Stock.txt file 
	public void writePB(String fileName, ArrayList<Paperback> pbList)throws FileNotFoundException{
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName,true)); 
			// false here means that we don't want to append data to the content of the file. 
			// If we need to append, then we should use true.
			// When we don't pass the second parameter (false/true), by default it would be false.
			for(Paperback pb: pbList) {
				bw.write("\n"+pb.toString());
			}

		} catch(IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
		}
	}


//writes to the Stock.txt file 
	public void writeAB(String fileName, ArrayList<Audiobooks> abList)throws FileNotFoundException{
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName,true)); 
			// false here means that we don't want to append data to the content of the file. 
			// If we need to append, then we should use true.
			// When we don't pass the second parameter (false/true), by default it would be false.
			for(Audiobooks ab: abList) {
				bw.write("\n"+ab.toString());
			}

		} catch(IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
		}
	}
	
	//writes to the stock.txt file
	public void writeEB(String fileName, ArrayList<Ebooks> ebList)throws FileNotFoundException{
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(fileName,true)); 
			// false here means that we don't want to append data to the content of the file. 
			// If we need to append, then we should use true.
			// When we don't pass the second parameter (false/true), by default it would be false.
			for(Ebooks eb: ebList) {
				bw.write("\n"+ eb.toString());
			}

		} catch(IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
		}
	}


//used to generate the combobox for the admin login by reading from User.txt
	public ArrayList<Admin> readFileAdmin(String fileName)throws FileNotFoundException{
		ArrayList<Admin> adminList = new ArrayList<Admin>();
		Scanner fileScanner = null;
		try {
			File inputFile = new File(fileName);
			fileScanner = new Scanner(inputFile);
			Admin ad;
			while (fileScanner.hasNextLine()) {
				String[] details = fileScanner.nextLine().split(",") ;
				if (details[7].trim().equals("admin")&&details.length >= 8){
				ad = new Admin(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim(),details[7].trim());
				adminList.add(ad); 
			} 
			}//end of while
			fileScanner.close();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			if(fileScanner != null) {				
				fileScanner.close();
			}
		}
		return(adminList);
}

	//used to generate the combobox for the customer login by reading from User.txt
public ArrayList<Customer> readFileCustomer(String fileName)throws FileNotFoundException{
	ArrayList<Customer> csList = new ArrayList<Customer>();
	Scanner fileScanner = null;
	try {
		File inputFile = new File(fileName);
		fileScanner = new Scanner(inputFile);
		Customer cs;
		while (fileScanner.hasNextLine()) {
			String[] details = fileScanner.nextLine().split(",") ;
			if (details[7].trim().equals("customer")&&details.length >= 8 ) {
			cs = new Customer(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim(),Float.parseFloat(details[6].trim()),details[7].trim());
			csList.add(cs); 
			}
		} //end of while
		fileScanner.close();
	}
	catch(Exception e) {
		System.err.println(e.getMessage());
		e.printStackTrace();
	}
	finally {
		if(fileScanner != null) {				
			fileScanner.close();
		}
	}
	return(csList);
}

//writes to the stock.txt file
	public void updateCredit(String filename, ArrayList<User> usList, int id,double total)throws FileNotFoundException{
		//System.out.print("here");
		BufferedWriter bw = null;
		Customer cs;
		User u = new User(0,"","",0,"","","");
		Admin ad;
		try {
			bw = new BufferedWriter(new FileWriter("UserAccounts.txt",false)); 
			// false here means that we don't want to append data to the content of the file. 
			// If we need to append, then we should use true.
			// When we don't pass the second parameter (false/true), by default it would be false.
			for(User us: usList) {
				if (us.getUserId()==id) {
					//System.out.println(id);
					if(((Customer)us).getBalance()>=total) {
					((Customer)us).setBalance(((Customer)us).getBalance()-total);
				}else {
					JOptionPane.showMessageDialog(null, "INSUFFICIENT STOCK FUNDS", "Error", JOptionPane.ERROR_MESSAGE);
				}
				}if (us.getUserType().equals("customer")) {
					bw.write(((Customer)us).toString()+"\n" );
			}else if (us.getUserType().equals("admin")) {
				bw.write(((Admin)us).toString()+"\n" );
			}else {}
			}	
		} catch(IOException e) {
			System.err.println("error");
			e.printStackTrace();
		}
		finally {
			try {
				if(bw != null) {
					bw.close();
				}
			} catch(IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
		}
	}

	//used to generate the combobox for the admin login by reading from User.txt
		public ArrayList<User> readUser(String fileName)throws FileNotFoundException{
			ArrayList<User> usList = new ArrayList<User>();
			Scanner fileScanner = null;
			try {
				File inputFile = new File(fileName);
				fileScanner = new Scanner(inputFile);
				User us;
				while (fileScanner.hasNextLine()) {
					String[] details = fileScanner.nextLine().split(",") ;
					if (details[7].trim().equals("admin")){
						us = new Admin(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim(),details[7].trim());
						usList.add(us);
						//System.out.print(us.toString());
					}else if(details[7].trim().equals("customer")) {
						us = new Customer(Integer.parseInt(details[0].trim()),details[1].trim(),details[2].trim(),Integer.parseInt(details[3].trim()),details[4].trim(),details[5].trim(),Float.parseFloat(details[6].trim()),details[7].trim());
						usList.add(us);
						//System.out.print(us.toString());
					}else {}
				}//end of while
				fileScanner.close();
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}
			finally {
				if(fileScanner != null) {				
					fileScanner.close();
				}
			}
			return(usList);
	}
	
		public void updateBooks(String filename, ArrayList<Books> bookList, int quantity,int barcode)throws FileNotFoundException{
			//System.out.print("here update books");
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter("Stock.txt",false)); 
				// false here means that we don't want to append data to the content of the file. 
				// If we need to append, then we should use true.
				// When we don't pass the second parameter (false/true), by default it would be false.
				for(Books b: bookList) {
					if (b.getBarcode()==barcode) {
						//System.out.println(b.getQuantityInStock());
						int currentStock=b.getQuantityInStock();
						b.setQuantityInStock(currentStock-quantity);
						//System.out.println(b.getQuantityInStock());
					}
						if (b.getBookType().equals("paperback")) {
							bw.write(((Paperback)b).toString()+"\n");
						}else if (b.getBookType().equals("ebook")) {
							bw.write(((Ebooks)b).toString()+"\n");
						}else if (b.getBookType().equals("audiobook")) {
							bw.write(((Audiobooks)b).toString()+"\n");
				}else {}
				}	
			} catch(IOException e) {
				System.err.println("error");
				e.printStackTrace();
			}
			finally {
				try {
					if(bw != null) {
						bw.close();
					}
				} catch(IOException e) {
					System.err.println("error");
					e.printStackTrace();
				}
			}
		}
		
}


