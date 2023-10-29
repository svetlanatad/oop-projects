public abstract class CompositeFunction extends Function{





    //The class should include two attributes– the constant value and the inner function.
    private double c;
    private Function g;
//• accessors for all instance variables
    public double getC(){ return c;}

    public Function getG(){return copy(g);}
// a two-argument constructor (note that you need to use copy() method here (even though it currently does not have an appropriate implementation) to avoid privacy leaks)
    public CompositeFunction(double c, Function g){
    this.c = c;
    this.g = copy(g);
}

//an overridden method scale()
    public void scale(double scalar){
        c =  (c * scalar);
    }

    //• an overridden method equals()
    public boolean equals(Object otherObject){



        if (otherObject == null){
            return false;
        }
        else if (getClass() != otherObject.getClass()) {
            return false;
        }
            CompositeFunction otherFunction = (CompositeFunction) otherObject;
            return (c == otherFunction.getC() && g.equals(otherFunction.g));



    }
}




