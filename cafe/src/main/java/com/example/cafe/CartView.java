package com.example.cafe;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CartView {
    private final Stage primaryStage;
    private final BorderPane root;
    private double totalPrice = 0;

    // Constructor
    public CartView(Stage primaryStage, BorderPane root) {
        this.primaryStage = primaryStage;
        this.root = root;

        //primaryStage.setFullScreen(true);


    }
    //so the cart can be viewed
    public static Scene viewCart(Stage primaryStage, BorderPane root) {
        CartView cartView = new CartView(primaryStage, root);


        BorderPane rootPane = new BorderPane();


        VBox mainLayout = cartView.createMainLayout();
        rootPane.setCenter(mainLayout);

        Scene scene = new Scene(rootPane, 800, 600);
        return scene;


    }


    private VBox createMainLayout() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20));
        vbox.setStyle("-fx-background-color: #F5DEB3; -fx-border-color: black;");
        vbox.setAlignment(Pos.CENTER);

        vbox.getChildren().add(createHeader());
        vbox.getChildren().add(createCartDetailsGrid());
        vbox.getChildren().add(createActionButtons());

        return vbox;
    }


    private Label createHeader() {
        Label header = new Label("Your Cart");
        header.setFont(new Font("Georgia", 24));
        header.setTextFill(Color.SADDLEBROWN);
        return header;
    }


    private GridPane createCartDetailsGrid() {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 0, 10, 0));


        addGridHeaders(grid);

        // adding items in the cart
        int row = 1;
        for (Items item : Items.list) { //this list is from item class
            grid.add(new Label(item.getName()), 0, row);
            grid.add(new Label(String.valueOf(item.getQuantity())), 1, row);
            grid.add(new Label("Rs" + String.format("%.2f", (double)item.getPrice())), 2, row);
            grid.add(new Label("Rs" + String.format("%.2f", (double)item.getAmount())), 3, row);
            row++;
            totalPrice += (double)item.getAmount();
        }

        //total wali row
        addTotalRow(grid, row);

        return grid;
    }

    private void addGridHeaders(GridPane grid) {
        String[] headers = {"Description", "Quantity", "Price", "Amount"};
        for (int i = 0; i < headers.length; i++) {
            Label header = new Label(headers[i]);
            header.setFont(new Font("Georgia", 16));
            header.setTextFill(Color.SADDLEBROWN);
            grid.add(header, i, 0);
        }
    }


    private void addTotalRow(GridPane grid, int row) {
        Label totalLabel = new Label("TOTAL:");
        totalLabel.setFont(new Font("Georgia", 16));
        totalLabel.setTextFill(Color.BLACK);
        grid.add(totalLabel, 2, row);

        Label totalAmountLabel = new Label("Rs" + String.format("%.2f", totalPrice));
        totalAmountLabel.setFont(new Font("Georgia", 16));
        totalAmountLabel.setTextFill(Color.BLACK);
        grid.add(totalAmountLabel, 3, row);
    }

    // Cancel and Proceed to Checkout buttons
    private HBox createActionButtons() {
        HBox buttonsBox = new HBox(20);
        buttonsBox.setAlignment(Pos.CENTER);

        // Cancel button
        Button cancelButton = new Button("CANCEL");
        cancelButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");
        cancelButton.setOnAction(e -> {
            System.out.println("Cancelled. Navigating back...");
            MainClass obj = new MainClass();
           obj.start(primaryStage);
        });

        // Proceed to checkout button
        Button checkoutButton = new Button("PROCEED TO CHECKOUT");
        checkoutButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white;");
        checkoutButton.setOnAction(e -> {
            ReceiptView receiptView = new ReceiptView(primaryStage, root, totalPrice); //calling of receipt view class
            primaryStage.setScene(receiptView.show());
        });

        buttonsBox.getChildren().addAll(cancelButton, checkoutButton);
        return buttonsBox;


    }
}