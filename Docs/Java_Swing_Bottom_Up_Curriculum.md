# Java Swing Bottom-Up Guide and Curriculum

This document is a detailed, technical, bottom-up guide to Java Swing. It is designed to be read like a curriculum: start at the top, build each idea carefully, and use the exercises and project milestones to turn the reading into real skill.

Swing is Java's classic desktop GUI toolkit. It is part of the JDK, so you do not need external libraries to start. Swing is older than JavaFX and modern web UI frameworks, but it is still valuable for learning event-driven programming, object-oriented design, desktop application structure, custom rendering, state management, and GUI architecture.

The goal of this guide is not only to teach buttons and windows. The goal is to help you build a complete project after reading: a maintainable desktop application with clear models, views, actions, input validation, persistence, menus, dialogs, background work, and a polished user experience.

---

## Table of Contents

1. Prerequisites
2. What Swing Is
3. The Mental Model of GUI Programming
4. Your First Swing Program
5. The Event Dispatch Thread
6. Top-Level Windows
7. Components
8. Containers
9. Layout Managers
10. Events and Listeners
11. Actions
12. Text Input and Validation
13. Models and State
14. Lists, Combo Boxes, Tables, and Trees
15. Menus, Toolbars, and Popups
16. Dialogs
17. Custom Painting
18. Images, Icons, Fonts, and Colors
19. Look and Feel
20. Keyboard Shortcuts and Focus
21. Background Work with SwingWorker
22. File Choosers and Persistence
23. Application Architecture
24. Testing and Debugging Swing Apps
25. Packaging and Running
26. Final Project Curriculum
27. Reference Cheat Sheets

---

## 1. Prerequisites

Before studying Swing, you should be comfortable with these Java topics:

- Classes and objects
- Constructors
- Encapsulation
- Inheritance
- Interfaces
- Abstract classes
- Collections such as `ArrayList`, `HashMap`, and `List`
- Exceptions
- Basic file handling
- Lambdas
- Packages and imports

You do not need to be perfect at all of these, but Swing uses object-oriented Java heavily. A Swing application is usually a graph of objects that communicate through events.

Important packages:

```java
import javax.swing.*;
// for java 
import javax.swing.table.*;
// 
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
```

Two package families matter most:

- `javax.swing`: Swing widgets such as `JFrame`, `JButton`, `JPanel`, `JTable`, `JList`, and `JDialog`.
- `java.awt`: lower-level windowing, layout, graphics, colors, fonts, events, and geometry.

Swing is built on top of AWT. You will use both.

---

## 2. What Swing Is

Swing is a GUI toolkit for Java desktop applications.

It provides:

- Windows
- Buttons
- Labels
- Text fields
- Menus
- Tables
- Lists
- Trees
- Dialog boxes
- Custom drawing
- Keyboard and mouse input
- Pluggable visual themes

Swing applications are event-driven. The program does not simply run from top to bottom and finish. Instead, it creates a window, waits for user actions, and responds to events.

Traditional console program:

```java
public class ConsoleApp {
    public static void main(String[] args) {
        System.out.println("Enter your name:");
        // read input
        // print output
        // end
    }
}
```

Swing program:

```java
public class GuiApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My App");
            frame.setSize(400, 300);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
```

The GUI program keeps running because the window system is alive and waiting for events.

---

## 3. The Mental Model of GUI Programming

A Swing application is built from four major ideas:

1. Components
2. Containers
3. Layout managers
4. Events

### Components

A component is something visible or interactive:

- `JButton`
- `JLabel`
- `JTextField`
- `JTextArea`
- `JCheckBox`
- `JRadioButton`
- `JTable`
- `JList`

Most Swing widgets inherit from `JComponent`.

### Containers

A container holds components:

- `JFrame`
- `JPanel`
- `JDialog`
- `JScrollPane`
- `JSplitPane`
- `JTabbedPane`

Most real screens are built from multiple nested panels.

### Layout Managers

A layout manager decides where components go and how large they become.

Common layout managers:

- `BorderLayout`
- `FlowLayout`
- `GridLayout`
- `BoxLayout`
- `GridBagLayout`
- `CardLayout`

Never rely heavily on absolute pixel positions. Good Swing applications use layout managers.

### Events

Events happen when the user interacts with the UI:

- Button clicked
- Key pressed
- Mouse moved
- Text changed
- Table row selected
- Window closed

You respond with listeners:

```java
button.addActionListener(event -> {
    System.out.println("Button clicked");
});
```

---

## 4. Your First Swing Program

Create a file named `HelloSwing.java`:

```java
import javax.swing.*;
import java.awt.*;

public class HelloSwing {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(HelloSwing::createAndShowGui);
    }

    private static void createAndShowGui() {
        JFrame frame = new JFrame("Hello Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, Swing!", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 24));

        frame.add(label);
        frame.setSize(400, 250);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
```

Compile and run:

```bash
javac HelloSwing.java
java HelloSwing
```

Line-by-line:

- `SwingUtilities.invokeLater(...)` schedules GUI creation on Swing's event thread.
- `JFrame` creates a top-level window.
- `setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)` exits the program when the window closes.
- `JLabel` displays text.
- `frame.add(label)` adds the label to the frame's content area.
- `setSize(...)` gives the frame dimensions.
- `setLocationRelativeTo(null)` centers the frame on the screen.
- `setVisible(true)` shows the window.

Checkpoint:

- Change the title.
- Change the label text.
- Change the font size.
- Resize the window.
- Add a button instead of a label.

---

## 5. The Event Dispatch Thread

Swing is not thread-safe. Almost all Swing component creation and updates must happen on the Event Dispatch Thread, often called the EDT.

The EDT is the thread responsible for:

