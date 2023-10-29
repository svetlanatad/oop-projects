public class Exponential extends CompositeFunction{

//The class should include an additional attribute representing the base value.
    private double b;

//• a three-argument constructor that calls the super constructor with appropriate arguments
    public Exponential(double b, double c, Function g){
        super(c,g);
        this.b = b;
    }

    //• a copy constructor
    public Exponential(Exponential that){
        super(that.getC(), copy(that.getG()));
        this.b = that.b;


    }
//• an overridden method value()
    public double value(double input){

        return getC() * Math.pow(b, getG().value(input));


    }

    //an overridden method derivative().

    public Function derivative(){


        Function result =  this.multiply(getG().derivative());
        result.scale(getC()*Math.log(b));
        return result;
    }
//an overridden method toString() that returns the string representation of this function using
//the format c*b ̂{g(x)}

    public String toString() {
        return getC() + "*" + b + "^{" + getG().toString() + "}";
    }

    //• an overridden method equals()

    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Exponential) {
            Exponential other = (Exponential) otherObject;
            return (getC() == other.getC() && b == other.b && getG().equals(other.getG()));
        }
        return false;
    }
}
