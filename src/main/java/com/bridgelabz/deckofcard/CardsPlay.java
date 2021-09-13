package com.bridgelabz.deckofcard;

import java.util.ArrayList;
import java.util.Scanner;

public class CardsPlay {
    String[] cards = new String[52];
    ArrayList<Player> playerList = new ArrayList<>();
    public void generateUniqueCards(){

        String[] suit = {"Clubs", "Diamonds", "Hearts","Spades"};
        String[] rank = {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
        int position = 0;
        for(int i=0; i<suit.length; i++){
            for(int j=0; j<rank.length; j++){
                cards[position] = suit[i] + rank[j];
                System.out.println(position);
                System.out.println( cards[position] );
                position++;
            }
        }
    }
    public void addPlayer(){

        System.out.print(" Enter the No of players : ");
        Scanner sc = new Scanner(System.in);
        int playerCount = sc.nextInt();
        if(playerCount >= 2 && playerCount <= 4){
            for(int i=0; i<playerCount; i++){
                Player player = new Player();
                playerList.add(player);
            }

        }else{
            System.out.println("Invalid input # Enter between 2 to 4 #");
        }
    }
}