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



@Route("ImiExpiraCardul")
@PageTitle("ImiExpiraCardul")

public class ImiExpiraCardul extends VerticalLayout {
    public ImiExpiraCardul(){
        Image img = new Image("images/icon.png","...");
        Paragraph text1 = new Paragraph("Vezi ce opțiuni ai pentru a-l primi.");

        Button cardFizic = new Button("SOLICIT CARD FIZIC");
        cardFizic.addClickListener(e -> {
            UI.getCurrent().navigate("cardFizic");
        });

        Button cardDigital = new Button("SOLICIT CARD DIGITAL");
        cardDigital.addClickListener(e -> {
            UI.getCurrent().navigate("Digital");
        });


        H2 text = new H2("Ți-a expirat cardul sau urmează să îți expire în luna în curs?");
        H2 text2 = new H2("Pași solicitare card digital");
        Paragraph text3 = new Paragraph("Cardul tău nou emis va fi pregătit în forma lui digitală în aplicația D&A,Ce Trebuie sa faci?");

        add(img);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(text);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(text1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        HorizontalLayout h1 = new HorizontalLayout(cardDigital,cardFizic);
        add(h1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);



    }
}
