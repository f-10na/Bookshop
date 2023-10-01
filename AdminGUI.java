package coursework;

import javax.swing.*;
import java.io.FileNotFoundException;

public class AdminGUI extends JFrame {
	adminLogin aL;
	UpdateStock us;
	private JTabbedPane tabbedPane;
	
	/*
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                AdminGUI gui = null;
				try {
					gui = new AdminGUI();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                gui.setVisible(true);
            }
        });
    }
*/
    public AdminGUI() throws FileNotFoundException {
    	UpdateStock us = new UpdateStock();
        // Set up the frame
        setTitle("Admin");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700, 450);
        setLocationRelativeTo(null);

        // Create the tabbed pane
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", new adminLogin());
        tabbedPane.addTab("View Books", new ViewBooks());
        tabbedPane.addTab("Stock", new UpdateStock());
        
        
        // Add the tabbed pane to the frame
        getContentPane().add(tabbedPane);

        // Enable or disable the login button based on the selection


}
}