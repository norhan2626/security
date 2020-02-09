    package javafxapplication2;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class FXMLBase extends AnchorPane {
    
    protected final BorderPane borderPane;
    protected final MenuBar menuBar;
    protected final Menu file;
    protected final MenuItem New;
    protected final MenuItem Open;
    protected final MenuItem save;
    protected final MenuItem Exit;
    protected final Menu Edit;
    protected final MenuItem Undo;
    protected final MenuItem Cut;
    protected final MenuItem Copy;
    protected final MenuItem Paste;
    protected final MenuItem Delete;
    protected final MenuItem SelectAll;
    protected final Menu Help;
    protected final MenuItem About;
    protected final TextArea textArea;
    
    public FXMLBase() {
        
        borderPane = new BorderPane();
        menuBar = new MenuBar();
        file = new Menu();
        New = new MenuItem();
        Open = new MenuItem();
        save = new MenuItem();
        Exit = new MenuItem();
        Edit = new Menu();
        Undo = new MenuItem();
        Cut = new MenuItem();
        Copy = new MenuItem();
        Paste = new MenuItem();
        Delete = new MenuItem();
        SelectAll = new MenuItem();
        Help = new Menu();
        About = new MenuItem();
        textArea = new TextArea();
        
        setId("AnchorPane");
        setPrefHeight(400.0);
        setPrefWidth(600.0);
        
        borderPane.setLayoutX(6.0);
        borderPane.setLayoutY(4.0);
        borderPane.setPrefHeight(394.0);
        borderPane.setPrefWidth(592.0);
        
        BorderPane.setAlignment(menuBar, javafx.geometry.Pos.CENTER);
        
        file.setMnemonicParsing(false);
        file.setText("File");
        
        New.setMnemonicParsing(false);
        New.setText("New");
        New.setAccelerator(KeyCombination.keyCombination("Ctrl+n"));
        
        Open.setMnemonicParsing(false);
        Open.setText("Open");
        Open.setAccelerator(KeyCombination.keyCombination("Ctrl+o"));
        
        save.setMnemonicParsing(false);
        save.setText("Save");
        save.setAccelerator(KeyCombination.keyCombination("Ctrl+s"));
        
        Exit.setMnemonicParsing(false);
        Exit.setText("Close");
        Exit.setAccelerator(KeyCombination.keyCombination("esc"));
        
        Edit.setMnemonicParsing(false);
        Edit.setText("Edit");
        
        Undo.setMnemonicParsing(false);
        Undo.setText("Undo");
        
        Cut.setMnemonicParsing(false);
        Cut.setText("Cut");
        
        Copy.setMnemonicParsing(false);
        Copy.setText("Copy");
        
        Paste.setMnemonicParsing(false);
        Paste.setText("Paste");
        
        Delete.setMnemonicParsing(false);
        Delete.setText("Delete");
        
        SelectAll.setMnemonicParsing(false);
        SelectAll.setText("Select All");
        
        Help.setMnemonicParsing(false);
        Help.setText("Help");
        
        About.setMnemonicParsing(false);
        About.setText("About Notepad");
        borderPane.setTop(menuBar);
        
        BorderPane.setAlignment(textArea, javafx.geometry.Pos.CENTER);
        textArea.setPrefHeight(200.0);
        textArea.setPrefWidth(200.0);
        borderPane.setCenter(textArea);
        
        file.getItems().add(New);
        file.getItems().add(Open);
        file.getItems().add(save);
        file.getItems().add(Exit);
        menuBar.getMenus().add(file);
        Edit.getItems().add(Undo);
        Edit.getItems().add(Cut);
        Edit.getItems().add(Copy);
        Edit.getItems().add(Paste);
        Edit.getItems().add(Delete);
        Edit.getItems().add(SelectAll);
        menuBar.getMenus().add(Edit);
        Help.getItems().add(About);
        menuBar.getMenus().add(Help);
        getChildren().add(borderPane);
        
    }
}
