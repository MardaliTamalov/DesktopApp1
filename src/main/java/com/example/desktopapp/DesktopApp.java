package com.example.desktopapp;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
public class DesktopApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("выберите файл");
        stage.setTitle("Моя программа");
        TextArea text = new TextArea();
        text.setPrefSize(900, 500);
        text.setWrapText(true);
        VBox vbox = new VBox(button, text);
  //      vbox.setAlignment(Pos.CENTER);

        button.setOnAction(event -> {
                FileChooser fileChooser = new FileChooser();
                File fileName = fileChooser.showOpenDialog(stage);

                //File fileName = new File("C:/Users/Mardali/Desktop/test.txt");

//                if (fileName != null) {
//                    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
//                        String line;
//                        StringBuilder sb = new StringBuilder();
//                        while ((line = reader.readLine()) != null) {
//                            sb.append(line).append("\n");
//                        }
//                        textArea.setText("файл содержит: " +sb.toString());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

                String fileContents;
                try {
                    fileContents = Files.lines(Paths.get(fileName.toString()))//, StandardCharsets.ISO_8859_1)
                            .collect(Collectors.joining("\n"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                text.setText("файл содержит:" + "\n" + fileContents.toString());});
/*
// Path filePath = Paths.get(fileName);
          //проверяем с помощью метода Files.exists() существует ли файл перед его чтением
        if (Files.exists(filePath)) {
            String fileContents = Files.lines(filePath, StandardCharsets.ISO_8859_1)
                    .collect(Collectors.joining("\n"));
            System.out.println(fileContents);
            // Process file contents
        } else {
            System.out.println("нет файла: " + fileName);
        }*/

                Scene scene = new Scene(vbox, 1000, 500);
                stage.setScene(scene);
                stage.show();
        }}