- Drawing components
- Processing button clicks
- Processing key and mouse events
- Updating GUI state

Correct:

```java
SwingUtilities.invokeLater(() -> {
    JFrame frame = new JFrame("Safe");
    frame.setVisible(true);
});
```

Incorrect:

```java
JFrame frame = new JFrame("Risky");
frame.setVisible(true);
```

The incorrect version may appear to work for small examples, but it teaches the wrong habit.

### Do Not Block the EDT

If you do slow work inside a button listener, the UI freezes.

Bad:

```java
button.addActionListener(event -> {
    Thread.sleep(5000); // freezes UI
});
```

Better:

```java
button.addActionListener(event -> {
    new SwingWorker<String, Void>() {
        @Override
        protected String doInBackground() throws Exception {
            Thread.sleep(5000);
            return "Done";
        }

        @Override
        protected void done() {
            label.setText("Finished");
        }
    }.execute();
});
```

Rule:

- Create and update Swing components on the EDT.
- Run slow work outside the EDT.
- Return results to the EDT before touching the UI.

---

## 6. Top-Level Windows

Top-level windows are containers that can appear directly on the screen.

Important classes:

- `JFrame`: main application window
- `JDialog`: secondary dialog window
- `JWindow`: undecorated window, rarely needed

### JFrame

Use `JFrame` for the main window.

```java
JFrame frame = new JFrame("Student Manager");
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setMinimumSize(new Dimension(800, 500));
frame.setLocationRelativeTo(null);
frame.setVisible(true);
```

Useful methods:

```java
frame.setTitle("New Title");
frame.setSize(900, 600);
frame.setMinimumSize(new Dimension(700, 400));
frame.setResizable(true);
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setJMenuBar(menuBar);
frame.add(component);
frame.pack();
```

Prefer `pack()` when your components have good preferred sizes:

```java
frame.pack();
frame.setLocationRelativeTo(null);
frame.setVisible(true);
```

`pack()` asks the layout system to calculate a natural size.

### Default Close Operations

Common values:

- `JFrame.EXIT_ON_CLOSE`: exit application
- `JFrame.DISPOSE_ON_CLOSE`: close this window and release resources
- `JFrame.HIDE_ON_CLOSE`: hide the window
- `JFrame.DO_NOTHING_ON_CLOSE`: ignore close button unless you handle it

For one main app window, use `EXIT_ON_CLOSE`.

For secondary windows, use `DISPOSE_ON_CLOSE`.

---

## 7. Components

Components are the visible building blocks of Swing.

### JLabel

Displays text or an icon.

```java
JLabel nameLabel = new JLabel("Name:");
nameLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
```

Labels are often paired with inputs.

### JButton

Represents a clickable command.

```java
JButton saveButton = new JButton("Save");
saveButton.addActionListener(event -> saveStudent());
```

Buttons should represent actions, not state. Use checkboxes, radio buttons, or toggles for state.

### JTextField

Single-line text input.

```java
JTextField nameField = new JTextField(20);
String name = nameField.getText();
nameField.setText("Abel");
```

The constructor argument is columns, not exact pixels.

### JPasswordField

Input for passwords.

```java
JPasswordField passwordField = new JPasswordField(20);
char[] password = passwordField.getPassword();
```

Use `getPassword()` instead of `getText()`.

### JTextArea

Multi-line text input.

```java
JTextArea notesArea = new JTextArea(8, 30);
notesArea.setLineWrap(true);
notesArea.setWrapStyleWord(true);

JScrollPane scrollPane = new JScrollPane(notesArea);
```

Large text components should usually be placed inside `JScrollPane`.

### JCheckBox

Represents an independent true/false choice.

```java
JCheckBox activeCheckBox = new JCheckBox("Active");
boolean active = activeCheckBox.isSelected();
```

### JRadioButton

Represents one choice from a group.

```java
JRadioButton male = new JRadioButton("Male");
JRadioButton female = new JRadioButton("Female");

ButtonGroup group = new ButtonGroup();
group.add(male);
group.add(female);
```

Use `ButtonGroup` to make radio buttons mutually exclusive.

### JComboBox

Dropdown selection.

```java
JComboBox<String> departmentBox = new JComboBox<>();
departmentBox.addItem("Computer Science");
departmentBox.addItem("Information Systems");

String selected = (String) departmentBox.getSelectedItem();
```

### JSlider

Numeric range input.

```java
JSlider slider = new JSlider(0, 100, 50);
slider.setMajorTickSpacing(25);
slider.setPaintTicks(true);
slider.setPaintLabels(true);
```

### JSpinner

Numeric or date stepping input.

```java
JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 0, 120, 1));
int age = (Integer) ageSpinner.getValue();
```

### JTable

Displays tabular data.

```java
String[] columns = {"ID", "Name", "Department"};
Object[][] data = {
    {1, "Sara", "CS"},
    {2, "Dawit", "IS"}
};

JTable table = new JTable(data, columns);
JScrollPane scrollPane = new JScrollPane(table);
```

For serious applications, use a custom `TableModel` instead of raw arrays.

### JList

Displays a vertical list of items.

```java
DefaultListModel<String> model = new DefaultListModel<>();
model.addElement("Java");
model.addElement("Python");

JList<String> list = new JList<>(model);
```

### JProgressBar

Shows progress.

```java
JProgressBar progressBar = new JProgressBar(0, 100);
progressBar.setValue(40);
progressBar.setStringPainted(true);
```

Useful with `SwingWorker`.

---

## 8. Containers

Containers hold components.

### JPanel

The most important container.

```java
JPanel panel = new JPanel(new BorderLayout());
panel.add(new JLabel("Title"), BorderLayout.NORTH);
panel.add(new JButton("Save"), BorderLayout.SOUTH);
```

