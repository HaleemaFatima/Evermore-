package com.example.cafe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass extends Application {
    List<String> flowerNames = new ArrayList<>(Arrays.asList("Rose", "Tulip", "Daisy", "Carnation", "Daffodils", "Lily", "Sunflower","Poppy")); //name of flowers
    //name of books
    List<String> bookNames = new ArrayList<>(Arrays.asList(
            "It ends with us",
            "Little Women",
            "Harry Potter",
            "Pride and Prejudice",
            "Emma",
            "Milenal",
            "All the light we cannot see",
            "Great Expectations",
            "Bringing down the duke"
    ));

    //making of first page aka homepage
     Scene homepageScene;

    //designing of hp
    public void start(Stage primaryStage)  {

        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: #f5f5dc;"); // Color for our bg

        // Header
        VBox header = new VBox();
        header.setStyle("-fx-background-color: #8B4513; -fx-padding: 20px;"); // Brown color header
        header.setAlignment(Pos.CENTER);

        Text title = new Text("The Evermore Hearth");
        title.setFont(Font.font("Georgia", 36));
        title.setFill(Color.WHITE);

        Text caption = new Text("Meet me at the crossroads of poetry and petals,where every sip tells a story");
        caption.setFont(Font.font("Georgia", FontPosture.ITALIC, 18));
        caption.setFill(Color.LIGHTGOLDENRODYELLOW);

        header.getChildren().addAll(title, caption);
        root.setTop(header);

        // our first page
        GridPane mainContent = new GridPane();
        mainContent.setHgap(20);
        mainContent.setVgap(20);
        mainContent.setAlignment(Pos.CENTER);
        mainContent.setPadding(new Insets(20));
        // Hot Section
        VBox hotSection = createSection("Hot", "Explore our warm and cozy beverages.", "C:/Users/hp/Downloads/project/hotcoffenewimage.jpg", primaryStage); //method called

        // Cold Section
        VBox coldSection = createSection("Cold", "Indulge in our refreshing and chilled drinks.", "C:/Users/hp/Downloads/project/coldcofeeimage.jpg", primaryStage);

        //Flower Section
        VBox flowerSection=createSection("Flowers","Bringing blooms and joy, one petal at a time!","C:/Users/hp/Downloads/project/Flowers roses.jpeg",primaryStage);

        //Book Section
        VBox bookSection=createSection("Books","In the realm of written beauty","C:/Users/hp/Downloads/project/books2.jpg",primaryStage);

        //grid setting
        mainContent.add(hotSection, 0, 0);
        mainContent.add(coldSection, 1, 0);
        mainContent.add(flowerSection, 0, 1);
        mainContent.add(bookSection, 1, 1);

       // so we can scroll our main page
        ScrollPane scrollPane = new ScrollPane(mainContent);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");


        root.setCenter(scrollPane);

        //primaryStage.setFullScreen(true);


        // Footer
        VBox footer = new VBox();
        footer.setStyle("-fx-background-color: #d2b48c; -fx-padding: 20px;"); // light brown color for footer
        footer.setAlignment(Pos.CENTER);
        Text footerText = new Text("Happiness at the click of a button");
        footerText.setFont(Font.font("Georgia", 18));
        footer.getChildren().add(footerText);
        root.setBottom(footer);

        // scene and stage setting for hp
        homepageScene = new Scene(root, 1000, 700);
        primaryStage.setTitle("Evermore Cafe Homepage");
        primaryStage.setScene(homepageScene);
        primaryStage.show();

    }
    //making and designing of sections in hp
    private VBox createSection(String title, String description, String imagePath, Stage primaryStage)  { //method defined
        VBox section = new VBox(10);
        section.setStyle("-fx-background-color: #fff; -fx-border-color: #8B4513; -fx-border-width: 2px; -fx-padding: 10px;");
        section.setPadding(new Insets(20));

        // Image
        ImageView imageView = new ImageView(new Image("file:" + imagePath));
        imageView.setFitWidth(300);
        imageView.setFitHeight(300);
        imageView.setPreserveRatio(true);

        // Text
        Text sectionTitle = new Text(title);
        sectionTitle.setFont(Font.font("Georgia", 24));
        sectionTitle.setFill(Color.BROWN);
        Text sectionDescription = new Text(description);
        sectionDescription.setFont(Font.font("Georgia",FontPosture.ITALIC, 14));
        sectionDescription.setFill(Color.ROSYBROWN);
        // Explore Button
        Button exploreButton = new Button("Explore");
        exploreButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px;");
        exploreButton.setOnAction(e -> navigateToSection(primaryStage, title)); //method called

        section.setAlignment(Pos.CENTER);
        section.getChildren().addAll(sectionTitle,sectionDescription, imageView, exploreButton);
        return section;


    }
    //going from one page to other and designing of menu page
    private void navigateToSection(Stage primaryStage, String sectionTitle) { //method defined
        VBox sectionPage = new VBox();
        sectionPage.setAlignment(Pos.CENTER);
        sectionPage.setPadding(new Insets(20)); //space between objects
        sectionPage.setStyle("-fx-background-color: #f5f5dc;");

        Text sectionText = new Text(sectionTitle + " Section");
        sectionText.setFont(Font.font("Georgia", 28));
        sectionText.setFill(Color.BROWN);

        //grid placement of our sections
        TilePane productGrid = new TilePane();
        productGrid.setHgap(20);
        productGrid.setVgap(20);
        productGrid.setPrefColumns(3);
        productGrid.setPadding(new Insets(20));
        productGrid.setAlignment(Pos.CENTER);

        //products for each section
        if (sectionTitle.equalsIgnoreCase("Hot")) {
            productGrid.getChildren().addAll(
                    createProductItem("Espresso", "file:C:/Users/hp/Downloads/project/espresso.jpg", primaryStage), //method called
                    createProductItem("Cortado", "file:C:/Users/hp/Downloads/project/cortado1.jpg", primaryStage),
                    createProductItem("Flat White", "file:C:/Users/hp/Downloads/project/flat white.jpg", primaryStage),
                    createProductItem("Americano", "file:C:/Users/hp/Downloads/project/americano.jpg", primaryStage),
                    createProductItem("Irish Coffee", "file:C:/Users/hp/Downloads/project/irish.jpg", primaryStage),
                    createProductItem("Turkish Coffee", "file:C:/Users/hp/Downloads/project/turkish coffee.jpg", primaryStage),
                    createProductItem("Long Black", "file:C:/Users/hp/Downloads/project/long black.jpg", primaryStage),
                    createProductItem("Mocha", "file:C:/Users/hp/Downloads/project/mocha.jpg", primaryStage)
            );
        } else if (sectionTitle.equalsIgnoreCase("Cold")) {
            productGrid.getChildren().addAll(
                    createProductItem("Cold Brew", "file:C:/Users/hp/Downloads/project/cold brew.jpg", primaryStage),
                    createProductItem("Cafe Macchiato", "file:C:/Users/hp/Downloads/project/cafe.jpg", primaryStage),
                    createProductItem("Iced Americano", "file:C:/Users/hp/Downloads/project/iced americano.jpg", primaryStage),
                    createProductItem("Iced Mocha", "file:C:/Users/hp/Downloads/project/iced mocha.jpg", primaryStage),
                    createProductItem("Iced Latte", "file:C:/Users/hp/Downloads/project/iced latte.jpg", primaryStage),
                    createProductItem("Iced Vanilla Latte", "file:C:/Users/hp/Downloads/project/iced vanilla.jpg", primaryStage),
                    createProductItem("Dalgona Iced Coffee", "file:C:/Users/hp/Downloads/project/dalgona.jpg", primaryStage),
                    createProductItem("Caramel Iced Latte", "file:C:/Users/hp/Downloads/project/iced choco.jpg", primaryStage),
                    createProductItem("Salted Caramel", "file:C:/Users/hp/Downloads/project/salted caramel.jpg", primaryStage)
            );
        }else if(sectionTitle.equalsIgnoreCase("Flowers")){
            productGrid.getChildren().addAll(
                    createProductItem("Rose", "file:C:/Users/hp/Downloads/project/rose1.jpg", primaryStage),
                    createProductItem("Tulip", "file:C:/Users/hp/Downloads/project/tulips1.jpg", primaryStage),
                    createProductItem("Daisy", "file:C:/Users/hp/Downloads/project/download (16).jpeg", primaryStage),
                    createProductItem("Carnation", "file:C:/Users/hp/Downloads/project/carnations1.jpg", primaryStage),
                    createProductItem("Daffodils", "file:C:/Users/hp/Downloads/project/daffodils.jpg", primaryStage),
                    createProductItem("Lily", "file:C:/Users/hp/Downloads/project/idk.jpg", primaryStage),
                    createProductItem("Sunflower", "file:C:/Users/hp/Downloads/project/sunflower.jpg", primaryStage),
                    createProductItem("Poppy", "file:C:/Users/hp/Downloads/project/Poppies.jpeg", primaryStage)
            );

        }else if(sectionTitle.equalsIgnoreCase("Books")){
            productGrid.getChildren().addAll(
                    createProductItem("It ends with us", "file:C:/Users/hp/Downloads/project/alex.jpg", primaryStage),
                    createProductItem("Little Women", "file:C:/Users/hp/Downloads/project/lw.jpg", primaryStage),
                    createProductItem("Harry Potter", "file:C:/Users/hp/Downloads/project/hp.jpg", primaryStage),
                    createProductItem("Pride and Prejudice", "file:C:/Users/hp/Downloads/project/pride.jpg", primaryStage),
                  //  createProductItem("Emma", "file:C:/Users/hp/Downloads/project/emma.jpg", primaryStage),
                    createProductItem("Milenal", "file:C:/Users/hp/Downloads/project/kaf.jpg", primaryStage),
                    createProductItem("All the light we cannot see", "file:C:/Users/hp/Downloads/project/all.jpg", primaryStage),
                    createProductItem("Great Expectations", "file:C:/Users/hp/Downloads/project/charles.jpg", primaryStage),
                    createProductItem("Bringing down the duke", "file:C:/Users/hp/Downloads/project/duke.jpg", primaryStage)
            );

        }
        //working of back to homepage button
        Button backButton = new Button("Back to Homepage");
        backButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px;");
        backButton.setOnAction(e -> primaryStage.setScene(homepageScene)); //takes you back to the homepage


        sectionPage.getChildren().addAll(sectionText, productGrid, backButton);

        //setting of menu page for all sections aka second page
        Scene sectionScene = new Scene(sectionPage, 1000, 700);
        System.out.println("Switching to Section: " + sectionTitle); //displaying on console
        primaryStage.setScene(sectionScene);


    }
    //the menu and button theory aka second page
    private VBox createProductItem(String title, String imagePath, Stage primaryStage) { //method defined
        VBox productItem = new VBox(10);
        productItem.setAlignment(Pos.CENTER);

        ImageView productImage = new ImageView(new Image(imagePath));
        productImage.setFitWidth(175);
        productImage.setFitHeight(175);
        productImage.setPreserveRatio(true);

        Label productLabel = new Label(title);
        productLabel.setFont(Font.font("Georgia", 16));
        productLabel.setTextFill(Color.BROWN);

        productItem.getChildren().addAll(productImage, productLabel);


        // button for items if you press on either picture or its name
        productImage.setOnMouseClicked(e -> navigateToProduct(primaryStage, title, imagePath)); //method called
        productLabel.setOnMouseClicked(e -> navigateToProduct(primaryStage, title, imagePath));
        //productImage.setOnMouseClicked(e->navigateToProduct(primaryStage,"Flowers",imagePath) );
       // productLabel.setOnMouseClicked(e->navigateToProduct(primaryStage,"Flowers",imagePath) );

        return productItem;
    }
                    /*Methods for the descriptive/addon page of all items (aka third page)*/

    //flower page
    private void showFlowerPage(Stage primaryStage, String title, String imagePath) {
        VBox productPage = new VBox(20);
        productPage.setAlignment(Pos.CENTER);
        productPage.setPadding(new Insets(20));
        productPage.setStyle("-fx-background-color: #f5f5dc;");

        // Image
        ImageView productImage = new ImageView(new Image(imagePath));
        productImage.setFitWidth(300);
        productImage.setFitHeight(300);
        productImage.setPreserveRatio(true);

        // Title
        Text productTitle = new Text(title+ " - Rs 500");
        productTitle.setFont(Font.font("Book Antiqua", 28));
        productTitle.setFill(Color.BROWN);

        // Description
        Label productDescription = new Label(getProductDescription(title));
        productDescription.setWrapText(true);
        productDescription.setFont(Font.font("Georgia", FontPosture.ITALIC, 14)); // Italic
        productDescription.setTextFill(Color.BROWN);
        productDescription.setMaxWidth(600);
        productDescription.setAlignment(Pos.CENTER); // Center text
        productDescription.setStyle("-fx-text-alignment: center;");

        // Quantity button
        Label quantityLabel = new Label("Quantity");
        quantityLabel.setFont(Font.font("Georgia", 18));
        quantityLabel.setTextFill(Color.BROWN);

        Button decreaseButton = new Button("-");
        Label quantityValue = new Label("1");
        quantityValue.setFont(Font.font("Georgia", 16));
        quantityValue.setTextFill(Color.BROWN);
        Button increaseButton = new Button("+");

        HBox quantityBox = new HBox(10, decreaseButton, quantityValue, increaseButton);
        quantityBox.setAlignment(Pos.CENTER);
        quantityBox.setPadding(new Insets(10));
        quantityBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        decreaseButton.setOnAction(e -> {
            int qty = Integer.parseInt(quantityValue.getText());
            if (qty > 1) quantityValue.setText(String.valueOf(qty - 1));
        });

        increaseButton.setOnAction(e -> {
            int qty = Integer.parseInt(quantityValue.getText());
            quantityValue.setText(String.valueOf(qty + 1));
        });

        // Color Options
        Label colorLabel = new Label("Choose Color:");
        colorLabel.setFont(Font.font("Times New Roman", 18));
        colorLabel.setTextFill(Color.BROWN);

        RadioButton red = new RadioButton("Red");
        red.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton pink = new RadioButton("Pink");
        pink.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton white = new RadioButton("White");
        white.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton blue = new RadioButton("Blue");
        blue.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton purple = new RadioButton("Purple");
        purple.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton multicolor = new RadioButton("Multicolor");
        multicolor.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");

        ToggleGroup colorGroup = new ToggleGroup();
        red.setToggleGroup(colorGroup);
        pink.setToggleGroup(colorGroup);
        white.setToggleGroup(colorGroup);
        blue.setToggleGroup(colorGroup);
        purple.setToggleGroup(colorGroup);
        multicolor.setToggleGroup(colorGroup);
        red.setSelected(true);

        VBox colorBox = new VBox(10, colorLabel, red, pink, white, blue, purple, multicolor);
        colorBox.setPadding(new Insets(10));
        colorBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        // Note Section
        CheckBox noteCheckbox = new CheckBox("Add a Note for Loved One (+75 Rs)");
        noteCheckbox.setFont(Font.font("Times New Roman", 16));
        noteCheckbox.setTextFill(Color.BROWN);

        TextArea noteArea = new TextArea();
        noteArea.setPromptText("Write your message here...");
        noteArea.setDisable(true);
        noteCheckbox.setOnAction(e -> noteArea.setDisable(!noteCheckbox.isSelected()));

        VBox noteBox = new VBox(10, noteCheckbox, noteArea);
        noteBox.setPadding(new Insets(10));
        noteBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        // Buttons Section
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        addToCartButton.setOnAction(event -> {
            int price = 500; // Base price for flowers
            if (noteCheckbox.isSelected()) price += 75; // Add note cost
            int quantity = Integer.parseInt(quantityValue.getText());
            String color = ((RadioButton) colorGroup.getSelectedToggle()).getText();
            String note = noteCheckbox.isSelected() ? noteArea.getText() : "";

            String name = title + " - " + color;
            Items item = new Items(name, price, quantity, note);
            Items.list.add(item);

            System.out.println("Added: " + item.getName() + ", Price: " + item.getPrice() + ", Quantity: " + item.getQuantity());
            if (!note.isEmpty()) System.out.println("Note: " + note);
        });
        //back button
        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        backButton.setOnAction(e -> navigateToSection(primaryStage, "Flowers"));

        //cart showing button
        Button showCartButton = new Button("Show Cart");
        showCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        //calling of cartView class
        showCartButton.setOnAction(event -> primaryStage.setScene(CartView.viewCart(primaryStage, new BorderPane())));

        //we can call it footer innit
        HBox buttonBox = new HBox(20, backButton, addToCartButton, showCartButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Add all elements to the page
        productPage.getChildren().addAll(
                productImage,
                productTitle,
                productDescription,
                quantityBox,
                colorBox,
                noteBox,
                buttonBox
        );

        // Add ScrollPane
        ScrollPane scrollPane = new ScrollPane(productPage);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");

        Scene productScene = new Scene(scrollPane, 800, 600);
        primaryStage.setScene(productScene);
    }

    //book page
    private void showBookPage(Stage primaryStage, String title, String imagePath) {
        VBox productPage = new VBox(20);
        productPage.setAlignment(Pos.CENTER);
        productPage.setPadding(new Insets(20));
        productPage.setStyle("-fx-background-color: #f5f5dc;");

        // Product Image
        ImageView productImage = new ImageView(new Image(imagePath));
        productImage.setFitWidth(300);
        productImage.setFitHeight(300);
        productImage.setPreserveRatio(true);

        // Product Title
        Text productTitle = new Text(title);
        productTitle.setFont(Font.font("Book Antiqua", 28));
        productTitle.setFill(Color.BROWN);


        // Product Description
        Label productDescription = new Label(getProductDescription(title));
        productDescription.setWrapText(true);
        productDescription.setFont(Font.font("Georgia", FontPosture.ITALIC, 14)); // Italic
        productDescription.setTextFill(Color.BROWN);
        productDescription.setMaxWidth(600);
        productDescription.setAlignment(Pos.CENTER); // Center text
        productDescription.setStyle("-fx-text-alignment: center;");

        // Borrow or Buy button
        Label optionLabel = new Label("Choose an Option:");
        optionLabel.setFont(Font.font("Georgia", 18));
        optionLabel.setTextFill(Color.BROWN);

        RadioButton borrowButton = new RadioButton("Borrow (Free)");
        borrowButton.setFont(Font.font("Georgia", 14));
        borrowButton.setTextFill(Color.BROWN);

        RadioButton buyButton = new RadioButton("Buy (350 Rs)");
        buyButton.setFont(Font.font("Georgia", 14));
        buyButton.setTextFill(Color.BROWN);

        ToggleGroup optionGroup = new ToggleGroup();
        borrowButton.setToggleGroup(optionGroup);
        buyButton.setToggleGroup(optionGroup);
        borrowButton.setSelected(true);

        VBox optionBox = new VBox(10, optionLabel, borrowButton, buyButton);
        optionBox.setPadding(new Insets(10));
        optionBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        // Buttons Section
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        addToCartButton.setOnAction(event -> {
            int price = buyButton.isSelected() ? 350 : 0; // Buy costs 350 Rs, Borrow is free
            String option = buyButton.isSelected() ? "Buy" : "Borrow";
            String name = title + " - " + option;

            Items item = new Items(name, price, 1);
            Items.list.add(item);

            System.out.println("Added: " + item.getName() + ", Price: " + item.getPrice());
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        backButton.setOnAction(e -> navigateToSection(primaryStage, "Books"));

        Button showCartButton = new Button("Show Cart");
        showCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        showCartButton.setOnAction(event -> primaryStage.setScene(CartView.viewCart(primaryStage, new BorderPane())));

        HBox buttonBox = new HBox(20, backButton, addToCartButton, showCartButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Add all elements to the page
        productPage.getChildren().addAll(
                productImage,
                productTitle,
                productDescription,
                optionBox,
                buttonBox
        );

        //ScrollPane for scrollingggg :)
        ScrollPane scrollPane = new ScrollPane(productPage);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");

        Scene productScene = new Scene(scrollPane, 800, 600);
        primaryStage.setScene(productScene);
    }

    //coffee page (hot and cold are siblings so they share this page)
    private void showCoffeePage(Stage primaryStage, String title, String imagePath){
        VBox productPage = new VBox(20);
        productPage.setAlignment(Pos.CENTER);
        productPage.setPadding(new Insets(20));
        productPage.setStyle("-fx-background-color: #f5f5dc;");

        //Image
        ImageView productImage = new ImageView(new Image(imagePath)); //calling imageview and image class please
        productImage.setFitWidth(300);
        productImage.setFitHeight(300);
        productImage.setPreserveRatio(true);

        //title
        Text productTitle = new Text(title);
        productTitle.setFont(Font.font("Georgia", 28));
        productTitle.setFill(Color.BROWN);

        //Description
        Label productDescription = new Label(getProductDescription(title));
        productDescription.setWrapText(true);
        productDescription.setFont(Font.font("Georgia", FontPosture.ITALIC, 14)); // Italic
        productDescription.setTextFill(Color.BROWN);
        productDescription.setMaxWidth(600);
        productDescription.setAlignment(Pos.CENTER); // Center text
        productDescription.setStyle("-fx-text-alignment: center;");


        // Size Options
        Label sizeLabel = new Label("Size");
        sizeLabel.setFont(Font.font("Georgia", 18));
        sizeLabel.setTextFill(Color.BROWN);

        //radio buttons so we can choose only one
        RadioButton smallSize = new RadioButton("Small (Rs 700)");
        smallSize.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton mediumSize = new RadioButton("Medium (Rs 750)");
        mediumSize.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        RadioButton largeSize = new RadioButton("Large (Rs 800)");
        largeSize.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        ToggleGroup sizeGroup = new ToggleGroup();
        smallSize.setToggleGroup(sizeGroup);
        mediumSize.setToggleGroup(sizeGroup);
        largeSize.setToggleGroup(sizeGroup);
        smallSize.setSelected(true);

        VBox sizeBox = new VBox(10, sizeLabel, smallSize, mediumSize, largeSize);
        sizeBox.setPadding(new Insets(10));
        sizeBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        // Extras Options
        Label extrasLabel = new Label("Extras");
        extrasLabel.setFont(Font.font("Georgia", 18));
        extrasLabel.setTextFill(Color.BROWN);

        //checkbox so we can choose more than one
        CheckBox whippedCream = new CheckBox("Whipped Cream");
        whippedCream.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        CheckBox decafCoffee = new CheckBox("Decaf");
        decafCoffee.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");
        CheckBox cinnamon = new CheckBox("Cinnamon");
        cinnamon.setStyle("-fx-font-family: 'Georgia'; -fx-font-size: 12px; -fx-text-fill: #8B0000;");

        VBox extrasBox = new VBox(10, extrasLabel, whippedCream, decafCoffee, cinnamon);
        extrasBox.setPadding(new Insets(10));
        extrasBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        // counts how many do you want
        Label quantityLabel = new Label("Quantity");
        quantityLabel.setFont(Font.font("Georgia", 18));
        quantityLabel.setTextFill(Color.BROWN);

        Button decreaseButton = new Button("-");
        Label quantityValue = new Label("1");
        quantityValue.setFont(Font.font("Georgia", 16));
        quantityValue.setTextFill(Color.BROWN);
        Button increaseButton = new Button("+");

        HBox quantityBox = new HBox(10, decreaseButton, quantityValue, increaseButton);
        quantityBox.setAlignment(Pos.CENTER);
        quantityBox.setPadding(new Insets(10));
        quantityBox.setStyle("-fx-border-color: #8B4513; -fx-border-width: 1px; -fx-border-radius: 5px;");

        decreaseButton.setOnAction(e -> {
            int currentQuantity = Integer.parseInt(quantityValue.getText()); //gets the quantity rn
            if (currentQuantity > 1) { //make sure it doesnt go below 1
                quantityValue.setText(String.valueOf(currentQuantity - 1)); //decreases
            }
        });

        increaseButton.setOnAction(e -> {
            int currentQuantity = Integer.parseInt(quantityValue.getText());
            quantityValue.setText(String.valueOf(currentQuantity + 1)); //increases
        });


        // Buttons
        Button addToCartButton = new Button("Add to Cart");
        addToCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");

        addToCartButton.setOnAction(event -> {
            int price = 700;
            int quantity = Integer.parseInt(quantityValue.getText());
            String size = "";
            if (smallSize.isSelected()) {
                size = smallSize.getText();
            } else if (mediumSize.isSelected()) {
                size = mediumSize.getText();
                price = 750;
            } else if (largeSize.isSelected()) {
                size = largeSize.getText();
                price = 800;
            }

            String name = productTitle.getText();
            Items item = new Items(name, price, quantity);
            Items.list.add(item);
            System.out.println(item.getName());
            System.out.println(item.getPrice());
            System.out.println(item.getAmount());
            System.out.println(item.getQuantity());
        });

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        backButton.setOnAction(e -> navigateToSection(primaryStage, title));
        Button ToCartButton = new Button("Show Cart");
        ToCartButton.setStyle("-fx-background-color: #8B4513; -fx-text-fill: white; -fx-padding: 10px 20px;");
        ToCartButton.setOnAction(event -> primaryStage.setScene(CartView.viewCart(primaryStage, new BorderPane())));

        // Wrap buttons in an HBox for proper alignment
        HBox buttonBox = new HBox(20, backButton, addToCartButton, ToCartButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        // Add components to the product page
        productPage.getChildren().addAll(
                productImage,
                productTitle,
                productDescription,
                sizeBox,
                extrasBox,
                quantityBox,
                buttonBox
        );

        // Scroll the product page
        ScrollPane scrollPane = new ScrollPane(productPage);
        scrollPane.setFitToWidth(true);
        scrollPane.setStyle("-fx-background-color: transparent;");



        Scene productScene = new Scene(scrollPane, 800, 600);
        primaryStage.setScene(productScene);
    }





    //show product page
    private void navigateToProduct(Stage primaryStage, String title, String imagePath) {//method defined


        if (flowerNames.contains(title)) {
            showFlowerPage(primaryStage, title, imagePath);

        } else if (bookNames.contains(title)) {
            showBookPage(primaryStage,title,imagePath);

        } else {
            showCoffeePage(primaryStage,title,imagePath);
        }

    }

    private String getProductDescription(String title) {
        switch (title) {
            case "Machiato":
                return "A delightful blend of rich espresso and a hint of velvety milk foam, perfectly balanced to create a bold yet smooth coffee experience.";
            case "Cortado":
                return "Espresso and milk in perfect balance neither eclipses the other. A drink for those who savor harmony.";
            case "Flat White":
                return "An espresso’s boldness wrapped in the satin whisper of micro-foamed milk.";
            case "Americano":
                return "Rich, smooth coffee made by diluting a shot of espresso with hot water, delivering a bold yet mellow flavor.";
            case "Irish Coffee":
                return "Espresso meets its match in the fiery embrace of Irish whiskey, softened by a cool crown of cream.";
            case "Turkish Coffee":
                return "Ground fine as dust and brewed to ancient perfection, this is a drink of bold tradition.";
            case "Long Black":
                return "Double espresso meets a splash of water, preserving its intensity.";
            case "Mocha":
                return "Rich chocolate combined with bold espresso and steamed milk, topped with a sweet whipped cream.";
            case "Cold Brew":
                return "Coffee’s darker mysteries revealed slow-steeped for hours, the essence of the bean emerges smooth and powerful.";
            case "Cafe Macchiato":
                return "A bold espresso crowned with a delicate dollop of steamed milk or foam, offering a harmonious blend of robust coffee and creamy smoothness. ";
            case "Iced Americano":
                return "Espresso dives into cold, crisp water over ice—a bold refreshment that’s as sharp as a breeze through city streets.";
            case "Iced Mocha":
                return "Rich chocolate and bold espresso chill together under a layer of frothy cream. It’s decadence on ice, perfect for indulgent days.";
            case "Iced Latte":
                return "Espresso and milk on ice—cool simplicity, where boldness meets a soothing chill. Each sip is a refreshing reset.";
            case "Iced Vanilla Latte":
                return "Bold espresso softened by silky milk and kissed with vanilla sweetness, served ice-cold. It’s the epitome of elegance and cool.";
            case "Dalgona Iced Coffee":
                return "Clouds of whipped coffee sit atop chilled milk, an airy contrast to the rich depth below. Sweet, creamy.";
            case "Caramel Iced Latte":
                return "A refreshing blend of rich espresso, creamy milk, and a drizzle of sweet caramel, served over ice.";
            case "Salted Caramel":
                return "Espresso and steamed milk mingle under a frothy crown, laced with salted caramel ribbons.";
            case "Rose":
                return "A timeless symbol of love and passion, the rose whispers stories of romance with every delicate petal.";
            case "Tulip":
                return "As gentle as spring’s first breeze, the tulip stands tall, carrying elegance and a promise of renewal.";
            case "Daisy":
                return "Bathed in innocence, the daisy blooms like a sunlit smile, bringing joy and purity to the heart.";
            case "Carnation":
                return "With petals soft as a lover's sigh, the carnation speaks of deep admiration, devotion, and enduring affection.";
            case "Daffodils":
                return "Golden trumpets of hope, daffodils herald the arrival of brighter days with their sunlit charm.";
            case "Lily":
                return "Graceful and serene, the lily rises like a quiet prayer, embodying purity, peace, and transcendence.";
            case "Sunflower":
                return "Turning always to the light, the sunflower radiates joy, a beacon of warmth, loyalty, and unshakable faith.";
            case "Poppy":
                return "A fleeting flame in hues untold, whispering dreams in summer's fold.";
            case "It ends with us":
                return "There is no such thing as bad people. We’re all just people who sometimes do bad things.";
            case "Little Women":
                return "I am not afraid of storms, for I am learning how to sail my ship.";
            case "Harry Potter":
                return "It is our choices, Harry, that show what we truly are, far more than our abilities.";
            case "Pride and Prejudice":
                return "I declare after all there is no enjoyment like reading!";
            //case "Emma":
                //return "Seldom, very seldom, does complete truth belong to any human disclosure.";
            case "Milenal":
                return "It's only because of their stupidity that they're able to be so sure of themselves.";
            case "All the light we cannot see":
                return "Open your eyes and see what you can with them before they close forever.";
            case "Great Expectations":
                return "Ask no questions, and you'll be told no lies.";
            case "Bringing down the duke":
                return "A woman should not have to wear a suit of armor to succeed in this world.";

                default:
                return "Delicious and satisfying coffee beverage.";
        }
    }
}


