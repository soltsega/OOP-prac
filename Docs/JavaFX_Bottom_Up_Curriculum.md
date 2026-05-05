# JavaFX Bottom-Up Guide and Curriculum

This document is a detailed, technical, bottom-up guide to JavaFX. It is designed to be used as both documentation and a curriculum. Read it in order, type the examples, and build the project milestones as you go.

JavaFX is Java's modern rich-client GUI framework. Compared with Swing, JavaFX has a cleaner scene graph model, CSS styling, observable properties, binding, FXML markup, animation APIs, media support, charts, and stronger separation between UI layout and controller code.

The goal of this guide is not only to teach windows and buttons. The goal is to prepare you to build a complete desktop application after reading: a maintainable JavaFX project with models, views, controllers, validation, tables, dialogs, menus, CSS, FXML, persistence, background tasks, and a final project structure.

Version note: JavaFX is no longer bundled with the JDK in modern Java versions. You normally add OpenJFX dependencies through Maven/Gradle or install a JavaFX SDK. The exact newest JavaFX version changes over time, so use a stable OpenJFX release compatible with your JDK and verify current versions from OpenJFX or Maven Central when creating a new project.

---

## Table of Contents

1. Prerequisites
2. What JavaFX Is
3. Swing vs JavaFX
4. The JavaFX Mental Model
5. Installing and Running JavaFX
6. Your First JavaFX Program
7. Application, Stage, Scene, and Node
8. The JavaFX Application Thread
9. Scene Graph Fundamentals
10. Layout Panes
11. Controls
12. Events
13. Properties and Observables
14. Binding
15. Collections and ObservableList
16. Text Input and Validation
17. Choice Controls
18. ListView, TableView, TreeView, and TreeTableView
19. Menus, Toolbars, Context Menus, and Shortcuts
20. Dialogs and Alerts
21. FXML
22. Controllers
23. CSS Styling
24. Images, Icons, Fonts, and Resources
25. Custom Drawing with Canvas
26. Shapes, Effects, Transforms, and Animation
27. Concurrency with Task and Service
28. File Choosers and Persistence
29. Application Architecture
30. Testing and Debugging JavaFX Apps
31. Packaging and Running
32. Final Project Curriculum
33. Reference Cheat Sheets

---

## 1. Prerequisites

Before studying JavaFX, you should understand these Java topics:

- Classes and objects
- Constructors
- Encapsulation
- Inheritance
- Interfaces
- Generics
- Collections
- Exceptions
- Lambdas
- Packages and imports
- Basic file handling
- Maven or Gradle basics

JavaFX also uses these ideas heavily:

- Event-driven programming
- Object composition
- Observable state
- Binding
- MVC or MVVM-style separation

Important JavaFX packages:

```java
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.*;
import javafx.collections.*;
import javafx.beans.property.*;
import javafx.beans.binding.*;
import javafx.concurrent.*;
import javafx.fxml.*;
```

Common JavaFX modules:

- `javafx.controls`: buttons, labels, text fields, tables, lists, menus, layout basics
- `javafx.fxml`: FXML loading and controller support
- `javafx.graphics`: scene graph, stage, scene, shapes, canvas, images
- `javafx.base`: properties, observables, binding, collections
- `javafx.media`: audio/video
- `javafx.web`: embedded web view

For most beginner and intermediate projects, you mainly need:

```text
javafx.controls
javafx.fxml
```

---

## 2. What JavaFX Is

JavaFX is a GUI framework for building rich desktop applications in Java.

It provides:

- Windows
- Controls
- Layout panes
- CSS styling
- FXML markup
- Observable properties
- Data binding
- Tables, lists, trees, and charts
- Animation
- 2D shapes
- Canvas drawing
- Media playback
- Web content embedding
- Background task helpers

JavaFX applications are event-driven. You create a window and scene, then the framework waits for user actions such as clicks, typing, selection, resizing, and menu commands.

Console style:

```java
public class ConsoleProgram {
    public static void main(String[] args) {
        System.out.println("Program starts");
        System.out.println("Program ends");
    }
}
```

JavaFX style:

```java
public class GuiProgram extends Application {
    @Override
    public void start(Stage stage) {
        Button button = new Button("Click Me");
        Scene scene = new Scene(new StackPane(button), 400, 250);

        stage.setTitle("JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

The program stays alive because the JavaFX runtime is running an event loop.

---

## 3. Swing vs JavaFX

Swing and JavaFX are both Java GUI technologies, but they feel different.

Swing:

- Older
- Included in the JDK
- Uses `JFrame`, `JPanel`, `JButton`, `JTable`
- Uses layout managers
- Styling is mostly through component properties and look and feel
- Uses listener interfaces
- Uses `SwingWorker` for background tasks

JavaFX:

- Newer
- Distributed separately from the JDK in modern Java
- Uses `Stage`, `Scene`, `Node`, `Pane`, `Button`, `TableView`
- Uses a scene graph
- Styling is usually done with CSS
- Supports properties and binding deeply
- Supports FXML for declarative UI
- Uses `Task` and `Service` for background tasks

Swing code often says:

```java
button.addActionListener(event -> save());
```

JavaFX code often says:

```java
button.setOnAction(event -> save());
```

Swing layout often says:

```java
panel.add(button, BorderLayout.CENTER);
```

JavaFX layout often says:

```java
root.setCenter(button);
```

JavaFX is especially good for learning:

- Scene graphs
- Reactive UI state
- Binding
- CSS-based styling
- Declarative UI with FXML
- Cleaner separation of view and controller code

---

## 4. The JavaFX Mental Model

JavaFX is built around these major ideas:

1. Application lifecycle
2. Stage
3. Scene
4. Scene graph
5. Nodes
6. Layout panes
7. Controls
8. Events
9. Properties
10. Binding

### Application Lifecycle

Your main JavaFX class extends `Application`.

```java
public class App extends Application {
    @Override
    public void start(Stage stage) {
        // create UI here
    }
}
```

The JavaFX runtime calls `start`.

Optional lifecycle methods:

```java
@Override
public void init() {
    // runs before start
}

@Override
public void stop() {
    // runs when app exits
}
```

Do not create UI in `main`. Use `start`.

### Stage

A `Stage` is a top-level window.

```java
stage.setTitle("Student Manager");
stage.setScene(scene);
stage.show();
```

### Scene

A `Scene` is the content inside a stage.

```java
Scene scene = new Scene(root, 900, 600);
```

Each scene has one root node.

### Scene Graph

The scene graph is a tree of nodes.

Example:

```text
Scene
└── BorderPane
    ├── top: ToolBar
    ├── left: VBox
    ├── center: TableView
    └── bottom: Label
```

### Node

Almost everything visible in JavaFX is a `Node`.

Examples:

- `Button`
- `Label`
- `TextField`
- `TableView`
- `VBox`
- `Rectangle`
- `Canvas`

### Parent

A `Parent` is a node that can contain child nodes.

Examples:

- `Pane`
- `VBox`
- `HBox`
- `BorderPane`
- `GridPane`
- `StackPane`

### Controls

Controls are ready-made interactive UI elements.

Examples:

- `Button`
- `TextField`
- `ComboBox`
- `TableView`
- `ListView`
- `MenuBar`

### Properties

JavaFX objects expose observable properties.

```java
StringProperty name = new SimpleStringProperty("Abel");
name.set("Sara");
System.out.println(name.get());
```

Properties can notify listeners and participate in binding.

### Binding

Binding connects values so one value automatically updates when another changes.

```java
label.textProperty().bind(nameField.textProperty());
```

When the text field changes, the label changes automatically.

---

## 5. Installing and Running JavaFX

JavaFX setup depends on your tools.

Recommended beginner path:

1. Use Maven.
2. Add OpenJFX dependencies.
3. Use the JavaFX Maven plugin.
4. Run with `mvn javafx:run`.

### Maven Project Structure

```text
my-javafx-app/
    pom.xml
    src/
        main/
            java/
                com/example/app/
                    App.java
            resources/
                com/example/app/
                    main-view.fxml
                    styles.css
