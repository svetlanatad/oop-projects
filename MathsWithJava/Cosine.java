public class Cosine extends TrigonometricFunction{

//• a two-argument constructor that calls the super constructor with appropriate arguments
    public Cosine(double c, Function g){
        super(c,copy(g));
    }

    //• a copy constructor
    public Cosine(Cosine that){
        super(that.getC(), copy(that.getG()));
    }

    //• an overridden method value()

    public double value(double input){

        return getC() * Math.cos(getG().value(input));

    }

//an overridden method derivative()
    public Function derivative(){

        return new Sine(-1*getC(), getG()).multiply(getG().derivative());
    }
//an overridden method toString() that returns the string representation of this function using
//the format c*cos(g(x))
    public String toString(){
        return getC() + "*cos(" + getG().toString() + ")";
    }

    //an overridden method equals()

    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Cosine) {
            Cosine other = (Cosine) otherObject;
            return (getC() == other.getC() && getG().equals(other.getG()));
        }
        return false;
    }
}
