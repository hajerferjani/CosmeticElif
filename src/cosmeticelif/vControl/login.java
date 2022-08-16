/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.vControl;


import cosmeticelif.Controller.LoginControl;
import cosmeticelif.model.User;
import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
/**
 *
 * @author USER
 */
public class login {
    @FXML
    private Button connecter;
    @FXML
    private TextField login;
    @FXML
    private PasswordField password;
    @FXML
    private Label mesg;
    
    User user = new User();
    LoginControl lc= new LoginControl();
    
    @FXML
    public void isSign(Event event) throws IOException {
        user.setLogin(login.getText());
        user.setMot_de_passe(password.getText());
        
           if (lc.isLogin(user)) {
               Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();                  
                    stage.close();
                   Parent root = FXMLLoader.load(getClass().getResource("/cosmeticelif/viewFXML/Home.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();
           }
           else
                mesg.setText("login or password is wrong");
    }
}
