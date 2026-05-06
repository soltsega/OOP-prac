package gui.seondminiapp;
import javax.swing.JFrame;
public class SimpleLoginForm {
    public static void main(String[] args) {
        new LoginForm();
    }

    
}


class LoginForm {
    public LoginForm() {
        System.out.println("Login Form Created");

        JFrame frame = new JFrame("Login Form");
        frame.setSize(400, 300);
        frame.setVisible(true);

    }
}