```

### Example pom.xml

Use this as a starting point. Replace the JavaFX version with a stable version compatible with your JDK.

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.example</groupId>
    <artifactId>javafx-student-manager</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>21</maven.compiler.source>
        <maven.compiler.target>21</maven.compiler.target>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <javafx.version>21.0.6</javafx.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>${javafx.version}</version>
        </dependency>

        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>${javafx.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.13.0</version>
            </plugin>

            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <configuration>
                    <mainClass>com.example.app.App</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

Run:

```bash
mvn javafx:run
```

Important:

- If your JDK is newer than your JavaFX version, you may still be fine, but matching major versions is usually cleaner.
- Long-term-support versions such as JavaFX 17 and 21 are common choices for learning and coursework.
- If your class or instructor gives a required version, use that.

### Module System Option

If using Java modules, add `module-info.java`:

```java
module com.example.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.app to javafx.fxml;
    exports com.example.app;
}
```

Many beginner projects skip modules at first. That is acceptable. Learn JavaFX first, then add modules when needed.

---

## 6. Your First JavaFX Program

Create `App.java`:

```java
package com.example.app;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Label label = new Label("Hello, JavaFX!");
        label.setFont(Font.font("SansSerif", 26));

        StackPane root = new StackPane(label);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 420, 260);

        stage.setTitle("Hello JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

Line-by-line:

- `extends Application`: marks this as a JavaFX app.
- `start(Stage stage)`: entry point for the UI.
- `Label`: displays text.
- `StackPane`: layout pane that stacks children.
- `Scene`: holds the visual tree.
- `stage.setScene(scene)`: puts the scene in the window.
- `stage.show()`: displays the window.
- `launch(args)`: starts the JavaFX runtime.

Checkpoint:

- Change the label text.
- Change the window size.
- Add a button.
- Put the label and button in a `VBox`.
- Print a message when the button is clicked.

---

## 7. Application, Stage, Scene, and Node

These are the four foundational concepts.

### Application

`Application` controls the lifecycle.

```java
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        // UI setup
    }
}
```

The JavaFX runtime creates an instance of your application class.

### Stage

A `Stage` is a window.

```java
Stage dialogStage = new Stage();
dialogStage.setTitle("Details");
dialogStage.setScene(new Scene(root));
dialogStage.show();
```

Useful methods:

```java
stage.setTitle("Title");
stage.setScene(scene);
stage.setWidth(900);
stage.setHeight(600);
stage.setMinWidth(700);
stage.setMinHeight(450);
stage.setResizable(true);
stage.centerOnScreen();
stage.show();
stage.close();
```

### Scene

A `Scene` contains a root node.

```java
BorderPane root = new BorderPane();
Scene scene = new Scene(root, 900, 600);
```

You can switch scenes:

```java
stage.setScene(loginScene);
stage.setScene(dashboardScene);
```

For many apps, switching the center content of a root layout is cleaner than replacing the whole scene.

### Node

`Node` is the base class for visible scene graph objects.

Useful node methods:

```java
node.setVisible(true);
node.setDisable(false);
node.setOpacity(0.8);
node.setStyle("-fx-background-color: white;");
node.getStyleClass().add("primary-button");
```

Difference between invisible and unmanaged:

```java
node.setVisible(false);
```

The node is hidden but may still take layout space.

```java
node.setManaged(false);
```

The layout pane ignores the node.

Often use both:

```java
errorLabel.setVisible(false);
errorLabel.setManaged(false);
```

---

## 8. The JavaFX Application Thread

JavaFX has a special UI thread called the JavaFX Application Thread.

Use this thread for:

- Creating UI
- Updating controls
- Handling events
- Modifying scene graph nodes

Do not run slow work on this thread.

Bad:

```java
button.setOnAction(event -> {
    Thread.sleep(5000); // freezes UI
});
```

Better:

```java
Task<String> task = new Task<>() {
    @Override
    protected String call() throws Exception {
        Thread.sleep(5000);
        return "Done";
    }
};

task.setOnSucceeded(event -> label.setText(task.getValue()));
new Thread(task).start();
```

Use `Platform.runLater` when a background thread needs to schedule a UI update:

```java
Platform.runLater(() -> statusLabel.setText("Finished"));
```

Rule:

- UI work belongs on the JavaFX Application Thread.
- Slow work belongs in a background thread.
- Use `Task`, `Service`, or `Platform.runLater` to coordinate safely.

---

## 9. Scene Graph Fundamentals

The JavaFX UI is a tree.

Example:

```java
BorderPane root = new BorderPane();
ToolBar toolBar = new ToolBar(new Button("New"), new Button("Save"));
TableView<Student> table = new TableView<>();
Label status = new Label("Ready");

root.setTop(toolBar);
root.setCenter(table);
root.setBottom(status);
```

Tree:

```text
BorderPane
├── ToolBar
│   ├── Button
│   └── Button
├── TableView
└── Label
```

Important idea:

> Layout flows from parent to child.

Parents decide how children are arranged. Children may report preferred sizes, minimum sizes, maximum sizes, and layout constraints.

### Parent-Child Rules

A node can only have one parent.

Incorrect:

```java
Button button = new Button("Save");
leftPane.getChildren().add(button);
rightPane.getChildren().add(button); // removes or errors conceptually
```

Correct:

```java
Button leftButton = new Button("Save");
Button rightButton = new Button("Save");
```

Or reuse behavior with an `EventHandler` or `Action`-like method.

### Adding and Removing Nodes

```java
vbox.getChildren().add(new Label("New item"));
vbox.getChildren().remove(existingNode);
vbox.getChildren().clear();
```

### Lookup

You can find nodes by CSS id:

```java
Node node = scene.lookup("#saveButton");
```

But in real controller code, prefer fields and direct references over lookup.

---

## 10. Layout Panes

Layout panes arrange child nodes.

Avoid absolute positioning for normal app UI. JavaFX has `Pane` for manual placement, but most applications should use layout panes such as `BorderPane`, `VBox`, `HBox`, `GridPane`, `StackPane`, and `SplitPane`.

### BorderPane

Divides space into top, bottom, left, right, and center.

```java
BorderPane root = new BorderPane();
root.setTop(menuBar);
root.setLeft(sidebar);
root.setCenter(content);
root.setBottom(statusBar);
```

Good for main windows.

### VBox

Stacks children vertically.

```java
VBox form = new VBox(8);
form.setPadding(new Insets(12));
form.getChildren().addAll(nameField, emailField, saveButton);
```

### HBox

Stacks children horizontally.

```java
HBox buttons = new HBox(8, cancelButton, saveButton);
buttons.setAlignment(Pos.CENTER_RIGHT);
```

### StackPane

Stacks children on top of each other.

```java
StackPane root = new StackPane(content, loadingOverlay);
```

Good for:

- Centering
- Overlays
- Empty states
- Layering

### GridPane

Form-like grid layout.

```java
GridPane form = new GridPane();
form.setHgap(8);
form.setVgap(8);
form.setPadding(new Insets(12));

form.add(new Label("Name:"), 0, 0);
form.add(nameField, 1, 0);
form.add(new Label("Email:"), 0, 1);
form.add(emailField, 1, 1);
```

Allow fields to grow:

```java
ColumnConstraints labels = new ColumnConstraints();
labels.setHgrow(Priority.NEVER);

ColumnConstraints fields = new ColumnConstraints();
fields.setHgrow(Priority.ALWAYS);

form.getColumnConstraints().addAll(labels, fields);
GridPane.setHgrow(nameField, Priority.ALWAYS);
```

### FlowPane

Wraps children like words in a paragraph.

```java
FlowPane tags = new FlowPane(6, 6);
tags.getChildren().addAll(new Label("Java"), new Label("OOP"));
```

Good for tags, chips, or small repeated controls.

### TilePane

Arranges equal-sized tiles.

```java
TilePane gallery = new TilePane(12, 12);
gallery.setPrefColumns(4);
```

Good for galleries or card grids.

### AnchorPane

Anchors children to edges.

```java
AnchorPane.setTopAnchor(table, 0.0);
AnchorPane.setRightAnchor(table, 0.0);
AnchorPane.setBottomAnchor(table, 0.0);
AnchorPane.setLeftAnchor(table, 0.0);
```

FXML tools often use `AnchorPane`, but do not overuse it for everything.

### SplitPane

Resizable split between areas.

```java
SplitPane splitPane = new SplitPane(sidebar, content);
splitPane.setDividerPositions(0.28);
```

### ScrollPane

Adds scrolling.

```java
ScrollPane scrollPane = new ScrollPane(form);
scrollPane.setFitToWidth(true);
```

Use it for long forms and custom content.

### Recommended Layout Strategy

For real apps:

1. Use `BorderPane` as the main root.
2. Use `MenuBar` and `ToolBar` at the top.
3. Use `SplitPane` for master/detail layouts.
4. Use `VBox` and `HBox` for stacks and button rows.
5. Use `GridPane` for forms.
6. Use `StackPane` for overlays and empty states.
7. Use `ScrollPane` when content can exceed the viewport.

---

## 11. Controls

Controls are ready-made UI widgets.

### Label

Displays text.

```java
Label label = new Label("Name:");
label.setFont(Font.font(14));
```

### Button

Clickable command.

```java
Button saveButton = new Button("Save");
saveButton.setOnAction(event -> saveStudent());
```

### TextField

Single-line text input.

```java
TextField nameField = new TextField();
nameField.setPromptText("Full name");
String name = nameField.getText();
```

### PasswordField

Password input.

```java
PasswordField passwordField = new PasswordField();
```

### TextArea

Multi-line text input.

```java
TextArea notesArea = new TextArea();
notesArea.setWrapText(true);
notesArea.setPrefRowCount(6);
```

### CheckBox

Independent true/false value.

```java
CheckBox activeBox = new CheckBox("Active");
boolean active = activeBox.isSelected();
```

### RadioButton and ToggleGroup

One choice from a group.

```java
RadioButton male = new RadioButton("Male");
RadioButton female = new RadioButton("Female");

ToggleGroup genderGroup = new ToggleGroup();
male.setToggleGroup(genderGroup);
female.setToggleGroup(genderGroup);
```

### ComboBox

Dropdown selection.

```java
ComboBox<String> departmentBox = new ComboBox<>();
departmentBox.getItems().addAll("Computer Science", "Information Systems");
departmentBox.getSelectionModel().selectFirst();
```

### Slider

Numeric range.

```java
Slider slider = new Slider(0, 100, 50);
slider.setShowTickMarks(true);
slider.setShowTickLabels(true);
```

### Spinner

Numeric, date, or list stepping input.

```java
Spinner<Integer> ageSpinner = new Spinner<>(0, 120, 18);
ageSpinner.setEditable(true);
```

### DatePicker

Date input.

```java
DatePicker datePicker = new DatePicker();
LocalDate selectedDate = datePicker.getValue();
```

Requires:

```java
import java.time.LocalDate;
```

### ProgressBar and ProgressIndicator

```java
ProgressBar progressBar = new ProgressBar();
progressBar.setProgress(0.4);

ProgressIndicator spinner = new ProgressIndicator();
```

Use `-1` for indeterminate progress:

```java
progressBar.setProgress(ProgressIndicator.INDETERMINATE_PROGRESS);
```

### Tooltip

```java
button.setTooltip(new Tooltip("Save the current file"));
```

### Separator

```java
toolBar.getItems().add(new Separator());
```

---

## 12. Events

JavaFX events are handled with event handlers.

### Button Action

```java
saveButton.setOnAction(event -> saveStudent());
```

### Text Change Listener

```java
nameField.textProperty().addListener((observable, oldValue, newValue) -> {
    validateForm();
});
```

### Selection Change

```java
table.getSelectionModel().selectedItemProperty().addListener(
    (observable, oldStudent, newStudent) -> {
        if (newStudent != null) {
            showStudentDetails(newStudent);
        }
    }
);
```

### Mouse Events

```java
node.setOnMouseClicked(event -> {
    System.out.println(event.getX() + ", " + event.getY());
});
```

### Key Events

For text-specific behavior, use input listeners. For shortcuts, prefer accelerators or key combinations.

```java
scene.setOnKeyPressed(event -> {
    if (event.getCode() == KeyCode.ESCAPE) {
        closeOverlay();
    }
});
```

Requires:

```java
import javafx.scene.input.KeyCode;
```

### Event Bubbling and Capturing

JavaFX events travel through the scene graph.

Two phases:

- Capturing phase: root down to target
- Bubbling phase: target back up to root

Use event filters for capturing:

```java
root.addEventFilter(MouseEvent.MOUSE_CLICKED, event -> {
    System.out.println("Before child handles click");
});
```

Use event handlers for bubbling:

```java
button.addEventHandler(ActionEvent.ACTION, event -> {
    System.out.println("Button action");
});
```

Consume an event to stop further handling:

```java
event.consume();
```

Use consumption carefully. It can make UI behavior confusing if overused.

---

## 13. Properties and Observables

Properties are one of the biggest differences between JavaFX and older Java GUI programming.

### Simple Property

```java
StringProperty name = new SimpleStringProperty("Abel");

System.out.println(name.get());
name.set("Sara");
```

### Property Listener

```java
name.addListener((observable, oldValue, newValue) -> {
    System.out.println("Name changed from " + oldValue + " to " + newValue);
});
```

### Common Property Types

- `StringProperty`
- `IntegerProperty`
- `DoubleProperty`
- `BooleanProperty`
- `ObjectProperty<T>`
- `ListProperty<T>`

Implementations:

- `SimpleStringProperty`
- `SimpleIntegerProperty`
- `SimpleDoubleProperty`
- `SimpleBooleanProperty`
- `SimpleObjectProperty<T>`

### JavaFX Model Class

For `TableView`, JavaFX property-based models are useful.

```java
public class Student {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();

    public Student(int id, String firstName, String lastName, String email) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }
}
```

This looks verbose, but it enables clean binding and table integration.

### Plain Java Model vs JavaFX Property Model

Plain model:

```java
public class Student {
    private String name;
}
```

JavaFX property model:

```java
public class Student {
    private final StringProperty name = new SimpleStringProperty();
}
```

Use plain models when:

- Your model must stay independent of JavaFX
- You share data with backend code
- You want clean domain objects

Use JavaFX property models when:

- The model is mostly for UI
- You need table editing and binding
- You want automatic UI updates

For serious layered apps, a common compromise is:

- Domain model: plain Java
- View model: JavaFX properties

---

## 14. Binding

Binding connects values automatically.

### Unidirectional Binding

```java
Label preview = new Label();
preview.textProperty().bind(nameField.textProperty());
```

Now the label follows the text field.

You cannot manually set a bound property:

```java
preview.setText("Manual"); // error if text is bound
```

Unbind first:

```java
preview.textProperty().unbind();
preview.setText("Manual");
```

### Bidirectional Binding

```java
model.nameProperty().bindBidirectional(nameField.textProperty());
```

Now model and text field update each other.

Use bidirectional binding carefully. It is powerful, but too many bidirectional bindings can make data flow hard to reason about.

### Boolean Binding

Disable Save button when name is empty:

```java
saveButton.disableProperty().bind(nameField.textProperty().isEmpty());
```

Multiple conditions:

```java
BooleanBinding invalidForm = nameField.textProperty().isEmpty()
    .or(emailField.textProperty().isEmpty())
    .or(Bindings.createBooleanBinding(
        () -> !emailField.getText().contains("@"),
        emailField.textProperty()
    ));

saveButton.disableProperty().bind(invalidForm);
```

### String Binding

```java
Label countLabel = new Label();
countLabel.textProperty().bind(
    Bindings.size(studentList).asString("Students: %d")
);
```

### Numeric Binding

```java
progressBar.progressProperty().bind(task.progressProperty());
```

### Binding Best Practices

Good uses:

- Disable buttons based on form validity
- Show count labels
- Connect progress bar to task progress
- Keep detail panel synchronized with selected item
- Tie visibility and managed state together

Example:

```java
errorLabel.managedProperty().bind(errorLabel.visibleProperty());
```

Avoid:

- Complex business logic hidden inside bindings
- Long chains that are hard to debug
- Bidirectional binding everywhere

---

## 15. Collections and ObservableList

JavaFX uses observable collections so controls can update when data changes.

### ObservableList

```java
ObservableList<Student> students = FXCollections.observableArrayList();
students.add(new Student(1, "Sara", "Ali", "sara@example.com"));
```

Controls such as `ListView`, `TableView`, and `ComboBox` can use observable lists.

```java
tableView.setItems(students);
```

When you add or remove items, the table updates.

### Listening to List Changes

```java
students.addListener((ListChangeListener<Student>) change -> {
    while (change.next()) {
        if (change.wasAdded()) {
            System.out.println("Added: " + change.getAddedSubList());
        }
        if (change.wasRemoved()) {
            System.out.println("Removed: " + change.getRemoved());
        }
    }
});
```

### FilteredList

```java
FilteredList<Student> filtered = new FilteredList<>(students, student -> true);

searchField.textProperty().addListener((observable, oldText, newText) -> {
    String query = newText == null ? "" : newText.toLowerCase();
    filtered.setPredicate(student ->
        student.getFirstName().toLowerCase().contains(query)
            || student.getLastName().toLowerCase().contains(query)
            || student.getEmail().toLowerCase().contains(query)
    );
});
```

### SortedList

```java
SortedList<Student> sorted = new SortedList<>(filtered);
sorted.comparatorProperty().bind(tableView.comparatorProperty());
tableView.setItems(sorted);
```

This is the standard search-and-sort pattern:

```text
ObservableList -> FilteredList -> SortedList -> TableView
```

---

## 16. Text Input and Validation

Validation protects your application from bad input.

### Basic Validation

```java
private boolean validateForm() {
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

### Error Label

```java
Label errorLabel = new Label();
errorLabel.getStyleClass().add("error-label");
errorLabel.setVisible(false);
errorLabel.setManaged(false);
errorLabel.managedProperty().bind(errorLabel.visibleProperty());
```

Show error:

```java
private void showError(String message) {
    errorLabel.setText(message);
    errorLabel.setVisible(true);
}
```

Clear error:

```java
private void clearError() {
    errorLabel.setText("");
    errorLabel.setVisible(false);
}
```

### Real-Time Validation

```java
BooleanBinding invalidForm = Bindings.createBooleanBinding(
    () -> nameField.getText().trim().isEmpty()
        || !emailField.getText().contains("@"),
    nameField.textProperty(),
    emailField.textProperty()
);

saveButton.disableProperty().bind(invalidForm);
```

### TextFormatter

Use `TextFormatter` to restrict or convert input.

Integer-only field:

```java
TextFormatter<Integer> formatter = new TextFormatter<>(
    new IntegerStringConverter(),
    0,
    change -> {
        String newText = change.getControlNewText();
        if (newText.matches("\\d*")) {
            return change;
        }
        return null;
    }
);

ageField.setTextFormatter(formatter);
```

Requires:

```java
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
```

### Validation Design

For real projects, separate validation logic from UI:

```java
public class StudentValidator {
    public List<String> validate(String firstName, String lastName, String email) {
        List<String> errors = new ArrayList<>();

        if (firstName == null || firstName.trim().isEmpty()) {
            errors.add("First name is required.");
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            errors.add("Last name is required.");
        }

        if (email == null || !email.contains("@")) {
            errors.add("Email is invalid.");
        }

        return errors;
    }
}
```

This is testable without JavaFX.

---

## 17. Choice Controls

### ComboBox

```java
ComboBox<Department> departmentBox = new ComboBox<>();
departmentBox.setItems(FXCollections.observableArrayList(
    new Department("CS", "Computer Science"),
    new Department("IS", "Information Systems")
));
```

By default, the combo box displays `toString()`.

Better display with cell factory:

```java
departmentBox.setCellFactory(listView -> new ListCell<>() {
    @Override
    protected void updateItem(Department department, boolean empty) {
        super.updateItem(department, empty);
        setText(empty || department == null ? null : department.getName());
    }
});

departmentBox.setButtonCell(new ListCell<>() {
    @Override
    protected void updateItem(Department department, boolean empty) {
        super.updateItem(department, empty);
        setText(empty || department == null ? null : department.getName());
    }
});
```

### ChoiceBox

Simpler than `ComboBox`.

```java
ChoiceBox<String> choiceBox = new ChoiceBox<>();
choiceBox.getItems().addAll("Low", "Medium", "High");
```

Use `ComboBox` more often for modern forms.

### RadioButton

```java
ToggleGroup group = new ToggleGroup();

RadioButton beginner = new RadioButton("Beginner");
RadioButton intermediate = new RadioButton("Intermediate");
RadioButton advanced = new RadioButton("Advanced");

beginner.setToggleGroup(group);
intermediate.setToggleGroup(group);
advanced.setToggleGroup(group);
```

Read selection:

```java
RadioButton selected = (RadioButton) group.getSelectedToggle();
String level = selected.getText();
```

### CheckBox

```java
CheckBox enrolledBox = new CheckBox("Currently enrolled");
enrolledBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
    System.out.println(isSelected);
});
```

---

## 18. ListView, TableView, TreeView, and TreeTableView

These are data controls. They are essential for real JavaFX applications.

### ListView

```java
ObservableList<Student> students = FXCollections.observableArrayList();
ListView<Student> listView = new ListView<>(students);
```

Custom display:

```java
listView.setCellFactory(view -> new ListCell<>() {
    @Override
    protected void updateItem(Student student, boolean empty) {
        super.updateItem(student, empty);
        if (empty || student == null) {
            setText(null);
        } else {
            setText(student.getFirstName() + " " + student.getLastName());
        }
    }
});
```

Selection:

```java
listView.getSelectionModel().selectedItemProperty().addListener(
    (obs, oldStudent, selectedStudent) -> showStudent(selectedStudent)
);
```

### TableView

Basic table:

```java
TableView<Student> table = new TableView<>();
table.setItems(students);

