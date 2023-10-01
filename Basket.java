package coursework;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.awt.event.ActionEvent;

public class Basket extends JPanel {
	// Member variables are declared private to encapsulate them (a key OOP principle) from outside interference.
	private JTable tblBasket;
	private JTextField txtTotal;
	Functions fn;
	ArrayList<Books>bookList;
	ArrayList<Customer>csList;
	ArrayList<User>usList;
	private DefaultTableModel tblBasketModel;
	csLogin cs;
	Customer c;
	csLogin csComboBox;
	csLogin loginWindow;
	private HashMap<Integer,Integer> sb = new HashMap<>();
	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	// The constructor for this class. It takes an object of the csLogin class as a parameter, demonstrating object composition.
	public Basket(csLogin loginWindow ) throws FileNotFoundException {
		this.loginWindow = loginWindow;
		setBackground(new Color(230, 230, 250));
		setLayout(null);
		csLogin cs = new csLogin();
		Functions fn = new Functions();
		usList = fn.readUser("UserAccounts.txt");
		bookList = fn.readFileBooks("Stock.txt");
		csList=fn.readFileCustomer("UserAccounts.txt");
		JLabel lblTitle = DefaultComponentFactory.getInstance().createTitle("CH:)CKOUT");
		lblTitle.setForeground(new Color(147, 112, 219));
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblTitle.setBounds(180, 25, 122, 25);
		add(lblTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 79, 322, 308);
		
		
		tblBasket = new JTable();
		//tblBasket.setBackground(new Color(216, 191, 216));
		tblBasket.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblBasket);
		tblBasketModel = new DefaultTableModel();
		
		tblBasketModel.addColumn("Barcode");
		tblBasketModel.addColumn("Title");
		tblBasketModel.addColumn("Genre");
		tblBasketModel.addColumn("language");
		tblBasketModel.addColumn("ReleaseDate");
		tblBasketModel.addColumn("RetailPrice");
		tblBasketModel.addColumn("QuantityInStock");	
		
