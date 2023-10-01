package coursework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class UpdateStock extends JPanel {
	    Books b;
	    Paperback pb;
	    Audiobooks ab;
	    Ebooks eb;
	    Functions fn;
	    ArrayList<Books> bookList;
	    JButton setButton;
	    private ArrayList<Paperback> pbList;
	    private ArrayList<Audiobooks> abList;
	    private ArrayList<Ebooks> ebList;
	    private JTextField txtBarcode;
	    private JTextField txtTitle;
	    private JTextField txtDate;
	    private JTextField txtStock;
	    private JTextField txtPrice;
	    private JTextField txtPages;
	    private JTextField txtFormat;
	    private JTextField txtLength;
	    private JComboBox cbBookType;
	    private JLabel lblFormat;
	    private JLabel lblNewLabel;
	    private JLabel title;
	    private JComboBox cbCondition;
	    private JComboBox cbLanguage;
	    private JComboBox cbGenre;
		/**
		 * Create the panel.
		 */
		public UpdateStock() {
			setBackground(new Color(230, 230, 250));
			 JPanel stockPanel = new JPanel();
		     stockPanel.setLayout(null);
		     setLayout(null);
		     JLabel lblStockUpdate = new JLabel("STOCK UPDATE");
		     lblStockUpdate.setForeground(new Color(147, 112, 219));
		     lblStockUpdate.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		     lblStockUpdate.setBounds(13, 10, 164, 16);
		     add(lblStockUpdate);
		     Functions fn = new Functions();
		     
		     txtBarcode = new JTextField();
		     txtBarcode.setBounds(120, 323, 130, 26);
		     add(txtBarcode);
		     txtBarcode.setColumns(10);
		     
		     txtTitle = new JTextField();
		     txtTitle.setBounds(120, 84, 130, 26);
		     add(txtTitle);
		     txtTitle.setColumns(10);
		     
		     txtDate = new JTextField();
		     txtDate.setBounds(120, 149, 130, 26);
		     add(txtDate);
		     txtDate.setColumns(10);
		     
		     JLabel lblBarcode = new JLabel("barcode:");
		     lblBarcode.setBounds(33, 328, 54, 16);
		     add(lblBarcode);
		     
		     JLabel lblLanguage = new JLabel("language:");
		     lblLanguage.setBounds(33, 432, 61, 16);
		     add(lblLanguage);
		     
		     JLabel lblGenre = new JLabel("genre");
		     lblGenre.setBounds(33, 394, 35, 16);
		     add(lblGenre);
		     
		     JLabel lblDate = new JLabel("date:");
		     lblDate.setBounds(53, 154, 31, 16);
		     add(lblDate);
		     
		     txtStock = new JTextField();
		     txtStock.setBounds(120, 361, 130, 26);
		     add(txtStock);
		     txtStock.setColumns(10);
		     
		     txtPrice = new JTextField();
		     txtPrice.setBounds(120, 285, 130, 26);
		     add(txtPrice);
		     txtPrice.setColumns(10);
		     
		     txtPages = new JTextField();
		     txtPages.setBounds(120, 111, 130, 26);
		     add(txtPages);
		     txtPages.setColumns(10);
		     
		     JLabel lblStock = new JLabel("stock:");
		     lblStock.setBounds(43, 366, 39, 16);
		     add(lblStock);
		     
		     JLabel lblPrice = new JLabel("price:");
		     lblPrice.setBounds(33, 290, 35, 16);
		     add(lblPrice);
		     
		     JLabel lblPages = new JLabel("no. of pages:");
		     lblPages.setBounds(13, 116, 82, 16);
		     add(lblPages);
		     
		     txtFormat = new JTextField();
		     txtFormat.setBounds(120, 257, 130, 26);
		     add(txtFormat);
		     txtFormat.setColumns(10);
		     
		     JLabel lblCondition = new JLabel("condition");
		     lblCondition.setBounds(33, 192, 60, 16);
		     add(lblCondition);
		     
		     txtLength = new JTextField();
		     txtLength.setBounds(120, 225, 130, 26);
		     add(txtLength);
		     txtLength.setColumns(10);
		     
		     JLabel lblLength = new JLabel("length:");
		     lblLength.setBounds(50, 230, 44, 16);
		     add(lblLength);
		     //create combobox to be used in switch statement 
		     String[] bookType = new String[] {"AUDIOBOOK","EBOOK","PAPERBACK"};
		     cbBookType = new JComboBox(bookType);
		     
		     cbBookType.setBounds(418, 256, 133, 27);
		     add(cbBookType);
		      
		     pbList = new ArrayList<Paperback>();
			 ebList = new ArrayList<Ebooks>();
			 abList = new ArrayList<Audiobooks>();
		     JButton addButton = new JButton("ADD");
		     addButton.setForeground(new Color(123, 104, 238));
		     addButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		     addButton.addActionListener(new ActionListener() {
		     	public void actionPerformed(ActionEvent e) {
		     		//does validation checks on the input fields for paperback
		     		if(!txtBarcode.getText().isEmpty() && !txtDate.getText().isEmpty() && !txtPrice.getText().isEmpty() && !txtStock.getText().isEmpty() && !txtTitle.getText().isEmpty()){
		     	    		try {
		     	    		    int barcode = Integer.parseInt(txtBarcode.getText());
		     	    		    String type = "paperback"; 		     	    		    String title = txtTitle.getText();
		     	    		    String language = (String)cbLanguage.getSelectedItem();
		     	    		    String genre = (String) cbGenre.getSelectedItem();
		     	    		    LocalDate date = LocalDate.parse(txtDate.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		     	    		    int stock = Integer.parseInt(txtStock.getText());
		     	    		    double price = Double.parseDouble(txtPrice.getText());
		     	    		    int pages = Integer.parseInt(txtPages.getText());
		     	    		    String condition = (String) cbCondition.getSelectedItem();
		     	    		    Paperback pb = new Paperback(barcode, type, title, language, genre, date, stock, price, pages, condition);
	     	     		        pbList.add(pb);

	     	     		        fn.writePB("Stock.txt", pbList);
		     	    		} catch (NumberFormatException | DateTimeParseException | FileNotFoundException e1) {
		     	    		    // handle exception - fields contain invalid data types for the expected format
		     	    			 e1.printStackTrace();
		     	    			 JOptionPane.showMessageDialog(null, "Invalid number format entered in one or more fields", "Error", JOptionPane.ERROR_MESSAGE);
		     	    		}
		     		}else if(!txtLength.getText().isEmpty() && !txtFormat.getText().isEmpty()) {
		     		    try {
		     		        int barcode = Integer.parseInt(txtBarcode.getText());
		     		        int stock = Integer.parseInt(txtStock.getText());
		     		        double price = Double.parseDouble(txtPrice.getText());
		     		        double length = Double.parseDouble(txtLength.getText());
		     		        String format = txtFormat.getText();
		     		        String language = (String)cbLanguage.getSelectedItem();
		     		        String genre = (String) cbGenre.getSelectedItem();

		     		        Audiobooks ab = new Audiobooks(barcode, "audiobook", txtTitle.getText(), language, genre,
		     		                LocalDate.parse(txtDate.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy")), stock, price, length,format);
		     		        abList.add(ab);
		     		        try {
		     		            fn.writeAB("Stock.txt", abList);
		     		        } catch (FileNotFoundException e1) {
		     		            e1.printStackTrace();
		     		        }
		     		    } catch (NumberFormatException  | DateTimeParseException e1) {
		     		        // Handle the case where the input fields contain invalid or empty values
		     		        // Display an error message or perform appropriate error handling
		     		        e1.printStackTrace();
		     		        JOptionPane.showMessageDialog(null, "Invalid number format entered or date format entered", "Error", JOptionPane.ERROR_MESSAGE);
		     		    }
		     		}

		     			//does the validation checks of the user input for ebooks
		     	     		 else if (!txtFormat.getText().isEmpty() && !txtPages.getText().isEmpty()) {
		     	     		    try {
		     	     		        int barcode = Integer.parseInt(txtBarcode.getText());
		     	     		        String title = txtTitle.getText();
		     	     		        String lang = (String) cbLanguage.getSelectedItem();
		     	     		        String genre = (String) cbGenre.getSelectedItem();
		     	     		        LocalDate date = LocalDate.parse(txtDate.getText(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		     	     		        int stock = Integer.parseInt(txtStock.getText());
		     	     		        double price = Double.parseDouble(txtPrice.getText());
		     	     		        int pages = Integer.parseInt(txtPages.getText());
		     	     		        String format = txtFormat.getText();

		     	     		        Ebooks eb = new Ebooks(barcode, "ebook", title, lang, genre, date, stock, price, pages, format);
		     	     		        ebList.add(eb);

		     	     		        try {
		     	     		            fn.writeEB("Stock.txt", ebList);
		     	     		        } catch (FileNotFoundException e1) {
		     	     		            e1.printStackTrace();
		     	     		            JOptionPane.showMessageDialog(null, "file not found", "Error", JOptionPane.ERROR_MESSAGE);
		     	     		        }
		     	     		    } catch (NumberFormatException | DateTimeParseException g) {
		     	     		        // Handle exception here
		     	     		        g.printStackTrace();
		     	     		        JOptionPane.showMessageDialog(null, "Invalid number format entered or date format entered", "Error", JOptionPane.ERROR_MESSAGE);
		     	     		    }
		     	     		}
		     	}
		     });

		     
		    addButton.setBounds(476, 295, 97, 71);
		    add(addButton);
		    
		    lblFormat = new JLabel("format:");
		    lblFormat.setBounds(33, 262, 61, 16);
		    add(lblFormat);
		    
		    title = new JLabel("title:");
		    title.setBounds(13, 89, 61, 16);
		    add(title);
		    
		    //audiobook is the intial one so has to have its fields preset and the other two are set when selected in combobox
		    txtBarcode.setEnabled(true);
            txtTitle.setEnabled(true);
            txtPrice.setEnabled(true);
            txtDate.setEnabled(true);
            txtStock.setEnabled(true);
            txtLength.setEnabled(true);
            txtPages.setEnabled(false);
            
            String[] conditionType= new String[] {"new","old"};
            cbCondition = new JComboBox(conditionType);
            cbCondition.setBounds(120, 187, 130, 27);
            add(cbCondition);
            
            String[] languageType= new String[] {"English","French"};
            cbLanguage = new JComboBox(languageType);
            cbLanguage.setBounds(120, 427, 130, 27);
            add(cbLanguage);
            
            String[] genreType= new String[] {"Biography","Computer Science","Business","Politics"};
            cbGenre = new JComboBox(genreType);
            cbGenre.setBounds(120, 390, 130, 27);
            add(cbGenre);
		  // Add an ActionListener to the book type JComboBox
		     cbBookType.addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent e) {
		     String selectedBookType = (String) cbBookType.getSelectedItem();
		     //System.out.println(cbBookType.getSelectedItem());
		     //System.out.println("$$$$$$$$$$$$$$$$$$$$");
		     //System.out.println(selectedBookType);
		     // Activate/deactivate text fields based on selected book type
		     switch (selectedBookType) {
		     case "EBOOK":
		    	 txtFormat.setEnabled(true);
		    	 txtBarcode.setEnabled(true);
		    	 txtTitle.setEnabled(true);
		    	 cbLanguage.setEnabled(true);
		    	 cbGenre.setEnabled(true);
		    	 txtPrice.setEnabled(true);
		    	 txtDate.setEnabled(true);
		    	 txtStock.setEnabled(true);
		    	 txtLength.setEnabled(false);
		    	 txtPages.setEnabled(false);
		    	 cbCondition.setEnabled(false);
		       case "AUDIOBOOK":
		            txtBarcode.setEnabled(true);
		            txtTitle.setEnabled(true);
		            cbLanguage.setEnabled(true);
		            cbGenre.setEnabled(true);
		            txtPrice.setEnabled(true);
		            txtDate.setEnabled(true);
		            txtStock.setEnabled(true);
		            txtLength.setEnabled(true);
		            txtFormat.setVisible(true);
		            cbCondition.setEnabled(false);
		            txtPages.setEnabled(false);
		            break;
		        case "PAPERBACK":
		        	txtBarcode.setEnabled(true);
			        txtTitle.setEnabled(true);
			        cbLanguage.setEnabled(true);
			        cbGenre.setEnabled(true);
			        txtPrice.setEnabled(true);
			        txtDate.setEnabled(true);
			        txtStock.setEnabled(true);
			        txtLength.setEnabled(false);
			        txtFormat.setVisible(false);  
			        txtPages.setEnabled(true);
			        cbCondition.setEnabled(true);
		            }
		        }
		     });
		    

		        
	setVisible(true);	
}
}

		     

		  

		   

	
		
		
		