TableColumn<Student, Number> idColumn = new TableColumn<>("ID");
idColumn.setCellValueFactory(cell -> cell.getValue().idProperty());

TableColumn<Student, String> firstNameColumn = new TableColumn<>("First Name");
firstNameColumn.setCellValueFactory(cell -> cell.getValue().firstNameProperty());

TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
emailColumn.setCellValueFactory(cell -> cell.getValue().emailProperty());

table.getColumns().addAll(idColumn, firstNameColumn, emailColumn);
```

If your model uses plain getters instead of JavaFX properties, use `PropertyValueFactory`:

```java
firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
```

Requires:

```java
import javafx.scene.control.cell.PropertyValueFactory;
```

Property-based cell factories are safer because the compiler can help you more.

### Table Selection

```java
Student selected = table.getSelectionModel().getSelectedItem();
```

Listen:

```java
table.getSelectionModel().selectedItemProperty().addListener(
    (obs, oldSelection, newSelection) -> {
        editButton.setDisable(newSelection == null);
        deleteButton.setDisable(newSelection == null);
    }
);
```

### Editable Table

```java
table.setEditable(true);

TableColumn<Student, String> firstNameColumn = new TableColumn<>("First Name");
firstNameColumn.setCellValueFactory(cell -> cell.getValue().firstNameProperty());
firstNameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
firstNameColumn.setOnEditCommit(event -> {
    Student student = event.getRowValue();
    student.setFirstName(event.getNewValue());
});
```

Requires:

```java
import javafx.scene.control.cell.TextFieldTableCell;
```

Use editable tables for simple direct edits. Use dialogs for complex validation.

### Table Placeholder

```java
table.setPlaceholder(new Label("No students found."));
```

### Column Resize Policy

```java
table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
```

### Search and Sort Table

```java
ObservableList<Student> students = FXCollections.observableArrayList();
FilteredList<Student> filtered = new FilteredList<>(students, student -> true);
SortedList<Student> sorted = new SortedList<>(filtered);

