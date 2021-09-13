package com.bridgelabz.deckofcard;

import java.util.ArrayList;
import java.util.Scanner;

public class CardsPlay {

    int playerCount;
    ArrayList<Player> playerList = new  ArrayList<>();
    ArrayList<String> cardsArr = new  ArrayList<>();
    public CardsPlay(int playerCount){
        this.playerCount = playerCount;
    }
    public void generateCards(){

        String[] suit = {"Clubs", "Diamonds", "Hearts","Spades"};
        String[] rank = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        //get combination
        for(int i=0; i<suit.length; i++){
            for(int j=0; j<rank.length; j++){

                cardsArr.add(suit[i] + rank[j]);
            }
        }
    }

    public void printCards(){

        System.out.println("\nCards ");
        for(int i=0; i<cardsArr.size(); i++){
            System.out.print(" " + cardsArr.get(i) + "\n");
        }
    }
    public void addPlayer(){

        Scanner sc = new Scanner(System.in);

        if(playerCount >= 2 && playerCount <= 4){
            for(int i=1; i<=playerCount; i++){
                System.out.print(" Enter player "+i+" name : ");
                String name = sc.nextLine();
                Player play = new Player(name);
                playerList.add(play);
            }
        }
    }
    public void shuffleCards(){

        for (int i = 0; i < cardsArr.size(); i++)
        {
            int min = 0;
            int max = cardsArr.size() - 1;
            int position = (int)(Math.random()  * (max - min + 1) + min);
            int newPosition = (position - i);
            if(newPosition < 0 || newPosition > 52)
                newPosition = 0;
            //swapping the elements
            String temp = cardsArr.get(newPosition);
            cardsArr.set(newPosition, cardsArr.get(i));
            cardsArr.set(i, temp);
        }
    }
    //get each card from cardsArr
    public String getCards(){

        int min = 0;
        int max = cardsArr.size() - 1;
        int position = (int)(Math.random()  * (max - min + 1) + min);

        String returnValue = cardsArr.get(position);
        cardsArr.remove(position);
        return returnValue;
    }
    public void distributeCards(){
        for(int i=1; i<=9; i++){
            for(Player playerObj : playerList){
                //adding each card in cardList of each player
                playerObj.setCardList(getCards());
                shuffleCards();
            }
        }
    }

    public void printCardList(){

        for(Player playerObj : playerList){

            System.out.print("\ncards of "+ playerObj.name +" : ");
            playerObj.getCardList();
            System.out.print("\n ");
            System.out.print("\nunique cards: ");
            playerObj.getUniqueCards();
        }
    }
    public void setPlayerSequence(){

        Scanner sc = new Scanner(System.in);
        int PlaylistSize = playerList.size();

        for(int i=0; i < PlaylistSize; i++){

            Player temp = playerList.get(i);
            System.out.print("\n Set player position for (staring from 0) "+ temp.name +" : ");
            int newPosition = sc.nextInt();
            if(newPosition > PlaylistSize || newPosition < 0){
                System.out.print("\n Invalid position !!");
                return;
            }

            playerList.set(i,playerList.get(newPosition));
            playerList.set(newPosition,temp);
        }
    }
}
