package com.example.application.views.list;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("D&A")
@Route(value = "")

public class ListView extends VerticalLayout {

    Button expiraCard;
    Button actualizareDate;
    Button nevoiPersonale;
    Button carduri;
    Button logIn;
    Button schimbValutar;

    HorizontalLayout h1;

    public ListView() {

        expiraCard = new Button("Imi expira cardul");
        actualizareDate = new Button("Actualizare Date");
        nevoiPersonale = new Button("Credite de nevoi personale");
        carduri = new Button("Carduri");
        logIn = new Button("Autentificare");
        schimbValutar = new Button("Schimb Valutar");

        h1 = new HorizontalLayout(expiraCard, actualizareDate, nevoiPersonale, carduri, logIn, schimbValutar);
        h1.setDefaultVerticalComponentAlignment(Alignment.START);
        add(h1);

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

        Image img = new Image("images/D&A.jpg", "...");
        img.setWidth("1900px");
        img.setHeight("600px");
        add(img);


        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        getStyle().set("text-align", "center");

        add(new H2("Banca infintata de Alex si Damian"));
        add(new Paragraph("In parteneriat cu UTCN "));
        add(new Paragraph("Serviciu clienti" + "   " + "+40 322 322 966"));
        getStyle().set("text-align", "end");

    }

}