Most Swing screens are built by composing panels.

### JScrollPane

Adds scrolling to a component.

```java
JTextArea area = new JTextArea(20, 50);
JScrollPane scrollPane = new JScrollPane(area);
```

Use it with:

- `JTextArea`
- `JTable`
- `JList`
- `JTree`
- custom drawing panels

### JSplitPane

Splits space between two components.

```java
JSplitPane splitPane = new JSplitPane(
    JSplitPane.HORIZONTAL_SPLIT,
    leftPanel,
    rightPanel
);
splitPane.setResizeWeight(0.3);
```

### JTabbedPane

Multiple pages in tabs.

```java
JTabbedPane tabs = new JTabbedPane();
tabs.addTab("Students", studentsPanel);
tabs.addTab("Courses", coursesPanel);
```

### CardLayout

Switches between screens in the same area.

```java
JPanel cards = new JPanel(new CardLayout());
cards.add(loginPanel, "login");
cards.add(dashboardPanel, "dashboard");

CardLayout layout = (CardLayout) cards.getLayout();
layout.show(cards, "dashboard");
```

Use `CardLayout` for simple navigation.

---

## 9. Layout Managers

Layout managers are one of the most important parts of Swing.

They solve this problem:

> When the window is resized, where should each component go?

Avoid `setLayout(null)` and `setBounds(...)` for normal application UI. Absolute positioning breaks resizing, fonts, scaling, and platform differences.

### BorderLayout

Divides a container into five regions:

- `BorderLayout.NORTH`
- `BorderLayout.SOUTH`
- `BorderLayout.WEST`
- `BorderLayout.EAST`
- `BorderLayout.CENTER`

```java
JPanel panel = new JPanel(new BorderLayout(8, 8));
panel.add(toolbar, BorderLayout.NORTH);
panel.add(navigation, BorderLayout.WEST);
panel.add(content, BorderLayout.CENTER);
panel.add(statusBar, BorderLayout.SOUTH);
```

Only one component can occupy each region. If you need more than one, put them in another panel.

Good for main application windows.

### FlowLayout

Places components left-to-right, wrapping as needed.

```java
JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
buttons.add(cancelButton);
buttons.add(saveButton);
```

Good for small button rows.

### GridLayout

Creates equal-sized cells.

```java
JPanel keypad = new JPanel(new GridLayout(4, 3, 4, 4));
```

Good for calculators, keypads, and simple equal grids.

### BoxLayout

Stacks components horizontally or vertically.

```java
JPanel form = new JPanel();
form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
form.add(nameField);
form.add(Box.createVerticalStrut(8));
form.add(emailField);
```

Good for vertical forms and sidebars.

### GridBagLayout

The most flexible built-in layout manager.

It uses constraints to place components in a grid with variable sizes.

```java
JPanel form = new JPanel(new GridBagLayout());
GridBagConstraints gbc = new GridBagConstraints();
gbc.insets = new Insets(4, 4, 4, 4);
gbc.anchor = GridBagConstraints.WEST;

gbc.gridx = 0;
gbc.gridy = 0;
form.add(new JLabel("Name:"), gbc);

gbc.gridx = 1;
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.weightx = 1.0;
form.add(new JTextField(20), gbc);
```

Important `GridBagConstraints` fields:

- `gridx`, `gridy`: column and row
- `gridwidth`, `gridheight`: how many cells to span
- `weightx`, `weighty`: how extra space is distributed
- `fill`: whether component grows horizontally or vertically
- `anchor`: where component sits if it does not fill
- `insets`: external spacing

Use helper methods to avoid repetitive code in large forms.

### Recommended Layout Strategy

For real apps:

1. Use `BorderLayout` for the main frame.
2. Use `JPanel` to divide sections.
3. Use `GridBagLayout` for forms.
4. Use `FlowLayout` for button rows.
5. Use `JScrollPane` for large content.
6. Use `CardLayout` for navigation between screens.

---

## 10. Events and Listeners

Swing uses listeners to respond to events.

### ActionListener

Used for buttons, menu items, text field enter key, and combo boxes.

```java
saveButton.addActionListener(event -> {
    saveStudent();
});
```

### ItemListener

Used when item selection changes.

```java
activeCheckBox.addItemListener(event -> {
    boolean selected = event.getStateChange() == ItemEvent.SELECTED;
});
```

### ChangeListener

Used for sliders, spinners, tabs, and some models.

```java
slider.addChangeListener(event -> {
    int value = slider.getValue();
});
```

### ListSelectionListener

Used when a `JList` or `JTable` selection changes.

```java
table.getSelectionModel().addListSelectionListener(event -> {
    if (!event.getValueIsAdjusting()) {
        int row = table.getSelectedRow();
        if (row >= 0) {
            loadSelectedRow(row);
        }
    }
});
```

The `getValueIsAdjusting()` check prevents duplicate handling while selection is still changing.

### DocumentListener

Used when text changes in a `JTextField` or `JTextArea`.

```java
nameField.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        validateForm();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        validateForm();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        validateForm();
    }
});
```

For normal text fields, `insertUpdate` and `removeUpdate` are usually the important ones.

### MouseListener

Used for mouse clicks, presses, releases, entering, and exiting.

```java
panel.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent event) {
        System.out.println(event.getPoint());
    }
});
```

Use adapter classes such as `MouseAdapter` when you only need some methods.

### KeyListener

Key listeners exist, but for keyboard shortcuts, prefer key bindings.

---

## 11. Actions

`Action` is a reusable command object.

Instead of wiring the same behavior separately into a button and menu item, define an action once.

