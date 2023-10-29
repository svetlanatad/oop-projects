public class Sine extends TrigonometricFunction{

    //a two-argument constructor that calls the super constructor with appropriate arguments
    public Sine(double c, Function g){
        super(c,copy(g));
    }

    //• a copy constructor
    public Sine (Sine that){
        super(that.getC(), copy(that.getG()));
    }

//• an overridden method value()

    public double value(double input){

        return getC() * Math.sin(getG().value(input));


    }
//an overridden method toString() that returns the string representation of this function using the format
// c*sin(g(x))
    public String toString(){
        return getC() + "*sin(" + getG().toString() + ")";
    }

//• an overridden method equals()

    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Sine) {
            Sine other = (Sine) otherObject;
            return (getC() == other.getC() && getG().equals(other.getG()));
        }
        return false;
    }

//Now go back to Sine class and override the derivative() based on the following derivation rule:

    public Function derivative(){

        return new Cosine(-1*getC(), getG()).multiply(getG().derivative());
    }
}
