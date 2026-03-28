# Introduction to GUI Programming with Java Swing

## Table of Contents
1. [Introduction to Swing](#51-introducing-to-swing)
2. [Swing Components](#52-swing-components)
3. [Layout Managers](#53-layout-managers)
4. [Delegation Event Classes](#54-delegation-event-classes)
5. [Common Event Listeners](#55-common-event-listeners)
6. [Defining Listeners](#56-defining-listeners)

---

## 5.1 Introduction to Swing

### What is Swing?
- **Swing** is a Java GUI widget toolkit
- Part of Java Foundation Classes (JFC)
- Provides platform-independent GUI components
- Built on top of AWT (Abstract Window Toolkit)

### Key Features of Swing
- **Platform Independence**: Write once, run anywhere
- **Pluggable Look and Feel**: Can change appearance
- **Lightweight Components**: Not dependent on native OS components
- **MVC Architecture**: Model-View-Controller pattern
- **Rich Set of Components**: Buttons, tables, trees, etc.

### Swing vs AWT
| Feature | Swing | AWT |
|---------|-------|-----|
| Components | Lightweight | Heavyweight |
| Platform Independence | Yes | Limited |
| Look and Feel | Pluggable | Native |
| Component Range | Extensive | Basic |

### Basic Swing Application Structure
```java
import javax.swing.*;

public class BasicSwingApp {
    public static void main(String[] args) {
        // Create frame on Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My First Swing App");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);
            frame.setVisible(true);
        });
    }
}
```

### Important Swing Classes
- `JFrame` - Top-level window
- `JPanel` - Container for components
- `JComponent` - Base class for all Swing components

---

## 5.2 Swing Components

### Component Hierarchy
```
java.lang.Object
├── java.awt.Component
    ├── java.awt.Container
        ├── javax.swing.JComponent
            ├── JButton, JLabel, JTextField, etc.
```

### Basic Components

#### 1. JLabel
```java
JLabel label = new JLabel("Hello World");
label.setText("New Text");
label.setFont(new Font("Arial", Font.BOLD, 16));
```

#### 2. JButton
```java
JButton button = new JButton("Click Me");
button.addActionListener(e -> {
    System.out.println("Button clicked!");
});
button.setEnabled(false); // Disable button
```

#### 3. JTextField
```java
JTextField textField = new JTextField(20); // 20 columns
textField.setText("Default text");
String text = textField.getText();
```

#### 4. JTextArea
```java
JTextArea textArea = new JTextArea(5, 20); // 5 rows, 20 columns
textArea.setLineWrap(true);
textArea.setWrapStyleWord(true);
JScrollPane scrollPane = new JScrollPane(textArea);
```

#### 5. JCheckBox
```java
JCheckBox checkBox = new JCheckBox("Subscribe to newsletter");
boolean isSelected = checkBox.isSelected();
```

#### 6. JRadioButton
```java
JRadioButton radio1 = new JRadioButton("Option 1");
JRadioButton radio2 = new JRadioButton("Option 2");

ButtonGroup group = new ButtonGroup();
group.add(radio1);
group.add(radio2);
```

#### 7. JComboBox
```java
String[] items = {"Item 1", "Item 2", "Item 3"};
JComboBox<String> comboBox = new JComboBox<>(items);
String selected = (String) comboBox.getSelectedItem();
```

#### 8. JList
```java
String[] data = {"Apple", "Banana", "Orange"};
JList<String> list = new JList<>(data);
list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
```

### Menu Components

#### JMenuBar, JMenu, JMenuItem
```java
JMenuBar menuBar = new JMenuBar();
JMenu fileMenu = new JMenu("File");
JMenuItem openItem = new JMenuItem("Open");
JMenuItem saveItem = new JMenuItem("Save");

fileMenu.add(openItem);
fileMenu.add(saveItem);
menuBar.add(fileMenu);

frame.setJMenuBar(menuBar);
```

### Advanced Components

#### JTable
```java
String[][] data = {
    {"John", "25", "New York"},
    {"Jane", "30", "Los Angeles"}
};
String[] columns = {"Name", "Age", "City"};

JTable table = new JTable(data, columns);
JScrollPane scrollPane = new JScrollPane(table);
```

#### JTree
```java
DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("Child 1");
DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Child 2");

root.add(child1);
root.add(child2);

JTree tree = new JTree(root);
```

---

## 5.3 Layout Managers

### What are Layout Managers?
- Layout managers control the size and position of components
- They automatically arrange components in containers
- Different managers provide different layout strategies

### Types of Layout Managers

#### 1. FlowLayout
```java
// Default layout for JPanel
JPanel panel = new JPanel(new FlowLayout());
// FlowLayout.LEFT, FlowLayout.CENTER, FlowLayout.RIGHT
panel.add(new JButton("Button 1"));
panel.add(new JButton("Button 2"));
```
- Components flow left to right, top to bottom
- Respects components' preferred sizes
- Simple and predictable

#### 2. BorderLayout
```java
JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());

frame.add(new JButton("North"), BorderLayout.NORTH);
frame.add(new JButton("South"), BorderLayout.SOUTH);
frame.add(new JButton("East"), BorderLayout.EAST);
frame.add(new JButton("West"), BorderLayout.WEST);
frame.add(new JButton("Center"), BorderLayout.CENTER);
```
- Five regions: North, South, East, West, Center
- Center gets remaining space
- Default for JFrame, JDialog

#### 3. GridLayout
```java
JPanel panel = new JPanel(new GridLayout(3, 2)); // 3 rows, 2 columns
panel.add(new JButton("1"));
panel.add(new JButton("2"));
panel.add(new JButton("3"));
panel.add(new JButton("4"));
panel.add(new JButton("5"));
panel.add(new JButton("6"));
```
- Equal-sized cells in grid
- Components fill entire cell
- All cells same size

#### 4. CardLayout
```java
JPanel cardPanel = new JPanel(new CardLayout());
CardLayout cl = (CardLayout) cardPanel.getLayout();

cardPanel.add(panel1, "Panel 1");
cardPanel.add(panel2, "Panel 2");

cl.show(cardPanel, "Panel 2"); // Show specific card
```
- Stack of components
- Only one visible at a time
- Good for wizards or tabbed interfaces

#### 5. BoxLayout
```java
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Vertical

panel.add(Box.createVerticalStrut(10)); // Spacer
panel.add(new JButton("Button 1"));
panel.add(Box.createVerticalGlue()); // Flexible spacer
panel.add(new JButton("Button 2"));
```
- Components in single row or column
- Can use rigid areas, struts, and glue
- More flexible than GridLayout

#### 6. GridBagLayout
```java
JPanel panel = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();

gbc.gridx = 0;
gbc.gridy = 0;
gbc.gridwidth = 2;
panel.add(new JButton("Wide Button"), gbc);

gbc.gridx = 0;
gbc.gridy = 1;
gbc.gridwidth = 1;
panel.add(new JButton("Button 2"), gbc);
```
- Most flexible but complex
- Grid-based with variable cell sizes
- Components can span multiple cells

### Combining Layout Managers
```java
JFrame frame = new JFrame();
frame.setLayout(new BorderLayout());

JPanel northPanel = new JPanel(new FlowLayout());
northPanel.add(new JLabel("Search:"));
northPanel.add(new JTextField(20));

JPanel centerPanel = new JPanel(new GridLayout(2, 2));
centerPanel.add(new JButton("1"));
centerPanel.add(new JButton("2"));

frame.add(northPanel, BorderLayout.NORTH);
frame.add(centerPanel, BorderLayout.CENTER);
```

---

## 5.4 Delegation Event Classes

### Event Delegation Model
Swing uses the **Delegation Event Model**:
1. **Event Source** - Component that generates events
2. **Event Object** - Contains information about the event
3. **Event Listener** - Object that waits for events

### Event Classes Hierarchy
```
java.util.EventObject
├── java.awt.AWTEvent
    ├── ActionEvent
    ├── ItemEvent
    ├── KeyEvent
    ├── MouseEvent
    ├── WindowEvent
    ├── FocusEvent
    └── ComponentEvent
```

### Common Event Classes

#### 1. ActionEvent
```java
// Generated by: JButton, JTextField, JMenuItem
button.addActionListener(e -> {
    String command = e.getActionCommand();
    System.out.println("Action: " + command);
});
```

#### 2. MouseEvent
```java
// Generated by: Mouse clicks, movement, dragging
component.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        System.out.println("Click at: " + x + ", " + y);
    }
});
```

#### 3. KeyEvent
```java
// Generated by: Keyboard input
textField.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        System.out.println("Key pressed: " + keyCode);
    }
});
```

#### 4. WindowEvent
```java
// Generated by: Window operations
frame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        System.out.println("Window closing");
    }
});
```

#### 5. ItemEvent
```java
// Generated by: JCheckBox, JRadioButton, JComboBox
checkBox.addItemListener(e -> {
    int stateChange = e.getStateChange();
    if (stateChange == ItemEvent.SELECTED) {
        System.out.println("Item selected");
    }
});
```

#### 6. FocusEvent
```java
// Generated by: Component gaining/losing focus
textField.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        System.out.println("Focus gained");
    }
});
```

---

## 5.5 Common Event Listeners

### Listener Interfaces and Methods

#### 1. ActionListener
```java
public interface ActionListener {
    void actionPerformed(ActionEvent e);
}

// Usage
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        // Handle button click
    }
});

// Lambda expression
button.addActionListener(e -> System.out.println("Clicked!"));
```

#### 2. MouseListener
```java
public interface MouseListener {
    void mouseClicked(MouseEvent e);
    void mousePressed(MouseEvent e);
    void mouseReleased(MouseEvent e);
    void mouseEntered(MouseEvent e);
    void mouseExited(MouseEvent e);
}

// Usage with adapter class
component.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) {
        // Only implement needed methods
    }
});
```

#### 3. KeyListener
```java
public interface KeyListener {
    void keyPressed(KeyEvent e);
    void keyReleased(KeyEvent e);
    void keyTyped(KeyEvent e);
}

// Usage
textField.addKeyListener(new KeyAdapter() {
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            // Handle Enter key
        }
    }
});
```

#### 4. WindowListener
```java
public interface WindowListener {
    void windowOpened(WindowEvent e);
    void windowClosing(WindowEvent e);
    void windowClosed(WindowEvent e);
    void windowIconified(WindowEvent e);
    void windowDeiconified(WindowEvent e);
    void windowActivated(WindowEvent e);
    void windowDeactivated(WindowEvent e);
}

// Usage
frame.addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
});
```

#### 5. ItemListener
```java
public interface ItemListener {
    void itemStateChanged(ItemEvent e);
}

// Usage
checkBox.addItemListener(e -> {
    if (e.getStateChange() == ItemEvent.SELECTED) {
        System.out.println("Selected");
    }
});
```

#### 6. FocusListener
```java
public interface FocusListener {
    void focusGained(FocusEvent e);
    void focusLost(FocusEvent e);
}

// Usage
textField.addFocusListener(new FocusAdapter() {
    public void focusGained(FocusEvent e) {
        textField.selectAll();
    }
});
```

#### 7. ChangeListener
```java
public interface ChangeListener {
    void stateChanged(ChangeEvent e);
}

// Usage for JSlider, JTabbedPane
slider.addChangeListener(e -> {
    int value = slider.getValue();
    System.out.println("Slider value: " + value);
});
```

### Adapter Classes
- **MouseAdapter** - MouseListener
- **KeyAdapter** - KeyListener
- **WindowAdapter** - WindowListener
- **FocusAdapter** - FocusListener

Adapter classes provide empty implementations, allowing you to override only needed methods.

---

## 5.6 Defining Listeners

### Ways to Define Listeners

#### 1. Anonymous Inner Classes
```java
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Button clicked!");
    }
});
```
**Pros**: 
- Quick for simple listeners
- Access to outer class variables

**Cons**:
- Verbose syntax
- Hard to reuse

#### 2. Lambda Expressions (Java 8+)
```java
button.addActionListener(e -> System.out.println("Button clicked!"));

// For multiple statements
button.addActionListener(e -> {
    String text = textField.getText();
    System.out.println("Text: " + text);
});
```
**Pros**:
- Concise syntax
- Readable for simple operations

**Cons**:
- Only for functional interfaces
- Limited to single method interfaces

#### 3. Named Inner Classes
```java
public class MyFrame extends JFrame {
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            handleButtonClick();
        }
    }
    
    public MyFrame() {
        JButton button = new JButton("Click");
        button.addActionListener(new ButtonClickListener());
    }
}
```
**Pros**:
- Can access outer class members
- More organized than anonymous classes

**Cons**:
- Still tightly coupled
- Can't be reused outside outer class

#### 4. Separate Listener Classes
```java
public class ButtonClickListener implements ActionListener {
    private JTextField textField;
    
    public ButtonClickListener(JTextField textField) {
        this.textField = textField;
    }
    
    public void actionPerformed(ActionEvent e) {
        System.out.println("Text: " + textField.getText());
    }
}

// Usage
ButtonClickListener listener = new ButtonClickListener(textField);
button.addActionListener(listener);
```
**Pros**:
- Reusable
- Testable
- Follows single responsibility principle

**Cons**:
- Need to pass dependencies
- More boilerplate

#### 5. Implementing Listener Interface
```java
public class MyFrame extends JFrame implements ActionListener {
    private JButton button1;
    private JButton button2;
    
    public MyFrame() {
        button1 = new JButton("Button 1");
        button2 = new JButton("Button 2");
        
        button1.addActionListener(this);
        button2.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == button1) {
            handleButton1Click();
        } else if (source == button2) {
            handleButton2Click();
        }
    }
}
```
**Pros**:
- Simple for few components
- All event handling in one place

**Cons**:
- Becomes messy with many components
- Violates single responsibility principle

### Best Practices for Listeners

#### 1. Use Lambda Expressions for Simple Cases
```java
// Good
button.addActionListener(e -> showMessage("Clicked!"));

// Avoid
button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        showMessage("Clicked!");
    }
});
```

#### 2. Use Separate Classes for Complex Logic
```java
// Good
public class LoginButtonListener implements ActionListener {
    private final LoginService loginService;
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    
    public LoginButtonListener(LoginService loginService, 
                               JTextField usernameField, 
                               JPasswordField passwordField) {
        this.loginService = loginService;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        
        if (loginService.authenticate(username, password)) {
            showSuccessMessage();
        } else {
            showErrorMessage();
        }
    }
}
```

#### 3. Remove Listeners When No Longer Needed
```java
ActionListener listener = e -> handleEvent();
button.addActionListener(listener);

// Later, when done
button.removeActionListener(listener);
```

#### 4. Use Event Objects Appropriately
```java
button.addActionListener(e -> {
    // Get event information
    String command = e.getActionCommand();
    long when = e.getWhen();
    int modifiers = e.getModifiers();
    
    // Use the information
    System.out.println("Command: " + command);
    System.out.println("Time: " + when);
});
```

### Complete Example
```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CompleteGUIExample extends JFrame {
    private JTextField nameField;
    private JButton submitButton;
    private JLabel resultLabel;

    public CompleteGUIExample() {
        setTitle("Complete GUI Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        initComponents();
        layoutComponents();
        setupListeners();
    }

    private void initComponents() {
        nameField = new JTextField(20);
        submitButton = new JButton("Submit");
        resultLabel = new JLabel("Enter your name and click submit");
    }

    private void layoutComponents() {
        setLayout(new FlowLayout());
        add(new JLabel("Name:"));
        add(nameField);
        add(submitButton);
        add(resultLabel);
    }

    private void setupListeners() {
        // Submit button listener
        submitButton.addActionListener(this::handleSubmit);
        
        // Enter key listener for text field
        nameField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    handleSubmit(null);
                }
            }
        });
        
        // Window listener
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Application closing");
            }
        });
    }

    private void handleSubmit(ActionEvent e) {
        String name = nameField.getText().trim();
        if (name.isEmpty()) {
            resultLabel.setText("Please enter a name");
            resultLabel.setForeground(Color.RED);
        } else {
            resultLabel.setText("Hello, " + name + "!");
            resultLabel.setForeground(Color.BLUE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CompleteGUIExample().setVisible(true);
        });
    }
}
```

---

## Summary

### Key Takeaways
1. **Swing** provides platform-independent GUI components
2. **Components** are the building blocks of GUI applications
3. **Layout Managers** control component positioning
4. **Event Delegation Model** handles user interactions
5. **Listeners** respond to events using various implementation strategies

### Best Practices
- Use `SwingUtilities.invokeLater()` for thread safety
- Choose appropriate layout managers for your needs
- Use lambda expressions for simple event handling
- Separate complex logic into dedicated listener classes
- Always remove listeners when they're no longer needed
- Test your GUI applications on different platforms

### Common Pitfalls to Avoid
- Don't block the Event Dispatch Thread (EDT)
- Don't mix AWT and Swing components unnecessarily
- Don't forget to set window close operation
- Don't use absolute positioning unless absolutely necessary
- Don't create components outside the EDT

This comprehensive guide covers all the essential topics for GUI programming with Java Swing, providing both theoretical knowledge and practical examples.
