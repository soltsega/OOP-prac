package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

/**
 * A small Swing contact manager that demonstrates encapsulation, event handling,
 * validation, layout managers, and list rendering.
 */
class Contact {
    private String name;
    private String email;
    private String phone;

    public Contact(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return name + " - " + email + " - " + phone;
    }
}

public class SwingMiniapp {

    private static final List<Contact> contacts = new ArrayList<>();  // In-memory list to store contacts
    private static final DefaultListModel<Contact> listModel = new DefaultListModel<>();  // Model for JList to display contacts


    //you can use many ways to declare colors
    // here are some: Color.RED, new Color(255, 0, 0), Color.decode("#FF0000")
    // the lower and uppercase hex digits are equivalent, so "#ff0000" also works
    // the lower and uppercase color names are equivalent, so Color.red also works
    // but it is recommended to use uppercase for constants to follow Java naming conventions
    private static final Color BACKGROUND = new Color(245, 247, 250);
    private static final Color PANEL = Color.WHITE;

    private static final Color TEXT = new Color(33, 37, 41);
    private static final Color MUTED = new Color(102, 112, 133);
    private static final Color PRIMARY = new Color(21, 101, 192);
    private static final Color BORDER = new Color(222, 226, 230);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingMiniapp::createAndShowGui);
    }

    private static void createAndShowGui() {
        applyLookAndFeel();

        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(780, 500));
        frame.setSize(860, 540);
        frame.setLocationRelativeTo(null);
        frame.setJMenuBar(createMenuBar(frame));

        JPanel rootPanel = new JPanel(new BorderLayout(24, 0));
        rootPanel.setBackground(BACKGROUND);
        rootPanel.setBorder(new EmptyBorder(24, 24, 24, 24));

        JTextField nameField = createTextField("Enter full name");
        JTextField emailField = createTextField("name@example.com");
        JTextField phoneField = createTextField("10-digit phone number");

        JLabel countLabel = createMutedLabel("0 saved");
        JPanel formPanel = createFormPanel(nameField, emailField, phoneField);
        JPanel listPanel = createListPanel(countLabel);

        rootPanel.add(formPanel, BorderLayout.WEST);
        rootPanel.add(listPanel, BorderLayout.CENTER);
        frame.setContentPane(rootPanel);

        JButton submitButton = (JButton) formPanel.getClientProperty("submitButton");
        JButton clearButton = (JButton) formPanel.getClientProperty("clearButton");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String email = emailField.getText().trim();
                String phone = phoneField.getText().trim();

                if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "All fields are required.", "Missing Information",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!email.contains("@") || !email.contains(".")) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid email address.", "Invalid Email",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (!phone.matches("\\d{10}")) {
                    JOptionPane.showMessageDialog(frame, "Phone must be exactly 10 digits.", "Invalid Phone",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Contact contact = new Contact(name, email, phone);
                contacts.add(contact);
                listModel.addElement(contact);
                countLabel.setText(contacts.size() + " saved");

                nameField.setText("");
                emailField.setText("");
                phoneField.setText("");
                nameField.requestFocusInWindow();

                JOptionPane.showMessageDialog(frame, "Contact added successfully.", "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearButton.addActionListener(e -> {
            nameField.setText("");
            emailField.setText("");
            phoneField.setText("");
            nameField.requestFocusInWindow();
        });

        frame.setVisible(true);
    }

    private static JMenuBar createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Contact Manager v1.2\nBuilt with Swing for OOP practice.", "About", JOptionPane.INFORMATION_MESSAGE));
        helpMenu.add(aboutItem);

        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        return menuBar;
    }

    private static JPanel createFormPanel(JTextField nameField, JTextField emailField, JTextField phoneField) {
        JPanel formPanel = createCardPanel();
        formPanel.setPreferredSize(new Dimension(320, 0));
        formPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = createTitleLabel("New Contact");
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 6, 0);
        formPanel.add(titleLabel, gbc);

        JLabel subtitleLabel = createMutedLabel("Save name, email, and phone details.");
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 24, 0);
        formPanel.add(subtitleLabel, gbc);

        addLabeledField(formPanel, gbc, 2, "Name", nameField);
        addLabeledField(formPanel, gbc, 4, "Email", emailField);
        addLabeledField(formPanel, gbc, 6, "Phone", phoneField);

        JButton submitButton = createPrimaryButton("Add Contact");
        JButton clearButton = createSecondaryButton("Clear");
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 12, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);

        gbc.gridy = 8;
        gbc.insets = new Insets(12, 0, 0, 0);
        formPanel.add(buttonPanel, gbc);

        gbc.gridy = 9;
        gbc.weighty = 1;
        formPanel.add(Box.createVerticalGlue(), gbc);

        formPanel.putClientProperty("submitButton", submitButton);
        formPanel.putClientProperty("clearButton", clearButton);
        return formPanel;
    }

    private static JPanel createListPanel(JLabel countLabel) {
        JPanel listPanel = createCardPanel();
        listPanel.setLayout(new BorderLayout(0, 16));

        JPanel listHeader = new JPanel(new BorderLayout());
        listHeader.setOpaque(false);
        listHeader.add(createTitleLabel("Contacts"), BorderLayout.WEST);
        listHeader.add(countLabel, BorderLayout.EAST);
        listPanel.add(listHeader, BorderLayout.NORTH);

        JList<Contact> contactList = new JList<>(listModel);
        contactList.setCellRenderer(new ContactListCellRenderer());
        contactList.setFixedCellHeight(70);
        contactList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        contactList.setBackground(PANEL);

        JScrollPane scrollPane = new JScrollPane(contactList);
        scrollPane.setBorder(BorderFactory.createLineBorder(BORDER));
        scrollPane.getViewport().setBackground(PANEL);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        return listPanel;
    }

    private static void applyLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
            UIManager.put("OptionPane.buttonFont", new Font("Segoe UI", Font.BOLD, 13));
        } catch (Exception ignored) {
            // Swing will use the default look and feel if Nimbus is unavailable.
        }
    }

    private static JPanel createCardPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(PANEL);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(24, 24, 24, 24)));
        return panel;
    }

    private static JLabel createTitleLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(TEXT);
        return label;
    }

    private static JLabel createMutedLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(MUTED);
        return label;
    }

    private static JTextField createTextField(String tooltip) {
        JTextField field = new JTextField();
        field.setToolTipText(tooltip);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setForeground(TEXT);
        field.setPreferredSize(new Dimension(0, 38));
        field.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                new EmptyBorder(7, 10, 7, 10)));
        return field;
    }

    private static void addLabeledField(JPanel panel, GridBagConstraints gbc, int row, String labelText,
            JTextField field) {
        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Segoe UI", Font.BOLD, 13));
        label.setForeground(TEXT);
        label.setLabelFor(field);

        gbc.gridy = row;
        gbc.insets = new Insets(0, 0, 6, 0);
        panel.add(label, gbc);

        gbc.gridy = row + 1;
        gbc.insets = new Insets(0, 0, 16, 0);
        panel.add(field, gbc);
    }

    private static JButton createPrimaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(PRIMARY);
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 14, 10, 14));
        return button;
    }

    private static JButton createSecondaryButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setForeground(PRIMARY);
        button.setBackground(new Color(232, 241, 252));
        button.setFocusPainted(false);
        button.setBorder(new EmptyBorder(10, 14, 10, 14));
        return button;
    }

    private static class ContactListCellRenderer extends JPanel implements ListCellRenderer<Contact> {
        private final JLabel nameLabel = new JLabel();
        private final JLabel detailsLabel = new JLabel();

        ContactListCellRenderer() {
            setLayout(new BorderLayout(0, 4));
            setBorder(new EmptyBorder(10, 14, 10, 14));
            nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
            detailsLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            add(nameLabel, BorderLayout.NORTH);
            add(detailsLabel, BorderLayout.CENTER);
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Contact> list, Contact value, int index,
                boolean isSelected, boolean cellHasFocus) {
            nameLabel.setText(value.getName());
            detailsLabel.setText(value.getEmail() + "   " + value.getPhone());

            setBackground(isSelected ? new Color(225, 239, 255) : PANEL);
            nameLabel.setForeground(TEXT);
            detailsLabel.setForeground(MUTED);
            return this;
        }
    }
}
