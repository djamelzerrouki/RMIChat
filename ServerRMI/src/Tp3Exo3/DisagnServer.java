package Tp3Exo3;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;


public class DisagnServer extends Application {


	public TextField field;
	public static Label label2;
	public Button button1;
	private   Chat server;
	public ListView<String> listView;
	public static ObservableList<String> observableList;
	public static String name;

	public static Text text;

	
	@Override
	public void start(Stage primaryStage)throws Exception {
		 try {
		  	  LocateRegistry.createRegistry(1099);

			    	Scanner s=new Scanner(System.in);
			    	System.out.println("Enter Your name and press Enter:");
			    	  name=s.nextLine().trim();
		 
			    	  server = new Chat(name);	
		 
			    	Naming.rebind("rmi://127.0.0.1:1099/chat", server);
		 
			    	System.out.println("[System] Chat Remote Object is ready:");
		 
			    
		 
		    	}catch (Exception e) {
		    		System.out.println("[System] Server failed: " + e);
		    	}
		BorderPane borderPaint=new BorderPane();



		  text = new Text(name);

		text.setFont(Font.font("Courier New", FontWeight.BOLD, 32));

 		text.setStyle("-fx-fill:  linear-gradient(#00bfff , #00bfff);\r\n");

		label2=new Label("");

		label2.setPrefHeight(37);
		label2.setAlignment(Pos.CENTER);
		label2.setPrefHeight(40);
		label2.setFont(Font.font("Tahoma", FontWeight.BOLD, 11));
		label2.setTextFill(Color.RED);

		field=new TextField();
		field.setPrefHeight(37);
		field.setPrefWidth(200);
		field.setPromptText("Entrer le message..");
		field.setOnKeyPressed(new EventHandler<>() {

			@Override
			public void handle(KeyEvent arg0){}
		});
		

		button1=new Button("Send");
		button1.setPrefHeight(37);
		button1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

	 
		    			try {
				    		String msg=field.getText();
				    		if (server.getClient()!=null){
				    			ChatInterface client=server.getClient();
							msg="["+server.getName()+"] "+msg;
			    			//client.send(msg);
							observableList.add(msg);
							client.getObservableList(msg);
						} }catch (RemoteException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
		    		}	
		    	 
			
			
			
			}


			


		});

		HBox hbox=new HBox(20);
		hbox.setPadding(new Insets(20));
		hbox.setAlignment(Pos.CENTER);

		hbox.getChildren().addAll(field,button1);
		//list=new ArrayList<String>();
		observableList=FXCollections.observableArrayList();
		listView =new ListView<String>(observableList);
		VBox vbox=new VBox(20);
		vbox.setPadding(new Insets(20));
		vbox.getChildren().addAll(listView);
		borderPaint.setTop(	text);
		borderPaint.setCenter(vbox);
		borderPaint.setBottom(hbox);
		BorderPane.setAlignment(text, Pos.CENTER);

		Scene scene = new Scene(borderPaint,400,600);

		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {

	   
		
			
		launch(args);

	}	


}
