
package com.example.application.views.list;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H1;

import com.vaadin.flow.component.html.Image;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import controller.LogInController;
import database.DaoAddress;
import database.DaoClient;
import model.Client;


import java.util.ArrayList;

import java.util.Objects;

@Route("ActualizareOnline")
@PageTitle("ActualizareOnline")
public class ActualizareOnline extends VerticalLayout {
    ComboBox<String> comboBox;

    Button modifica;

    TextField firstName;
    PasswordField parola1;
    TextField nrTelefon1;
    TextField strada;
    TextField oras;


    PasswordField parola;
    PasswordField repetaParola;

    public ActualizareOnline() {
        Image img = new Image("images/icon.png", "...");
        Image img2 = new Image("images/actualizare.png", "...");
        H1 text = new H1("Actualizarea datelor online");
        H1 text2 = new H1("Inainte de a va actualiza datele va rugam sa completati cateva campuri");

        firstName = new TextField("Nume");
        firstName.setAllowedCharPattern("[a-z A-Z]");

        parola1 = new PasswordField("Parola");


        H1 text3 = new H1("Datele pe care le puteti modifica");

        nrTelefon1 = new TextField("Numar Telefon");
        nrTelefon1.setAllowedCharPattern("[0-9]");

        strada = new TextField("Strada");

        oras = new TextField("Oras");
        oras.setAllowedCharPattern("[a-z A-Z]");



        parola = new PasswordField("Parola");
        repetaParola = new PasswordField("Confirmare Parola");

        modifica = new Button("Actualizeaza");
        comboBox = new ComboBox<>("Judet");
        comboBox.setItems(this.judete());
        //comboBox.setAllowedCharPattern("[]");

        VerticalLayout v1 = new VerticalLayout(text, img, img2, text2);
        add(v1);
        v1.setHorizontalComponentAlignment(Alignment.CENTER);
        v1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout v2 = new HorizontalLayout(firstName, parola1);
        add(v2);
        setHorizontalComponentAlignment(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        VerticalLayout v4 = new VerticalLayout(text3);
        add(v4);
        v4.setHorizontalComponentAlignment(Alignment.CENTER);
        v4.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout v5 = new HorizontalLayout(nrTelefon1, strada);
        add(v5);
        setHorizontalComponentAlignment(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout v6 = new HorizontalLayout(oras, comboBox);
        add(v6);
        setHorizontalComponentAlignment(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        HorizontalLayout v7 = new HorizontalLayout(parola, repetaParola);
        add(v7);
        setHorizontalComponentAlignment(Alignment.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        VerticalLayout v8 = new VerticalLayout(modifica);
        add(v8);
        v8.setHorizontalComponentAlignment(Alignment.CENTER);
        v8.setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        modifica.addClickListener(e -> {
            LogInController logControl = new LogInController(firstName.getValue(), parola1.getValue());
            if (logControl.validate()) {

                //actualizare  ADRESA
                DaoAddress dadr = new DaoAddress();
                DaoClient dcl = new DaoClient();
                String data = this.getAdressData();

                if (data.length() > 0) {
                    dadr.updateAddress(data, this.getClientId(firstName.getValue()));
                    Notification.show("Adresa actualizata cu succes!");
                    this.resetFields1();
                }


                //actualizare  parola
                String data1 = this.getClientDataPas();
                if (data1.length() > 0 && this.validatePassword()) {
                    dcl.updateClient(data1, this.getClientId(firstName.getValue()));
                    Notification.show("Parola actualizata cu succes!");
                    this.resetFields2();
                }

                if (!this.validatePassword() && this.repetaParola.getValue().length() > 0)
                    Notification.show("parolele nu corespund!");

                //actualizare numar de telefon
                String data3 = this.getClientDataPhone();
                if (data3.length() > 0) {
                    dcl.updateClient(data3, this.getClientId(firstName.getValue()));
                    Notification.show("Numar de telefon actualizat cu succes!");
                    this.nrTelefon1.setValue("");
                }



            } else {
                Notification.show("userName sau parola incorecte");
                firstName.setValue("");
                parola1.setValue("");
            }


        });

    }


    public int getClientId(String firstName) {
        DaoClient daoClient = new DaoClient();
        Client client = daoClient.getClientByName(firstName);
        return client.getId();
    }


    public String getAdressData() {
        String data = "";
        if (this.strada.getValue().length() != 0)
            data += " strada='" + strada.getValue() + "'" + ",";
        if (this.oras.getValue().length() != 0)
            data += " oras='" + oras.getValue() + "'" + ",";
        if (  comboBox.getValue()!=null)
            if(this.comboBox.getValue().length() !=0)
                data += " judet='" + comboBox.getValue() + "'" + ",";

        if (data.length() > 0)
            data = data.substring(0, data.length() - 1);

        return data;
    }


    public String getClientDataPas() {
        String data = "";

        if (this.repetaParola.getValue().length() != 0)
            data += " password='" + repetaParola.getValue() + "'" + ",";


        if (data.length() > 0)
            data = data.substring(0, data.length() - 1);

        return data;
    }

    public String getClientDataPhone() {
        String data = "";
        if (this.nrTelefon1.getValue().length() != 0)
            data += " phoneNum='" + nrTelefon1.getValue() + "'" + ",";

        if (data.length() > 0)
            data = data.substring(0, data.length() - 1);

        return data;
    }


    public Boolean validatePassword() {
        if (this.repetaParola.getValue().length() > 0)
            return Objects.equals(this.parola.getValue(), this.repetaParola.getValue());
        return false;
    }


    public ArrayList<String> judete() {
        ArrayList<String> items = new ArrayList<>();
        items.add("Alba");
        items.add("Arad");
        items.add("Argeș");
        items.add("Bacău");
        items.add("Bihor");
        items.add("Bistrița-Năsăud");
        items.add("Botoșani");
        items.add("Brașov");
        items.add("Brăila");
        items.add("București");
        items.add("Buzău");
        items.add("Caraș-Severin");
        items.add("Călărași");
        items.add("Cluj");
        items.add("Constanța");
        items.add("Covasna");
        items.add("Dâmbovița");
        items.add("Dolj");
        items.add("Galați");
        items.add("Giurgiu");
        items.add("Gorj");
        items.add("Harghita");
        items.add("Hunedoara");
        items.add("Ialomița");
        items.add("Iași");
        items.add("Ilfov");
        items.add("Maramureș");
        items.add("Mehedinți");
        items.add("Mureș");
        items.add("Neamț");
        items.add("Olt");
        items.add("Prahova");
        items.add("Satu Mare");
        items.add("Sălaj");
        items.add("Sibiu");
        items.add("Suceava");
        items.add("Teleorman");
        items.add("Timiș");
        items.add("Tulcea");
        items.add("Vaslui");
        items.add("Vâlcea");

        return items;
    }


    public void resetFields1()
    {
        this.strada.setValue("");
        this.oras.setValue("");
        this.comboBox.setValue("");
    }

    public void resetFields2()
    {
        this.parola.setValue("");
        this.repetaParola.setValue("");
    }

}
