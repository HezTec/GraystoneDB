package GraystoneView;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	void registerHandler(ActionEvent event)throws IOException{
		Parent view2 = FXMLLoader.load(getClass().getResource("registerResident.fxml"));

        Scene scene2 = new Scene(view2);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
	}

    @FXML
    void loginPage(ActionEvent event)throws IOException {
        Parent view2 = FXMLLoader.load(getClass().getResource("homepage.fxml"));

        Scene scene2 = new Scene(view2);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
    }
    
    @FXML
    void residentList(ActionEvent event)throws IOException {
        Parent view3 = FXMLLoader.load(getClass().getResource("residentlist.fxml"));

        Scene scene3 = new Scene(view3);

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
    }

}