sorted.comparatorProperty().bind(table.comparatorProperty());
table.setItems(sorted);

searchField.textProperty().addListener((obs, oldText, newText) -> {
    String query = newText == null ? "" : newText.toLowerCase();
    filtered.setPredicate(student ->
        student.getFirstName().toLowerCase().contains(query)
            || student.getLastName().toLowerCase().contains(query)
            || student.getEmail().toLowerCase().contains(query)
    );
});
```

### TreeView

For hierarchical data:

```java
TreeItem<String> root = new TreeItem<>("School");
TreeItem<String> cs = new TreeItem<>("Computer Science");
cs.getChildren().addAll(new TreeItem<>("Java"), new TreeItem<>("Database"));
root.getChildren().add(cs);
root.setExpanded(true);

TreeView<String> treeView = new TreeView<>(root);
```

### TreeTableView

Use when data is both hierarchical and tabular.

It is powerful but more advanced. Learn `TableView` and `TreeView` first.

---

## 19. Menus, Toolbars, Context Menus, and Shortcuts

### MenuBar

```java
MenuBar menuBar = new MenuBar();

Menu fileMenu = new Menu("File");
MenuItem newItem = new MenuItem("New");
MenuItem saveItem = new MenuItem("Save");
MenuItem exitItem = new MenuItem("Exit");

