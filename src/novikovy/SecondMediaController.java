package novikovy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//import application.Database;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import java.util.Date;

public class SecondMediaController {

	//private MediaList media;

	private ArrayList<String> list = MediaController._list;
	private ArrayList<Date> dat = MediaController.date;


	@FXML private Button btnLoadLog;
	@FXML private Button btnClearLog;
	@FXML private Button btnSaveLog;
	@FXML private TextArea textArea;



	//Created initialize method to call it when window opens
	@FXML private void initialize(){

		//Attach Event Handlers
		btnLoadLog.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onLoadLogClicked();
			}
		});

		btnClearLog.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onClearClicked();
			}
		});

		btnSaveLog.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent e){
				onSaveClicked();
			}
		});

	}
	@FXML
	private void onLoadLogClicked(){  //loads information to the text area from both arrayLists

		System.out.print(list);
		String showup = "";
		for (int index = 0; index < list.size(); index++) {
			showup += list.get(index)+"  &  "+dat.get(index);
			showup += "\n";
		}
		textArea.setText(showup);
	}
	@FXML
	private void onClearClicked(){  //Deletes all the entries from the log (text area)
		textArea.clear();
	}

	@FXML
	private void onSaveClicked(){    //Saves all the entries from  the text area to the log.txt file
		PrintWriter writer = null;
		try {
			File file = new File("log.txt");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			writer = new PrintWriter(bw);
			writer.println("New record");
			for (int i = 0; i < list.size(); i++) {

				writer.println(list.get(i) +" & "+ (dat.get(i)));
			}
		} catch (IOException ioe) {
			textArea.setText("Exception occurred:" + ioe.getMessage());
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}
}
