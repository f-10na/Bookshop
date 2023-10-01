package coursework;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;

public class ViewBooks extends JPanel {
	private JTable table;
    private DefaultTableModel model;
    Functions fn;
    ArrayList<Books> bookList;
    Books b;
    Paperback pb;
    Audiobooks ab;
    Ebooks eb;
	/**
	 * panel reads book data from text file and creates the 3 types of book objects
	 */
	public ViewBooks() {
		setBackground(new Color(230, 230, 250));
		 JPanel viewBooksPanel = new JPanel();
	     viewBooksPanel.setLayout(null);
	     JLabel label = new JLabel("View Books");
	     label.setBounds(189, 5, 71, 16);
	     viewBooksPanel.add(label);
	     Functions fn =new Functions();
	     ArrayList<Books>bookList = fn.readFileBooks("Stock.txt");
	     
	     
	     table = new JTable() {
	    	 public boolean isCellEditable(int row,int column) {
	    		 return false;
	    	 }
	     };
	     table.setBounds(342, 227, 400, 300);
	     //overriding DTM which treats all as string to treat column six as integer which is quantity in stock and use it to sort
	     model = new DefaultTableModel(){
	            @Override
	            public Class<?> getColumnClass(int columnIndex) {
	                if (columnIndex == 6) {
	                    return Integer.class;
	                } else {
	                    return String.class;
	                }
	            }
	        };
	     
	     model.addColumn("Barcode");
	     model.addColumn("Title");
	     model.addColumn("Genre");
	     model.addColumn("language");
	     model.addColumn("Release Date");
	     model.addColumn("Retail Price");
	     model.addColumn("Length");
	     model.addColumn("Number Of Pages");
	     model.addColumn("Condition");
	     model.addColumn("Format");
	     
	    /*uses inheritance and polymorphism to enable each book to inherit attributes and methods from the parent book class and its unique features
	     uses abstraction to define book class to extend other book types and uses encapsulation to keep data protected
	     */
	     for(Books b:bookList) { 
	    	 //System.out.println(b.getBookType());
	    	 if(b.getBookType().equals("paperback")) {
	    		//System.out.println(b);
	    		model.addRow(new Object[] {b.getBarcode(),b.getTitle(),b.getGenre(),b.getLanguage(),b.getReleaseDate(),b.getRetailPrice(),(int) b.getQuantityInStock(),((Paperback)b).getNumberOfPages(),((Paperback)b).getCondition()});
	    	 }else if(b.getBookType().equals("audiobook")) {
	    		//System.out.println(b);
	    		model.addRow(new Object[] {b.getBarcode(),b.getTitle(),b.getGenre(),b.getLanguage(),b.getReleaseDate(),b.getRetailPrice(),(int) b.getQuantityInStock(),((Audiobooks)b).getLength(),((Audiobooks)b).getFormat()});
	    	 }else if(b.getBookType().equals("ebook")) {
	    		//System.out.println(b);
	    		model.addRow(new Object[] {b.getBarcode(),b.getTitle(),b.getGenre(),b.getLanguage(),b.getReleaseDate(),b.getRetailPrice(),(int) b.getQuantityInStock(),((Ebooks)b).getNumberOfPages(),((Ebooks)b).getFormat()});
	    	 }else {
	    	 }
	     }
	     
	    		 
	     // Create the TableRowSorter and set it as the sorter for the JTable
	     TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
	     table.setRowSorter(sorter);

	        // Sort the rows based on the second column in ascending order
	     sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(6, SortOrder.ASCENDING)));

	     

	     
	     table.setModel(model);

	     add(new JScrollPane(table), BorderLayout.CENTER);
	     setVisible(true);

	}

	public JTable getTable() {
		return table;
	}
}
