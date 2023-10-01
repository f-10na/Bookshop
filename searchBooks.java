package coursework;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Color;

public class searchBooks extends JPanel {
	Functions fn;
	private JTextField txtBarcode;
	private JTextField txtLength;
	private JTable table;
    private DefaultTableModel model;
	ArrayList<Books> bookList;
	Books b;
	Paperback pb;
	Audiobooks ab;
	Ebooks eb;
	Basket basket ;
	private JTable searchTable;
	public searchBooks(Basket basket) throws FileNotFoundException{
		this.basket = basket;
		Functions fn = new Functions();
		ArrayList<Books>bookList = fn.readFileBooks("Stock.txt");
		setBackground(new Color(230, 230, 250));
		
		JPanel searchBooks = new JPanel();
	    setLayout(null);
	    
	    JLabel lblBarcode = new JLabel("Search barcode:");
	    lblBarcode.setBounds(6, 70, 102, 16);
	    add(lblBarcode);
	    JLabel label = new JLabel("CUSTOMER");
	    label.setBounds(223, 5, 69, 16);
	    add(label);	    
	    
	    txtBarcode = new JTextField();
	    txtBarcode.setBounds(120, 65, 183, 26);
	    add(txtBarcode);
	    txtBarcode.setColumns(10);
	    
	    JLabel lblLength = new JLabel("Search length:");
	    lblLength.setBounds(6, 98, 92, 16);
	    add(lblLength);
	    
	    txtLength = new JTextField();
	    txtLength.setBounds(110, 98, 182, 26);
	    add(txtLength);
	    txtLength.setColumns(10);
	    
	    
	    JScrollPane scrollPane = new JScrollPane();
	    scrollPane.setBounds(17, 266, 404, 198);
	    add(scrollPane);
	    searchTable = new JTable();
	    scrollPane.setColumnHeaderView(searchTable);
	    
	     //overriding DTM which treats all as string to treat column six as integers which is quantity in stock
	    model = new DefaultTableModel(){
           private static final long serialVersionUID = 1L;

			@Override
           public Class<?> getColumnClass(int columnIndex) {
               if (columnIndex == 5) {
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
		 model.addColumn("Format");		      
		 model.addColumn("Release Date");
	     model.addColumn("Retail Price");
	     model.addColumn("Length");
	     model.addColumn("Number Of Pages");
	     model.addColumn("Condition");
	     
	    searchTable.setModel(model);

		
	     
	    JButton btnBarcode = new JButton("search barcode");
	    btnBarcode.setBounds(303, 65, 152, 29);
	    add(btnBarcode);
	    
	    JButton btnLength = new JButton("search length");
	    btnLength.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            clearTable(searchTable);
	            String lengthInput = txtLength.getText().trim();
	            if (!lengthInput.isEmpty()) {
	                boolean foundMatch = false;
	                for (Books b : bookList) {
	                    if (b.getBookType().equals("audiobook") && b instanceof Audiobooks) {
	                        Audiobooks audiobook = (Audiobooks) b;
	                        try {
	                            double length = Double.parseDouble(lengthInput);
	                            if (length <= audiobook.getLength()) {
	                                model.addRow(new Object[] { b.getBarcode(), b.getTitle(), b.getGenre(), b.getLanguage(), b.getReleaseDate(), b.getRetailPrice(), (int) b.getQuantityInStock(), audiobook.getLength(), audiobook.getFormat() });
	                                foundMatch = true;
	                            }
	                        } catch (NumberFormatException ex) {
	                            // The input is not a valid double, show an error message
	                            JOptionPane.showMessageDialog(null, "Invalid length input", "Error", JOptionPane.ERROR_MESSAGE);
	                            return;
	                        }
	                    }
	                }
	                if (!foundMatch) {
	                    JOptionPane.showMessageDialog(null, "No matching audiobooks found.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Please enter a length", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    btnLength.setBounds(304, 93, 117, 29);
	    add(btnLength);
	    
	    //search based on barcode functionality
	    btnBarcode.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            clearTable(searchTable);
	            String barcodeInput = txtBarcode.getText().trim();
	            if (!barcodeInput.isEmpty()) {
	                boolean foundMatch = false;
	                for (Books b : bookList) {
	                    try {
	                        int barcode = Integer.parseInt(barcodeInput);
	                        if (barcode == b.getBarcode()) {
	                            if (b.getBookType().equals("paperback")) {
	                                model.addRow(new Object[] { b.getBarcode(), b.getTitle(), b.getGenre(), b.getLanguage(), b.getReleaseDate(), b.getRetailPrice(), (int) b.getQuantityInStock(), ((Paperback) b).getNumberOfPages(), ((Paperback) b).getCondition() });
	                                foundMatch = true;
	                            } else if (b.getBookType().equals("audiobook")) {
	                                model.addRow(new Object[] { b.getBarcode(), b.getTitle(), b.getGenre(), b.getLanguage(), b.getReleaseDate(), b.getRetailPrice(), (int) b.getQuantityInStock(), ((Audiobooks) b).getLength(), ((Audiobooks) b).getFormat() });
	                                foundMatch = true;
	                            } else if (b.getBookType().equals("ebook")) {
	                                model.addRow(new Object[] { b.getBarcode(), b.getTitle(), b.getGenre(), b.getLanguage(), b.getReleaseDate(), b.getRetailPrice(), (int) b.getQuantityInStock(), ((Ebooks) b).getNumberOfPages(), ((Ebooks) b).getFormat() });
	                                foundMatch = true;
	                            }
	                        }
	                    } catch (NumberFormatException ex) {
	                        // The input is not a valid integer, show an error message
	                        JOptionPane.showMessageDialog(null, "Invalid barcode input", "Error", JOptionPane.ERROR_MESSAGE);
	                        return;
	                    }
	                    searchTable.setVisible(true);
	                }
	                if (!foundMatch) {
	                    JOptionPane.showMessageDialog(null, "No matching books found.", "Information", JOptionPane.INFORMATION_MESSAGE);
	                }
	            } else {
	                JOptionPane.showMessageDialog(null, "Please enter a barcode", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });

	    //prevents customer adding changes 
	    
		    searchTable = new JTable();
		     // Create the TableRowSorter and set it as the sorter for the JTable
		     TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
		     searchTable.setRowSorter(sorter);

		        // Sort the rows based on the second column in ascending order
		     sorter.setSortKeys(Arrays.asList(new RowSorter.SortKey(5, SortOrder.ASCENDING)));
		     
		     JButton addButton = new JButton("ADD");
		     addButton.setForeground(new Color(147, 112, 219));
		     //returns the barcode to the update basket and that adds to the basket in the different panel
		     addButton.addActionListener(new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	for (int i=0;i<searchTable.getRowCount();i++) {
	            		    int barcode = (int)searchTable.getValueAt(i, 0);
	            		    //System.out.print(barcode);
			             basket.updateBasket(barcode);
			             basket.revalidate();
			             basket.repaint();
		             }
		         }
		     });
		     searchTable.setModel(model);
		     searchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		     
		     addButton.setBounds(490, 262, 117, 29);
		     add(addButton);
		  
		     
	    setVisible(true);

	}
	//clear the JTable you are looking at each time you search a different filter
	 public void clearTable(JTable table) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0);
	}
}
