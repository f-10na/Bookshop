package coursework;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class csLogin extends JPanel {
	JComboBox<Integer> csComboBox;
    private JButton addButton;
    private JButton viewButton;
    Functions fn;
    private JButton btnPurchase;
	/**
	 * Create the panel.
	 * @throws FileNotFoundException 
	 */
	public csLogin() throws FileNotFoundException {
		setBackground(new Color(230, 230, 250));
		JPanel csLogin = new JPanel();
	    csLogin.add(new JLabel("CUSTOMER"));
        Functions fn = new Functions();
		ArrayList<Customer>csList = fn.readFileCustomer("UserAccounts.txt");
		csComboBox = new JComboBox<Integer>();
		csComboBox.setBounds(6, 139, 196, 27);
		for (Customer cs :csList) {
			csComboBox.addItem(cs.getUserId());
		}
		setLayout(null);
		add(csComboBox);
		
        addButton = new JButton("Search");
        addButton.setForeground(new Color(147, 112, 219));
        addButton.setBounds(412, 138, 85, 29);
        add(addButton);     
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedAdmin = (Integer) csComboBox.getSelectedItem();
                if (selectedAdmin != null) {
                        JTabbedPane parentTabbedPane = (JTabbedPane) getParent(); 
                        parentTabbedPane.setSelectedIndex(2); 
                        
                    }
            }
        });
        
        
        viewButton = new JButton("View");
        viewButton.setForeground(new Color(147, 112, 219));
        viewButton.setBounds(412, 179, 85, 29);
        add(viewButton);
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer selectedAdmin = (Integer) csComboBox.getSelectedItem();
                if (selectedAdmin != null) {
                        JTabbedPane parentTabbedPane = (JTabbedPane) getParent(); 
                        parentTabbedPane.setSelectedIndex(1);
                        
                        
                    }
            }
        });
        
        JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("CUSTOMER LOGIN");
        lblNewJgoodiesTitle.setForeground(new Color(147, 112, 219));
        lblNewJgoodiesTitle.setFont(new Font("Lucida Grande", Font.BOLD, 23));
        lblNewJgoodiesTitle.setBounds(156, 37, 278, 60);
        add(lblNewJgoodiesTitle);
        
        btnPurchase = new JButton("Purchase");
        btnPurchase.setForeground(new Color(147, 112, 219));
        btnPurchase.setBounds(412, 220, 117, 29);
        add(btnPurchase);
        btnPurchase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedAdmin = (String) csComboBox.getSelectedItem();
                if (selectedAdmin != null) {
                        JTabbedPane parentTabbedPane = (JTabbedPane) getParent(); 
                        parentTabbedPane.setSelectedIndex(3);
                        
                        
                    }
            }
        });
        
        setVisible(true);

	}
}