fileMenu.getItems().addAll(newItem, saveItem, new SeparatorMenuItem(), exitItem);
menuBar.getMenus().add(fileMenu);
```

### Menu Actions

```java
saveItem.setOnAction(event -> saveFile());
exitItem.setOnAction(event -> attemptExit());
```

### Keyboard Accelerators

```java
saveItem.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
newItem.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
```

Requires:

```java
import javafx.scene.input.KeyCombination;
```

### ToolBar

```java
ToolBar toolBar = new ToolBar(
    new Button("New"),
    new Button("Save"),
    new Separator(),
    new Button("Delete")
);
```

### ContextMenu

```java
ContextMenu contextMenu = new ContextMenu();
MenuItem editItem = new MenuItem("Edit");
MenuItem deleteItem = new MenuItem("Delete");
contextMenu.getItems().addAll(editItem, deleteItem);

table.setContextMenu(contextMenu);
```

For row-specific actions, select the row under the mouse:

```java
table.setRowFactory(view -> {
    TableRow<Student> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (!row.isEmpty()) {
            table.getSelectionModel().select(row.getItem());
        }
    });
    row.setContextMenu(contextMenu);
    return row;
});
```

### Command Methods

JavaFX does not have Swing's `Action` class built into its controls. A clean pattern is to use command methods:

```java
private void createNewStudent() {
    // command logic
}

private void save() {
    // command logic
}
```

Then connect buttons and menus to the same methods.

```java
newButton.setOnAction(event -> createNewStudent());
newItem.setOnAction(event -> createNewStudent());
```

---

## 20. Dialogs and Alerts

### Information Alert

```java
Alert alert = new Alert(Alert.AlertType.INFORMATION);
alert.setTitle("Saved");
alert.setHeaderText(null);
alert.setContentText("Student saved successfully.");
alert.showAndWait();
```

### Error Alert

```java
Alert alert = new Alert(Alert.AlertType.ERROR);
alert.setTitle("Error");
alert.setHeaderText("Could not save file");
alert.setContentText(ex.getMessage());
alert.showAndWait();
```

### Confirmation Alert

```java
Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
confirm.setTitle("Delete Student");
confirm.setHeaderText("Delete selected student?");
confirm.setContentText("This action cannot be undone.");

Optional<ButtonType> result = confirm.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    deleteSelectedStudent();
}
```

Requires:

```java
import java.util.Optional;
```

### TextInputDialog

```java
TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("New Department");
dialog.setHeaderText("Create department");
dialog.setContentText("Department name:");

Optional<String> result = dialog.showAndWait();
result.ifPresent(name -> addDepartment(name.trim()));
```

### ChoiceDialog

```java
ChoiceDialog<String> dialog = new ChoiceDialog<>("CS", "CS", "IS", "SE");
dialog.setTitle("Department");
dialog.setHeaderText("Choose a department");

Optional<String> result = dialog.showAndWait();
```

### Custom Dialog

```java
Dialog<Student> dialog = new Dialog<>();
dialog.setTitle("Student");
dialog.setHeaderText("Enter student details");

ButtonType saveButtonType = new ButtonType("Save", ButtonBar.ButtonData.OK_DONE);
dialog.getDialogPane().getButtonTypes().addAll(saveButtonType, ButtonType.CANCEL);

TextField firstNameField = new TextField();
TextField lastNameField = new TextField();
TextField emailField = new TextField();

GridPane form = new GridPane();
form.setHgap(8);
form.setVgap(8);
form.setPadding(new Insets(12));
form.addRow(0, new Label("First name:"), firstNameField);
form.addRow(1, new Label("Last name:"), lastNameField);
form.addRow(2, new Label("Email:"), emailField);

dialog.getDialogPane().setContent(form);

dialog.setResultConverter(button -> {
    if (button == saveButtonType) {
        return new Student(0, firstNameField.getText(), lastNameField.getText(), emailField.getText());
    }
    return null;
});

Optional<Student> result = dialog.showAndWait();
result.ifPresent(student -> students.add(student));
```

Custom dialogs are excellent for add/edit workflows.

---

## 21. FXML

FXML is an XML-based markup language for JavaFX UI.

Instead of building every node in Java code:

```java
VBox root = new VBox();
root.getChildren().add(new Label("Name"));
root.getChildren().add(new TextField());
```

You can describe the UI in FXML:

```xml
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox spacing="8" xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.app.StudentController">
    <Label text="Name"/>
    <TextField fx:id="nameField"/>
    <Button text="Save" onAction="#handleSave"/>
</VBox>
```

FXML benefits:

- Separates layout from Java code
- Works with Scene Builder
- Keeps controllers focused on behavior
- Makes large UIs easier to read

FXML costs:

- Runtime loading errors if ids or methods are wrong
- Less compile-time safety
- Requires understanding resource paths

### Loading FXML

```java
FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
Parent root = loader.load();
Scene scene = new Scene(root, 900, 600);
stage.setScene(scene);
stage.show();
```

Resource path:

```text
src/main/resources/com/example/app/main-view.fxml
```

Java class:

```text
src/main/java/com/example/app/App.java
```

Then this works:

```java
App.class.getResource("main-view.fxml")
```

because the resource is in the same package path.

---

## 22. Controllers

FXML controllers connect UI markup to Java behavior.

FXML:

```xml
<VBox xmlns:fx="http://javafx.com/fxml"
      fx:controller="com.example.app.StudentController">
    <TextField fx:id="nameField"/>
    <Button text="Save" onAction="#handleSave"/>
</VBox>
```

Controller:

```java
package com.example.app;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML
    private TextField nameField;

    @FXML
    private void handleSave() {
        String name = nameField.getText().trim();
        System.out.println(name);
    }
}
```

### initialize Method

JavaFX calls `initialize` after FXML fields are injected.

```java
@FXML
private void initialize() {
    nameField.setPromptText("Full name");
}
```

Use `initialize` for:

- Setting table columns
- Adding listeners
- Initializing combo boxes
- Setting button disabled bindings
- Configuring validators

### Controller Communication

After loading FXML, get the controller:

```java
FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
Parent root = loader.load();

