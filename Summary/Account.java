/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Summary;

/**
 *
 * @author Habte
 */
public class Account{
    public int ID;
    public double balance;
    public String Name;
    public Account(int ID, String Name,double balance){
        this.ID = ID;
        this.Name = Name;
        this.balance = balance;
    }
    public void deposit(double amount){
        
    }
    public boolean withdraw(double amount){
        if (this.balance>=amount){
            this.balance-=amount;
            return true;
        }
        return false;
    }
    public boolean transfer(double amount,Account transfer_to){
        return true;
    }
    public int getID(){
        return this.ID;
    }
    public String getName(){
        return this.Name;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setID(int ID){
        this.ID = ID;
    }
    public void setName(String Name){
        this.Name = Name;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    public void display(){
        System.out.println("Hello "
                + getName()
                + ",\n"
                + "Your current balance is "
                + getBalance()
                + " Birr" );
    }
    @Override
    public String toString(){
        return this.Name;
    }
}
