package javafxapplication2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.IndexRange;
import javafx.scene.control.TextArea;

import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author Dan
 */
public class JavaFXApplication2 extends Application {

    boolean save = false;
    String textnew = new String();
    static File file;

    @Override
    public void start(Stage primaryStage) {
        FXMLBase root = new FXMLBase();

        Scene scene = new Scene(root, 600, 450);

        primaryStage.setTitle("Hello From JETS!");
        primaryStage.setScene(scene);
        primaryStage.show();

        root.Edit.setOnShown(event -> {
            if (root.textArea.getSelectedText().equals("")) {
                root.Cut.setDisable(true);

                root.Copy.setDisable(true);

                root.Delete.setDisable(true);
            } else {
                root.Cut.setDisable(false);

                root.Copy.setDisable(false);

                root.Delete.setDisable(false);
            }
        });
        // Button b = new Button("Confirmation alert"); 

        root.SelectAll.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TextArea textarea = root.textArea;
                String text = textarea.getText();
                // textarea.requestFocus();

                // textarea.selectAll();
                textarea.selectRange(0, text.length());
            }
        });
        /*            TextArea textArea = new TextArea();
        UnaryOperator<Change> filter = c -> {

            int caret = c.getCaretPosition();
            int anchor = c.getAnchor() ;

            if (caret != anchor) {
                int start = caret ;
                int end = caret ;
                String text = c.getControlNewText();
                while (start > 0 && text.charAt(start) != '\n') start-- ;
                while (end < text.length() && text.charAt(end) != '\n') end++ ;
                c.setAnchor(start);
                c.setCaretPosition(end);
                

            }
            
           return c ;  
        }; 
         */

        root.Undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TextArea textarea = root.textArea;
                String text = textarea.getText();

                textarea.undo();

            }
        });
        root.Paste.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                TextArea text = root.textArea;
                String textt = text.getText();

                String subtext = text.getSelectedText();
                String fulltext = text.getText();

                //  text.getCaretPosition();
                // text.nextWord();
                Clipboard systemClipboard = Clipboard.getSystemClipboard();

                String ss = systemClipboard.getString();

                //fulltext = fulltext.replaceFirst("", ss);
                IndexRange index = text.getSelection();

                text.replaceText(index.getStart(), index.getEnd(), ss);
                //text.insertText(index, ss);
                //      text.replaceText(index, ss);

            }
        });

        root.Delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TextArea textarea = new TextArea();
                TextArea text = root.textArea;
                String textt = text.getText();
                //     TextArea textarea = new TextArea();
                //textarea.setText(text);
                //  String textjt= text.replace(text.positionCaret(0),"");
                // text.positionCaret(0);
                text.getCaretPosition();
                //  text.selectPositionCaret(0);
                //  text.caretPositionProperty(get)
                // text.selectPositionCaret(text.getText().length());
                //  text.replaceSelection("");
                text.deleteNextChar();

            }
        });
        root.Copy.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String text = root.textArea.getSelectedText();
                Clipboard systemClipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();
                content.putString(text);
                systemClipboard.setContent(content);
            }
        });

        root.Cut.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //  root.Cut.setDisable(true);
                TextArea text = root.textArea;

                String subtext = text.getSelectedText();

                //  root.Cut.setDisable(false);
                String fulltext = text.getText();
                Clipboard systemClipboard = Clipboard.getSystemClipboard();
                ClipboardContent content = new ClipboardContent();

                content.putString(subtext);
                systemClipboard.setContent(content);
                fulltext = fulltext.replaceFirst(subtext, "");
                text.setText(fulltext);

            }

        });
        ///////////////////////////////////////file//////////////////////////////////////////////////////////////
        root.New.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!root.textArea.getText().equals("")) {
                    if (save == false) {
                        Alert a1 = new Alert(AlertType.INFORMATION,
                                "are you want to save? ");
                        a1.getButtonTypes().add(ButtonType.CANCEL);
                        ButtonType buttontype = new ButtonType("Dont save");
                        a1.getButtonTypes().add(buttontype);
                        a1.setHeaderText("Welcome Here");
                        a1.showAndWait();
                        ButtonType check = a1.getResult();

                        if (check == ButtonType.OK) {

                            FileWriter fw = null;
                            try {
                                FileChooser fileChooser = new FileChooser();
                                fileChooser.setTitle("save Resource File");
                                File file = fileChooser.showSaveDialog(primaryStage);
/////////////////////////////////////////////////////////
                                fw = new FileWriter(file.getAbsoluteFile());
                                fw = new FileWriter(file.getAbsoluteFile());
                                try (BufferedWriter bw = new BufferedWriter(fw)) {
                                    bw.write(root.textArea.getText());
                                    bw.flush();
                                }
                                ///////////////////////
                                if (file != null) {
                                    String path = file.getAbsolutePath();
                                    Alert a = new Alert(AlertType.CONFIRMATION, path);
                                    a.show();
                                }
                            } catch (IOException ex) {
                                Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
                            } ///////////////////////
                            finally {
                                try {
                                    fw.close();
                                } catch (IOException ex) {
                                    Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                        if (check == ButtonType.CANCEL) {

                            event.consume();
                        }

                        if (check == buttontype) {

                            root.textArea.clear();

                        }

                    }
                }
            }

        });

        root.Open.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (root.textArea.getText().equals("")) {
                    FileChooser fileChooser = new FileChooser();
                    fileChooser.setTitle("open Resource File");
                    File file = fileChooser.showOpenDialog(primaryStage);
/////////////////////////////////////////////////////////
                    try (BufferedReader reader = new BufferedReader(new FileReader(new File(file.getAbsolutePath())))) {

                        String line;
                        while ((line = reader.readLine()) != null) {
                            //   System.out.println(line);
                            root.textArea.appendText(line);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

///////////////////////
                    if (file != null) {
                        String path = file.getAbsolutePath();
                        Alert a = new Alert(AlertType.CONFIRMATION, path);
                        a.show();

                    }
                }

                if (!root.textArea.getText().equals("")) {

                    Alert a1 = new Alert(AlertType.INFORMATION,
                            "are you want to save? ");
                    a1.getButtonTypes().add(ButtonType.CANCEL);
                    ButtonType buttontype = new ButtonType("Dont save and open");
                    a1.getButtonTypes().add(buttontype);
                    a1.setHeaderText("Welcome Here");
                    a1.showAndWait();
                    ButtonType check = a1.getResult();

                    if (check == ButtonType.OK) {

                        try {

                            FileChooser fileChhooser = new FileChooser();
                            fileChhooser.setTitle("save Resource File");
                            File ffile = fileChhooser.showSaveDialog(primaryStage);
                            if (ffile != null) {
                                String paath = ffile.getAbsolutePath();

                                /////////////////////////////////////////////////////////
                                FileWriter fw = null;
                                fw = new FileWriter(ffile.getAbsoluteFile());
                                try (BufferedWriter bw = new BufferedWriter(fw)) {
                                    bw.write(root.textArea.getText());
                                    bw.flush();
                                    Alert ak = new Alert(AlertType.CONFIRMATION, paath);
                                    ak.show();
                                }
                            }
///////////////////////

                        } catch (IOException ex) {
                            Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if (check == ButtonType.CANCEL) {

                        event.consume();
                    }

                    if (check == buttontype) {

                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("open Resource File");
                        File file = fileChooser.showOpenDialog(primaryStage);
/////////////////////////////////////////////////////////
                        root.textArea.clear();
                        try (BufferedReader reader = new BufferedReader(new FileReader(new File(file.getAbsolutePath())))) {

                            String line;
                            while ((line = reader.readLine()) != null) {
                                //   System.out.println(line);
                                root.textArea.appendText(line);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }

///////////////////////
                        if (file != null) {
                            String path = file.getAbsolutePath();
                            Alert a = new Alert(AlertType.CONFIRMATION, path);
                            a.show();

                        }

                    }
                }
            }

        });

        root.save.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileWriter fw = null;
                /*   if (!textnew.equals(root.textArea.getText())) {
                    save = true;
                }*/
                if (save == false) {

                    try {

                        FileChooser fileChooser = new FileChooser();
                        fileChooser.setTitle("save Resource File");
                        file = fileChooser.showSaveDialog(primaryStage);

                        /////////////////////////////////////////////////////////
                        fw = new FileWriter(file.getAbsoluteFile());

                        try (BufferedWriter bw = new BufferedWriter(fw)) {
                            bw.write(root.textArea.getText());
                            bw.flush();
                        }
                        ///////////////////////
                        if (file != null) {
                            String path = file.getAbsolutePath();
                            Alert a = new Alert(AlertType.CONFIRMATION, path);
                            a.show();
                            textnew = root.textArea.getText();
                            save = true;
                            /////////////////////////////////////////////

                            //   a.setAlertType(AlertType.CONFIRMATION);
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                if (save == true) {

                    try {

                        fw = new FileWriter(file.getAbsoluteFile());

                        try (BufferedWriter bw = new BufferedWriter(fw)) {
                            bw.write(root.textArea.getText());
                            bw.flush();
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(JavaFXApplication2.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                ///////////////////////catch (IOException ex) {
            }

        });

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                if (!root.textArea.getSelectedText().equals("")) {
                    Alert a1 = new Alert(AlertType.INFORMATION,
                            "are you want to exit ? ");
                    a1.getButtonTypes().add(ButtonType.CANCEL);
                    ButtonType buttontype = new ButtonType("save");
                    a1.getButtonTypes().add(buttontype);
                    a1.setHeaderText("Welcome Here");
                    a1.showAndWait();
                    ButtonType check = a1.getResult();

                    if (check == ButtonType.OK) {

                        Platform.exit();
                        System.exit(0);

                    }
                    if (check == buttontype) {

                        try {

                            FileChooser fileChooserrrr = new FileChooser();
                            fileChooserrrr.setTitle("save Resource File");
                            File filee = fileChooserrrr.showSaveDialog(primaryStage);
/////////////////////////////////////////////////////////
                            FileWriter fw = new FileWriter(filee.getAbsoluteFile());
                            BufferedWriter bw = new BufferedWriter(fw);

                            bw.write(root.textArea.getText());
                            bw.flush();

///////////////////////
                            if (filee != null) {
                                String pathhh = filee.getAbsolutePath();
                                Alert aaaa = new Alert(AlertType.CONFIRMATION, pathhh);
                                aaaa.show();

                            }

                        } catch (IOException ex) {
                            Logger.getLogger(JavaFXApplication2.class
                                    .getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    if (check == buttontype.CANCEL) {
                        event.consume();
                    }
                }
            }
        });
        root.Exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!root.textArea.getSelectedText().equals("")) {

                    Alert a1 = new Alert(AlertType.INFORMATION,
                            "are you want to save ? ");
                    a1.getButtonTypes().add(ButtonType.CANCEL);
                    ButtonType buttontype = new ButtonType("save");
                    a1.getButtonTypes().add(buttontype);
                    a1.setHeaderText("Welcome Here");
                    a1.showAndWait();
                    ButtonType check = a1.getResult();

                    if (check == ButtonType.OK) {

                        Platform.exit();
                        System.exit(0);

                    }
                    if (check == buttontype) {

                        FileChooser fileChooserrrr = new FileChooser();
                        fileChooserrrr.setTitle("save Resource File");
                        File filee = fileChooserrrr.showSaveDialog(primaryStage);

                        if (filee != null) {
                            String pathhh = filee.getAbsolutePath();
                            Alert aaaa = new Alert(AlertType.CONFIRMATION, pathhh);
                            aaaa.show();
                        }

                    }

                } else {
                    Platform.exit();
                    System.exit(0);
                }

            }
        });
        /////////////////////////////////////about////////////////////////////////////////////////
        root.About.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Alert a1 = new Alert(AlertType.INFORMATION,
                        "First NotePad " + "\n" + "Made by NOrhan Fadel "
                        + "\n" + "Eng:Medhat");
                a1.setHeaderText("Welcome Here");
                ImageView imageView = new ImageView("e-512.png");
                imageView.setFitHeight(100);
                imageView.setFitWidth(100);
                a1.setGraphic(imageView);
                a1.show();

            }
        });

    }

    public static void main(String[] args) {
                 System.out.println("Classloader of this class:"+JavaFXApplication2.class.getClassLoader()); 
        launch(args);
    }
}
