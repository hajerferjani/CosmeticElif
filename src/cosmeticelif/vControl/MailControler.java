/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cosmeticelif.vControl;


//import java.net.PasswordAuthentication;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
//import sun.plugin2.message.transport.Transport;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public class MailControler {
     @FXML   
    private TextField dest ;
    @FXML   
    private TextField obj ;
    @FXML   
    private TextField ctn ;
    @FXML
    private Button btn;
    @FXML
    private Button btnr;
        @FXML
    public void send(){
     String from = "tasmine.jamazi@esprit.tn";
     String destination = dest.getText();
     String host = "localhost";
     String objet = obj.getText();
     String contenu = ctn.getText();
        Properties p = new Properties();
   
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.put("mail.smtp.port", "587");
         p.put("mail.smtp.ssl.trust", "*");
         Session s = Session.getInstance(p,new javax.mail.Authenticator() {
         
          @Override
          protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tasmine.jamazi@esprit.tn", "llrfmrigycdihkcu");
            }
    });
         

try {
    
     if (validateEmail()==false){ 
               JOptionPane.showMessageDialog(null, "verifier votre adresse mail");
          }
            Message message = new MimeMessage(s);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(destination));
            message.setSubject(objet);
            
            message.setText(contenu);
            //Send mail
            Transport.send(message);
            System.out.println("Mail sent successfully");
            
        } catch (MessagingException ex) {
        }
        
    }
    
    
        
       private boolean validateEmail(){
       Pattern p=Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
       Matcher m=p.matcher(dest.getText());
       if (m.find()&& m.group().equals(dest.getText())){
          // System.out.println("ok");
       return true;
       }
       // System.out.println("not ok");
        return false;
}
          public void Backmail(Event e)
 {
      try {
                    //add you loading or delays - ;-)
                   Node node = (Node) e.getSource();
                   Stage stage = (Stage) node.getScene().getWindow();                  
                   stage.close();
                   
                   Parent root = FXMLLoader.load(getClass().getResource("/cosmeticelif/viewFXML/Mail.fxml"));       
                   Scene scene = new Scene(root);       
                   stage.setScene(scene);
                   stage.show();

                } catch (Exception ex) {
                    System.out.println("y"+ex.getMessage());
                }
 }
}
    

