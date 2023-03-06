package com.example.application.views.list;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.notification.Notification;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import database.DaoCard;
import database.DataProvider;

@PageTitle("nevoiPersonale")
@Route(value = "nevoiPersonale")
public class CrediteNevoiePersonaleView extends VerticalLayout{
    TextField firstName;
    TextField lastName;
    TextField nrTelefon;
    TextField idClient;
    TextField creditOnline;
    Button b1;
    Button b2;
    public CrediteNevoiePersonaleView(){
        H1 text1 = new H1("Ce sumă poți împrumuta?");
        H5 text2 = new H5("Completează formularul pentru a cere creditul sau pentru a afla ce");
        H5 text3 = new H5("sumă poți lua. După aceea, te sunăm noi ca să discutăm mai multe.");
        H1 text4 = new H1("Creditul online");
        H4 text5 = new H4("maxim 10000 ron in mai putin de 10 minute");

        firstName = new TextField("Nume");
        firstName.setAllowedCharPattern("[a-z A-Z]");

        lastName = new TextField("Prenume");
        lastName.setAllowedCharPattern("[a-z A-Z]");

        idClient = new TextField("nume Client");
        idClient.setAllowedCharPattern("[a-z A-Z]");

        nrTelefon = new TextField("Numar Telefon");
        nrTelefon.setAllowedCharPattern("[0-9]");

        creditOnline=new TextField("Suma dorita");
        nrTelefon.setAllowedCharPattern("[0-4]");

        b1 = new Button("Vreau sa fiu sunat");
        b2 = new Button("confirmare");

        DatePicker datePicker = new DatePicker("Cand doriti sa fiti sunat");

        Image img = new Image("images/credit.png", "...");
        Image costuri = new Image("images/costuri.png", "...");
        VerticalLayout v1 = new VerticalLayout(img,text1,text2,text3,firstName,lastName,nrTelefon,datePicker,b1,costuri,text4,text5,idClient,creditOnline,b2);
        v1.setHorizontalComponentAlignment(Alignment.CENTER);
        v1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(v1);


        b2.addClickListener(e->{
            String currentName=idClient.getValue();
            String username= new DataProvider().getFirstName();
            String value=creditOnline.getValue();

            if(username.length()==0 || value.length()==0)
                Notification.show("Completati toate campurile!");
            else if(!username.equals(currentName))
                Notification.show("Nume incorect sau nu sunteti autentificat!");
            else if(Integer.parseInt(value) > 10000)
                    Notification.show("Imprumut prea mare!");
            else {
                new DaoCard().updateCardPlus(value,username);
                Notification.show("Imprumut efectuat!");
                creditOnline.setValue("");
            }
        });
    }

}
