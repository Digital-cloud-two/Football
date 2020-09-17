package com.football;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class StartFootballElection {

    void startE(){
        UserPart userPart = new UserPart();
        userPart.begin();
    }

    Connection connection;

    ConnectionFreeDB sFE;

//    private void openDB() {
//        sFE = new ConnectionFreeDB();
//        connection = sFE.enterFreeDB();
////        preparedStatement = connection.prepareStatement();
//    }
//
//    private void closeDB() {
//        sFE.exitFreeDB(connection);
//    }


}
