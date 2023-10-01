package coursework;

import java.awt.EventQueue;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class CustomerGUI extends JFrame {
	csLogin cL;
	
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CustomerGUI gui = null;
				try {
					gui = new CustomerGUI();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				gui.setVisible(true);
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 * @throws FileNotFoundException 
	 */
	public CustomerGUI() throws FileNotFoundException {
	     // Set up the frame
        setTitle("CUSTOMER");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        // Create the tabbed pane
        tabbedPane = new JTabbedPane();
        csLogin loginWindow = new csLogin();
        Basket basket = new Basket(loginWindow);
        csViewBooks ViewBooks =  new csViewBooks();
        searchBooks BookSearch = new searchBooks(basket);
        
        tabbedPane.addTab("Login", loginWindow);
        tabbedPane.addTab("View Books",ViewBooks);
        
        
        // Add the tabbed pane to the frame
        getContentPane().add(tabbedPane);
      
        tabbedPane.addTab("Search Books", BookSearch);
        tabbedPane.addTab("Buy Books", basket);
        // Enable or disable the login button based on the selection

	}

}
