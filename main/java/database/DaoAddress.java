package database;

import model.Address;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.logging.Level;
import java.util.logging.Logger;
public class DaoAddress {
    public DaoAddress(){};

    protected static final Logger LOGGER = Logger.getLogger(DaoAddress.class.getName());
    private static final String insertStatementString = "INSERT INTO adresa (idclient,strada,oras,judet)"
            + " VALUES (?,?,?,?)";
    private static final String deleteStatementString = "DELETE FROM adresa WHERE idadresa=";
    private static final String updateStatementString = "UPDATE adresa SET ";



    public  int addAddress(Address pr) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);

            insertStatement.setString(1, String.valueOf(pr.getIdClient()));
            insertStatement.setString(2, pr.getStrada());

            insertStatement.setString(3, pr.getOras());
            insertStatement.setString(4, pr.getJudet());


            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoAddress:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }


    public static void deleteAddress(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;

        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString+id);

            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoAddress:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
    }



    public  void updateAddress(String settings,int id) {

        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;

        try {

            updateStatement = dbConnection.prepareStatement(updateStatementString+settings+" WHERE idclient= "+id);

            updateStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoAddress:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }

    }


    public static ArrayList<Address> printAllAddresses() {
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM adresa");
            ResultSet result = printStatement.executeQuery();

            ArrayList<Address> addresses = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                int id2 = result.getInt(2);
                String strada = result.getString(3);
                String oras = result.getString(4);
                String judet = result.getString(5);

                addresses.add(new Address(id,id2,strada,oras, judet));
            }
            return addresses;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoPrint:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

    public ArrayList<String> getInfos(int clId){
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM adresa WHERE idclient="+clId);
            ResultSet result = printStatement.executeQuery();

            ArrayList<String> addresses = new ArrayList<>();

            while (result.next()) {
                int id = result.getInt(1);
                int id2 = result.getInt(2);
                String strada = result.getString(3);
                String oras = result.getString(4);
                String judet = result.getString(5);

               Address newAddress=new Address(id,id2,strada,oras, judet);

               addresses.add(newAddress.getStrada());
               addresses.add(newAddress.getOras());
               addresses.add(newAddress.getJudet());
            }
            return addresses;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoPrint:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }

}