```java
Action saveAction = new AbstractAction("Save") {
    @Override
    public void actionPerformed(ActionEvent event) {
        saveStudent();
    }
};

JButton saveButton = new JButton(saveAction);
JMenuItem saveMenuItem = new JMenuItem(saveAction);
```

You can enable or disable the action:

```java
saveAction.setEnabled(false);
```

Both button and menu item update automatically.

Useful action properties:

```java
saveAction.putValue(Action.NAME, "Save");
saveAction.putValue(Action.SHORT_DESCRIPTION, "Save the current record");
saveAction.putValue(Action.MNEMONIC_KEY, KeyEvent.VK_S);
saveAction.putValue(Action.ACCELERATOR_KEY,
    KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
```

Use actions for:

- Save
- Delete
- New
- Open
- Export
- Search
- Refresh
- Login

---

## 12. Text Input and Validation

User input is unreliable. Your GUI must validate it.

### Basic Validation

```java
private boolean validateStudentForm() {
    String name = nameField.getText().trim();
    String email = emailField.getText().trim();

    if (name.isEmpty()) {
        showError("Name is required.");
        return false;
    }

    if (!email.contains("@")) {
        showError("Email must contain @.");
        return false;
    }

    return true;
}
```

### Friendly Error Display

Avoid only printing errors to the console. Show them in the UI.

```java
JOptionPane.showMessageDialog(
    this,
    "Name is required.",
    "Validation Error",
    JOptionPane.ERROR_MESSAGE
);
```

For forms, you can also use an error label:

```java
errorLabel.setText("Name is required.");
errorLabel.setForeground(Color.RED);
```

### Real-Time Validation

Use `DocumentListener` to enable the Save button only when the form is valid.

```java
private void updateSaveButtonState() {
    boolean valid = !nameField.getText().trim().isEmpty()
        && emailField.getText().contains("@");
    saveAction.setEnabled(valid);
}
```

### JFormattedTextField

For formatted values:

```java
JFormattedTextField priceField = new JFormattedTextField(NumberFormat.getNumberInstance());
priceField.setColumns(10);
```

Useful for:

- Numbers
- Dates
- Currency

But be careful: formatted fields can be confusing if you do not handle parsing errors clearly.

### InputVerifier

`InputVerifier` validates when focus tries to leave a component.

```java
emailField.setInputVerifier(new InputVerifier() {
    @Override
    public boolean verify(JComponent input) {
        JTextField field = (JTextField) input;
        return field.getText().contains("@");
    }
});
```

Use sparingly. Blocking focus movement can annoy users.

---

## 13. Models and State

Swing separates many components into:

- Component: visual widget
- Model: data behind the widget

Examples:

- `JList` uses `ListModel`
- `JTable` uses `TableModel`
- `JComboBox` uses `ComboBoxModel`
- `JTree` uses `TreeModel`
- `JSpinner` uses `SpinnerModel`

This is important because serious apps should not store everything directly in components.

### Poor State Management

```java
String name = nameField.getText();
table.setValueAt(name, row, 1);
```

This may work, but it mixes user interface and application data too tightly.

### Better State Management

Create a domain model:

```java
public class Student {
    private int id;
    private String name;
    private String email;
    private String department;

    public Student(int id, String name, String email, String department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDepartment() {
        return department;
    }
}
```

Store data in a list:

```java
List<Student> students = new ArrayList<>();
```

Then create a table model that displays that list.

---

## 14. Lists, Combo Boxes, Tables, and Trees

These components are model-driven and extremely useful in real projects.

### JList with DefaultListModel

```java
DefaultListModel<Student> studentListModel = new DefaultListModel<>();
JList<Student> studentList = new JList<>(studentListModel);

studentListModel.addElement(new Student(1, "Sara", "sara@example.com", "CS"));
```

By default, `JList` uses `toString()` to display objects.

You can override `toString()`:

```java
@Override
public String toString() {
    return name + " (" + department + ")";
}
```

For more control, use a custom cell renderer.

### Custom List Renderer

```java
studentList.setCellRenderer((list, value, index, isSelected, cellHasFocus) -> {
    JLabel label = new JLabel(value.getName() + " - " + value.getDepartment());
    label.setOpaque(true);

    if (isSelected) {
        label.setBackground(list.getSelectionBackground());
        label.setForeground(list.getSelectionForeground());
    } else {
        label.setBackground(list.getBackground());
        label.setForeground(list.getForeground());
    }

    return label;
});
```

Renderers are reused like stamps. Do not store application state inside renderers.

### JComboBox with Objects

```java
JComboBox<Department> departmentBox = new JComboBox<>();
departmentBox.addItem(new Department("CS", "Computer Science"));
departmentBox.addItem(new Department("IS", "Information Systems"));
```

Override `toString()` in `Department` or provide a renderer.

### JTable

`JTable` is powerful but should be used with a table model.

A basic custom table model:

```java
public class StudentTableModel extends AbstractTableModel {
    private final String[] columns = {"ID", "Name", "Email", "Department"};
    private final List<Student> students = new ArrayList<>();

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> student.getId();
            case 1 -> student.getName();
            case 2 -> student.getEmail();
            case 3 -> student.getDepartment();
            default -> null;
        };
    }

    public Student getStudentAt(int row) {
        return students.get(row);
    }

    public void addStudent(Student student) {
        int row = students.size();
        students.add(student);
        fireTableRowsInserted(row, row);
    }

    public void removeStudent(int row) {
        students.remove(row);
        fireTableRowsDeleted(row, row);
    }
}
```

Why `fireTableRowsInserted` matters:

- It tells the table that the model changed.
- The table redraws only what it needs.
- Selection and sorting behave better.

### JTable Sorting

```java
table.setAutoCreateRowSorter(true);
```

Important: when sorting is enabled, view row indexes and model row indexes are different.

