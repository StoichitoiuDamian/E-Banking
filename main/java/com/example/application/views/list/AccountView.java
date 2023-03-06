package com.example.application.views.list;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import database.DataProvider;

@PageTitle("account")
@Route(value = "account")

public class AccountView extends VerticalLayout{

    public AccountView(){
    H1 h1 = new H1("Hello");

    }
}
