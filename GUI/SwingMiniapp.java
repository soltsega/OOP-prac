package GUI;
import java.awt.*;
import java.awt.event.ActionEvent;  // Importing the AWT package which is the accronym of Abstract Window Toolkit, it provides classes for creating user interfaces and for painting graphics and images. It is part of the Java Foundation Classes (JFC) and is used in conjunction with Swing to create graphical user interfaces in Java applications.
import java.awt.event.ActionListener; // Importing the ActionEvent class from the AWT package, which is used to represent an action event, such as a button click or a menu selection. It contains information about the event, such as the source of the event and any associated data. ActionEvent is commonly used in event handling to trigger specific actions when a user interacts with a component in a graphical user interface (GUI).
import javax.swing.*;  // Importing the ActionListener interface from the AWT package, which is used to receive action events. It contains a single method, actionPerformed(ActionEvent e), that is called when an action event occurs. To handle an action event, you need to implement the ActionListener interface and override the actionPerformed method to define the desired behavior when the event is triggered. This is commonly used in GUI applications to respond to user interactions, such as button clicks or menu selections.
/**
 * JavaFrame is a top-level container that represents a window in a Swing application. It provides a title bar, borders, and buttons for minimizing, maximizing, and closing the window. JavaFrame is commonly used as the main window of an application.
 * Javabeans are reusable software components that follow a specific design pattern. They are used to encapsulate data and behavior in a way that allows them to be easily manipulated and reused in different contexts. JavaBeans typically have properties, events, and methods that can be accessed and modified by other components.
 * introduction to swing
 * swing components
 * event handling
 * layout managers
 */


// Let's build a contact form using Swing. The form will have fields for name, email, and phone number, along with a submit button. When the user clicks the submit button, the entered information will be displayed in a dialog box.
public class SwingMiniapp {

    public static void main(String[] args) {
        // Create a JFrame
        //Jframe is a top-level container that represents a window in a Swing application. It provides a title bar, borders, and buttons for minimizing, maximizing, and closing the window. JavaFrame is commonly used as the main window of an application.
        JFrame frame = new JFrame("Contact Form");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLayout(new GridLayout(10,10));

        // Create labels and text fields
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField();
        JLabel phoneLabel = new JLabel("Phone:");
        JTextField phoneField = new JTextField();

        // Create a submit button
        JButton submitButton = new JButton("Submit");

        // Add components to the frame
        //add() is a method of the JFrame class that is used to add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(phoneLabel);
        frame.add(phoneField);
        frame.add(submitButton);

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String phone = phoneField.getText();
                JOptionPane.showMessageDialog(frame, "Name: " + name + "\nEmail: " + email + "\nPhone: " + phone);
            }
        });

        // Set the frame visibility
        frame.setVisible(true);
    }


}
