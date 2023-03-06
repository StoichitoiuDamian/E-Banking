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

@Route("Digital")
@PageTitle("cardDigital")


public class CardDigital extends VerticalLayout{

    public CardDigital(){
        Image img = new Image("images/icon.png","...");
        Image unu = new Image("images/unu.png","...");
        Image qr = new Image("images/bancaqr.png","...");
        Image doi = new Image("images/doi.png","...");
        Image aplicatie = new Image("images/aplicatie.png","...");
        Paragraph text1 = new Paragraph("Vezi ce opțiuni ai pentru a-l primi.");
        Paragraph text7 = new Paragraph("Apeși butonul 'Adaugă card', iar un SMS de confirmare va fi trimis automat pe numărul tău de telefon.");
        Paragraph text9 = new Paragraph("Și gata, ai noul card. ");
        Paragraph text5 = new Paragraph("Poti descarca aplicatia de aici");
        Paragraph text3 = new Paragraph("Cardul tău nou emis va fi pregătit în forma lui digitală în aplicația D&A,Ce Trebuie sa faci?");
        H2 text4 = new H2("Intri în aplicația D&A");
        H2 text8 = new H2("Introduci în aplicație codul trimis.");
        H2 text6 = new H2("Urmezi pașii de adăugare card.");
        H2 text = new H2("Ți-a expirat cardul sau urmează să îți expire în luna în curs?");
        H2 text2 = new H2("Pași solicitare card digital");
        Button cardFizic = new Button("SOLICIT CARD FIZIC");
        Button cardDigital = new Button("SOLICIT CARD DIGITAL");
        qr.setWidth("100px");
        qr.setHeight("100px");
        aplicatie.setWidth("250px");
        aplicatie.setHeight("250px");

        cardFizic.addClickListener(e -> {
            UI.getCurrent().navigate("cardFizic");
        });

        add(img,text,text1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        HorizontalLayout h1 = new HorizontalLayout(cardDigital,cardFizic);
        add(h1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(text2,text3,unu,text4,text5,qr,doi,text6,text7,aplicatie,text8,text9);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
    }

}
