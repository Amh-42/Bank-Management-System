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
public class CAccount extends Account{
    public double overdraft_limit;
    public double overdrawn_amount = 0;
    
    public CAccount(int ID, String Name,double balance){
        super(ID,Name,balance);
    }
    public double getOverdraft(){
        return this.overdraft_limit;
    }
    public void setOverdraft(double overdraft_limit){
        this.overdraft_limit = overdraft_limit;
    }
    public double getOverdrawn(){
        return this.overdrawn_amount;
    }
    public void setOverdrawn(double overdrawn_amount){
        this.overdrawn_amount = overdrawn_amount;
    }
    @Override
    public boolean withdraw(double amount) {
        if ((this.overdraft_limit+this.balance)<amount){
            return false;
        }else if(this.balance<amount){
            setOverdrawn(amount-balance);
            setBalance(0);
            
        }else{
            setBalance(balance-amount);
        }
        return true;
    }
    @Override
    public void deposit(double amount) {
        if (this.overdrawn_amount>0){
            if (amount<this.overdrawn_amount){
                setOverdrawn(this.overdrawn_amount-amount);
            }else{
                amount-=this.overdrawn_amount;
                setOverdrawn(0);
                setBalance(amount);
            }
        }else{
            setBalance(balance+amount);
        }
    }
    public boolean transfer(double amount,CAccount transfer_to){
        if ((this.overdraft_limit+this.balance)<amount){
            return false;
        }else if(this.balance<amount){
            setOverdrawn(amount-balance);
            setBalance(0);
            transfer_to.deposit(amount);
            
        }else{
            setBalance(balance-amount);
            transfer_to.deposit(amount);
        }
        return true;
        
    }
    @Override
    public void display(){
        System.out.println("Hello "
                + getName()
                + ",\n"
                + "Your current balance is "
                + getBalance()
                + " Birr\n"
                + "Your overdrawn amount is "+getOverdrawn()+" Birr\n"
                + "Your overdraft limit is "+getOverdraft()+" Birr\n" );
    }
    @Override
    public String toString(){
        return this.Name;
    }
    
}