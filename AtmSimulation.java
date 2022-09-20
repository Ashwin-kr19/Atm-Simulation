/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm.simulation;

import java.util.Scanner;

/**
 *
 * @author Aditya
 */
public class AtmSimulation {

    /**
     * @param args the command line arguments
     */
    
    static Scanner in = new Scanner(System.in);
    
    //function to display available options to the user
    public static int menu(){
              
        int option = 0;
        
        System.out.print("\n\n\n\t\t\t|-----------------------|\n");
        System.out.print("\t\t\t|\t   ATM\t\t|");
        System.out.print("\n\t\t\t|-----------------------|\n");
        System.out.print("\n\t\t\t|   1. Deposit Amount\t| ");
        System.out.print("\n\t\t\t|   2. Withdraw Amount\t| ");
        System.out.print("\n\t\t\t|   3. Check Balance\t| ");
        System.out.print("\n\t\t\t|   4. Transfer Amount\t| ");
        System.out.print("\n\t\t\t|   5. Exit\t\t|\n");
        System.out.print("\n\t\t\t|-----------------------|\n");
        
        System.out.print("\n\n\t\tEnter an Option: "); //prompts user to enter an option
        option = in.nextInt();
        
        return option;
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        //instantiating the class-objects
        account accobj = new account();
        checking checkobj = new checking();
        savings savobj = new savings();

        //calls the login function to authorise user
        accobj.login();

        String accname = accobj.getaccountname();

        System.out.print("\n\n\t\t\t  Welcome "+accname+"!\t");

        boolean done = true; //to break the do-while loop
        int acc_choice = -1;

        do{            
            switch(menu()){

                //Deposit
                case 1:

                    System.out.println("\n\n\t\tWhich Account Would You Like to Deposit To");
                    System.out.println("\n\t\t\t1. Checking");
                    System.out.println("\n\t\t\t2. Savings");
                    
                    System.out.print("\n\t\tEnter an Option: ");
                    acc_choice = in.nextInt();

                    switch(acc_choice){

                        case 1:
                            //deposit to checking account
                            checkobj.setdeposit();
                            break;

                        case 2:
                            //deposit to savings account
                            savobj.setdeposit();
                            break;

                        default:
                            System.out.println("\n\t\tInvalid Option! Enter a Valid one.");
                            break;
                    }

                    break;

                //Withdraw
                case 2:

                    System.out.println("\n\n\tWhich Account Would You Like to Withdraw From");
                    System.out.println("\n\t\t\t 1.Checking");
                    System.out.println("\n\t\t\t 2.Savings");

                    System.out.print("\n\t\tEnter an Option: ");
                    acc_choice = in.nextInt();

                    switch(acc_choice){

                        case 1:
                            //withdraw from checking account
                            checkobj.setwithdraw();
                            break;

                        case 2:
                            //withdraw from savings account
                            savobj.setwithdraw();
                            break;

                        default:
                            System.out.println("\n\t\tInvalid Option! Enter a Valid one.");
                            break;
                    }

                    break;

                //Check Balance
                case 3:

                    System.out.println("\n\n\t\tWhich Account Would You Like to Check Balance For");
                    System.out.println("\n\t\t\t 1.Checking");
                    System.out.println("\n\t\t\t 2.Savings");

                    System.out.print("\n\t\tEnter an Option: ");
                    acc_choice = in.nextInt();

                    switch(acc_choice){

                        //display checking account balance
                        case 1:
                            System.out.println("\n\t\tYour Current Checkings Account Balance is Rs."+checkobj.getbalance());
                            break;

                        //display savings account balance
                        case 2:
                            System.out.println("\n\t\tYour Current Savings Account Balance is Rs."+savobj.getsavingsbalance());
                            break;

                        default:
                            System.out.println("\n\t\tInvalid Option! Enter a Valid one.");
                            break;
                    }

                    break;

                //Transfer
                case 4:
                    
                    System.out.println("\n\n\t\tWhich Account Would You Like to Transfer to");
                    System.out.println("\n\t\t\t 1.Checking to Savings");
                    System.out.println("\n\t\t\t 2.Savings to Checking");

                    System.out.print("\n\t\tEnter an Option: ");
                    acc_choice = in.nextInt();
                    
                    switch(acc_choice){
                        
                        
                        //transfer from checking to savings account
                        case 1:
                            
                            double deposit_to_sav = checkobj.gettransfer();
                            savobj.setsavingsbalance(deposit_to_sav);
                            break;
                            
                        //transfer from savings to checking account
                        case 2:
                            
                            double deposit_to_check = savobj.gettransfer();
                            checkobj.setbalance(deposit_to_check);
                            break;
                            
                        default:
                            System.out.println("\n\t\tInvalid Option! Enter a Valid one.");
                            break;
                    }
                    
                    break;
                    
                //Exit
                case 5:
                    
                    System.out.println("\n\n\t\t\tThanks For Using Our Service!\n\t\t\t     Have a Great Day!\n\n");
                    done = false;
                    break;
                    
                //Invalid Input
                default:
                    
                    System.out.println("\n\n\t\tInvalid Option! Enter a Valid One.");
                    break;
               
            }
        }while(done);       
              
        
    }
    
}
