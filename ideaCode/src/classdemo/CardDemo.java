package classdemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CardDemo {
    public static void main(String[] args) {
        //1.创建一副牌
        List<Card> poker=buyCard();
        //2.洗牌
        //把list的元素全部打乱
        Collections.shuffle(poker);
        //3.发牌,有三个玩家，每个人发5张排
        List<List<Card>> players=new ArrayList<>();
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        players.add(new ArrayList<Card>());
        //i表示牌编号
        //j表示玩家
        for(int i=0;i<5;i++){
            for(int j=0;j<3;j++){
                List<Card> player=players.get(j);
                player.add(poker.remove(0));
            }
        }
        for(int i=0;i<3;i++){
            System.out.println("玩家"+i+": "+players.get(i));
        }
    }
    //这是一幅新牌
    private static List<Card> buyCard(){
        List<Card> poker=new ArrayList<>();
        String[] suits={"♥","♠","♣","♦"};
        for(int i=0;i<4;i++){
            //4种花色，13张牌
            poker.add(new Card("A",suits[i]));
            for(int j=2;j<=10;j++){
                //""+int型，可以转字符串
                //String.valueOf(j)可以转字符串
                poker.add(new Card(""+j,suits[i]));
            }
            poker.add(new Card("J",suits[i]));
            poker.add(new Card("Q",suits[i]));
            poker.add(new Card("K",suits[i]));
        }
        return poker;
    }
}


//卡牌
class Card{
    private String rank;//卡牌点数
    private String suit;//花

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "["+this.suit+this.rank+"]";
    }



    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
