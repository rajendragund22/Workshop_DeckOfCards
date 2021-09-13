package com.bridgelabz.deckofcard;

import java.util.Scanner;

public class DecksOfCards {

    public static void main(String[] args) {
        System.out.println("Welcome to the Deck of Cards Program !!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number between 2 to 4");
        System.out.print("Enter number of players :");
        int playerCount = sc.nextInt();
        CardsPlay play = new CardsPlay(playerCount);
        play.generateCards();
        play.addPlayer();
        play.setPlayerSequence();
        play.distributeCards();
        play.printCardList();
    }
}

