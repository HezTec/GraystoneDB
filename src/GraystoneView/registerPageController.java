package GraystoneView;

import java.io.IOException;

import GraystoneSQL.GraystoneReg;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class registerPageController {

    @FXML
    private ImageView homeController;

    @FXML
    private Button submitButton;
    
    @FXML
    private TextField idInput;

    @FXML
    private TextField fNameInput;

    @FXML
    private TextField lNameInput;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField cityInput;

    @FXML
    private TextField zipcodeInput;

    @FXML
    private TextField phoneInput;

    @FXML
    private TextField ssnInput;
    
    @FXML
    private TextField roomInput;
    
    @FXML
    private Button homeButton;

    @FXML
    void fNameHandler(ActionEvent event) {

    }
    
    @FXML
    void homeHandler(ActionEvent event) throws IOException {
        Parent view4 = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        Scene scene4 = new Scene(view4);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.show();
    }

    @FXML
    void submitHandler(ActionEvent event) throws IOException {
    	String id = null;
    	String fName = null;
    	String lName = null;
    	String roomNum = null;
    	String address = null;
    	String city = null;
    	String zip = null;
    	String phone = null;
    	String ssn = null;
    	
    	id = idInput.getText();
    	fName = fNameInput.getText();
    	lName = lNameInput.getText();
    	roomNum = roomInput.getText();
    	address = addressInput.getText();
    	city = cityInput.getText();
    	zip = zipcodeInput.getText();
    	phone = phoneInput.getText();
    	ssn = ssnInput.getText();
    	
    	GraystoneReg reg = new GraystoneReg(id,roomNum,fName,lName,address,city,zip,phone,ssn);
    	reg.insert();
    	
    	Parent view2 = FXMLLoader.load(getClass().getResource("homepage.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    	
    }

}