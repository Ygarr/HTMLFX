import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.*;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 
public class HTMLEditorSample extends Application {
    private final String INITIAL_TEXT = "Lorem ipsum dolor sit "
            + "amet, consectetur adipiscing elit. Nam tortor felis, pulvinar "
            + "in scelerisque cursus, pulvinar at ante. Nulla consequat"
            + "congue lectus in sodales. Nullam eu est a felis ornare "
            + "bibendum et nec tellus. Vivamus non metus tempus augue auctor "
            + "ornare. Duis pulvinar justo ac purus adipiscing pulvinar. "
            + "Integer congue faucibus dapibus. Integer id nisl ut elit "
            + "aliquam sagittis gravida eu dolor. Etiam sit amet ipsum "
            + "sem.";
 
    @Override
    public void start(Stage stage) {
        stage.setTitle("HTMLEditor Sample");
        stage.setWidth(650);
        stage.setHeight(500);
        Scene scene = new Scene(new Group());
    
        VBox root = new VBox();     
        root.setPadding(new Insets(8, 8, 8, 8));
        root.setSpacing(5);
        root.setAlignment(Pos.BOTTOM_LEFT);
 
        final HTMLEditor htmlEditor = new HTMLEditor();
        htmlEditor.setPrefHeight(245);
        htmlEditor.setHtmlText(INITIAL_TEXT);
        
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
     
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.getStyleClass().add("noborder-scroll-pane");
        scrollPane.setStyle("-fx-background-color: white");
        
        scrollPane.setFitToWidth(true);
        scrollPane.setPrefHeight(180);
        
        //->
        final TextArea htmlCode = new TextArea();
        htmlCode.setWrapText(true);        
        
        
        Button showHTMLButton0 = new Button("Produce HTML Code");
        root.setAlignment(Pos.BOTTOM_LEFT);
        showHTMLButton0.setOnAction((ActionEvent arg1) -> {
            htmlCode.setText(htmlEditor.getHtmlText());
            
            scrollPane.setContent(htmlCode);
        });
		//<-
		
        Button showHTMLButton = new Button("Load Content in Browser");
        root.setAlignment(Pos.TOP_LEFT);
        showHTMLButton.setOnAction((ActionEvent arg0) -> {
            webEngine.loadContent(htmlEditor.getHtmlText());
            
            scrollPane.setContent(browser);
        });
        
        
        HBox buttons = new HBox();
		buttons.setSpacing(10);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(showHTMLButton0, showHTMLButton);
                
        root.getChildren().addAll(htmlEditor, buttons, scrollPane);
        scene.setRoot(root);
 
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}