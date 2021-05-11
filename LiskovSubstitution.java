package SOLID;

// liskov-substitution says that any parent class A should be 
// able to be replaced with one of it's subclasses B such that doing so
// doesn't interrupt the behaviour of the program || break anything
// let's make an example of something that does break liskov's rule

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

class tesla extends automobile{

    int batteryLevel;

    public tesla(int battery){
        super();
        batteryLevel = battery;

    }

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
// run into some issues. A solution to this might be to add a level to the hierarchy
// and havve automobile, then two sub classes for EV and gas vehicles

class newAutomobile{
    // would have tires, odomoter, whatever
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