```java
int viewRow = table.getSelectedRow();
int modelRow = table.convertRowIndexToModel(viewRow);
Student selected = tableModel.getStudentAt(modelRow);
```

Always convert row indexes when using sorting or filtering.

### JTable Editing

To make cells editable:

```java
@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    return columnIndex != 0;
}

@Override
public void setValueAt(Object value, int rowIndex, int columnIndex) {
    // update your model object here
    fireTableCellUpdated(rowIndex, columnIndex);
}
```

Only allow direct table editing when it makes sense. For complex forms, edit in fields or dialogs.

### Filtering with TableRowSorter

```java
TableRowSorter<StudentTableModel> sorter = new TableRowSorter<>(tableModel);
table.setRowSorter(sorter);

searchField.getDocument().addDocumentListener(new DocumentListener() {
    private void update() {
        String text = searchField.getText().trim();
        if (text.isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(text)));
        }
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        update();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        update();
    }
});
```

Requires:

```java
import java.util.regex.Pattern;
```

### JTree

Use `JTree` for hierarchical data.

```java
DefaultMutableTreeNode root = new DefaultMutableTreeNode("School");
DefaultMutableTreeNode cs = new DefaultMutableTreeNode("Computer Science");
cs.add(new DefaultMutableTreeNode("Java"));
cs.add(new DefaultMutableTreeNode("Database"));
root.add(cs);

JTree tree = new JTree(root);
```

Use trees only when the data is naturally hierarchical.

---

## 15. Menus, Toolbars, and Popups

### JMenuBar

```java
JMenuBar menuBar = new JMenuBar();

JMenu fileMenu = new JMenu("File");
fileMenu.add(new JMenuItem(newAction));
fileMenu.add(new JMenuItem(saveAction));
fileMenu.addSeparator();
fileMenu.add(new JMenuItem(exitAction));

menuBar.add(fileMenu);
frame.setJMenuBar(menuBar);
```

### Mnemonics and Accelerators

Mnemonic: keyboard letter used when menu is open.

```java
fileMenu.setMnemonic(KeyEvent.VK_F);
```

Accelerator: global shortcut while window is focused.

```java
saveAction.putValue(
    Action.ACCELERATOR_KEY,
    KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK)
);
```

### JToolBar

```java
JToolBar toolBar = new JToolBar();
toolBar.setFloatable(false);
toolBar.add(newAction);
toolBar.add(saveAction);
toolBar.add(deleteAction);
```

Toolbars should contain common commands.

### JPopupMenu

Context menu, often shown on right click.

```java
JPopupMenu popup = new JPopupMenu();
popup.add(new JMenuItem(deleteAction));

table.setComponentPopupMenu(popup);
```

For row-specific table actions, select the row under the mouse before showing the popup.

---

## 16. Dialogs

Dialogs are secondary windows for short tasks or messages.

### JOptionPane

Message:

```java
JOptionPane.showMessageDialog(
    frame,
    "Student saved successfully.",
    "Saved",
    JOptionPane.INFORMATION_MESSAGE
);
```

Confirmation:

```java
int result = JOptionPane.showConfirmDialog(
    frame,
    "Delete this student?",
    "Confirm Delete",
    JOptionPane.YES_NO_OPTION
);

if (result == JOptionPane.YES_OPTION) {
    deleteStudent();
}
```

Input:

```java
String name = JOptionPane.showInputDialog(frame, "Enter name:");
```

### Custom JDialog

Use `JDialog` for complex input.

```java
public class StudentDialog extends JDialog {
    private boolean confirmed;
    private final JTextField nameField = new JTextField(20);

    public StudentDialog(Window owner) {
        super(owner, "Student", ModalityType.APPLICATION_MODAL);
        setLayout(new BorderLayout(8, 8));

        JPanel form = new JPanel(new GridLayout(1, 2, 4, 4));
        form.add(new JLabel("Name:"));
        form.add(nameField);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(event -> {
            confirmed = true;
            dispose();
        });

        add(form, BorderLayout.CENTER);
        add(okButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(owner);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public String getStudentName() {
        return nameField.getText().trim();
    }
}
```

Usage:

```java
StudentDialog dialog = new StudentDialog(frame);
dialog.setVisible(true);

if (dialog.isConfirmed()) {
    String name = dialog.getStudentName();
}
```

Modal dialogs block interaction with the parent window until closed.

---

## 17. Custom Painting

Custom painting lets you draw your own graphics.

Use a `JPanel` and override `paintComponent`.

```java
public class ChartPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        try {
            g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(Color.BLUE);
            g2.fillRect(20, 20, 100, 50);
        } finally {
            g2.dispose();
        }
    }
}
```

Rules:

- Override `paintComponent`, not `paint`.
- Call `super.paintComponent(g)`.
- Do not perform slow work inside painting.
- Do not load files inside painting.
- Use `repaint()` when visual state changes.
- Use `Graphics2D` for better drawing.
- Dispose copied graphics contexts created by `g.create()`.

### Drawing Shapes

```java
g2.drawLine(10, 10, 100, 100);
g2.drawRect(20, 20, 80, 40);
g2.fillOval(120, 20, 60, 60);
```

### Drawing Text

```java
g2.setFont(new Font("SansSerif", Font.BOLD, 18));
g2.drawString("Sales", 20, 40);
```

### Preferred Size

Custom components should often define a preferred size:

```java
@Override
public Dimension getPreferredSize() {
    return new Dimension(400, 300);
}
```

### Animation

Use `javax.swing.Timer` for simple GUI animation.

```java
Timer timer = new Timer(16, event -> {
    x += 2;
    repaint();
});
timer.start();
```

This timer fires on the EDT, so keep its work small.

---

## 18. Images, Icons, Fonts, and Colors

