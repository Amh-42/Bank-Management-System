/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Summary;
import java.util.Scanner;
/**
 *
 * @author Habte
 */
public class Summary {
    public static void main(String[] args) {
            int c_accounts = 0;
            int acc_index = 0;
            CAccount caccounts[] = new CAccount[100];
            Account accounts[] = new Account[100];
            String menu = "\n\n-----------Welcome To Bank-----------\n"
                    + "1. Create new account\n"
                    + "2. Withdraw From An Accoount\n"
                    + "3. Deposit To an Account\n"
                    + "4. Transfer from an Account\n"
                    + "5. Display Account Information\n"
                    + "6. Exit\n";
            int choice,ID,choi,ch,ch1,ch2,choosen;
            String Name;
            double balance,withdraw_amount,deposit_amount,transfer_amount;
            Scanner scanner = new Scanner(System.in);
            boolean active = true,x;
            while (active){
                System.out.println(menu);
            choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter USER ID>> ");
                    ID = scanner.nextInt();
                    System.out.println("Enter USER Name>> ");
                    Name = scanner.next();
                    System.out.println("Enter USER Initial Balance>> ");
                    balance = scanner.nextDouble();
                    System.out.println("\n\nChoose Account Type>>\n\n"
                            + "1. Saving Account\n"
                            + "2. Checking Account\n");
                    ch = scanner.nextInt();
                switch (ch) {
                    case 1:
                        Account a = new Account(ID,Name,balance);
                        accounts[acc_index] = a;
                        acc_index++;
                        break;
                    case 2:
                        CAccount ca = new CAccount(ID,Name,balance);
                        System.out.println("Set Overdraft limit>> ");
                        double oda = scanner.nextDouble();
                        ca.setOverdraft(oda);
                        ca.setOverdrawn(0);
                        caccounts[c_accounts] = ca;
                        c_accounts++;
                        break;
                    default:
                        System.out.println("Wrong Choice");
                        break;
                }
                    
                    break;

                
                case 2:
                    System.out.println("Choose Account Type\n"
                            + "1. Saving Account\n"
                            + "2. Checking Account\n");
                    choi=scanner.nextInt();
                    switch (choi) {
                        case 1:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<acc_index;i++) {
                                System.out.println(String.valueOf(i)+". "+accounts[i]);
                            }
                            ch = scanner.nextInt();
                            System.out.println("Enter the Amount you want to withdraw>>");
                            withdraw_amount = scanner.nextDouble();
                            x = accounts[ch].withdraw(withdraw_amount);
                            if (x){
                                System.out.println("Successfully Withdrawn");
                            }else{
                                System.out.println("Balance Insufficient??");
                            }
                            break;
                        case 2:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<c_accounts;i++) {
                                System.out.println(String.valueOf(i)+". "+caccounts[i]);
                            }
                            ch = scanner.nextInt();
                            System.out.println("Enter the Amount you want to withdraw>>");
                            withdraw_amount = scanner.nextDouble();
                            x = caccounts[ch].withdraw(withdraw_amount);
                            if (x){
                                System.out.println("Successfully Withdrawn");
                            }else{
                                System.out.println("Balance Insufficient??");
                            }
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    break;
                
                case 3:
                    System.out.println("Choose Account Type\n"
                            + "1. Saving Account\n"
                            + "2. Checking Account\n");
                    choi=scanner.nextInt();
                    switch (choi) {
                        case 1:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<acc_index;i++) {
                                System.out.println(String.valueOf(i)+". "+accounts[i]);
                            }
                            ch = scanner.nextInt();
                            System.out.println("Enter the Amount you want to deposit>>");
                            deposit_amount = scanner.nextDouble();
                            accounts[ch].deposit(deposit_amount);
                            break;
                        case 2:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<c_accounts;i++) {
                                System.out.println(String.valueOf(i)+". "+caccounts[i]);
                            }
                            ch = scanner.nextInt();
                            System.out.println("Enter the Amount you want to deposit>>");
                            deposit_amount = scanner.nextDouble();
                            caccounts[ch].deposit(deposit_amount);
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    break;
                
                case 4:
                    System.out.println("Choose Account Type\n"
                            + "1. Saving Account\n"
                            + "2. Checking Account\n");
                    choi=scanner.nextInt();
                    switch (choi) {
                        case 1:
                            System.out.println("Choose an Account to transfer from>> ");
                            for (int i = 0 ; i<acc_index;i++) {
                                System.out.println(String.valueOf(i)+". "+accounts[i]);
                            }
                            ch1 = scanner.nextInt();
                            choosen = ch1;
                            System.out.println("Choose an Account to transfer to>> ");
                            for (int i = 0 ; i<acc_index;i++) {
                                if (i==choosen){
                                    continue;
                                }
                                System.out.println(String.valueOf(i)+". "+accounts[i]);
                            }
                            ch2 = scanner.nextInt();
                            System.out.println("Enter the Amount you want to transfer>>");
                            transfer_amount = scanner.nextDouble();
                            x = accounts[ch1].transfer(transfer_amount,accounts[ch2]);
                            if (x){
                                System.out.println("Successfully Transfered");
                            }else{
                                System.out.println("Insufficcient Amount !!");
                            }
                            break;
                        case 2:
                            System.out.println("Choose an Account to transfer from>> ");
                            for (int i = 0 ; i<c_accounts;i++) {
                                System.out.println(String.valueOf(i)+". "+caccounts[i]);
                            }
                            ch1 = scanner.nextInt();
                            choosen = ch1;
                            System.out.println("Choose an Account to transfer to>> ");
                            for (int i = 0 ; i<c_accounts;i++) {
                                if (i==choosen){
                                    continue;
                                }
                                System.out.println(String.valueOf(i)+". "+caccounts[i]);
                            }
                            ch2 = scanner.nextInt();
                            System.out.println("Enter the Amount you want to transfer>>");
                            transfer_amount = scanner.nextDouble();
                            x = caccounts[ch1].transfer(transfer_amount,caccounts[ch2]);
                            if (x){
                                System.out.println("Successfully Transfered");
                            }else{
                                System.out.println("Insufficcient Amount !!");
                            }
                    }
                            break;
                case 5:
                    System.out.println("Choose Account Type\n"
                            + "1. Saving Account\n"
                            + "2. Checking Account\n");
                    choi = scanner.nextInt();
                    switch (choi) {
                        case 1:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<acc_index;i++) {
                                System.out.println(String.valueOf(i)+". "+accounts[i]);
                            }
                            ch = scanner.nextInt();
                            accounts[ch].display();
                            break;
                        case 2:
                            System.out.println("Choose an Account\n");
                            for (int i = 0 ; i<c_accounts;i++) {
                                System.out.println(String.valueOf(i)+". "+caccounts[i]);
                            }
                            ch = scanner.nextInt();
                            caccounts[ch].display();
                            break;
                        default:
                            System.out.println("Wrong Choice");
                            break;
                    }
                    
                    break;

                case 6:
                    active = false;
                    break;
                
            }
            }
            
    }
}

