package com.bridgelabz.deckofcard;

import java.util.ArrayList;
import java.util.Scanner;

public class CardsPlay {

    int playerCount;
    String[] cards = new String[52];
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

        System.out.print("Cards : ");
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
                Player player1 = new Player(name);
                playerList.add(player1);
            }
        }
    }
    public String getCards(){

        int position = (int)(Math.random());
        String returnValue = cardsArr.get(position);
        cardsArr.remove(position);
        return returnValue;
    }
    public void distributeCards(){
        for(int i=1; i<=9; i++){
            for(Player playerObj : playerList){
                //adding each card in cardList of each player
                playerObj.setCardList(getCards());

            }
        }
    }
    public void printCardList(){

        for(Player playerObj : playerList){

            System.out.print("\ncards of "+ playerObj.name +" : ");
            playerObj.getCardList();
            System.out.print("\n ");
        }
    }
}
