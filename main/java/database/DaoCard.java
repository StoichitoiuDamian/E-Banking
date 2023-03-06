package database;

import model.Card;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCard {
    public DaoCard(){};

    protected static final Logger LOGGER = Logger.getLogger(DaoClient.class.getName());
    private static final String insertStatementString = "INSERT INTO card (idclient,number,exDate,nume,cvv,val)"
            + " VALUES (?,?,?,?,?,?)";

    private static final String updateStatementStringPlus = "UPDATE card SET val=val+";
    private static final String updateStatementStringMinus = "UPDATE card SET val=val-";



    public  int addCard(Card card) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            //  insertStatement.setString(1, cl.getId());
            insertStatement.setString(1, String.valueOf(card.getIdClient()));
            insertStatement.setString(2, String.valueOf(card.getNumber()));

            insertStatement.setString(3, card.getExpDate());
            insertStatement.setString(4, card.getName());

            insertStatement.setString(5,String.valueOf(card.getCvv()));
            insertStatement.setString(6, String.valueOf(card.getVal()));

            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoCard:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }


    public  void updateCardPlus(String value,String firstName) {

        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;

        try {

            updateStatement = dbConnection.prepareStatement(updateStatementStringPlus+value+" WHERE nume= '"+firstName+"'");

            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }

    public  void updateCardMinus(String value,String firstName) {
        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement updateStatement = null;

        try {
            updateStatement = dbConnection.prepareStatement(updateStatementStringMinus+value+" WHERE nume= '"+firstName+"'");

            updateStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
    }


    public ArrayList<String> getAllCardNames() {
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM card");
            ResultSet result = printStatement.executeQuery();

            ArrayList<String> allCards = new ArrayList<>();

            while (result.next()) {
                int idcard = result.getInt(1);
                int idclient = result.getInt(2);
                int number = result.getInt(3);
                String exDate = result.getString(4);
                String name = result.getString(5);
                int cvv = result.getInt(6);
                int val = result.getInt(7);

                allCards.add(name);
            }
            return allCards;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return null;
    }


    public  int getSoldByName(String clientName) {
        Connection dbConnection = null;
        PreparedStatement printStatement = null;
        try {
            dbConnection = ConnectionFactory.getConnection();
            printStatement = dbConnection.prepareStatement("SELECT * FROM card");
            ResultSet result = printStatement.executeQuery();

            ArrayList<Card> allCards = new ArrayList<>();

            while (result.next()) {
                int idcard = result.getInt(1);
                int idclient = result.getInt(2);
                int number = result.getInt(3);
                String exDate = result.getString(4);
                String name = result.getString(5);
                int cvv = result.getInt(6);
                int val = result.getInt(7);

                allCards.add(new Card(idcard,idclient,exDate,name,val));
            }
            for (Card card : allCards){
                if(Objects.equals(card.getName(), clientName))
                    return card.getVal();
            }
            return -1;

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DaoClient:print " + e.getMessage());
        } finally {
            ConnectionFactory.close(printStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }



}
