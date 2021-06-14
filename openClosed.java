package SOLID;

// open closed principle is all about making 
// good code once and then trying not to disrupt whatever stable thing you've built
// the goal is to extend existing code so that we can avoid bringing in bugs
// let's do a more basic example for this
// say we had a very simple bankAccount like from the SRP example
// and it just had a balance

class basicBankAccount{

    private int bal;

    public basicBankAccount(){
        this.bal = 0;
    }

    public void deposit(int deposit){
        this.bal += deposit;
    }

    public void withdraw(int withdraw){
        this.bal -= withdraw;
    }

    public int getBal(){
        return this.bal;
    }

}

// this seems to be a perfectly fine working bankAccount but let's say we want to give it an account number
// we don't want to mess up our good code, so we will extend it instead to implement the new feature

class betterBankAccount2 extends basicBankAccount{
    
    private int accountNum;

    public betterBankAccount2(){
        super();
        this.accountNum = 1234;
    }

    public betterBankAccount2(int actNum){
        super();
        this.accountNum = actNum;
    }

    public int getActNum(){
        return this.accountNum;
    }
}

// this way we don't disrupt our *tested, stable* withdraw and deposit functionality, if we wrote an entirely new class
// we would have to retest the logic and that's exactly what we're trying to avoid, 
// althought using the extends keyword is very useful, that's not always the best way
// sometimes it will be better to edit the actual class by ADDING, not modifying the existing code
// the real difference is that one uses a keyword and retains the old class, whereas modifying still 
// keeps the logic but then we lose access to the old class incase it's needed for something else,
// although if we adhered to liskov-substituion that wouldn't really be a scenario
// so maybe instead we do

class oldClassNewNameForLintingPurposes {

    private int bal;
    // new
    private int accountNum;

    public oldClassNewNameForLintingPurposes(){
        this.bal = 0;
        this.accountNum = 1234;
    }

    // we can override the old constructor if we want to pass
    // in an acccount number, thus we retain old logic 
    public oldClassNewNameForLintingPurposes(int actNum){
        this.accountNum = actNum;
    }

    public void deposit(int deposit){
        this.bal += deposit;
    }

    public void withdraw(int withdraw){
        this.bal -= withdraw;
    }

    public int getBal(){
        return this.bal;
    }

    public int getActNum(){
        return this.accountNum;
    }

}

// when we write our code the first time, we want to make it extendable for whenever we need to build 
// out more functionality in the future, this will make it much easier when it comes to actually
// doing the extension of the code, always plan for the future

class openClosed {
    
    public static void main(String[] args){

        basicBankAccount basic = new basicBankAccount();
        basic.deposit(1250);
        System.out.println(basic.getBal());
        
        betterBankAccount2 better = new betterBankAccount2(123456);
        better.deposit(1250);
        System.out.println(better.getBal());
        System.out.println(better.getActNum());

    }
}
