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
// for coupling reasons however we could definitely abstract it out
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

// perhaps the betterBankAccount hooks up to a db and provides a link for the account + balance,
// at which point the only reason to change would be if something changed with the db, 
// we know we need an account num, bal, pin, and uid for making a connection to a theoretical (and very unsecure)
// bank, so their implementation's can change on their own

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

// uid only changes if the implementation of a uid change

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

// pin only changes if the implementation of pin changes,
// ie maybe we only allowed numeric pins, but someone decides
// we need alphanumeric pins, then we would change this 
// !! we would revise our bank class to receive a string instead that we 
// could parse out or do whatever with !! but we would have that thought when making
// the bank class, because that's smart

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

// account num only  changes if we want to change the format of 
// an accout number 

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

// balance only changes if we want to change the format of a balance
// ie mmaybe we want it to be a coujnt of pennies, or something 
// maybe we would take deposit or balance into their own classes
// but that seems like overkill - if we figured they would ever
// want to deposit stuff differently then maybe we would do that
// ie if there was a new form of cheque or something, we could
// extend a deposit class to account for that 


class SRP {

    public static void main(String[] args){
    
    }
    
}
