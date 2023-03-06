package com.example.application.views.list;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;

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


@Route("login")
@PageTitle("login")


public class LoginView extends HorizontalLayout {

    TextField userName;
    PasswordField password;
    Button logIn;
    Button register;
    VerticalLayout h1;

    public LoginView() {

        userName = new TextField("Username");
        password = new PasswordField("Password");
        logIn = new Button("Login");
        register = new Button("Register");

        Image img = new Image("images/save.jpg", "placeholder plant");
        img.setWidth("1600px");
        img.setHeight("950px");
        h1 = new VerticalLayout(new H1("Welcome"), userName, password, logIn, register);

        h1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(h1,img);
        register.addClickListener(e->{
            UI.getCurrent().navigate("RegisterView");
        });
        logIn.addClickListener(e->{
            LogInController logControl = new LogInController(userName.getValue(),password.getValue());
            if(logControl.validate()) {
                UI.getCurrent().navigate("clienti");
                userName.setValue("");
                password.setValue("");
            }
            else {
                Notification.show("userName sau parola incorecte");
                userName.setValue("");
                password.setValue("");
            }
        });

    }

}