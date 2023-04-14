package com.example.snakeladderapril;

import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Player {
    private Circle coin;
    private int currentPosition;
    private String name;
    private static  Board gameboard=new Board();
    public Player(int tileSize, Color coincolor,String playername){
        coin=new Circle(tileSize/2);
        coin.setFill(coincolor);
        currentPosition=1;
        movePlayer(0);
        name=playername;
    }
    public void movePlayer(int diceValue){
        if(currentPosition+diceValue<=100){
            currentPosition+=diceValue;
            TranslateTransition secondMove=null  ,firstMove=translateAnimation(diceValue);
       // int x=gameboard.getXcoordinate(currentPosition);
        //int y=gameboard.getYcoordinate(currentPosition);
       // coin.setTranslateX(x);
       // coin.setTranslateY(y);
        translateAnimation(diceValue);
        int newPosition= gameboard.getNewPosition(currentPosition);
        if(newPosition!=currentPosition&&newPosition!=-1){
            currentPosition=newPosition;

                    secondMove=translateAnimation(6);}
        if(secondMove==null){
            firstMove.play();
        }else{
            SequentialTransition sequentialTransition=new SequentialTransition(firstMove,
            new PauseTransition(Duration.millis(1000)),secondMove);
            sequentialTransition.play();
        }


    }}
    private  TranslateTransition translateAnimation(int diceValue){
        TranslateTransition animate=new TranslateTransition(Duration.millis(200*diceValue),coin);
        animate.setToX(gameboard.getXcoordinate(currentPosition));
        animate.setToY(gameboard.getYcoordinate(currentPosition));
        animate.setAutoReverse(false);
        return animate;
    }
    boolean isWinner(){
        if(currentPosition==100)
        return true;
        return false;
    }
    public void staringPosition(){
        currentPosition=1;
        movePlayer(0);
    }

    public Circle getCoin() {
        return coin;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getName() {
        return name;
    }
}