MainController controller = loader.getController();
controller.setStudentService(studentService);
```

This is useful for dependency injection.

### Passing Data to a Controller

```java
public class StudentDialogController {
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
        firstNameField.setText(student.getFirstName());
    }
}
```

Load:

```java
FXMLLoader loader = new FXMLLoader(App.class.getResource("student-dialog.fxml"));
Parent root = loader.load();
StudentDialogController controller = loader.getController();
controller.setStudent(student);
```

### Controller Best Practices

Good controllers:

- Handle UI events
- Update controls
- Call services
- Validate form state
- Keep methods short

Controllers should not:

- Contain all business logic
- Directly perform complex file parsing
- Become huge classes
- Use static fields for shared state

---

## 23. CSS Styling

JavaFX supports CSS.

Add a stylesheet:

```java
scene.getStylesheets().add(
    Objects.requireNonNull(App.class.getResource("styles.css")).toExternalForm()
);
```

Resource:

```text
src/main/resources/com/example/app/styles.css
```

### Style Classes

Java:

```java
saveButton.getStyleClass().add("primary-button");
```

CSS:

```css
.primary-button {
    -fx-background-color: #2563eb;
    -fx-text-fill: white;
    -fx-font-weight: bold;
}
```

### ID Selectors

Java:

```java
titleLabel.setId("titleLabel");
```

CSS:

```css
#titleLabel {
    -fx-font-size: 24px;
}
```

Use ids for unique nodes and style classes for reusable styling.

### Common CSS Properties

```css
.root {
    -fx-font-family: "Segoe UI", "Arial", sans-serif;
    -fx-font-size: 13px;
}

.error-label {
    -fx-text-fill: #b91c1c;
}

.toolbar {
    -fx-padding: 8px;
    -fx-spacing: 8px;
}

.section-title {
    -fx-font-size: 18px;
    -fx-font-weight: bold;
}
```

### Inline Styles

```java
label.setStyle("-fx-text-fill: red;");
```

Use inline styles only for quick experiments or dynamic one-off values. Prefer CSS files for real apps.

### Styling Best Practices

- Put repeated styles in CSS.
- Use style classes instead of many inline styles.
- Keep UI readable before making it decorative.
- Avoid excessive colors.
- Use spacing consistently.
- Do not use CSS to hide poor layout decisions.

---

## 24. Images, Icons, Fonts, and Resources

### Loading Images

```java
Image image = new Image(
    Objects.requireNonNull(App.class.getResourceAsStream("images/logo.png"))
);
ImageView imageView = new ImageView(image);
```

Resource path:

```text
src/main/resources/com/example/app/images/logo.png
```

### ImageView

```java
imageView.setFitWidth(120);
imageView.setPreserveRatio(true);
imageView.setSmooth(true);
```

### Button with Graphic

```java
ImageView icon = new ImageView(new Image(
    Objects.requireNonNull(App.class.getResourceAsStream("icons/save.png"))
));
icon.setFitWidth(16);
icon.setFitHeight(16);

Button saveButton = new Button("Save", icon);
```

### Fonts

```java
label.setFont(Font.font("Segoe UI", 16));
```

Load custom font:

```java
Font.loadFont(
    Objects.requireNonNull(App.class.getResourceAsStream("fonts/Inter-Regular.ttf")),
    14
);
```

### Resource Path Rules

Relative to class package:

```java
App.class.getResource("styles.css")
```

Absolute from classpath root:

```java
App.class.getResource("/com/example/app/styles.css")
```

Use `Objects.requireNonNull(...)` so missing resources fail clearly.

---

## 25. Custom Drawing with Canvas

Use `Canvas` for immediate-mode drawing.

```java
Canvas canvas = new Canvas(500, 300);
GraphicsContext gc = canvas.getGraphicsContext2D();

gc.setFill(Color.WHITE);
gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

gc.setFill(Color.BLUE);
gc.fillOval(50, 50, 120, 80);
```

Canvas is good for:

- Charts
- Drawing tools
- Games
- Simulations
- Large custom visuals

### Resizable Canvas

By default, `Canvas` does not automatically redraw itself on resize. You need to listen to size changes.

```java
canvas.widthProperty().bind(container.widthProperty());
canvas.heightProperty().bind(container.heightProperty());

canvas.widthProperty().addListener(event -> draw());
canvas.heightProperty().addListener(event -> draw());
```

Draw method:

```java
private void draw() {
    GraphicsContext gc = canvas.getGraphicsContext2D();
    double width = canvas.getWidth();
    double height = canvas.getHeight();

    gc.clearRect(0, 0, width, height);
    gc.setFill(Color.LIGHTGRAY);
    gc.fillRect(0, 0, width, height);
}
```

### Canvas vs Shapes

Use shapes when:

- You need nodes that can be styled, transformed, animated, or clicked individually
- The number of objects is moderate

Use canvas when:

- You draw many objects
- You want pixel-style rendering
- You are building a drawing surface
- You need game-like rendering

---

## 26. Shapes, Effects, Transforms, and Animation

### Shapes

```java
Rectangle rectangle = new Rectangle(120, 80, Color.CORNFLOWERBLUE);
Circle circle = new Circle(40, Color.TOMATO);
Line line = new Line(0, 0, 100, 100);
```

Shapes are nodes, so they can receive events:

```java
circle.setOnMouseClicked(event -> circle.setFill(Color.GREEN));
```

### Effects

```java
DropShadow shadow = new DropShadow();
shadow.setRadius(8);
node.setEffect(shadow);
```

Use effects carefully. Too many effects can make UI noisy and slower.

### Transforms

```java
node.setTranslateX(50);
node.setTranslateY(20);
node.setRotate(15);
node.setScaleX(1.2);
node.setScaleY(1.2);
```

### Animation

Timeline:

```java
Timeline timeline = new Timeline(
    new KeyFrame(Duration.ZERO, new KeyValue(node.opacityProperty(), 0)),
    new KeyFrame(Duration.seconds(1), new KeyValue(node.opacityProperty(), 1))
);
timeline.play();
```

Translate transition:

```java
TranslateTransition transition = new TranslateTransition(Duration.millis(300), node);
transition.setFromX(0);
transition.setToX(100);
transition.play();
```

Requires:

```java
import javafx.animation.*;
import javafx.util.Duration;
```

Animation is useful for:

- Feedback
- Progress
- State transitions
- Visual explanations

Do not animate everything. Use motion to clarify, not distract.

---

## 27. Concurrency with Task and Service

JavaFX provides `Task` and `Service` for background work.

Use background work for:

- Loading files
- Saving files
- Database calls
- Network calls
- Long calculations
- Report generation

### Task

```java
Task<List<Student>> loadTask = new Task<>() {
    @Override
    protected List<Student> call() throws Exception {
        updateMessage("Loading students...");
        updateProgress(0, 100);

        List<Student> result = repository.loadAll();

        updateProgress(100, 100);
        updateMessage("Loaded");
        return result;
    }
};

loadTask.setOnSucceeded(event -> {
    students.setAll(loadTask.getValue());
});

loadTask.setOnFailed(event -> {
    Throwable error = loadTask.getException();
    showError("Load failed: " + error.getMessage());
});

progressBar.progressProperty().bind(loadTask.progressProperty());
statusLabel.textProperty().bind(loadTask.messageProperty());

Thread thread = new Thread(loadTask);
thread.setDaemon(true);
thread.start();
```

### Updating Progress

Inside `call`:

```java
updateProgress(current, total);
updateMessage("Processing " + current + " of " + total);
```

These methods are safe to call from the background thread.

### Service

Use `Service` for reusable tasks.

```java
public class LoadStudentsService extends Service<List<Student>> {
    private final StudentRepository repository;

