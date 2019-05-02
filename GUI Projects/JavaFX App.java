/*
Developer Name: John Gallagher

Code Purpose: Develop a JavaFX app that uses e-mail dual-authentication
and prevents brute-force login attacks/attempts.


*/

import java.util.Random;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.Timestamp;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author jim Adopted from Oracle's Login Tutorial Application
 * https://docs.oracle.com/javafx/2/get_started/form.htm
 */
public class JavaFXApplication7 extends Application {
                    int var; 
                    int logAttempts = 0; 
                    long millisecond = System.currentTimeMillis();
                    Timestamp timeStamp = new Timestamp(millisecond);

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("SDEV425 Login");
        // Grid Pane divides your window into grids
        GridPane grid = new GridPane();
        // Align to Center
        // Note Position is geometric object for alignment
        grid.setAlignment(Pos.CENTER);
        // Set gap between the components
        // Larger numbers mean bigger spaces
        grid.setHgap(10);
        grid.setVgap(10);

        // Create some text to place in the scene
        Text scenetitle = new Text("Welcome. Login to continue.");
        // Add text to grid 0,0 span 2 columns, 1 row
        grid.add(scenetitle, 0, 0, 2, 1);

        // Create Label
        Label userName = new Label("User Name:");
        // Add label to grid 0,1
        grid.add(userName, 0, 1);

        // Create Textfield
        TextField userTextField = new TextField();
        // Add textfield to grid 1,1
        grid.add(userTextField, 1, 1);
        
        // Create Label
        Label pw = new Label("Password:");
        // Add label to grid 0,2
        grid.add(pw, 0, 2);
        
        // Create Passwordfield
        PasswordField pwBox = new PasswordField();
        // Add Password field to grid 1,2
        grid.add(pwBox, 1, 2);
        
        //Create label
        Label da = new Label("Dual Auth Pass:");
        //add label to grid 0,3
        grid.add(da,0, 3);
        
        //Create Dual-Authentication Password Field
        PasswordField daBox = new PasswordField();
        //Add password Field to grid 2,2
        grid.add(daBox, 1,3);
        
        //Create dualAuth email button
        Button daBtn = new Button("Send Dual-Authentication Email");
        grid.add(daBtn, 1, 5);
        daBtn.setOnAction(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent e) {
            var =  sendEmail();
        }
    });
        
        // Create Login Button
        Button btn = new Button("Login");
        // Add button to grid 1,4
        grid.add(btn, 1, 4);
        
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        // Set the Action when button is clicked
        btn.setOnAction(new EventHandler<ActionEvent>() {

           
            @Override
            public void handle(ActionEvent e) {
                //variable to log unsuccessful attempts
                // Authenticate the user
               
                boolean isValid = authenticate(userTextField.getText(), pwBox.getText(), Integer.parseInt(daBox.getText()));
                // If valid clear the grid and Welcome the user
                if (isValid) {
                    String activity = "Successful Login by USER: "+userTextField.getText() + " PASSWORD: " 
                        + pwBox.getText()+ " TimeStamp:" + timeStamp;
                    logActivity(activity);

                    grid.setVisible(false);
                    GridPane grid2 = new GridPane();
                    // Align to Center
                    // Note Position is geometric object for alignment
                    grid2.setAlignment(Pos.CENTER);
                     // Set gap between the components
                    // Larger numbers mean bigger spaces
                    grid2.setHgap(10);
                    grid2.setVgap(10);
                    Text scenetitle = new Text("Welcome " + userTextField.getText() + "!");
                    // Add text to grid 0,0 span 2 columns, 1 row
                    grid2.add(scenetitle, 0, 0, 2, 1);
                    Scene scene = new Scene(grid2, 500, 400);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                  
                    
                   // If Invalid Ask user to try again
                } else {    
                    String activity = "Failed Login by USER: "+userTextField.getText() + " PASSWORD: " 
                            +pwBox.getText()+ " TimeStamp:" + timeStamp;
                    logActivity(activity);
                    final Text actiontarget = new Text();
                    grid.add(actiontarget, 1, 6);
                    actiontarget.setFill(Color.FIREBRICK);    
                    logAttempts = logAttempts + 1;
                    actiontarget.setText("Only authorized personnel are permitted to login to system.\n\nPlease try again\n\nFailed login Attempts (Max 3): " + logAttempts);
                    if (logAttempts > 3) {
                        System.exit(0);
                    
                    }
                }

            }
        });
        // Set the size of Scene
        Scene scene = new Scene(grid, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param user the username entered
     * @param pword the password entered
     * @return isValid true for authenticated
     */
    public boolean authenticate(String user, String pword, int dpword) {
        boolean isValid = false;
        if (user.equalsIgnoreCase("sdevadmin")
            && pword.equals("425!pass") 
            && dpword == var) {
            isValid = true;
        }

        return isValid;
    }
    
    public static void logActivity(String activity) {
        String txt = activity;      
        BufferedWriter writer = null;
        // write the text variable using the bufferedwriter to testing.txt
        try {
            writer = new BufferedWriter(new FileWriter("ActivityLog.txt", true));
            writer.write(txt + ",");
            
        }
        // print error message if there is one
        catch (IOException io) {
            System.out.println("File IO Exception" + io.getMessage());
        }
        //close the file
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            }
            //print error message if there is one
            catch (IOException io) {
                System.out.println("Issue closing the File." + io.getMessage());
            }
        }
}

    public int sendEmail() {
                Random r = new Random(); 
                var = r.nextInt(1000); 
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
                            @Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("earlgray88@gmail.com","|)dE35;}A78Z25q");
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("earlgray88@gmail.com"));
                        message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse("earlgray88@gmail.com"));
			message.setSubject("Different Subject");
			message.setText("Please enter this Verification Code to Login:" + var);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	return var; 
    }
}
