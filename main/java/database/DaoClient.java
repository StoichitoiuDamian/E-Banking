package database;

import model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DaoClient {

    public DaoClient(){};

    protected static final Logger LOGGER = Logger.getLogger(DaoClient.class.getName());
    private static final String insertStatementString = "INSERT INTO client (firstName,lastName,phoneNum,password)"
            + " VALUES (?,?,?,?)";
    private static final String deleteStatementString = "DELETE FROM client WHERE idclient=";
    private static final String updateStatementString = "UPDATE client SET ";
    private static final String insert2StatementString = "INSERT INTO client (id,firstName,lastName,phoneNum,password)"
            + " VALUES (";



    public  int addClient(Client cl) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            //  insertStatement.setString(1, cl.getId());
            insertStatement.setString(1, cl.getFirstName());
            insertStatement.setString(2, cl.getLastName());

            insertStatement.setString(3, cl.getPhoneNumber());
            insertStatement.setString(4, cl.getPassword());

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }



    public  void deleteClient(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString+id);

            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }


    public  void updateClient(String settings,int id) {

        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;

        try {

            updateStatement = dbConnection.prepareStatement(updateStatementString+settings+" WHERE idclient= "+id);

            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }





    public  ArrayList<Client> getAllClients() {
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM client");
            ResultSet result = printStatement.executeQuery();
            ArrayList<Client> allClients = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                String lastName = result.getString(2);
                String firstName = result.getString(3);
                String phone = result.getString(4);
                String password = result.getString(5);

                allClients.add(new Client(id,firstName,lastName,  phone,password));
            }
            return allClients;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    public  Client getClientByName(String clientName) {
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM client");
            ResultSet result = printStatement.executeQuery();
            ArrayList<Client> allClients = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                String lastName = result.getString(2);
                String firstName = result.getString(3);
                String phone = result.getString(4);
                String password = result.getString(5);

                allClients.add(new Client(id,firstName,lastName,  phone,password));
            }
            for (Client cl : allClients){
                if(Objects.equals(cl.getFirstName(), clientName))
                    return cl;
            }
           return null;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }


    public String getLastName(String clientName){
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM client");
            ResultSet result = printStatement.executeQuery();
            ArrayList<Client> allClients = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                String lastName = result.getString(2);
                String firstName = result.getString(3);
                String phone = result.getString(4);
                String password = result.getString(5);

                allClients.add(new Client(id,firstName,lastName,  phone,password));
            }
            for (Client cl : allClients){
                if(Objects.equals(cl.getFirstName(), clientName))
                    return cl.getLastName();
            }
            return null;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    public String getPhoneNum(String clientName){
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM client");
            ResultSet result = printStatement.executeQuery();
            ArrayList<Client> allClients = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                String lastName = result.getString(2);
                String firstName = result.getString(3);
                String phone = result.getString(4);
                String password = result.getString(5);

                allClients.add(new Client(id,firstName,lastName,  phone,password));
            }
            for (Client cl : allClients){
                if(Objects.equals(cl.getFirstName(), clientName))
                    return cl.getPhoneNumber();
            }
            return null;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

}

