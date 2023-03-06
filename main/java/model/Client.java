package model;


import java.util.Objects;

public class Client {

    private int id;

    private String lastName;

    private String firstName;

    private String phoneNum;

    private String password;

    public Client(){}

    public Client(int id,String lastName, String firstName, String phoneNum,String password) {
        super();
        this.id=id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.phoneNum = phoneNum;
        this.password=password;

    }


    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId(){return this.id;}

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getPhoneNumber() {
        return  this.phoneNum;
    }

    public String getPassword(){return this.password;}

    public String toString(){
        return this.firstName+"||"+this.password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(this.firstName, client.firstName) && Objects.equals(this.password, client.password);
    }


}
