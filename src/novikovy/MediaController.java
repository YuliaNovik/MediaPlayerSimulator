package novikovy;


import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MediaController {


	//Construct the array object
	private MediaList media = new MediaList();

	//ArrayList holding records
	static  ArrayList <String> _list = new ArrayList<String>();

	//ArrayList holding the date
	static ArrayList<Date> date = new ArrayList<Date>();


	@FXML private TextField index;
	@FXML private Button btnLoad;
	@FXML private Button btnPlay;
	@FXML private Label title;
	@FXML private Label year;
	@FXML private Label playL;
	@FXML private ImageView image;
	@FXML private Button btnOpen;

	//Created initialize method to call it when window opens
	@FXML private void initialize(){

		//Attach Event Handlers
		btnLoad.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onLoadClicked();
			}
		});

		btnPlay.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onPlayClicked();
			}
		});

		btnOpen.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onOpenClicked();
			}
		});
	}
	//This method loads the movie/song title and year of production, displays the image accordingly,
	// displays the error window if chosen number of the media item is out of arrayList bounds,
	//and clears all the fields/labels in case of error
	//It is also displays alert window in letter is typed as an index instead of the number
	private void onLoadClicked(){

		try{
			String indx = index.getText();
			int parse = Integer.parseInt(indx);
			title.setText(media.lookup(parse-1).getTitle());
			_list.add("Load  "+media.lookup(parse-1).getTitle());//adding record to ArrayList _list
			date.add(new Date());                                //adding data to ArrayList   date
			year.setText(media.lookup(parse-1).getProductionYear());
			Image image1 = new Image(media.lookup(parse-1).getImagePath());
			image.setImage(image1);
		}catch (IndexOutOfBoundsException e) {
			title.setText(null);
			year.setText(null);
			playL.setText(null);
			image.setImage(null);
			Alert alert = new Alert(AlertType.ERROR, "Error: Media item doesn't exist. Please enter number of the media item from 1 to 6.");
			Optional<ButtonType> res = alert.showAndWait();

		}catch (NumberFormatException e){
			Alert alert = new Alert(AlertType.ERROR, "Error: Index must be a number. Please enter number of the media item from 1 to 6. ");
			Optional<ButtonType> res = alert.showAndWait();
		}

	}
	//This method "plays" movie/song and also throws the alert window if chosen index out of arrayList bounds
	//and button "play" is clicked instead of "load"
	public void onPlayClicked(){
		try{
			String indx = index.getText();
			int parse = Integer.parseInt(indx);
			playL.setText(MediaList.lookup(parse-1).playMedia());
			_list.add("Play  "+media.lookup(parse-1).getTitle());//adding record to ArrayList _list
			date.add(new Date());                               //adding date to ArrayList date
		}catch (IndexOutOfBoundsException e) {
			Alert alert = new Alert(AlertType.ERROR, "Error: Media item doesn't exist. Please enter number of the media item from 1 to 6.");
			Optional<ButtonType> res = alert.showAndWait();
		}

	}
	public void onOpenClicked(){

		try {
			//Creating the second window access
			FXMLLoader loader = new	FXMLLoader(getClass().getResource("SecondMedia.fxml"));
			AnchorPane root = loader.load();

			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Stage secondStage = new Stage();
			secondStage.setScene(scene);

			secondStage.setTitle("LogWindow");
			secondStage.initModality(Modality.WINDOW_MODAL);
			secondStage.showAndWait();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}



