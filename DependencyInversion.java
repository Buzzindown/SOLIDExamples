package SOLID;

// dpendency inversion says that 
// High level modules should not depend on low level modules,
// both should depend on abstrations
// also, abstractions should not depend on details. Details
// should depend on abstractions
// this is a little harder to think about for sure
// The essence of dependency inversion is to be able to create code
// high level or low level, without having to refactor all of the high level AND
// low level code. If a high level module depends on a low level modules, and you change
// the low level module. Then the high level module's behaviour may have changed
// and it has to be retested incase we brought in any bugs

// dependecy inversion tries to get rid of this potential for bugs,
// by abstracting away the specific implementation details for high level and low level
// modules. In doing so, we essentially create a shield (interface?) which protects
// the high level code from low level changes

// similarly, when we do create these interfaces to make abstractions,
// the abstracctions shouldn't depend on the details of how they'll be used.
// Instrad the details of the abstraction should be based on the purpose of the abstraction.
// if we were todesign an abstraction based on details, we lose part of the abstraction
// simply by basing it off of some details. Instrad, our abstraction should be abstract! 
// It shouldn't depend on specific details, the details should depend on it

// let's say we had a crazy complicated class for a business that depends on lots of stuff

class businessModel{
    Developer dev;
    Manager mgr;
    Inventory inv;
    Database db;

    public void productChange(){
        // this might involve the developer,
        // manager, inventory and the db
    }

    public void productRollBack(){
        // could involve the dev, mgr and inv
    }
}

class Developer{
    String name;
    // does some stuff
}

class Manager{
    String name;
    // does some other stuff
}

class Inventory{
    int available;
    int sold;
    // inventory information
}

class Database{
    String dbName;
    int entries;
    int tables;
    int queries;
}

// the point of this is that the business model directly relies
// on how the 4 property classes are implemented. If the implementation of those classes change
// then we have issues because the behavior of the whole business model may have changed
// and now we have to go retest everything

// a better idea might be to abstract out employees and their specific roles, we'll redo this

class businessModel2{
    Dev dev;
    Mgr mgr;
    Inventory inv;
    Database db;

    public void productChange(){
        // this might involve the developer,
        // manager, inventory and the db
    }

    public void productRollBack(){
        // could involve the dev, mgr and inv
    }
}

class employee{
    // basic properties of an employye

}

interface developer{
    public void code();
    public void fixStuff();
}

interface manager{
    public void manage();
    public void lead();
}

class Dev extends employee implements developer{
    public void code(){
        // do some stuff
    }

    public void fixStuff(){
        // do more stuff
    }
}

class Mgr extends employee implements manager{
    public void manage(){
        //
    }
    
    public void lead(){
        //
    }
}

// now our business model depends on the abstracted promises made by our interfaces
// they dictate the return behaviour and methods of our classes. So we can change
// the implementation of a classes method and test it, without breaking the entire codebase
// additionally it would not be hard to add new types of employees we could also do something similar for db and inv

public class DependencyInversion {
    
}
