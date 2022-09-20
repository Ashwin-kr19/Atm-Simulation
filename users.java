/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulation;

/**
 *
 * @author Aditya
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//class to load user details
public class users {
    
    private static int MAX = 10000;
    private static int[] account_nos;
    private static String[] users;
    private static int[] pins;
    private static int fi = 0;

    public static void loadAccounts() {
        File inFile = new File("accounts.csv");
        account_nos = new int[MAX];
        users = new String[MAX];
        pins = new int[MAX];
        try {
            Scanner fReader = new Scanner(inFile);
            while(fReader.hasNext()) {
                String line = fReader.nextLine();
                String[] tokens = line.split(",");
                account_nos[fi] = Integer.valueOf(tokens[0]);
                users[fi] = tokens[1];
                pins[fi++] = Integer.valueOf(tokens[2]);
            }
            fReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidAccount(int account_no) {
        for (int i = 0; i < fi; i++) {
            if (account_nos[i] == account_no) {
                return true;
            }
        }
        return false;
    }

    public static String getAccount(int account_no, int pin) {
        for (int i = 0; i < fi; i++) {
            if ((account_nos[i] == account_no) && (pins[i] == pin)) {
                return users[i];
            }
        }
        return null;
    }
}

