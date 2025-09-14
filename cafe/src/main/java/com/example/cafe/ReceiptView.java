package com.example.cafe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptView {
    private final BorderPane root;
    private double totalPrice;

    public ReceiptView(Stage primaryStage, BorderPane root, double totalPrice) {
        this.root = root;
        this.totalPrice = totalPrice;
        //primaryStage.setFullScreen(true);

    }

    public Scene show() {
        VBox vbox = new VBox(15);
        vbox.setStyle("-fx-background-color: #F5DEB3; -fx-padding: 30px;"); // Full beige background
        vbox.setAlignment(Pos.TOP_CENTER);

        //date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm a");


        Label header = new Label("INVOICE");
        header.setFont(new Font("Georgia", 28));
        header.setTextFill(Color.SADDLEBROWN);
        vbox.getChildren().add(header);

        Line divider1 = createDivider(400);
        vbox.getChildren().add(divider1);


        Label dateLabel = new Label("Date: " + now.format(dateFormatter));
        dateLabel.setFont(new Font("Georgia", 18));
        dateLabel.setTextFill(Color.SADDLEBROWN);

        Label timeLabel = new Label("Time: " + now.format(timeFormatter));
        timeLabel.setFont(new Font("Georgia", 18));
        timeLabel.setTextFill(Color.SADDLEBROWN);

        vbox.getChildren().addAll(dateLabel, timeLabel);

        Line divider2 = createDivider(400);
        vbox.getChildren().add(divider2);


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        addGridHeader(grid);
        int row = 1;
        for (Items item : Items.list) {
            grid.add(new Label(item.getName()), 0, row);
            grid.add(new Label(String.valueOf(item.getQuantity())), 1, row);
            grid.add(new Label(String.format("Rs %.2f", (double) item.getPrice())), 2, row);
            grid.add(new Label(String.format("Rs %.2f", (double) item.getAmount())), 3, row);
            row++;
        }

        vbox.getChildren().add(grid);

        Line divider3 = createDivider(400);
        vbox.getChildren().add(divider3);

        Label totalLabel = new Label("Total: Rs " + String.format("%.2f", totalPrice));
        totalLabel.setFont(new Font("Georgia", 22));
        totalLabel.setTextFill(Color.SADDLEBROWN);
        vbox.getChildren().add(totalLabel);

        // Thank you note
        Label thankYou = new Label("Thank you for sipping with us - until the next cup!");
        thankYou.setFont(new Font("Georgia", 18));
        thankYou.setTextFill(Color.SADDLEBROWN);
        vbox.getChildren().add(thankYou);

        // fake barcode for cool aesthetics
        vbox.getChildren().add(createBarcode());

        // ScrollPane
        ScrollPane scrollPane = new ScrollPane(vbox);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: #F5DEB3; -fx-border-color: transparent;"); // Matching background color

        // Root container
        root.setStyle("-fx-background-color: #F5DEB3;"); // Matching entire background
        root.setCenter(scrollPane);

        // Scene with full background
        Scene scene = new Scene(root, 600, 800);
        scene.getRoot().setStyle("-fx-background-color: #F5DEB3;");

        return scene;
    }

    private Line createDivider(double width) {
        Line divider = new Line(0, 0, width, 0);
        divider.setStroke(Color.SADDLEBROWN);
        divider.setStrokeWidth(1.5);
        return divider;
    }

    private void addGridHeader(GridPane grid) {
        Label descriptionHeader = new Label("Description");
        descriptionHeader.setFont(new Font("Georgia", 18));
        descriptionHeader.setTextFill(Color.SADDLEBROWN);

        Label quantityHeader = new Label("Quantity");
        quantityHeader.setFont(new Font("Georgia", 18));
        quantityHeader.setTextFill(Color.SADDLEBROWN);

        Label priceHeader = new Label("Price");
        priceHeader.setFont(new Font("Georgia", 18));
        priceHeader.setTextFill(Color.SADDLEBROWN);

        Label amountHeader = new Label("Amount");
        amountHeader.setFont(new Font("Georgia", 18));
        amountHeader.setTextFill(Color.SADDLEBROWN);

        grid.add(descriptionHeader, 0, 0);
        grid.add(quantityHeader, 1, 0);
        grid.add(priceHeader, 2, 0);
        grid.add(amountHeader, 3, 0);
    }

    private GridPane createBarcode() {
        GridPane barcode = new GridPane();
        barcode.setHgap(2);
        barcode.setAlignment(Pos.CENTER);

        for (int i = 0; i < 60; i++) { //bar nums
            Rectangle bar = new Rectangle(2, 70); // tall bars
            if (Math.random() > 0.5) {
                bar.setFill(Color.BLACK);
            } else {
                bar.setFill(Color.TRANSPARENT);
            }
            barcode.add(bar, i, 0);
        }
        return barcode;
    }
}

