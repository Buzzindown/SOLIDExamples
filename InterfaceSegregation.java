package SOLID;

// interface segregation has to do with creating smarter, slimmer
// interfaces so that objects don't have to implement functions that they
// will never use, but must have because of the interface they implement
// by creating good interface segregation, we can make slimmer, cleaner
// and easier to understand classes

// let's do a bad example first
// we shall try an implement a creature class

interface creature {
    public void eat();
    public void run();
    public void swim();
    public void fly();
    public void makeNoise();
}

class giraffe implements creature{
    public void eat(){
        System.out.println("The giraffe eats");
    }

    public void run(){
        System.out.println("The giraffe runs");
    }

    public void swim(){
        System.out.println("The giraffe can't swim");
    }

    public void fly(){
        System.out.println("The giraffe can't fly");
    }

    public void makeNoise(){
        System.out.println("Giraffe noises");
    }
}

// it's clear that giraffe doesn't need to implement fly and swim because it's
// unable to do so, so we should redesign our creature interface to create
// more modular, specific interfaces

interface baseCreature{
    public void eat();
    public void makeNoise();
}

interface runningCreature{
    public void run();
}

interface swimmingCreature{
    public void swim();
}

interface flyingCreature{
    public void fly();
}

class betterGiraffe implements baseCreature, runningCreature{
    public void eat(){
        System.out.println("The giraffe eats");
    }

    public void makeNoise(){
        System.out.println("*giraffe noises*");
    }

    public void run(){
        System.out.println("The giraffe runs");
    }
}

class bigBird implements baseCreature, flyingCreature{
    public void eat(){
        System.out.println("The bird eats");
    }

    public void makeNoise(){
        System.out.println("*bird noises*");
    }

    public void fly(){
        System.out.println("The bird flys");
    }
}

// this design is much better because none of our classes 
// are bloated with methods that they don't need to implement, whereas
// before, each class would have to implement each methods


public class InterfaceSegregation {
    
}
