package GraystoneView;

import java.io.IOException;
import GraystoneControl.Resident;
import GraystoneControl.ResidentList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TableController {

	private ObservableList<String> filterList = FXCollections.observableArrayList();

	@FXML
	private TableView<Resident> data;
	
	@FXML
	public TableColumn<Resident, String> residentID;

	@FXML
	public TableColumn<Resident, String> roomNum;

	@FXML
	public TableColumn<Resident, String> firstName;

	@FXML
	public TableColumn<Resident, String> lastName;

	@FXML
	public TableColumn<Resident, String> address;

	@FXML
	public TableColumn<Resident, String> city;

	@FXML
	public TableColumn<Resident, String> zip;

	@FXML
	public TableColumn<Resident, String> phoneNumber;

	@FXML
	public TableColumn<Resident, String> ssn;

	@FXML
	public TextField filterField;//the field that gets user input to filter the list

	@FXML
	private ChoiceBox<String> choiceFilter;//the choices for the check box filter

	/**
	 * method for switching scenes to the home page
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void homePage(ActionEvent event) throws IOException {
		Parent view4 = FXMLLoader.load(getClass().getResource("homepage.fxml"));

		Scene scene4 = new Scene(view4);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene4);
		window.show();
	}

	private ObservableList<Resident> info = (ObservableList<Resident>) ResidentList.getList();

	@FXML
	/**
	 * The class that initializes the filtered list in the table
	 */
	private void initialize() {
		loadData();

		try {
			residentID.setCellValueFactory(cellData -> cellData.getValue().resIdProperty());
			roomNum.setCellValueFactory(cellData -> cellData.getValue().roomNumProperty());
			firstName.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
			lastName.setCellValueFactory(cellData -> cellData.getValue().lNameProperty());
			address.setCellValueFactory(cellData -> cellData.getValue().addressProperty());
			city.setCellValueFactory(cellData -> cellData.getValue().cityProperty());
			zip.setCellValueFactory(cellData -> cellData.getValue().zipProperty());
			phoneNumber.setCellValueFactory(cellData -> cellData.getValue().numProperty());
			ssn.setCellValueFactory(cellData -> cellData.getValue().ssnProperty());

			FilteredList<Resident> filter = new FilteredList<>(info, p -> true);

			filterField.textProperty().addListener((observable, oldValue, newValue) -> {
				filter.setPredicate(resident -> {

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					// checking if the choice box value as been changed from null, if it hasn't
					// it will search by fname, lname, room num, and ssn by default if no option is chosen
					if (choiceFilter.getValue() == null) {
						if (resident.getResidentID().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						} else if (resident.getRoomNum().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						} else if (resident.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						} else if (resident.getLastName().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						} else if (resident.getSSN().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "ID") {
						if (resident.getResidentID().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "Room") {
						if (resident.getRoomNum().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "First name") {
						if (resident.getFirstName().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "Last name") {
						if (resident.getLastName().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "Address") {
						if (resident.getAddress().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "City") {
						if (resident.getCity().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "Zip") {
						if (resident.getZip().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "Phone") {
						if (resident.getPhoneNumber().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					} else if (choiceFilter.getValue().toString() == "SSN") {
						if (resident.getSSN().toLowerCase().contains(lowerCaseFilter)) {
							return true;
						}
					}
					return false;
				});
			});

			// putting together the sorted list witih the data
			SortedList<Resident> sortedData = new SortedList<>(filter);
			sortedData.comparatorProperty().bind(data.comparatorProperty());
			data.setItems(sortedData);
		} catch (Exception e) {

		}

	}

	/**
	 * method for loading all the resident data in to the filtered checkbox
	 */
	private void loadData() {
		String a = "ID";
		String b = "Room";
		String c = "First name";
		String d = "Last name";
		String e = "Address";
		String f = "City";
		String g = "Zip";
		String h = "Phone";
		String i = "SSN";

		filterList.addAll(a, b, c, d, e, f, g, h, i);

		choiceFilter.getItems().addAll(filterList);

	}

}
