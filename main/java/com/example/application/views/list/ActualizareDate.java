package com.example.application.views.list;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("ActualizareDate")
@Route(value = "ActualizareDate")

public class ActualizareDate extends VerticalLayout{
    Button incepeAici;
    public ActualizareDate(){
        Image img1= new Image("images/semnul.jpg","...");
        Image img2= new Image("images/unitate.png","...");
        Image img3= new Image("images/unu.png","...");
        Image img4= new Image("images/doi.png","...");
        Image img5= new Image("images/trei.png","...");
        H1 text1 = new H1("Actualizarea datelor");
        H1 text2 = new H1("De ce trebuie să îmi actualizez datele?");
        H4 text3 = new H4("Este o măsură de precauție privind tranzacțiile tale prin D&A.");
        H4 text4 = new H4("Eviți ca informații confidențiale legate de contul tău să ajungă la alte persoane.");
        H4 text5 = new H4("Putem să te protejăm mai bine, atunci când depistăm tranzacții suspecte în cont.");
        H1 text6 = new H1("Actualizezi datele online");
        H4 text7 = new H4("Chiar aici pe site-ul nostru");
        H4 text8 = new H4("Vino in orice unitate D&A");
        Paragraph text9 = new Paragraph("Te asteptam pe strada Baritiu nr26-28 Cluj-Napoca");
        Paragraph t1 = new Paragraph("E atât de ușor să actualizezi datele online și offline.");
        Paragraph t2 = new Paragraph("În aproximativ 15 minute, ai datele actualizate.");
        incepeAici = new Button("Incepe aici");
        incepeAici.addClickListener(e -> {
            UI.getCurrent().navigate("ActualizareOnline");
        });
        img1.setWidth("200px");
        img1.setHeight("200px");
        img2.setWidth("100px");
        img2.setHeight("100px");
        img3.setWidth("30px");
        img3.setHeight("30px");
        img4.setWidth("30px");
        img4.setHeight("30px");
        img5.setWidth("30px");
        img5.setHeight("30px");

        VerticalLayout texte = new VerticalLayout(text1,t1);
        HorizontalLayout img = new HorizontalLayout(img1,img3,text3,img4,text4,img5,text5);
        add(texte,text2,img);
        texte.setHorizontalComponentAlignment(Alignment.CENTER);
        texte.setDefaultHorizontalComponentAlignment(Alignment.CENTER);


        add(text6,t2,text7,incepeAici,text8,text9);
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);


    }
}
