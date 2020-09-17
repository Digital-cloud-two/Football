package com.football;

import java.util.Scanner;

public class UserPart {

    void begin() {
        showOpenText();
        while (true) {
            ActionUser actionUser = userMakeDecision();
            Way way;
            if ((way = decisionUserRLE(actionUser)) == null) {
                return;
            }
            if (way.startWay()) {
                continue;
            }else {
                break;
            }
        }
    }

//    private void start() {
//        showOpenText();
//        while (true) {
//            ActionUser userDecision = userMakeDecision();
//            Way way;
//            if ((way = decisionUserRLE(userDecision)) != null) {
//                if (way.startWay()) {
//                    System.out.println("Try again");
//                } else {
//                    return;
//                }
//            } else {
//                return; // The End
//            }
//        }
//    }

    private void showOpenText() {
        System.out.println(" *** THIS SOFTWARE APPLICATION TRY TO ANSWER WHO IS BETTER M10 or CR7 ***");
    }

    private ActionUser userMakeDecision() {
        while (true) {
            System.out.println("Choose the number of option:\n" +
                    "                           1. Register\n" +
                    "                           2. Login\n" +
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
                    return action = ActionUser.REGISTER;
                case 2:
                    return action = ActionUser.LOGIN;
                case 0:
                    return action = ActionUser.EXIT;
                default:
                    System.out.println("Error unknown" +
                            "\n it is impossible!" +
                            "\n Method: userMakeDecision ");
                    continue;
            }
        }
    }

    private Way decisionUserRLE(ActionUser userDecision) {
        Way way = null;

        switch (userDecision) {
            case REGISTER:
                way = new WayRegister();
                break;
            case LOGIN:
                way = new WayLogin();
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
        return way;
    }
}
