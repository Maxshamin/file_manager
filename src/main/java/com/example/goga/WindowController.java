package com.example.goga;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.util.*;

public class WindowController {

    @FXML
    private Button Button_1;

    @FXML
    private Button Button_2;

    @FXML
    private Button Button_3;

    @FXML
    private Button Button_4;

    @FXML
    private Button Button_5;

    @FXML
    private Button Button_6;

    @FXML
    private Button Button_7;

    @FXML
    private Button Button_8;

    @FXML
    private Button Button_9;

    @FXML
    private TextArea Text_Area;

    @FXML
    private TextField Text_field;


    public static File currentDir;


    @FXML
    void initialize(){

        currentDir = new File(System.getProperty("user.dir"));

        Button_1.setOnAction(actionEvent -> {
            Text_Area.setText(currentDir.getAbsolutePath());
        });

        Button_2.setOnAction(actionEvent -> {
            StringBuilder text = new StringBuilder();
            text.append("Текущая директория: ").append(currentDir.getAbsolutePath()).append("\n");
            File[] files = currentDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    text.append(file.getName()).append("\n");
                }
            }
            Text_Area.setText(text.toString());
        });

        Button_3.setOnAction(actionEvent -> {
            String directoryName = Text_field.getText();
            Text_field.setText("");
            File newDir = new File(currentDir, directoryName);
            if (newDir.isDirectory()) {
                currentDir = newDir;
                Text_Area.setText("Директория изменена на: " + currentDir.getAbsolutePath());

            } else {
                Text_Area.setText("Не является директорией");
            }
        });

        Button_4.setOnAction(actionEvent -> {
            File parentDir = currentDir.getParentFile();
            if (parentDir != null) {
                currentDir = parentDir;
                Text_Area.setText("Директория изменена на: " + currentDir.getAbsolutePath());
            } else {
                Text_Area.setText("Уже в корневой директории");
            }
        });

        Button_5.setOnAction(actionEvent -> {
            String fileName = Text_field.getText();
            Text_field.setText("");
            File file = new File(currentDir, fileName);
            if (file.exists()) {
                Text_Area.setText("Характеристики файла:" + "\n"
                        + "Название: " + file.getName() + "\n"
                        + "Полный путь: " + file.getAbsolutePath() + "\n"
                        + "Размер: " + file.length() + " байт" + "\n"
                        + "Чтение: " + file.canRead() + "\n"
                        + "Запись: " + file.canWrite() + "\n"
                        + "Выполняемый: " + file.canExecute()
                );
            } else {
                Text_Area.setText("Файл не найден");
            }
        });

        Button_6.setOnAction(actionEvent -> {
            String fileName = Text_field.getText();
            Text_field.setText("");
            File file = new File(currentDir, fileName);
            if (file.exists()) {
                if (file.delete()) {
                    Text_Area.setText("Файл удален");
                } else {
                    Text_Area.setText("Не удалось удалить");
                }
            } else {
                Text_Area.setText("Файл не обнаружен");
            }
        });

        Button_7.setOnAction(actionEvent -> {
            String fileName = Text_field.getText();
            Text_field.setText("");
            try {
                Process process = Runtime.getRuntime().exec("notepad.exe " + fileName, null, currentDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button_8.setOnAction(actionEvent -> {
            try {
                String fileName = Text_field.getText();
                Text_field.setText("");
                File file = new File(currentDir, fileName);
                if (file.createNewFile()) {
                    Text_Area.setText("Файл создан");
                } else {
                    Text_Area.setText("Не удалось создать");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Button_9.setOnAction(actionEvent -> {
            String directoryName = Text_field.getText();
            Text_field.setText("");
            File newDir = new File(currentDir, directoryName);
            if (newDir.mkdir()) {
                Text_Area.setText("Директория создана");
            } else {
                Text_Area.setText("Не удалось создать");
            }
        });
    }
}