### Icons

```java
ImageIcon icon = new ImageIcon("assets/save.png");
JButton saveButton = new JButton("Save", icon);
```

For resources packaged with your app:

```java
ImageIcon icon = new ImageIcon(
    Objects.requireNonNull(getClass().getResource("/icons/save.png"))
);
```

Resources should usually be placed under:

```text
src/main/resources/icons/save.png
```

### Scaling Images

```java
Image original = icon.getImage();
Image scaled = original.getScaledInstance(24, 24, Image.SCALE_SMOOTH);
ImageIcon scaledIcon = new ImageIcon(scaled);
```

For high-quality repeated scaling, consider using `BufferedImage` and `Graphics2D`.

### Fonts

```java
label.setFont(label.getFont().deriveFont(Font.BOLD, 18f));
```

Prefer deriving from the existing font instead of hardcoding everything.

### Colors

```java
panel.setBackground(new Color(245, 245, 245));
button.setForeground(Color.WHITE);
```

Use colors carefully. Desktop apps should prioritize readability and platform consistency.

### Borders

```java
panel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
```

Common borders:

- `createEmptyBorder`
- `createLineBorder`
- `createTitledBorder`
- `createCompoundBorder`

Use empty borders for spacing. Do not create spacing with random labels.

---

## 19. Look and Feel

Swing supports pluggable look and feel.

Set the system look and feel:

```java
try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (ClassNotFoundException
       | InstantiationException
       | IllegalAccessException
       | UnsupportedLookAndFeelException ex) {
    ex.printStackTrace();
}
```

Call this before creating components.

Example:

```java
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        setLookAndFeel();
        new StudentManagerFrame().setVisible(true);
    });
}
```

Do not over-customize every component early. First build correct layout and behavior. Then polish.

---

## 20. Keyboard Shortcuts and Focus

### Key Bindings

Prefer key bindings over `KeyListener` for commands.

```java
JComponent root = frame.getRootPane();

root.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
    .put(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK), "newStudent");

root.getActionMap().put("newStudent", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent event) {
        createNewStudent();
    }
});
```

Input map conditions:

- `WHEN_FOCUSED`
- `WHEN_ANCESTOR_OF_FOCUSED_COMPONENT`
- `WHEN_IN_FOCUSED_WINDOW`

For app-level shortcuts, use `WHEN_IN_FOCUSED_WINDOW`.

### Focus

Request focus after the UI is visible:

```java
SwingUtilities.invokeLater(() -> nameField.requestFocusInWindow());
```

Set tab order only when the default order is poor. Most of the time, component add order controls focus traversal.

---

## 21. Background Work with SwingWorker

Use `SwingWorker` for tasks that take time:

- Loading files
- Saving large data
- Calling APIs
- Searching many records
- Generating reports

Basic pattern:

```java
new SwingWorker<List<Student>, Void>() {
    @Override
    protected List<Student> doInBackground() throws Exception {
        return studentRepository.loadAll();
    }

    @Override
    protected void done() {
        try {
            List<Student> students = get();
            tableModel.setStudents(students);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        } catch (ExecutionException ex) {
            showError("Could not load students: " + ex.getCause().getMessage());
        }
    }
}.execute();
```

Requires:

```java
import java.util.concurrent.ExecutionException;
```

### Progress Updates

```java
SwingWorker<Void, Integer> worker = new SwingWorker<>() {
    @Override
    protected Void doInBackground() throws Exception {
        for (int i = 0; i <= 100; i++) {
            setProgress(i);
            Thread.sleep(50);
        }
        return null;
    }
};

worker.addPropertyChangeListener(event -> {
    if ("progress".equals(event.getPropertyName())) {
        progressBar.setValue((Integer) event.getNewValue());
    }
});

worker.execute();
```

### Publish and Process

Use `publish` and `process` when background work produces intermediate results.

```java
new SwingWorker<Void, String>() {
    @Override
    protected Void doInBackground() {
        publish("Starting...");
        publish("Loading records...");
        publish("Done.");
        return null;
    }

    @Override
    protected void process(List<String> chunks) {
        for (String message : chunks) {
            logArea.append(message + "\n");
        }
    }
}.execute();
```

---

## 22. File Choosers and Persistence

### JFileChooser

Open file:

```java
JFileChooser chooser = new JFileChooser();
int result = chooser.showOpenDialog(frame);

if (result == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
    loadFile(file.toPath());
}
```

Save file:

```java
JFileChooser chooser = new JFileChooser();
int result = chooser.showSaveDialog(frame);

if (result == JFileChooser.APPROVE_OPTION) {
    File file = chooser.getSelectedFile();
    saveFile(file.toPath());
}
```

### Simple Text Persistence

```java
Files.writeString(path, textArea.getText());
String content = Files.readString(path);
```

Requires:

```java
import java.nio.file.Files;
import java.nio.file.Path;
```

### CSV Persistence

Simple CSV writing:

```java
public void saveStudents(Path path, List<Student> students) throws IOException {
    List<String> lines = new ArrayList<>();
    lines.add("id,name,email,department");

    for (Student student : students) {
        lines.add(student.getId() + ","
            + escapeCsv(student.getName()) + ","
            + escapeCsv(student.getEmail()) + ","
            + escapeCsv(student.getDepartment()));
    }

    Files.write(path, lines);
}

private String escapeCsv(String value) {
    if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
        return "\"" + value.replace("\"", "\"\"") + "\"";
    }
    return value;
}
```

For complex CSV, use a proper CSV library. For learning, implementing a small serializer teaches useful details.

### Unsaved Changes

Track dirty state:

