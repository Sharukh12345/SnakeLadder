package com.example.snakeladderapril;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;


public class SnakeLadder extends Application {
    public static final int tileSize=50,width=10,height=10;
    public static final int buttonLine=height*tileSize+30,infoLine=buttonLine-20;
    private static Dice dice=new Dice();
    private Player playerOne,playerTwo;
    private  boolean gameStarted=false,playerOneTurn=false,playerTwoTurn=false;
    private Pane createContest(){
        Pane root=new Pane();
        root.setPrefSize(width*tileSize,height*tileSize+50);
        for (int i = 0; i <height ; i++) {
            for (int j = 0; j < width; j++) {
                Tile tile=new Tile(tileSize);
                tile.setTranslateX(j*tileSize);
                tile.setTranslateY(i*tileSize);
                root.getChildren().add(tile);
            }}
 Image img=new Image("C:\\Users\\hi\\IdeaProjects\\snakeladderapril\\src\\main\\img.jpg");
        ImageView board=new ImageView();
        board.setImage(img);
        board.setFitHeight(height*tileSize);
        board.setFitWidth(width*tileSize);
        //Buttons
        Button playerOneButton=new Button("player One");
        Button playerTwoButton=new Button("player Two");
        Button startButton=new Button("Start");
        playerOneButton.setTranslateY(buttonLine);
        playerOneButton.setTranslateX(30);
        playerOneButton.setDisable(true);
        playerTwoButton.setTranslateY(buttonLine);
        playerTwoButton.setTranslateX(330);
        playerTwoButton.setDisable(true);
        startButton.setTranslateY(buttonLine);
        startButton.setTranslateX(180);
        Label  playerOneLabel=new Label("");
        Label playerTwoLabel=new Label("");
        Label diceLabel=new Label("start");
        playerOneLabel.setTranslateY(infoLine);
        playerOneLabel.setTranslateX(30);
        playerTwoLabel.setTranslateY(infoLine);
        playerTwoLabel.setTranslateX(320);
        diceLabel.setTranslateY(infoLine);
        diceLabel.setTranslateX(180);
        playerOne =new Player(tileSize, Color.BLACK,"sharukh");
        playerTwo=new Player(tileSize-5,Color.WHITE,"anil");
        //player action
     playerOneButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

               if(gameStarted){
                    if(playerOneTurn){
                        int diceValue=dice.getRollDiceValue();
                        diceLabel.setText("dice Value :"+diceValue);
                        playerOne.movePlayer(diceValue);
                        //wining condition
                        if(playerOne.isWinner()) {
                            diceLabel.setText("Winner is:"+playerOne.getName());
                            playerOneTurn=false;
                            playerOneButton.setDisable(true);
                            playerOneLabel.setText("");
                            playerTwoTurn=false;
                            playerTwoButton.setDisable(true);
                            playerTwoLabel.setText("");
                            startButton.setDisable(false);
                            startButton.setText("Restart Game");
                        }else{
                        playerOneTurn=false;
                          playerOneButton.setDisable(true);
                        playerOneLabel.setText("");
                        playerTwoTurn=true;
                        playerTwoButton.setDisable(false);
                        playerTwoLabel.setText("Your Turn: "+playerTwo.getName());
                    }}
                }}});

      playerTwoButton.setOnAction(new EventHandler<ActionEvent>() {
          @Override
          public void handle(ActionEvent actionEvent) {


              if(gameStarted){
                  if(playerTwoTurn){
                      int diceValue=dice.getRollDiceValue();
                      diceLabel.setText("dice Value :"+diceValue);
                      playerTwo.movePlayer(diceValue);//wining condition
                      if(playerTwo.isWinner()) {
                      diceLabel.setText("Winner is:"+playerTwo.getName());
                          playerOneTurn=false;
                          playerOneButton.setDisable(true);
                          playerOneLabel.setText("");
                          playerTwoTurn=false;
                          playerTwoButton.setDisable(true);
                          playerTwoLabel.setText("");
                          startButton.setDisable(false);
                          startButton.setText("Restart Game");
                      }else{
                      playerOneTurn=true;
                       playerOneButton.setDisable(false);
                      playerOneLabel.setText("Your Turn "+playerOne.getName());
                      playerTwoTurn=false;
                      playerTwoButton.setDisable(true);
                      playerTwoLabel.setText("");}

              }}}});





        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                gameStarted=true;
                diceLabel.setText("Game Started");
                startButton.setDisable(true);
                playerOneTurn=true;
                playerOneLabel.setText("Your Turn:"+playerOne.getName());
                playerOneButton.setDisable(false);
                playerOne.staringPosition();
                playerTwoTurn=false;
                playerTwoLabel.setText("");
                playerTwoButton.setDisable(true);
                playerTwo.staringPosition();
            }
        });


        root.getChildren().addAll(board,playerOneButton,playerTwoButton,startButton,
                playerOneLabel,playerTwoLabel, diceLabel,playerOne.getCoin(),playerTwo.getCoin());


        return root;}

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SnakeLadder.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContest());
        stage.setTitle("Sanke & Ladder!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}