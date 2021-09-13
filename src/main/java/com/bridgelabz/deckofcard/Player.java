package com.bridgelabz.deckofcard;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    String name;
    ArrayList<String> cardList = new ArrayList<>();
    HashMap<String,Integer> cardMap = new HashMap<>();

    public Player(String name){
        this.name = name;
    }

    public void setCardList(String card){
        cardList.add(card);
    }

    public void getCardList(){
        //get all cards inside cardList
        for(String position : cardList){
            System.out.print(position+", ");
        }
    }

    public void getUniqueCards(){
        String[] suit = {"Clubs", "Diamonds", "Hearts","Spades"};

        for(int i=0; i < suit.length ; i++){
            String suitValue = suit[i];

            for(String card : cardList){

                if(card.contains(suitValue)){

                    if(cardMap.containsKey(suitValue)){
                        // increment count here
                        cardMap.put(suitValue, cardMap.get(suitValue) + 1);
                    }else{
                        // add new keyvalue pair to HashMap
                        cardMap.put(suitValue, 1);
                    }
                }
            }

        }
        for (String card: cardMap.keySet()) {

            String key = card.toString();
            int value = cardMap.get(key);
            System.out.println(key + " " + value);
        }

    }

}