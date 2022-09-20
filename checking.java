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

//inherited from account class
class checking extends account {
    
    static Scanner in = new Scanner(System.in);
    public void setbalance(double deposit){
        current_balance += deposit;
    }
    
    public double getbalance(){
        return current_balance;
    }
    
    public void setwithdraw(){
        
        double withdraw = 0;
        
        System.out.print("\n\n\t\tEnter Amount to Withdraw: Rs.");
        withdraw = in.nextDouble();
        
        if(current_balance >= withdraw){
            
            current_balance -= withdraw;
            
            System.out.println("\n\t\tYour Updated Checkings Account Balance: Rs."+current_balance);
        }
        
        else{
            System.out.println("\n\t\tNot Enough Minimum Balance! Cannot Withdraw.\n");
        }                
                  
    }
    
    public void setdeposit(){
        
        double dep = 0;
        
        System.out.print("\n\n\t\tEnter Deposit Amount: Rs.");
        dep = in.nextDouble();
        
        current_balance += dep;
        
        System.out.println("\n\t\tYour Updated Checkings Account Balance: Rs."+current_balance);
        
    }
    
    public double gettransfer(){
        
        double withdraw = 0;
        
        System.out.print("\n\n\t\tEnter the Transfer Amount: Rs.");
        withdraw = in.nextDouble();
        
        if(current_balance >= withdraw){
            
            current_balance -= withdraw;
            
            System.out.println("\n\t\tYour Updated Checkings Account Balance: Rs."+current_balance);
            
            return withdraw;
        }
        
        else{
            System.out.println("\n\t\tNot Enough Minimum Balance! Cannot Transfer.\n");
            
            return 0.0;
        }
        
    }
    
}
