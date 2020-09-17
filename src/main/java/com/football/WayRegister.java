package com.football;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class WayRegister implements Way {

    @Override
    public boolean startWay() {
        System.out.println("WayRegister");
        getEmailsDB();
        if (checkUserEmailRegistered()) {
            return true; // Duplicate
        }
        //registerUserFinal(enterUserFirstName(), enterUserLastName(),stringUserEmail, enterUserPassword());
        Election election = new Election(stringUserEmail);
        election.startElection();
        return false; //Exit
    }

    private ArrayList<String> arrayListEmailsDB = new ArrayList<String>();

    private void getEmailsDB() {
        ConnectionFreeDB connectionFreeDB = new ConnectionFreeDB();

        String query = "select e_mail from sql7363392.users";

        Statement statement = null;
        try {
            statement = connectionFreeDB.openFreeDB().createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next())
                arrayListEmailsDB.add(resultSet.getString("e_mail"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
                System.out.println("Close");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private String stringUserEmail;
    private Scanner scannerUser;

    private boolean checkUserEmailRegistered() {
        Iterator iterator = arrayListEmailsDB.iterator();

        System.out.println("Register For This Application \n" +
                "Enter email:");

        scannerUser = new Scanner(System.in);
        stringUserEmail = scannerUser.next();

        while (iterator.hasNext()) {
            if (iterator.next().equals(stringUserEmail)) {
                System.out.println("This email is already registered !!!");
                arrayListEmailsDB.clear();
                return true; // Duplicate
            }
        }
        return false;
    }

    private String enterUserFirstName() {
        System.out.println("Enter first name:");
        String userFirstName = scannerUser.next();
        return userFirstName;
    }

    private String enterUserLastName() {
        System.out.println("Enter last name:");
        String userLastName = scannerUser.next();
        return userLastName;
    }

    private String enterUserPassword() {
        System.out.println("Enter password:");
        String userPassword = scannerUser.next();
        return userPassword;
    }

//    private final String INSERT_USER = "INSERT INTO sql7363392.users VALUES (?,?,?,?,?,?)";

    private void registerUserFinal(String firstName, String lastName, String email, String password) {
        final String INSERT_USER = "INSERT INTO sql7363392.users VALUES (?,?,?,?,?,?)";

        ConnectionFreeDB connectionFreeDB = new ConnectionFreeDB();
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connectionFreeDB.openFreeDB().prepareStatement(INSERT_USER);

            preparedStatement.setString(1, null);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, email);
            preparedStatement.setString(5, password);
            preparedStatement.setInt(6, 0);

            preparedStatement.execute();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
                System.out.println("connection (preparedStatement) is closed");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}