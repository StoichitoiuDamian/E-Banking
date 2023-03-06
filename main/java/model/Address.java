package model;

public class Address {
    private int idAdresa;
    private int idClient;
    private String strada;
    private String oras;
    private String judet;

    public Address(int idAdresa, int idClient, String strada, String oras, String judet) {
        this.idAdresa = idAdresa;
        this.idClient = idClient;
        this.strada = strada;
        this.oras = oras;
        this.judet = judet;
    }

    public void setIdAdresa(int idAdresa) {
        this.idAdresa = idAdresa;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public int getIdAdresa() {
        return idAdresa;
    }

    public int getIdClient() {
        return idClient;
    }

    public String getStrada() {
        return strada;
    }

    public String getOras() {
        return oras;
    }

    public String getJudet() {
        return judet;
    }

    public String toString(){
        return "client"+this.idClient+" la adresa "+this.strada;
    }

}
