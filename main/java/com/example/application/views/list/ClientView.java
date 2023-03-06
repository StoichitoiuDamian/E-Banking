package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import database.DaoCard;
import database.DaoClient;
import database.DataProvider;

@PageTitle("list")
@Route(value = "clienti")
public class ClientView extends VerticalLayout {
    String userName;

    DataProvider dataProvider;
    Button logOut;
    Button expiraCard;
    Button actualizareDate;
    Button nevoiPersonale;
    Button carduri;
    Button logIn;
    Button schimbValutar;
    Button sold;
    Button veziDatePersonale;


    Button sendMoney;
    TextField recieverName;
    TextField ammount;

    HorizontalLayout h2;
    VerticalLayout h3;


    public ClientView() {
        expiraCard = new Button("Imi expira cardul");
        actualizareDate = new Button("Actualizare Date");
        nevoiPersonale = new Button("Credite de nevoi personale");
        carduri = new Button("Carduri");
        logIn = new Button("Autentificare");
        schimbValutar = new Button("Schimb Valutar");
        dataProvider = new DataProvider();
        sold = new Button("Vezi sold");
        veziDatePersonale=new Button("Contul meu");

        userName = dataProvider.getFirstName();
        logOut = new Button("LogOut");

        sendMoney=new Button("Trimite bani");

        recieverName=new TextField("Nume");
        recieverName.setValue("ex:Popescu");
        recieverName.setAllowedCharPattern("[a-z A-Z]");

        ammount=new TextField("Suma");
        ammount.setValue("ex:500");
        ammount.setAllowedCharPattern("[0-9]");


        logOut.addClickListener(e -> {
            dataProvider=null;
            UI.getCurrent().navigate("");

        });

        logIn.addClickListener(e -> {
            UI.getCurrent().navigate("login");
        });
        expiraCard.addClickListener(e -> {
            UI.getCurrent().navigate("ImiExpiraCardul");
        });
        carduri.addClickListener(e -> {
            UI.getCurrent().navigate("Carduri");
        });
        schimbValutar.addClickListener(e -> {
            UI.getCurrent().navigate("SchimbValutar");
        });
        actualizareDate.addClickListener(e -> {
            UI.getCurrent().navigate("ActualizareDate");
        });
        nevoiPersonale.addClickListener(e -> {
            UI.getCurrent().navigate("nevoiPersonale");
        });

        sold.addClickListener(e -> {
            int sold= (new DaoCard()).getSoldByName(userName);
            Notification.show(sold+"lei");
        });

        veziDatePersonale.addClickListener(e->{
            UI.getCurrent().navigate("contulMeu");
        });

        sendMoney.addClickListener(e -> {
            int sold= (new DaoCard()).getSoldByName(userName);
            String rName=recieverName.getValue();
            int value= Integer.parseInt(ammount.getValue());

            if(new DaoClient().getClientByName(rName)==null)
                Notification.show("Client inexistent!");
            else if(sold<value)
                Notification.show("Sold insuficient!");
            else if (rName.equals(userName))
                Notification.show("Nu iti poti trimite tie!");
            else {
                DaoCard dc=new DaoCard();
                dc.updateCardPlus(String.valueOf(value),rName);
                dc.updateCardMinus(String.valueOf(value),userName);

                Notification.show("Tranzactie efectuata!");
                recieverName.setValue("");
                ammount.setValue("");
            }
        });


        VerticalLayout h1 = new VerticalLayout(new H1("Welcome "+userName));
        h1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(h1);

        h2 = new HorizontalLayout(expiraCard, actualizareDate, nevoiPersonale, carduri,schimbValutar,logOut,sold,veziDatePersonale);
        h2.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        add(h2);

        Image img = new Image("images/D&A.jpg", "...");
        img.setWidth("1900px");
        img.setHeight("600px");
        add(img);


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        getStyle().set("text-align", "center");

        h2 = new HorizontalLayout(recieverName,ammount,sendMoney);
        h2.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        add(h2);
        getStyle().set("text-align", "end");

    }

}
