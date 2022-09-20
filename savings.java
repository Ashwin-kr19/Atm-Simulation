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
class savings extends account {
    
    static Scanner in = new Scanner(System.in);
    public void setsavingsbalance(double deposit){           
        savings_balance += deposit;
    }
    
    public double getsavingsbalance(){
        return savings_balance;
    }
    
    public void setwithdraw(){
        
        double withdraw = 0;
        
        System.out.print("\n\n\t\tEnter the Amount to Withdraw: Rs.");
        withdraw = in.nextDouble();
        
        if(savings_balance >= withdraw){
            savings_balance -= withdraw;
            System.out.println("\n\t\tYour Updated Savings Account Balance: Rs."+savings_balance);
        }
        
        else{
            System.out.println("\n\t\tNot Enough Minimum Balance! Cannot Withdraw.\n");
        }
            
    }
    
    public void setdeposit(){
        
        double dep = 0;
        
        System.out.print("\n\n\t\tEnter the Amount for Deposit: Rs.");
        dep = in.nextDouble();
        
        savings_balance += dep;
        
        System.out.println("\n\t\tYour Updated Savings Account Balance: Rs."+savings_balance);
    }
    
    public double gettransfer(){
        
        double withdraw = 0;
        
        System.out.print("\n\n\t\tEnter the Transfer Amount: Rs.");
        withdraw = in.nextDouble();
        
        if(savings_balance >= withdraw){
            savings_balance -= withdraw;
            
            System.out.println("\n\t\tYour Updated Savings Account Balance: Rs."+savings_balance);
            
            return withdraw;
        }
        
        else{
            System.out.println("\n\t\tNot Enough Minimum Balance! Cannot Transfer.\n");
            
            return 0.0;
        }
    }
        
    
}
