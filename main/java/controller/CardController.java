package controller;

import database.DaoCard;
import database.DaoClient;
import database.DataProvider;
import model.Card;
import model.Client;


import java.util.List;

public class CardController {
    private String firstName;
    private DaoCard daoCard;
    private String expDate;

    public CardController(String firstName,String expDate) {
        this.firstName = firstName;
        this.expDate=expDate;
        this.daoCard=new DaoCard();

    }

    public boolean validate(){
        List<String> cardsList=daoCard.getAllCardNames();

        if((new DaoClient()).getClientByName(firstName)!=null &&  !cardsList.contains(this.firstName) )

          if((new DataProvider()).getFirstName().equals(this.firstName)){ //just for the current user
            String newDate = this.expDate.substring(0,3)+'5'+ this.expDate.substring(4);

            Card card=new Card(1,this.getClientId(this.firstName),newDate,firstName,100);
            this.daoCard.addCard(card);
            return true;
        }
        return false;
    }

    public int getClientId(String firstName) {
        DaoClient daoClient = new DaoClient();
        Client client = daoClient.getClientByName(firstName);
        return client.getId();
    }

}
