# Spring Boot Setup

This folder now has a small Spring Boot web app at the project root.

## Files Added

- `pom.xml` - Maven build file with Spring Boot Web.
- `src/main/java/com/oopprac/contactmanager/ContactManagerApplication.java` - main Spring Boot app.
- `src/main/java/com/oopprac/contactmanager/ContactController.java` - REST API for contacts.
- `src/main/java/com/oopprac/contactmanager/Contact.java` - contact model.
- `src/main/resources/static/index.html` - browser UI.
- `src/main/resources/static/styles.css` - UI styling.
- `src/main/resources/static/app.js` - browser-side API calls.
- `.vscode/launch.json` - VS Code launch option.

## Required Configuration

1. Install a JDK. You already have Java installed.
2. Install Maven and make sure `mvn -version` works in PowerShell.
3. In VS Code, install:
   - Extension Pack for Java
   - Spring Boot Extension Pack
4. Open the project root folder, not the `GUI` folder.
5. Run the app from Spring Boot Dashboard or use:

```powershell
mvn spring-boot:run
```

Then open:

```text
http://localhost:8080
```

## Notes

The old `GUI/SwingMiniapp.java` is a desktop Swing app. This Spring Boot app is separate and runs in the browser.

There is an empty `GUI/pom.xml` file in the Swing folder. The Spring Boot project uses the root-level `pom.xml`.