```java
private boolean dirty;

private void markDirty() {
    dirty = true;
    updateTitle();
}

private void markClean() {
    dirty = false;
    updateTitle();
}

private void updateTitle() {
    frame.setTitle(dirty ? "Student Manager *" : "Student Manager");
}
```

Ask before closing:

```java
frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent event) {
        attemptExit();
    }
});
```

---

## 23. Application Architecture

Small demos can put everything in one class. Real projects should not.

Recommended package structure:

```text
src/main/java/com/example/studentmanager/
    App.java
    model/
        Student.java
        Department.java
    repository/
        StudentRepository.java
        CsvStudentRepository.java
    service/
        StudentService.java
    ui/
        MainFrame.java
        StudentFormPanel.java
        StudentTablePanel.java
        StudentTableModel.java
        StudentDialog.java
```

### Responsibilities

`model`:

- Plain Java objects representing data
- No Swing imports

`repository`:

- Loading and saving data
- File or database access
- No Swing imports

`service`:

- Business rules
- Validation that is not purely visual
- Coordination between repositories and models

`ui`:

- Swing components
- Listeners
- User interaction

### Important Rule

Your model should not depend on Swing.

Bad:

```java
public class Student {
    private JTextField nameField;
}
```

Good:

```java
public class Student {
    private String name;
}
```

### MVC Thinking

Swing already uses model-view ideas internally, but at the application level you can think this way:

- Model: your data and business objects
- View: panels, frames, dialogs
- Controller/Presenter: event-handling logic that connects UI to model

You do not need a perfect formal MVC framework. You need separation of responsibilities.

### MainFrame Example Structure

```java
public class MainFrame extends JFrame {
    private final StudentService studentService;
    private final StudentTableModel tableModel;

    public MainFrame(StudentService studentService) {
        super("Student Manager");
        this.studentService = studentService;
        this.tableModel = new StudentTableModel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(createToolBar(), BorderLayout.NORTH);
        add(new JScrollPane(new JTable(tableModel)), BorderLayout.CENTER);
        setMinimumSize(new Dimension(800, 500));
        pack();
        setLocationRelativeTo(null);
    }
}
```

### Avoid These Common Architecture Mistakes

- Putting all code in `main`
- Making every field `static`
- Storing data only in text fields and table cells
- Mixing file saving code directly into button listeners
- Creating one huge class with thousands of lines
- Updating UI from background threads
- Letting dialogs directly mutate global state

---

## 24. Testing and Debugging Swing Apps

Swing UI automation can be harder than testing normal classes, so separate logic from UI.

Easy to test:

- Models
- Repositories
- Services
- Validators
- Formatters

Harder to test:

- Exact button clicks
- Pixel-perfect layout
- Custom painting

### Validation Test Example

```java
public class StudentValidator {
    public List<String> validate(String name, String email) {
        List<String> errors = new ArrayList<>();

        if (name == null || name.trim().isEmpty()) {
            errors.add("Name is required.");
        }

        if (email == null || !email.contains("@")) {
            errors.add("Email is invalid.");
        }

        return errors;
    }
}
```

This class can be tested without Swing.

### Debugging Tips

- Print current selected row and converted model row.
- Check whether code is running on the EDT:

```java
System.out.println(SwingUtilities.isEventDispatchThread());
```

- Use borders temporarily to understand layout:

```java
panel.setBorder(BorderFactory.createLineBorder(Color.RED));
```

- If a component is invisible, check:
  - Was it added to a visible container?
  - Did you call `pack()` or set a size?
  - Is the layout manager replacing another component in the same region?
  - Is it inside a scroll pane with a bad preferred size?
  - Are you updating the UI on the EDT?

### Common Error: Component Added But Not Showing

If you add a component after the frame is visible:

```java
panel.add(new JButton("New"));
panel.revalidate();
panel.repaint();
```

`revalidate()` asks the layout manager to run again.

`repaint()` asks Swing to redraw.

---

## 25. Packaging and Running

### Simple javac

For one file:

```bash
javac HelloSwing.java
java HelloSwing
```

For packages:

```bash
javac -d out src/main/java/com/example/App.java
java -cp out com.example.App
```

### Maven

Typical Maven structure:

```text
src/main/java/
src/main/resources/
src/test/java/
pom.xml
```

Run:

```bash
mvn compile
mvn test
```

If your app has a main class, configure packaging or run from the IDE.

### Runnable JAR

A runnable JAR needs a manifest with `Main-Class`, or a build plugin that creates one.

For learning, your IDE's run button is fine. For project submission, learn how to export or package the app.

---

## 26. Final Project Curriculum

This section turns the guide into a project path. Build the project step by step.

Recommended final project:

> Student Course Manager

Core features:

- Add students
- Edit students
- Delete students
- Search students
- Assign courses
- Show students in a table
- Save and load data from CSV or JSON
- Use dialogs for add/edit
- Use menus and keyboard shortcuts
- Show validation errors
- Track unsaved changes

### Phase 1: Window and Layout

Build:

- `App.java`
- `MainFrame.java`
- Main window with `BorderLayout`
- Toolbar at top
- Table in center
- Status bar at bottom

Skills:

- `JFrame`
- `JPanel`
- `BorderLayout`
- `JToolBar`
- `JLabel`

Deliverable:

- A resizable window with empty table and toolbar buttons.

### Phase 2: Domain Model

Build:

- `Student`
- `Course`
- `Department`

Example fields:

```java
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String department;
}
```

Skills:

- Encapsulation
- Constructors
- Getters
- Setters or immutable design
- `toString`

Deliverable:

- Model classes with no Swing imports.

### Phase 3: Table Model

Build:

- `StudentTableModel extends AbstractTableModel`

Required methods:

- `getRowCount`
- `getColumnCount`
- `getColumnName`
- `getValueAt`
- `addStudent`
- `removeStudent`
- `getStudentAt`
- `setStudents`

