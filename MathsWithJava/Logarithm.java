public class Logarithm extends CompositeFunction{
    //The class should include an additional attribute representing the base value.
    private double b;
    //Even though the assignment requirement doesn't ask for getters, it should still be added to not have related problems in the class Ln
public double getB(){return b;}
    //a three-argument constructor that calls the super constructor with appropriate arguments
    public Logarithm(double b, double c, Function g){
        super(c,g);
        this.b = b;
    }

    //• a copy constructor

    public Logarithm(Logarithm that){
        super(that.getC(), copy(that.getG()));
        this.b = that.b;


    }

//•//>< an overridden method value()

    public double value(double input){


        return Math.log(getG().value(input))  / getC() * Math.log(b);


    }
    //an overridden method derivative()

    public Function derivative(){

        Function gCopy  = copy(getG());
        Function newFunction = getG().derivative();
        newFunction.scale(getC());
        gCopy.scale((Math.log(b)));

        return newFunction.divide(gCopy);

    }
//an overridden method toString() that returns the string representation of this function using the format

// c*log[b](g(x))
    public String toString() {
        return getC() + "*log[" + b + "](" + getG().toString() + ")";
    }

    //• an overridden method equals()
    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Logarithm) {
            Logarithm other = (Logarithm) otherObject;
            return (getC() == other.getC() && b == other.b && getG().equals(other.getG()));
        }
        return false;
    }
}
