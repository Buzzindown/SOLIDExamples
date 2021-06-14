package SOLID;

// liskov-substitution says that any parent class A should be 
// able to be replaced with one of it's subclasses B such that doing so
// doesn't interrupt the behaviour of the program || break anything
// let's make an example of something that does break liskov's rule

// the main thing that get's any piece of code into trouble with Liskov-sub
// is overriding some functionality after extending a parent class, in such a way
// that it is more specific, or more restrictive than the parent class

// this is becase, if we consider that case, when we swap the classes,
// where the parent may have accepted a broad range of inputs, since our 
// subclasss (who's now in the parents position) was more specific in it's
// input, some of the cases where the parent worked, the child will not 

// to avoid this, we may be as restrictive or less in our children,
// but not more

// sometimes this will mean restructuring the hierarchy to create
// more abstract or even more specific parent classses

// let's say that we start off with a fairly generic automobile class

class automobile{

    private int gasLevel;
    private int odometer;

    public automobile(){
        gasLevel = 0;
        odometer = 0;
    }

    public automobile(int gas, int odo){
        gasLevel = gas;
        odometer = odo;
    }

    public String startEngine(){
        return "Starting engine, vroom";
    }

    public int checkGas(){
        return gasLevel;
    }

    public int checkOdometer(){
        return odometer;
    }

}

// we want to make a tesla, it's an automobile too right?!

class tesla extends automobile{

    int batteryLevel;

    public tesla(int battery){
        super();
        batteryLevel = battery;

    }
    // overrides
    public String startEngine(){
        return "Can't start a car with no engine";
    }

    public String turnOn(){
        return "Car is on";
    }

    public int checkBatteryLevel(){
        return batteryLevel;
    }

}

// This is clearly poorly designed. Tesla is an automobile, however
// it lacks much of the basic functionality described in its parent class,
// because it lacks an engine. So if we were to try and start the engine 
// on a tesla (if we had swapped it with an automobile object) we would
// run into some issues.

// not to mention, because we extended the automobile, we're able to ccheck the gasLevel
// on the tesla, which is terrible, 

// A solution to this might be to add a level to the hierarchy
// and havve automobile, then two sub classes for EV and gas vehicles

class newAutomobile{
    // would have tires, odomoter, whatever actual GENERIC stuff that a car has 
    private int odometer;
    private int numTires;

    public newAutomobile(){
        odometer = 0;
        numTires = 4;
    }

    public newAutomobile(int odo, int tires){
        odometer = odo;
        numTires = tires; 
    }

    public int checkOdometer(){
        return odometer;
    }

    public int getNumTires(){
        return numTires;
    }
}


// ev can now safely extend it, because we will maintain all the functionality
// of our parent class 

class ElectricVehicle extends newAutomobile{

    private int batteryLevel;
    private int chargeRate;

    public ElectricVehicle(){
        super();
        batteryLevel = 0;
        chargeRate = 0;
    }

    public ElectricVehicle(int odo, int tires){
        super(odo, tires);
    }

    public ElectricVehicle(int odo, int tires, int battery, int charge){
        super(odo, tires);
        batteryLevel = battery;
        chargeRate = charge;
    }

    public String turnOn(){
        return "Car is ready to roll, quietly";
    }

    public int checkBatteryLevel(){
        return batteryLevel;
    }

    public int checkChargeRate(){
        return chargeRate;
    }
}

// gv is better designed now and similarily to ev, will get tires, odo from the parent
class gasVehicle extends newAutomobile{

    private int gasLevel;

    public gasVehicle(){
        super();
        gasLevel = 0;
    }

    public gasVehicle(int odo, int tires){
        super(odo, tires);
    }

    public gasVehicle(int odo, int tires, int gas){
        super(odo, tires);
        gasLevel = gas;
    }

    public String turnEngine(){
        return "engine on, vroom vroom";
    }

    public int checkGasLevel(){
        return gasLevel;
    }
}

// now if we wanted to make a tesla by extending our ev class we would be safe to do so
// and our design would be more open to future 

// this is another reason it's important to consider the future, maybe we would take it one
// level higher, in case we figure there might be personal flying vehicles
// at that point though, it might be overkill as we end up with a huge
// chain of dependencies 



public class LiskovSubstitution {
    
    public static void main(String[] args){

        automobile a1 = new automobile(90,121000);
        System.out.println(a1.startEngine());
        System.out.println(a1.checkGas());
        System.out.println(a1.checkOdometer());

        tesla t1 = new tesla(100);
        System.out.println(t1.startEngine());
        System.out.println(t1.checkGas());
        System.out.println(t1.checkOdometer());

        // produces bad results because a tesla cannot be used in the same way 
        // that an "automobile" object can because the automobile depends on having an engine

        System.out.println("Better design ...");

        newAutomobile a2 = new newAutomobile(121000, 4);
        System.out.println(a2.checkOdometer());
        System.out.println(a2.getNumTires());

        ElectricVehicle t2 = new ElectricVehicle(41000, 4, 90, 13);
        System.out.println(t2.checkOdometer());
        System.out.println(t2.getNumTires());
        System.out.println(t2.checkBatteryLevel());
        System.out.println(t2.turnOn());

        gasVehicle g1 = new gasVehicle(158000, 4, 70);
        System.out.println(g1.checkOdometer());
        System.out.println(g1.getNumTires());
        System.out.println(g1.checkGasLevel());
        System.out.println((g1.turnEngine()));

        // we're able to substitute any of the sublcasses for the super class here
        // this was achieved by not changing any of the original functionality
        // of the superclass and being specific about what clas should hold what
        // methods and properties. this class design makes more sense and follows liskov sub
        // this also follows good open closed principle because we extends our functionality
        // instead of modifying it

    }

}
