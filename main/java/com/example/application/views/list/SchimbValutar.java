package com.example.application.views.list;

import controller.SchimbValutarBack;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@PageTitle("SchimbValutar")
@Route(value = "SchimbValutar")


public class SchimbValutar extends HorizontalLayout{

    VerticalLayout h1;
    VerticalLayout h2;

    TextField monedaSchimb1;
    TextField monedaSchimb2;
    ComboBox<String> comboBox;
    ComboBox<String> comboBox2;
    SchimbValutarBack svb;

    Button buttonConvert;
    List items;

    public SchimbValutar(){

        items=generateMoneyList();
        buttonConvert = new Button("Click");

        monedaSchimb1 = new TextField("Introduceti valoarea");

        monedaSchimb2 = new TextField("Valoarea convertita");
        monedaSchimb2.setAllowedCharPattern("[]");

        Image img = new Image("images/banca.jpg","...");
        img.setWidth("1400px");
        img.setHeight("1000px");


        comboBox = new ComboBox<>("Schimba din");
        comboBox.setItems(items);
        comboBox.setAllowedCharPattern("[]");


        comboBox2 = new ComboBox<>("In");
        comboBox2.setItems(items);
        comboBox2.setAllowedCharPattern("[]");




        buttonConvert.addClickListener(e -> {
            float suma;
            try {
                suma = Integer.parseInt(monedaSchimb1.getValue());
                svb=new SchimbValutarBack(comboBox.getValue(),suma,comboBox2.getValue());
                monedaSchimb2.setValue(svb.returnValue());

            } catch (NumberFormatException num) {
                Notification.show("INTRODUCETI UN NUMAR VALID !");
            }
        });



        h1 = new VerticalLayout(comboBox,comboBox2,monedaSchimb1,monedaSchimb2,buttonConvert);
        add(h1);
        setSizeFull();
        h1.setHorizontalComponentAlignment(Alignment.CENTER);
        h1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        h2 = new VerticalLayout(img);
        add(h2);
        setSizeFull();
        h2.setHorizontalComponentAlignment(Alignment.START);
        h2.setDefaultHorizontalComponentAlignment(Alignment.START);



    }
    public List generateMoneyList(){
        ArrayList<String> items=new ArrayList<>();
        items.add("USD");
        items.add("EUR");
        items.add("GBP");
        items.add("CHF");
        items.add("SEK");
        items.add("CAD");
        items.add("MDL");
        items.add("HUF");
        items.add("CZK");
        items.add("PLN");
        items.add("RON");

        return items;
    }
}
