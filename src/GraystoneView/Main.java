package GraystoneView;
import GraystoneControl.ResidentList;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

	Stage window;
	Scene scene1, scene2, scene3;
	
	private TableView<Resident> table = new TableView<Resident>();
	private final ObservableList<Resident> info = (ObservableList<Resident>) ResidentList.getList();

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		Scene scene1 = new Scene(new Group());
		stage.setTitle("Resident List");
		stage.setWidth(775);
		stage.setHeight(600);
		
		//Goes to HomePage
		Button home = new Button("Home");
		home.setOnAction(e -> window.setScene(scene2));
		VBox layout1 = new VBox(20);

		//Home Page layout
		Button list = new Button("Resident List");
		Button app = new Button("Appointment");
		list.setOnAction(e -> window.setScene(scene1));
		app.setOnAction(e -> window.setScene(scene3));
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(list, app);
		scene2 = new Scene(layout2, 775, 550);
		
		//Appointment Layout
		Button home1 = new Button("Home");
		home1.setOnAction(e -> window.setScene(scene2));
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(home1);
		scene3 = new Scene(layout3, 775, 550);
		
		/*
		 * Table Contents and Format
		 */
		table.setEditable(true);

		// residentID column
		TableColumn<Resident, String> column1 = new TableColumn<>("Res ID");
		column1.setCellValueFactory(new PropertyValueFactory<>("residentID"));

		// roomNum column
		TableColumn<Resident, String> column2 = new TableColumn<>("Room #");
		column2.setCellValueFactory(new PropertyValueFactory<>("roomNum"));

		TableColumn<Resident, String> column3 = new TableColumn<>("First Name");
		column3.setCellValueFactory(new PropertyValueFactory<>("firstName"));

		// Last Name Column
		TableColumn<Resident, String> column4 = new TableColumn<>("Last Name");
		column4.setCellValueFactory(new PropertyValueFactory<>("lastName"));

		// Address column
		TableColumn<Resident, String> column5 = new TableColumn<>("Address");
		column5.setCellValueFactory(new PropertyValueFactory<>("address"));

		// City column
		TableColumn<Resident, String> column6 = new TableColumn<>("City");
		column6.setCellValueFactory(new PropertyValueFactory<>("city"));

		// Zip code column
		TableColumn<Resident, Integer> column7 = new TableColumn<>("Zip");
		column7.setMinWidth(50);
		column7.setCellValueFactory(new PropertyValueFactory<>("zip"));

		// Number column
		TableColumn<Resident, String> column8 = new TableColumn<>("Number");
		column8.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

		// SSN column
		TableColumn<Resident, String> column9 = new TableColumn<>(" SSN ");
		column9.setMinWidth(75);
		column9.setCellValueFactory(new PropertyValueFactory<>("SSN"));

		@SuppressWarnings("unchecked")
		/*
		 * Search through table with text field 
		 */
		FilteredList<Resident> resident = new FilteredList(info, p -> true);
		table.setItems(resident);
		table.getColumns().addAll(column1, column2, column3, column4, column5, column6, column7, column8, column9);

		// Adding ChoiceBox and TextField here!
		ChoiceBox<String> choiceBox = new ChoiceBox();
		choiceBox.getItems().addAll("Resident ID", "Room Number", "First Name", "Last Name", "Address", "City", "Zip",
				"Number", "SSN");
		choiceBox.setValue("Resident ID");

		TextField textField = new TextField();
		textField.setPromptText("Filter");
		textField.setOnKeyReleased(keyEvent -> {
			//Pulling info from table
			switch (choiceBox.getValue()) {
			case "Resident ID":
				resident.setPredicate(
						p -> p.getResidentID().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "Room Number":
				resident.setPredicate(
						p -> p.getRoomNum().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "First Name":
				resident.setPredicate(
						p -> p.getFirstName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "Last Name":
				resident.setPredicate(
						p -> p.getLastName().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "Address":
				resident.setPredicate(
						p -> p.getAddress().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "City":
				resident.setPredicate(
						p -> p.getCity().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;

			case "Zip":
				resident.setPredicate(p -> p.getZip().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;
			case "Phone Number":
				resident.setPredicate(
						p -> p.getPhoneNumber().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;
			case "SSN":
				resident.setPredicate(p -> p.getSSN().toLowerCase().contains(textField.getText().toLowerCase().trim()));
				break;
			}
		});

		choiceBox.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {

			if (newVal != null) {
				textField.setText("");
				resident.setPredicate(null);
			}
		});
		
		/*
		 * Titles and orientation of buttons
		 */
		Label label = new Label("Resident List");
		label.setAlignment(Pos.TOP_CENTER);
		label.setFont(new Font("Arial", 20));
		
		HBox hBox = new HBox(choiceBox, textField);// Add choiceBox and textField to hBox
		hBox.setAlignment(Pos.BOTTOM_CENTER);// Center HBox
		
		layout1.setSpacing(5);
		layout1.setPadding(new Insets(10, 0, 0, 10));
		layout1.getChildren().addAll(label, table, hBox, home);
		
		((Group) scene1.getRoot()).getChildren().addAll(layout1);
		
		stage.setScene(scene2);
		stage.show();
		
		
	}
}
