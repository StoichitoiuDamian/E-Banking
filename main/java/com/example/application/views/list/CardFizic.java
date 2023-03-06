package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;



@Route("cardFizic")
@PageTitle("cardFizic")

public class CardFizic extends VerticalLayout{


    public CardFizic(){
        Image img = new Image("images/icon.png","...");
        Paragraph text1 = new Paragraph("Vezi ce opțiuni ai pentru a-l primi.");
        TextField firstName = new TextField("Nume");
        TextField lastName = new TextField("Prenume");
        TextField nrTelefon = new TextField("Numar Telefon");
        TextField ultimelePatruCifre=new TextField("Ultimele patru cifre din CNP");
        Button cardFizic = new Button("SOLICIT CARD FIZIC");
        Button cardDigital = new Button("SOLICIT CARD DIGITAL");
        cardDigital.addClickListener(e -> {
            UI.getCurrent().navigate("Digital");
        });

        H2 text = new H2("Ți-a expirat cardul sau urmează să îți expire în luna în curs?");
        H2 text2 = new H2("Daca intampinati probleme nu evitati sa solicitati ajutorul unui expert la numarul +40 372 229 933");
        Button trimite = new Button("Solicita");
        trimite.addClickListener(click-> Notification.show("Solicitarea dumneavoastra a fost plasata,va multumim"));
        trimite.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);

        add(img,text,text1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        HorizontalLayout h1 = new HorizontalLayout(cardDigital,cardFizic);
        add(h1);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        HorizontalLayout h2 = new HorizontalLayout(firstName,lastName);
        add(h2);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        HorizontalLayout h3 = new HorizontalLayout(nrTelefon,ultimelePatruCifre);
        add(h3);
        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(trimite,text2);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);


    }
}