		JButton btnRemoveAll = new JButton("Remove All");
		btnRemoveAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Clear the table
            	tblBasketModel.setRowCount(0);
            }
        });

		btnRemoveAll.setForeground(new Color(147, 112, 219));
		btnRemoveAll.setBounds(383, 100, 117, 29);
		add(btnRemoveAll);
		
		JButton btnRemove = new JButton("Remove Selected Row");
		btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblBasket.getSelectedRow();
                if (selectedRow != -1) {
                    // Remove row from the model
                	tblBasketModel.removeRow(tblBasket.convertRowIndexToModel(selectedRow));
                }
            }
        });
		btnRemove.setForeground(new Color(147, 112, 219));
		btnRemove.setBounds(383, 148, 117, 29);
		add(btnRemove);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        for (int i = 0; i < tblBasket.getRowCount(); i++) {
		            int barcode = (Integer) tblBasketModel.getValueAt(i, 0);
		            double price = (Double) tblBasketModel.getValueAt(i, 5);
		            for (User us : usList) {
		                if (loginWindow.csComboBox.getSelectedItem().equals(us.getUserId())) {
		                    int id = us.getUserId();
		                    try {
		                        Functions fn = new Functions();
		                        bookList = fn.readFileBooks("Stock.txt");
		                        HashMap<Integer, Integer> sb = getBasketQuantity(); // Call getBasketQuantity() to update sb
		                        fn.updateCredit("UserAccounts.txt", usList, id, price);
		                        //System.out.println("before update:"+sb.get(barcode));
		                        //System.out.println(barcode);// Now sb should have the updated values
		                        fn.updateBooks("Stock.txt", bookList, sb.get(barcode), barcode);
		                    } catch (FileNotFoundException e1) {
		                        e1.printStackTrace();
		                    }
		                }
		            }
		        }
		    }
		});

		btnPurchase.setForeground(new Color(147, 112, 219));
		btnPurchase.setBounds(383, 203, 117, 29);
		add(btnPurchase);
		
		JButton btnPrint = new JButton("Print Receipt");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    StringBuilder receiptBuilder = new StringBuilder();

			    // Iterate through the rows of the JTable
			    for (int i = 0; i < tblBasket.getRowCount(); i++) {
			        for (int j = 0; j < tblBasket.getColumnCount(); j++) {
			            // Append the value of each cell to the receipt string
			            Object cellValue = tblBasket.getValueAt(i, j);
			            receiptBuilder.append(cellValue).append("\t");
			        }
			        receiptBuilder.append("\n");
			    }

			    // Get user address from user input dialog
			    String userAddress = getAddress();

			    // Calculate total
			    double total= calculateTotal(tblBasket);
			    // Assuming you have a separate method for calculating the total

			    // Append address and total to the receipt
			    receiptBuilder.append("Thank you for your purchase").append("\n");
			    receiptBuilder.append("Delivery Address: ").append(userAddress).append("\n");
			    receiptBuilder.append("Total: ").append(total).append("\n");

			    // Show the receipt in a dialog using JOptionPane
			    String receiptText = receiptBuilder.toString();
			    JOptionPane.showMessageDialog(null, receiptText, "Receipt", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});


		btnPrint.setForeground(new Color(147, 112, 219));
		btnPrint.setBounds(383, 253, 117, 29);
		add(btnPrint);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(new Color(147, 112, 219));
		lblTotal.setBounds(338, 408, 61, 16);
		add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(383, 403, 130, 26);
		add(txtTotal);
		txtTotal.setColumns(10);
		
		tblBasket.setModel(tblBasketModel);
		add(scrollPane);

	}
	
	//adds book to basket by getting a barcode passed to it from the search books panel 
	public void updateBasket(int barcode) {
	    for(Books b:bookList) {
	        if (barcode==b.getBarcode()) {
	            final Object[] rowData = new Object[] { b.getBarcode(), b.getTitle(), b.getGenre(), b.getLanguage(), b.getReleaseDate(), b.getRetailPrice(), (int) b.getQuantityInStock()};
	            SwingUtilities.invokeLater(new Runnable() {
	                public void run() {
	                    tblBasketModel.addRow(rowData);
	                    tblBasket.revalidate();
	                    tblBasket.repaint();
	                }
	            });
	        }
	    }
	}
	
	//calculates the total by looping through the basket and adding all the prices in the price index
	public double calculateTotal(JTable tblBasket) {
	    int rowCount = tblBasket.getRowCount();
	    int columnIndex = 5; // Specify the index of the column you want to calculate the sum for
	    double sum = 0.0; // Use double for the sum to handle decimal values

	    for (int i = 0; i < rowCount; i++) {
	        Object value = tblBasket.getValueAt(i, columnIndex);
	        if (value instanceof Number) {
	            Number numberValue = (Number) value;
	            sum += numberValue.doubleValue();
	        }
	    }

	    return sum;
	}

	
	/*this function checks which customer is signed in by checking the combobox through the customer list
	public double getCredit() {
		for (Customer cs: csList) {
			if (loginWindow.csComboBox.getSelectedItem().equals(cs.getUserId())) {
				return cs.getBalance();
			}
			
		}
		return 0;
	}
	*/
	
	//formats the string to get the address
	public String getAddress() {
		for (Customer cs: csList) {
			if (loginWindow.csComboBox.getSelectedItem().equals(cs.getUserId())) {
				  // If the condition is true, it returns a concatenated string representing the Customer's address.
				return cs.getHouseNumber()+" " + cs.getCity()+" "+ cs.getPostcode();
			}
		}
		// If no match is found in the loop, an empty string is returned.
        // This return statement is part of the method's interface and encapsulates the behavior in case no address is found.
		return "";
	}
	
	//Hashmap key is the barcode and the value is the quantity in the basket and it returns the hashmap back
	public HashMap<Integer, Integer> getBasketQuantity() {
		Functions fn = new Functions();
	    bookList = fn.readFileBooks("Stock.txt");
	    HashMap<Integer, Integer> sb = new HashMap<>();
	    //System.out.println((Integer) tblBasket.getValueAt(0, 0));
	    for (int i = 0; i < tblBasket.getRowCount(); i++) {
	        int barcode = (Integer) tblBasket.getValueAt(i, 0);
	        System.out.println(barcode);
	        int count = 0; // Move the count variable inside the outer loop
	        for (Books b : bookList) {
	        	//System.out.println(b.getTitle());
	        	//System.out.println(barcode);
	        	//System.out.println(b.getBarcode());
	            if (barcode == b.getBarcode()) {
	                count++;
	                //System.out.print("look");
	                //System.out.println(barcode);
	                sb.put(barcode, count);
	            }
	        }

	        //System.out.println(sb.get(barcode));
	    }

	    return sb;
	}



    
    
}