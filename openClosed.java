package SOLID;

// open closed principle is all about making 
// solid code once and then trying not to disrupt whatever stable thing you've built
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
