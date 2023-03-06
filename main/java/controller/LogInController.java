package controller;

import database.DaoClient;
import model.Client;

import java.util.List;

public class LogInController {
     private String firstName;
     private String passWord;
     private DaoClient daoClient;

    public LogInController(String firstName, String passWord) {
        this.firstName = firstName;
        this.passWord = passWord;
        daoClient=new DaoClient();
    }

    public boolean validate(){
        List<Client> clientsList=daoClient.getAllClients(); // lista de clienti
        Client clientCheck=new Client(0,"",this.firstName,"",this.passWord);
        if(clientsList.contains(clientCheck)) {
            CurrentUser.set(this.firstName); //setez user-ul curent
            return true;
        }
        return false;
    }


}
