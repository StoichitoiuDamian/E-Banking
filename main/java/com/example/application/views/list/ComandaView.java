package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.*;


import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import controller.CardController;
import database.DaoCard;
import model.Card;

@PageTitle("comanda")
@Route(value = "comanda")
public class ComandaView extends VerticalLayout{
    TextField firstName;
    TextField nrTelefon;
    Button b1;
    DatePicker datePicker;

    public ComandaView(){
        H1 text1 = new H1("Vreau card!");
        H4 text2 = new H4("Completează formularul pentru a cere cardul sau un calcul personalizat. ");
        H4 text3 = new H4("Te sunăm noi pentru a discuta detaliile.");

        firstName = new TextField("Nume");
        firstName.setAllowedCharPattern("[a-z A-Z]");

        nrTelefon = new TextField("Numar Telefon");
        nrTelefon.setAllowedCharPattern("[0-9]");
        b1 = new Button("Solicit card");

        datePicker = new DatePicker("data");
        Image img = new Image("images/manacard.png", "...");
        VerticalLayout v1 = new VerticalLayout(img,text1,text2,text3,firstName,nrTelefon,datePicker,b1);
        v1.setHorizontalComponentAlignment(Alignment.CENTER);
        v1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(v1);


        b1.addClickListener(e -> {
            String currentFirstName=firstName.getValue();
            String phoneNum=nrTelefon.getValue();
            String date= String.valueOf(datePicker.getValue());
            CardController cardController=new CardController(currentFirstName, date);

            if(currentFirstName.length()==0 || phoneNum.length()==0 || datePicker.getValue()==null)
                Notification.show("Completati toate campurile!");
            else if(cardController.validate()) {
                Notification.show("Cerere inregistrata!");
                firstName.setValue("");
                nrTelefon.setValue("");

            }
            else
                Notification.show("Cerere esuata!");
        });
    }


}
