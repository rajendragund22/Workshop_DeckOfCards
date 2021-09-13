package com.bridgelabz.deckofcard;

import java.util.ArrayList;

public class Player {
    String name;
    ArrayList<String> cardList = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public void setCardList(String card) {
        cardList.add(card);
    }

    public void getCardList() {
        //get all cards inside cardList
        for (String position : cardList) {
            System.out.print(position + ", ");
        }
    }
}
