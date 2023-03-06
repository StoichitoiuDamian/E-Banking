package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Carduri")
@Route(value = "Carduri")


public class CarduriView extends HorizontalLayout{
    Button b1;
    public CarduriView(){
        b1 = new Button("Comandă acum");
        Image m1 = new Image("images/carduri.png", "...");
        VerticalLayout h1 = new VerticalLayout(m1,b1);
        h1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(h1);

        b1.addClickListener(e -> {
            UI.getCurrent().navigate("comanda");
        });
    }

}