Skills:

- `JTable`
- `AbstractTableModel`
- model-view separation

Deliverable:

- Table displays sample students.

### Phase 4: Add Student Dialog

Build:

- `StudentDialog`

Fields:

- First name
- Last name
- Email
- Department combo box

Buttons:

- Save
- Cancel

Skills:

- `JDialog`
- `GridBagLayout`
- input validation
- modal dialogs

Deliverable:

- User can add a student through a dialog.

### Phase 5: Edit and Delete

Build:

- Edit selected student
- Delete selected student
- Confirmation before delete
- Disable edit/delete when no row is selected

Skills:

- table selection
- actions
- `JOptionPane`
- `ListSelectionListener`

Deliverable:

- User can update and remove records safely.

### Phase 6: Search and Sort

Build:

- Search text field
- Row filtering
- Table sorting

Skills:

- `TableRowSorter`
- `RowFilter`
- `DocumentListener`
- view/model row conversion

Deliverable:

- User can search by name, email, or department.

### Phase 7: Menus and Shortcuts

Build:

- File menu
- Edit menu
- Help menu
- New, Save, Open, Exit actions
- Keyboard shortcuts

Skills:

- `JMenuBar`
- `JMenu`
- `JMenuItem`
- `Action`
- accelerators

Deliverable:

- Commands available from toolbar and menu.

### Phase 8: Persistence

Build:

- `StudentRepository`
- `CsvStudentRepository`
- Open file
- Save file
- Save As
- Unsaved changes marker

Skills:

- `JFileChooser`
- file I/O
- exception handling
- dirty state

Deliverable:

- Data survives after closing the application.

### Phase 9: Background Work

Build:

- Load file using `SwingWorker`
- Save file using `SwingWorker`
- Progress bar or status message

Skills:

- EDT safety
- `SwingWorker`
- error reporting

Deliverable:

- App stays responsive during file operations.

### Phase 10: Polish

Build:

- System look and feel
- Empty state label
- Better spacing
- Status messages
- About dialog
- Confirm exit with unsaved changes

Skills:

- UI polish
- user experience
- maintainability

Deliverable:

- A complete, usable desktop project.

---

## 27. Reference Cheat Sheets

### Essential Swing Startup Template

```java
public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            setLookAndFeel();
            MainFrame frame = new MainFrame();
            frame.setVisible(true);
        });
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException
               | InstantiationException
               | IllegalAccessException
               | UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }
}
```

### Component Choice Guide

Use:

- `JLabel` for display text
- `JTextField` for single-line input
- `JTextArea` for multi-line input
- `JButton` for commands
- `JCheckBox` for independent yes/no values
- `JRadioButton` for one choice from a small group
- `JComboBox` for one choice from a larger group
- `JList` for a list of records
- `JTable` for records with multiple columns
- `JTree` for hierarchy
- `JPanel` for grouping
- `JScrollPane` for scrollable content
- `JDialog` for secondary workflows

### Layout Choice Guide

Use:

- `BorderLayout` for main screens
- `FlowLayout` for button rows
- `GridLayout` for equal cells
- `GridBagLayout` for forms
- `BoxLayout` for vertical or horizontal stacks
- `CardLayout` for screen switching

### Event Choice Guide

Use:

- `ActionListener` for commands
- `DocumentListener` for text changes
- `ListSelectionListener` for table/list selection
- `ChangeListener` for sliders/spinners/tabs
- `ItemListener` for checkbox/combo item changes
- Key bindings for keyboard shortcuts
- `MouseAdapter` for mouse behavior

### EDT Rules

Remember:

- Build GUI on EDT.
- Update GUI on EDT.
- Do slow work outside EDT.
- Use `SwingWorker` for background tasks.
- Never block button listeners with long operations.

### Table Rules

Remember:

- Use `AbstractTableModel` for real data.
- Fire table events after model changes.
- Convert view rows to model rows when sorting/filtering.
- Do not store your only copy of data inside the table component.

### Project Readiness Checklist

Before starting your project, you should be able to:

- Create a `JFrame` safely on the EDT
- Add panels using layout managers
- Handle button clicks
- Read and validate text input
- Show error messages
- Build a custom table model
- Add, edit, and remove records
- Use dialogs
- Use menus and actions
- Save and load files
- Keep the UI responsive with `SwingWorker`
- Separate model, repository, service, and UI code

---

## Suggested Study Schedule

### Week 1: Foundations

Study:

- Sections 1 to 10

Practice:

- Build small windows
- Try every basic component
- Practice layout managers
- Write event listeners

Mini project:

- Simple calculator
- Login form mockup
- Temperature converter

### Week 2: Data-Oriented UI

Study:

- Sections 11 to 16

Practice:

- Build forms
- Validate input
- Use `JList`
- Use `JTable`
- Create dialogs

Mini project:

- Contact list manager without file saving

### Week 3: Real Application Behavior

Study:

- Sections 17 to 23

Practice:

- Add menus
- Add search
- Add file saving
- Add background loading

Mini project:

- Contact manager with CSV persistence

### Week 4: Final Project

Study:

- Sections 24 to 27

Build:

- Student Course Manager

Focus:

- Clean packages
- Clear responsibilities
- Good validation
- Usable table workflows
- Reliable saving and loading

---

## Final Advice

Swing rewards patience. At first, the code may feel verbose because you are building windows from many small objects. That is normal. The skill is learning how to divide the application into clear pieces:

- Data classes hold data.
- Repositories load and save.
- Services enforce rules.
- Swing panels display and collect information.
- Actions connect user commands to behavior.

If you can build a complete Swing project with that separation, you will have learned much more than GUI programming. You will have practiced real application design.

