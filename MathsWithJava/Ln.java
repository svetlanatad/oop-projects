public class Ln extends Logarithm{

    //• a three-argument constructor that calls the super constructor with appropriate arguments
    public Ln( double b, double c, Function g){
        super(Math.E, c,copy(g));


    }
    //• a copy constructor
    public Ln(Ln that){
        super(that.getB(), that.getC(), copy(that.getG()));
    }

    //an overridden method toString() that modifies the value returned by super toString and returns the string representation of this function using the format
    // c*ln(g(x))
    public String toString() {
        return getC() + "*ln(" + getG().toString() + ")";
    }

    //• an overridden method equals()

    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Ln) {
            Ln other = (Ln) otherObject;
            return (getC() == other.getC() && getB() == other.getB() && getG().equals(other.getG()));
        }
        return false;
    }
}
