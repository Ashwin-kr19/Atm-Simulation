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

//parent class
class account {
    
    static Scanner in = new Scanner(System.in);
    private String name;
    public double current_balance = 0;
    public double savings_balance = 0;
    private int loginnumber;
    
       
    public void setaccountname(String n){
        name = n;
    }
    
    public String getaccountname(){
        return name;
    }
    
    public boolean login(){

        users.loadAccounts(); //load user credentials from users class
        
        int givennum = -1;
        int givenpin = -1;
        
        boolean isaccinvalid = true;
        boolean ispininvalid = true;
        
        int count = 0;
        
        //to authorise user 
        System.out.println("\n\t\t***\t  Login Credentials\t ***");
        
        while(isaccinvalid){
            System.out.print("\n\t\t|----------------------------------|\n");
            System.out.print("\n\t\t  Enter Your Account Number: ");
            givennum = in.nextInt();
            
            if(users.isValidAccount(givennum)){
                isaccinvalid = false;
                this.loginnumber = givennum;
            }
            else{
                System.out.println("\n\t\t\tInvalid Account Number!");
            }
        }
        
        while(ispininvalid){
            
            System.out.print("\n\t\t  Enter Your PIN: ");
            givenpin = in.nextInt();
            System.out.print("\n\t\t|----------------------------------|\n");
            
            String username = users.getAccount(loginnumber, givenpin);

            if(username != null){
                ispininvalid = false;
                setaccountname(username);
            }
            
            //account gets blocked after more than 3 invalid attempts
            else{
                System.out.println("\n\t\t\tInvalid PIN!");
                ++count;   
                
                if (count == 2) {
                    System.out.println("\n\tYou Have Only One Chance left to Enter the Correct PIN!\n");
                }

                if (count > 2) {
                    System.out.println("\n\tYou Have Entered the Wrong Pin More than 3 Times!\n\n\t    Hence Your Account Has been Blocked.\n\n");
                    System.exit(0);
                }
            }
            
            
        }
        
        return true;
    }
    
    
}
