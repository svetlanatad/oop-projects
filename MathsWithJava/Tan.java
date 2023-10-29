public class Tan extends TrigonometricFunction{

    //• a two-argument constructor that calls the super constructor with appropriate arguments
    public Tan(double c, Function g){
        super(c,copy(g));

    }
    //• a copy constructor
    public Tan(Tan that){
        super(that.getC(), copy(that.getG()));

    }
    //• an overridden method value()
    public double value(double input){

        return getC() * Math.tan(getG().value(input));


    }
    //an overridden method derivative()
    public Function derivative(){

        Function f1 = getG().derivative();
        f1.scale(getC());
        Function cos = new Cosine(1, getG());
        cos.multiply(cos);

        return f1.divide(cos);
    }

    //an overridden method toString() that returns the string representation of this function using the format
    // c*tan(g(x))
    public String toString(){
        return getC() + "*tan(" + getG().toString() + ")";
    }

    //an overridden method equals()

    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Tan) {
            Tan other = (Tan) otherObject;
            return (getC() == other.getC() && getG().equals(other.getG()));
        }
        return false;
    }




}
