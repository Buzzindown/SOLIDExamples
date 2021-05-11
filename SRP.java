package SOLID;
// What's a good way to demonstrate SRP
// What's something that might have multiple purposes
// but should be broken down into each principle
// Let's think of something big like a bank account
// a bank account might have a user, account number, balance, and pin

// a monolithic bankAccount class design
class bankAccount {

    private int uid;
    private int pin;
    private int act;
    private int bal;

    // constructors
    public bankAccount(){
        uid = 0;
        pin = 0;
        act = 0;
        bal = 0;
    }

    public bankAccount(int newUID, int newPin, int newAct, int newBal){
        this.uid = newUID;
        this.pin = newPin;
        this.act = newAct;
        this.bal = newBal;
    }

    // uid methods
    public void setUID(int newUID){
        this.uid = newUID;
    }

    public int getUID(){
        return this.uid;
    }

    // pin methods
    public String changePin(int oldPin, int newPin){
        if(oldPin == this.pin){
            this.pin = newPin;
            return "Changed pin";
        }
        return "Failed to change pin";
    }

    // act methods
    public int getAct(){
        return this.act;
    }

    // bal methods 
    public int getBal(){
        return this.bal;
    }

    public void deposit(int money){
        this.bal += money;
    }

    public void withdraw(int money){
        this.bal -= money;
    }
}

// this class clearly has a lot of responsibilities
// let's see if we can narrow that out
// perhaps we make classes for each of our properties
// uid, which will contain the uid and methods to handle it
// pid which will contain the pid and methods to handle it
// acct whih will contain the act number and methods for it
// finally a bal and the corresponding methods

// I think this is an improvment although this is flawed in the sense
// that betterbankAccount depemds on 4 other classes. This is bad
// for dependency-inversion however we could definitely abstract it out
// nonetheless, I think this is an okay examples of bad SRP vs better SRP

class betterBankAccount{

    public userIdentification UID;
    public personalIdentification PIN;
    public accountNumber ACTN;
    public accountBalance BAL;

    public betterBankAccount(){
        UID = new userIdentification();
        PIN = new personalIdentification();
        ACTN = new accountNumber();
        BAL = new accountBalance();
    }

    public betterBankAccount(int newUID, int newPIN, int newACTN, int newBAL){
        UID = new userIdentification(newUID);
        PIN = new personalIdentification(newPIN);
        ACTN = new accountNumber(newACTN);
        BAL = new accountBalance(newBAL);
    }

}

class userIdentification{

    private int uid;

    public userIdentification(){
        this.uid = 4321;
    }

    public userIdentification(int newUID){
        this.uid = newUID;
    }

    public int getUID(){
        return this.uid;
    }

}

class personalIdentification{

    private int pin;

    public personalIdentification(){
        this.pin = 1234;
    }

    public personalIdentification(int pin){
        this.pin = pin;
    }

    public String changePid(int oldPin, int newPin){
        if(oldPin == this.pin){
            this.pin = newPin;
            return "Changed pin";
        }
        return "Failed to change pin";
    }

}

class accountNumber{

    private int accountNum;

    public accountNumber(){
        this.accountNum = 1234;
    }

    public accountNumber(int act){
        this.accountNum = act;
    }

    public int getActNum(){
        return this.accountNum;
    }

}

class accountBalance{

    private int balance;

    public accountBalance(){
        this.balance = 0;
    }

    public accountBalance(int newBal){
        this.balance = newBal;
    }

    public int getBalance(){
        return this.balance;
    }

    public void deposit(int deposit){
        this.balance += deposit;
    }

    public void withdraw(int withdraw){
        this.balance -= withdraw;
    }

}


class SRP {

    public static void main(String[] args){
    
    }
    
}
