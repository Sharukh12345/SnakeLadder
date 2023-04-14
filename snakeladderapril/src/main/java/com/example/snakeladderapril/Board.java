package com.example.snakeladderapril;

import javafx.util.Pair;

import java.security.PublicKey;
import java.util.ArrayList;

public class Board {
    ArrayList<Pair<Integer,Integer>> positionCoordinate;
    ArrayList<Integer> snakeLadderPosition;
    public Board(){
        positionCoordinate=new ArrayList<>();
        PopulatePositionCoordinates();
        populateSnakeLadder();
    }

    public void PopulatePositionCoordinates(){
        positionCoordinate.add(new Pair<>(0,0));//dummy values;
        for (int i = 0; i < SnakeLadder.height; i++) {
            for (int j = 0; j < SnakeLadder.width; j++) {
                int xcord=0;
                if(i%2==0){
                    xcord=(j*SnakeLadder.tileSize)+SnakeLadder.tileSize/2;}
                else{
                    xcord=(SnakeLadder.tileSize*SnakeLadder.height)-(j*SnakeLadder.tileSize)-(SnakeLadder.tileSize/2);
                }
                int ycord=SnakeLadder.tileSize*SnakeLadder.height-(i*SnakeLadder.tileSize)-(SnakeLadder.tileSize/2);
                positionCoordinate.add(new Pair<>(xcord,ycord));}}}


    private void populateSnakeLadder() {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(4, 25);
        snakeLadderPosition.set(27, 5);
        snakeLadderPosition.set(33, 49);
        snakeLadderPosition.set(40, 3);
        snakeLadderPosition.set(42, 63);
        snakeLadderPosition.set(43, 18);
        snakeLadderPosition.set(50, 69);
        snakeLadderPosition.set(54, 31);
        snakeLadderPosition.set(62, 81);
        snakeLadderPosition.set(66, 45);
        snakeLadderPosition.set(76, 58);
        snakeLadderPosition.set(74, 92);
        snakeLadderPosition.set(89, 53);
        snakeLadderPosition.set(99, 41);
    }
    public int getNewPosition(int currentPosition){
        if(currentPosition>0&&currentPosition<=100) {
            return snakeLadderPosition.get(currentPosition);
        }return -1;
    }




    int getXcoordinate(int position){
        if(position>=1&&position<=100)
            return positionCoordinate.get(position).getKey();
            return -1;}
    int getYcoordinate(int position){
        if(position>=1&&position<=100)
        return positionCoordinate.get(position).getValue();
        return -1;
    }


  /*  public static void main(String args[]){
        Board board=new Board();
        for(int i=0;i<board.positionCoordinate.size();i++){
            System.out.println(i+" $ X: "+board.positionCoordinate.get(i).getKey()+" y : "
                    +board.positionCoordinate.get(i).getValue());

            }

        }*/

    }


