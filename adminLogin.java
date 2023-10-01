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
//This class, adminLogin, is a subclass of JPanel, meaning it inherits all properties and behaviors of JPanel.
//In object-oriented programming (OOP), this is an example of inheritance, one of the four fundamental principles of OOP.
public class adminLogin extends JPanel {

 // These are the member variables of the class.
 // In OOP, these are often referred to as the state or attributes of an object.
 JComboBox<String> adminComboBox;
 private JButton addButton;
 private JButton viewButton;
 Functions fn;

 // This is the constructor of the adminLogin class.
 // It is called when an instance of adminLogin is created.
 // It sets up the initial state of the object and is a key part of encapsulation, another fundamental OOP principle.
 public adminLogin() throws FileNotFoundException {
     JPanel adminLogin = new JPanel();
     adminLogin.add(new JLabel("ADMIN"));

     // An instance of the Functions class is created here, demonstrating object creation and use in OOP.
     Functions fn = new Functions();
     ArrayList<Admin>adminList = fn.readFileAdmin("UserAccounts.txt");
     adminComboBox = new JComboBox<String>();
     adminComboBox.setBounds(37, 214, 196, 27);

     // Here we see a for-each loop, demonstrating the OOP concept of iterating over a collection of objects.
     for (Admin ad :adminList) {
         adminComboBox.addItem("Admin: "+ad.getUsername());
     }

     setLayout(null);
     add(adminComboBox);

     // Object creation and method calls are demonstrated here, key components of OOP.
     addButton = new JButton("Add");
     addButton.setForeground(new Color(147, 112, 219));
     addButton.setBounds(447, 201, 75, 29);
     add(addButton);

     // An anonymous inner class is created here to handle button click events.
     // This is an example of the OOP concept of encapsulation because the event handling logic is bundled with the button object.
     addButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String selectedAdmin = (String) adminComboBox.getSelectedItem();
             if (selectedAdmin != null) {
                 JTabbedPane parentTabbedPane = (JTabbedPane) getParent();
                 parentTabbedPane.setSelectedIndex(2);
             }
         }
     });

     // Similar to the addButton, the viewButton demonstrates object creation, method calling, and event handling.
     viewButton = new JButton("View");
     viewButton.setForeground(new Color(147, 112, 219));
     viewButton.setBounds(447, 234, 75, 29);
     add(viewButton);

     JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ADMIN LOGIN");
     lblNewJgoodiesTitle.setForeground(new Color(147, 112, 219));
     lblNewJgoodiesTitle.setFont(new Font("Lucida Grande", Font.BOLD, 24));
     lblNewJgoodiesTitle.setBounds(212, 53, 196, 49);
     add(lblNewJgoodiesTitle);

     viewButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
             String selectedAdmin = (String) adminComboBox.getSelectedItem();
             if (selectedAdmin != null) {
                 JTabbedPane parentTabbedPane = (JTabbedPane) getParent();
                 parentTabbedPane.setSelectedIndex(1);
             }
         }
     });

     setVisible(true);
 }
}


