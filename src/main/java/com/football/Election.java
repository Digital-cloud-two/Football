package com.football;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Election {

    private String userEmail;

    Election(String userEmail) {
        this.userEmail = userEmail;
    }

    void startElection() {
        showWelcomeIn();
        decisionUserMenu(userMenuMakeDecision());
        decisionMessiCristiano(decideWhoIsBetter());
    }

    private void showWelcomeIn() {
        System.out.println("!!!!!!!!!!!!!Welcome registration is successful!!!!!!!!!!!!!!");
    }

    private ActionUser userMenuMakeDecision() {
        while (true) {
            System.out.println("(Choose the number) Menu:\n" +
                    "                           1. Vote\n" +
                    "                           2. Rating\n" +
                    "                           0. Exit");
            Scanner scannerUserDecision = new Scanner(System.in);
            int userDecision;
            try {
                userDecision = scannerUserDecision.nextInt();
            } catch (Exception e) {
                System.out.println("Choose is wrong! Try again!!!");
                continue;
            }

            if (userDecision < 0 || userDecision > 2) {
                System.out.println("The number of chose is wrong >>>  " + userDecision +
                        "\n           Try again!!!");
                continue;
            }
            ActionUser action;
            switch (userDecision) {
                case 1:
                    return action = ActionUser.VOTE;
                case 2:
                    return action = ActionUser.RATING;
                case 0:
                    return action = ActionUser.EXIT;
                default:
                    System.out.println("Error unknown" +
                            "\n it is impossible!" +
                            "\n Method: userMenuMakeDecision ");
                    continue;
            }
        }
    }

    private void decisionUserMenu(ActionUser userDecision) {

        switch (userDecision) {
            case VOTE:
                System.out.println("VOTE");
                checkVote();
                //method
                break;
            case RATING:
                System.out.println("RATING");
                //method
                break;
            case EXIT:
                System.out.println("The End");
                break;
            default:
                System.out.println("Error unknown" +
                        "\n it is impossible!" +
                        "\n Method: decisionUserRLE ");
                break;
        }
        return;
    }

    private void checkVote() {
        String upUserEmail = "'" + userEmail + "'";
        String query = "select footballer from sql7363392.users where e_mail ="+upUserEmail;
        Statement statement = null;
        int numberVote = 69;
        try {
            statement = ConnectionFreeDB.openFreeDB().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                numberVote = resultSet.getInt("footballer");
                System.out.println(numberVote);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(numberVote == 0){

        }

    }

    private ActionUser decideWhoIsBetter() {
        while (true) {
            System.out.println("Vote who is better:     " +
                    "CRISTIANO RONALDO  press the № 7\n" +
                    "                        LIONEL MESSI  press the № 10");

            Scanner scannerUserDecision = new Scanner(System.in);
            int userDecision;
            try {
                userDecision = scannerUserDecision.nextInt();
            } catch (Exception e) {
                System.out.println("Choose number  7 or 10    Try again!!!");
                continue;
            }

            if (userDecision == 7 || userDecision == 10) {
                System.out.println(userDecision);

            } else {
                System.out.println("The number of chose is wrong >>>  " + userDecision +
                        "\n           Try again!!!");
                continue;
            }

            ActionUser action;
            switch (userDecision) {
                case 7:
                    return action = ActionUser.CRISTIANO;
                case 10:
                    return action = ActionUser.MESSI;
                default:
                    System.out.println("Error unknown" +
                            "\n it is impossible!" +
                            "\n Method: userMakeDecision ");
                    continue;
            }
        }
    }

    private void decisionMessiCristiano(ActionUser userDecision) {
        if (userDecision.equals(ActionUser.CRISTIANO) || (userDecision.equals(ActionUser.MESSI))) {
//            addCR7orM10(userDecision);
        } else {
            System.out.println("Error unknown" +
                    "\n it is impossible!" +
                    "\n Method: decisionMessiCristiano ");
        }

    }

    private void addCR7orM10(ActionUser userDesicion) {
        System.out.println("CR7");
        System.out.println(userEmail);
        String upUserEmail = "'" + userEmail + "'";
        System.out.println(upUserEmail);

        ConnectionFreeDB connectionFreeDB = new ConnectionFreeDB();
        final String UPDATE;
        if (userDesicion.equals(ActionUser.CRISTIANO)) {
            UPDATE = "UPDATE `sql7363392`.`users` SET `footballer` = '1' WHERE (`e_mail` =" + upUserEmail + ");";
            System.out.println(UPDATE);
        } else {
            UPDATE = "UPDATE `sql7363392`.`users` SET `footballer` = '2' WHERE (`e_mail` =" + upUserEmail + ");";
            System.out.println(UPDATE);
        }

        Statement statement = null;
        try {
            statement = connectionFreeDB.openFreeDB().createStatement();
            statement.executeUpdate(UPDATE);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