    public LoadStudentsService(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    protected Task<List<Student>> createTask() {
        return new Task<>() {
            @Override
            protected List<Student> call() throws Exception {
                return repository.loadAll();
            }
        };
    }
}
```

Usage:

```java
LoadStudentsService service = new LoadStudentsService(repository);
service.setOnSucceeded(event -> students.setAll(service.getValue()));
service.restart();
```

### Concurrency Rules

Remember:

- Do not update UI controls directly from `call`.
- Use `updateMessage`, `updateProgress`, and event handlers.
- Bind progress and status controls to task properties.
- Use daemon threads for background tasks that should not keep the app alive.
- Disable buttons while important tasks are running.

```java
saveButton.disableProperty().bind(saveTask.runningProperty());
```

---

## 28. File Choosers and Persistence

### FileChooser

Open:

```java
FileChooser chooser = new FileChooser();
chooser.setTitle("Open Students File");
chooser.getExtensionFilters().add(
    new FileChooser.ExtensionFilter("CSV Files", "*.csv")
);

File file = chooser.showOpenDialog(stage);
if (file != null) {
    loadStudents(file.toPath());
}
```

Save:

```java
File file = chooser.showSaveDialog(stage);
if (file != null) {
    saveStudents(file.toPath());
}
```

### DirectoryChooser

```java
DirectoryChooser chooser = new DirectoryChooser();
chooser.setTitle("Choose Export Folder");
File directory = chooser.showDialog(stage);
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

```java
public class CsvStudentRepository implements StudentRepository {
    @Override
    public List<Student> load(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);
        List<Student> students = new ArrayList<>();

        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",", -1);
            students.add(new Student(
                Integer.parseInt(parts[0]),
                parts[1],
                parts[2],
                parts[3]
            ));
        }

        return students;
    }

    @Override
    public void save(Path path, List<Student> students) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("id,firstName,lastName,email");

        for (Student student : students) {
            lines.add(student.getId() + ","
                + student.getFirstName() + ","
                + student.getLastName() + ","
                + student.getEmail());
        }

        Files.write(path, lines);
    }
}
```

This simple CSV example does not handle commas inside fields. For serious CSV, escape values correctly or use a CSV library.

### Dirty State

Track unsaved changes:

```java
private final BooleanProperty dirty = new SimpleBooleanProperty(false);
```

Bind title:

```java
stage.titleProperty().bind(
    Bindings.when(dirty)
        .then("Student Manager *")
        .otherwise("Student Manager")
);
```

Mark dirty when data changes:

```java
students.addListener((ListChangeListener<Student>) change -> dirty.set(true));
```

Ask before exit:

```java
stage.setOnCloseRequest(event -> {
    if (dirty.get() && !confirmDiscardChanges()) {
        event.consume();
    }
});
```

---

## 29. Application Architecture

Small examples can put everything in `App.java`. Real JavaFX projects should not.

Recommended package structure:

```text
src/main/java/com/example/studentmanager/
    App.java
    model/
        Student.java
        Course.java
        Department.java
    viewmodel/
        StudentViewModel.java
    repository/
        StudentRepository.java
        CsvStudentRepository.java
    service/
        StudentService.java
        StudentValidator.java
    controller/
        MainController.java
        StudentDialogController.java
    util/
        Dialogs.java

src/main/resources/com/example/studentmanager/
    main-view.fxml
    student-dialog.fxml
    styles.css
    icons/
```

### Responsibilities

`model`:

- Data objects
- Business identity
- Should not know about UI controls

`viewmodel`:

- JavaFX properties
- UI-friendly state
- Binding targets

`repository`:

- File/database loading and saving
- No UI logic

`service`:

- Validation
- Business rules
- Coordination

`controller`:

- UI event handlers
- Control initialization
- Connects UI to services

`resources`:

- FXML
- CSS
- Images
- Icons

### Plain Model Example

```java
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Student(int id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
}
```

### ViewModel Example

```java
public class StudentViewModel {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty firstName = new SimpleStringProperty();
    private final StringProperty lastName = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();

    public StudentViewModel(Student student) {
        id.set(student.getId());
        firstName.set(student.getFirstName());
        lastName.set(student.getLastName());
        email.set(student.getEmail());
    }

    public Student toModel() {
        return new Student(id.get(), firstName.get(), lastName.get(), email.get());
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public StringProperty emailProperty() {
        return email;
    }
}
```

### Dependency Injection Without a Framework

In `App`:

```java
StudentRepository repository = new CsvStudentRepository();
StudentService service = new StudentService(repository);

FXMLLoader loader = new FXMLLoader(App.class.getResource("main-view.fxml"));
Parent root = loader.load();

MainController controller = loader.getController();
controller.setStudentService(service);
```

This keeps your controller testable and avoids global static state.

### Architecture Mistakes to Avoid

- Putting every screen in `App.java`
- Making all controls public
- Using static fields for app state
- Loading files directly inside table event handlers
- Putting business rules in FXML
- Making one giant controller
- Updating UI from background threads
- Duplicating data in multiple lists without a clear source of truth

---

## 30. Testing and Debugging JavaFX Apps

Separate logic from UI so it can be tested normally.

Easy to test:

- Validators
- Repositories
- Services
- Formatters
- Plain model classes

Harder to test:

- Exact UI interactions
- Visual layout
- Animation
- CSS appearance

### Validator Test Target

```java
public class StudentValidator {
    public List<String> validate(Student student) {
        List<String> errors = new ArrayList<>();

        if (student.getFirstName().isBlank()) {
            errors.add("First name is required.");
        }

        if (!student.getEmail().contains("@")) {
            errors.add("Email is invalid.");
        }

        return errors;
    }
}
```

This can be tested with JUnit without launching JavaFX.

### Debugging FXML

Common FXML problems:

- Wrong `fx:controller` package
- `fx:id` does not match controller field
- Missing `@FXML`
- Handler name does not match method
- Method is not accessible
- Resource path is wrong
- Controller class not opened in `module-info.java`

If using modules and FXML injection fails, check:

```java
opens com.example.studentmanager.controller to javafx.fxml;
```

### Debugging CSS

Temporarily add borders:

```css
.debug {
    -fx-border-color: red;
    -fx-border-width: 1px;
}
```

Add class:

```java
node.getStyleClass().add("debug");
```

### Debugging Thread Issues

Check thread:

```java
System.out.println(Platform.isFxApplicationThread());
```

If UI freezes:

- Look for long loops in event handlers.
- Look for file I/O on the JavaFX Application Thread.
- Move slow work into `Task`.

### Debugging Layout

If a node is not visible:

- Is it in the scene graph?
- Is it inside a parent with size?
- Is it `visible=false`?
- Is it `managed=false`?
- Is another node covering it in a `StackPane`?
- Does it have zero preferred size?
- Did CSS set text fill and background to similar colors?

---

## 31. Packaging and Running

### Maven Run

```bash
mvn javafx:run
```

### IDE Run

Most IDEs can run JavaFX Maven projects directly. If not, use the Maven plugin.

### Manual Module Path Run

If using the JavaFX SDK manually:

```bash
java --module-path path/to/javafx-sdk/lib --add-modules javafx.controls,javafx.fxml -jar app.jar
```

This is more fragile than Maven for beginners.

### jlink

`jlink` can create a custom runtime image containing your app and required modules.

Useful for distribution, but learn it after you can already build and run the app normally.

### jpackage

`jpackage` can create platform installers or app images.

For a polished final project, packaging goals are:

- App launches without command line setup
- Resources are included
- Main class is configured
- JavaFX modules are included

Packaging can be tricky. Do it after the application works.

---

## 32. Final Project Curriculum

Recommended final project:

> JavaFX Student Course Manager

Core features:

- Add students
- Edit students
- Delete students
- Search students
- Assign courses
- Display students in a `TableView`
- Use dialogs for add/edit
- Use menus and shortcuts
- Use CSS styling
- Use FXML and controllers
- Save/load data from CSV or JSON
- Track unsaved changes
- Use background tasks for file operations

### Phase 1: Project Setup

Build:

- Maven JavaFX project
- `App.java`
- `main-view.fxml`
- `styles.css`

Skills:

- JavaFX dependencies
- application lifecycle
- FXML loading
- resource paths

Deliverable:

- App opens a blank main window with a title.

### Phase 2: Main Layout

Build:

- `BorderPane` root
- `MenuBar` at top
- `ToolBar` under menu
- `TableView` in center
- Status bar at bottom

Skills:

- layout panes
- scene graph
- controls
- CSS classes

Deliverable:

- A professional main shell for the app.

### Phase 3: Domain Model

Build:

- `Student`
- `Course`
- `Department`

Skills:

- clean model classes
- constructors
- getters
- validation thinking

Deliverable:

- Model classes with no UI controls inside them.

### Phase 4: ViewModel and ObservableList

Build:

- `StudentViewModel`
- `ObservableList<StudentViewModel>`

Skills:

- JavaFX properties
- observable collections
- model-to-viewmodel mapping

Deliverable:

- Sample students appear in memory.

### Phase 5: TableView

Build:

- columns for ID, first name, last name, email, department
- selection listener
- placeholder label

Skills:

- `TableView`
- `TableColumn`
- cell value factories
- selection model

Deliverable:

- Student data displays in a sortable table.

### Phase 6: Add/Edit Dialog

Build:

- `student-dialog.fxml`
- `StudentDialogController`
- text fields
- combo box
- validation

Skills:

- dialogs
- controller communication
- result conversion
- form validation

Deliverable:

- User can add and edit students.

### Phase 7: Delete and Selection State

Build:

- delete command
- confirmation alert
- edit/delete disabled when no row selected

Skills:

- selected item property
- confirmation dialogs
- button disabling with bindings

Deliverable:

- User can safely delete selected students.

### Phase 8: Search and Sort

Build:

- search text field
- `FilteredList`
- `SortedList`
- table comparator binding

Skills:

- observable collections
- filtering
- sorting
- live search

Deliverable:

- User can search students instantly.

### Phase 9: Menus, Shortcuts, and Context Menu

Build:

- File menu
- Edit menu
- Help menu
- keyboard accelerators
- table context menu

Skills:

- `MenuBar`
- `MenuItem`
- `ContextMenu`
- command methods

Deliverable:

- Common commands work from multiple UI entry points.

### Phase 10: Persistence

Build:

- `StudentRepository`
- `CsvStudentRepository`
- Open
- Save
- Save As
- dirty state

Skills:

- file I/O
- `FileChooser`
- repository pattern
- error alerts

Deliverable:

- Data persists after closing the app.

### Phase 11: Background Tasks

Build:

- load task
- save task
- progress indicator
- status binding

Skills:

- `Task`
- progress binding
- safe UI updates
- error handling

Deliverable:

- File operations do not freeze the UI.

### Phase 12: Polish and Final Review

Build:

- CSS polish
- about dialog
- empty state
- better spacing
- confirm exit with unsaved changes
- clean package structure

Skills:

- app finishing
- maintainability
- user experience

Deliverable:

- Complete JavaFX Student Course Manager.

---

## 33. Reference Cheat Sheets

### Essential JavaFX Startup Template

```java
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
            Objects.requireNonNull(App.class.getResource("main-view.fxml"))
        );

        Scene scene = new Scene(root, 900, 600);
        scene.getStylesheets().add(
            Objects.requireNonNull(App.class.getResource("styles.css")).toExternalForm()
        );

        stage.setTitle("JavaFX App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
```

### Component Choice Guide

Use:

- `Label` for display text
- `TextField` for single-line input
- `PasswordField` for password input
- `TextArea` for multi-line input
- `Button` for commands
- `CheckBox` for independent true/false values
- `RadioButton` for one choice from a small group
- `ComboBox` for dropdown selection
- `DatePicker` for dates
- `Spinner` for numeric stepping
- `ListView` for simple lists
- `TableView` for records with columns
- `TreeView` for hierarchy
- `Dialog` for custom workflows
- `Alert` for messages and confirmations

### Layout Choice Guide

Use:

- `BorderPane` for main windows
- `VBox` for vertical stacks
- `HBox` for horizontal rows
- `GridPane` for forms
- `StackPane` for overlays and centered content
- `SplitPane` for resizable master/detail areas
- `ScrollPane` for scrollable content
- `FlowPane` for wrapping items
- `TilePane` for equal repeated tiles

### Event Choice Guide

Use:

- `setOnAction` for button/menu commands
- property listeners for text and selection changes
- `setOnMouseClicked` for mouse clicks
- accelerators for shortcuts
- event filters for parent-level interception
- `event.consume()` only when you intentionally stop propagation

### Property and Binding Guide

Use:

- `StringProperty` for observable strings
- `IntegerProperty` for observable ints
- `BooleanProperty` for observable true/false state
- `ObjectProperty<T>` for selected objects or nullable values
- `ObservableList<T>` for list/table data
- `BooleanBinding` for disable/visibility logic
- `FilteredList` and `SortedList` for searchable tables

### Threading Rules

Remember:

- Build and update UI on the JavaFX Application Thread.
- Do slow work in `Task` or `Service`.
- Do not touch controls directly inside `Task.call`.
- Use `updateMessage` and `updateProgress`.
- Use `setOnSucceeded` and `setOnFailed`.
- Bind progress controls to task properties.

### FXML Rules

Remember:

- `fx:id` must match controller field names.
- Handler methods need `@FXML`.
- Controller package must match `fx:controller`.
- Resources must be in the correct `src/main/resources` path.
- Use `FXMLLoader` when you need controller access.
- If using modules, use `opens ... to javafx.fxml`.

### Project Readiness Checklist

Before starting your JavaFX project, you should be able to:

- Create an `Application`
- Show a `Stage`
- Create a `Scene`
- Build layouts with panes
- Use basic controls
- Handle button clicks
- Listen to text and selection changes
- Use properties and binding
- Display data in `TableView`
- Use FXML and controllers
- Style with CSS
- Show alerts and dialogs
- Save and load files
- Use `Task` for background work
- Organize packages cleanly

---

## Suggested Study Schedule

### Week 1: JavaFX Foundations

Study:

- Sections 1 to 12

Practice:

- Build simple windows
- Try layout panes
- Add buttons and fields
- Handle events

Mini projects:

- Temperature converter
- Login form mockup
- Simple calculator

### Week 2: State, Binding, and Data Controls

Study:

- Sections 13 to 20

Practice:

- Use properties
- Bind labels and buttons
- Build forms
- Validate input
- Use `ListView`
- Use `TableView`

Mini project:

- Contact manager without persistence

### Week 3: FXML, CSS, and Architecture

Study:

- Sections 21 to 29

Practice:

- Build FXML screens
- Use controllers
- Add CSS
- Create repository and service classes
- Add file saving

Mini project:

- Contact manager with CSV persistence

### Week 4: Final Project

Study:

- Sections 30 to 33

Build:

- JavaFX Student Course Manager

Focus:

- Clean package structure
- Table workflows
- Dialog validation
- Search and sort
- File persistence
- Background tasks
- CSS polish

---

## Final Advice

JavaFX becomes powerful when you stop thinking of the UI as a pile of controls and start thinking of it as a graph of observable state.

The big ideas to master are:

- The scene graph gives the UI structure.
- Layout panes control resizing and placement.
- Properties expose state.
- Binding connects state.
- Observable lists feed data controls.
- FXML separates layout from behavior.
- CSS separates styling from logic.
- Controllers connect user actions to application services.
- Background tasks keep the app responsive.

If you can build a complete JavaFX project with these ideas, you will be ready for serious desktop application work and much stronger in general software design.

