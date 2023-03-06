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
import database.DaoAddress;
import database.DaoClient;
import model.Address;
import model.Client;

@Route("RegisterView")
@PageTitle("RegisterView")


public class RegisterView extends HorizontalLayout{
    TextField firstName;
    TextField lastName;

    PasswordField password;

    PasswordField repeatPassword;

    TextField phoneNumber;
    VerticalLayout h1;
    Button register;

    public RegisterView(){

        firstName = new TextField("First Name");
        firstName.setAllowedCharPattern("[a-z A-Z]");

        lastName = new TextField("Last Name");
        lastName.setAllowedCharPattern("[a-z A-Z]");

        password = new PasswordField("Password");
        repeatPassword = new PasswordField("Repeat Password");

        phoneNumber = new TextField("Phone Number");
        phoneNumber.setAllowedCharPattern("[0-9]");

        register = new Button("Register");

        Image img = new Image("images/save.jpg", "placeholder plant");
        img.setWidth("1600px");
        img.setHeight("950px");
        h1 = new VerticalLayout(new H1("Welcome"), firstName,lastName, password,repeatPassword,phoneNumber,register);

        h1.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(h1,img);



        register.addClickListener(e->{
            String currentFirstName=firstName.getValue();
            String currentLastName=lastName.getValue();
            String currentPassword= password.getValue();
            String currentPassword2= repeatPassword.getValue();
            String currentPhone= phoneNumber.getValue();

            if(currentFirstName.length()==0 || currentLastName.length()==0 || currentPassword.length()==0 ||currentPassword2.length()==0 || currentPhone.length()==0)
                Notification.show("Completati toate campurile!");
            else if(currentPassword.equals(currentPassword2)){

                Client newClient=new Client(1, currentLastName, currentFirstName, currentPhone,currentPassword);
                (new DaoClient()).addClient(newClient);

                int currentId=this.getClientId(currentFirstName);
                Address newAddress=new Address(1,currentId,"","","");
                (new DaoAddress()).addAddress(newAddress);

                firstName.setValue("");
                lastName.setValue("");
                password.setValue("");
                repeatPassword.setValue("");
                phoneNumber.setValue("");
                Notification.show("Cont creeat cu succes!");
                UI.getCurrent().navigate("login");
            }
            else
                Notification.show("Parolele nu corespund!");
        });

    }


    public int getClientId(String firstName) {
        DaoClient daoClient = new DaoClient();
        Client client = daoClient.getClientByName(firstName);
        return client.getId();
    }

}

