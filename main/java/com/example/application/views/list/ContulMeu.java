package com.example.application.views.list;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;


import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import database.DaoAddress;
import database.DaoClient;
import database.DataProvider;
import model.Client;

import java.util.List;


@PageTitle("list")
@Route(value = "contulMeu")

public class ContulMeu extends HorizontalLayout {

    VerticalLayout h1;
    Button goBack;
    Label phoneLabel;
    Label streetLabel;
    Label cityLabel;
    Label countyLabel;

    private List<String> location; // [strada,oras,judet]
    private DataProvider dataProvider;
    private String userName;
    private String lastName;

    public ContulMeu(){

        this.dataProvider = new DataProvider();
        this.userName=this.dataProvider.getFirstName();
        this.lastName=(new DaoClient()).getLastName(this.userName);
        this.location=new DaoAddress().getInfos(this.getClientId(this.userName));

        this.goBack = new Button("Inapoi");

        this.phoneLabel=new Label("Numar: "+(new DaoClient()).getPhoneNum(this.userName));
        this.streetLabel=new Label("Strada: "+location.get(0));
        this.cityLabel=new Label("Oras: "+location.get(1));
        this.countyLabel=new Label("Judet: "+location.get(2));

        Image img = new Image("images/save.jpg", "placeholder plant");
        img.setWidth("1600px");
        img.setHeight("950px");

        this.h1 = new VerticalLayout(new H1(userName+" "+lastName),phoneLabel,streetLabel,cityLabel,countyLabel,goBack);
        this.h1.setDefaultHorizontalComponentAlignment(FlexComponent.Alignment.CENTER);
        add(this.h1,img);


        goBack.addClickListener(e->{
            UI.getCurrent().navigate("clienti");
        });

    }

    public int getClientId(String firstName) {
        DaoClient daoClient = new DaoClient();
        Client client = daoClient.getClientByName(firstName);
        return client.getId();
    }

}
