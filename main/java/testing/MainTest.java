package testing;

import database.DaoAddress;
import database.DaoCard;
import database.DaoClient;
import model.Address;
import model.Card;
import model.Client;

public class MainTest {
    public static void main(String[] args) {
        DaoCard dac = new DaoCard();
        //Card myCard=new Card(1,1,"22/03/2025","rus",100);
        //dac.addCard(myCard);
        dac.updateCardMinus("68","neymar");

    }
}
