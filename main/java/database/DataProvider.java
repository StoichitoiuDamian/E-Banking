package database;

import controller.AccessControlFactory;
import model.Client;



public class DataProvider {
    private DaoClient daoClient;
    Client client;

    public DataProvider() {
        String userNameCredential = AccessControlFactory.getInstance().createAccessControl(). getPrincipalName();
        daoClient=new DaoClient();
        client=daoClient.getClientByName(userNameCredential);
    }

   public String getPhoneNum(){
     if(client!=null)
        return client.getPhoneNumber();
     return null;
   }

   public String getFirstName(){
     if(client!=null)
        return client.getFirstName();
     return null;
   }

   public int getClientId(){
        return this.client.getId();
   }

}
