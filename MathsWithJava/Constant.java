public class Constant extends SimpleFunction{

  // がんばって  o( ❛ᴗ❛ )o

    //The class should include an attribute representing the constant value.
    private double c;

    //• a one-argument constructor
    public Constant(double c){
        this.c = c;
    }

    //• a copy constructor
    public Constant(Constant other){
        this.c = other.c;
    }

//an overridden method value(...) that returns the value of this function
    public double value(double input) {
        return c;
    }

    //an overloaded method value()
    public double value(){
        return c;
    }

    //an overridden method derivative()
    public Function derivative(){
        return new Constant(0);
    }

    //an overridden method scale()
    public void scale(double scalar){
        c *= scalar;
    }

//an overridden method add(SimpleFunction that) that returns a new function representing the sum of this and that functions.
    public Function add(SimpleFunction that){

        if(that instanceof Constant){
            return new Constant (((Constant)that).c + this.c);
        }else if (that instanceof Polynomial){
            Polynomial polynomial = new Polynomial((Polynomial) that);
            return polynomial.add(this);
        }

        return null;

    }
    //an overridden method subtract(SimpleFunction that)

    public Function subtract(SimpleFunction that){
        if(that instanceof Constant){
            return new Constant (((Constant)that).c - c);
        }else if (that instanceof Polynomial){
            Polynomial polynomial = new Polynomial((Polynomial) that);
            return polynomial.subtract(this);
        }

        return null;

    }
//an overridden method multiply(SimpleFunction that) that returns a new function representing the product of this and that functions.
    public Function multiply(SimpleFunction that){

        if(that instanceof Constant){
            return new Constant (((Constant)that).c * this.c);
        }else if (that instanceof Polynomial){
            Polynomial polynomial = new Polynomial((Polynomial) that);
            return polynomial.multiply(this);
        }

        return null;

    }
//an overridden method square()
    public Function square(){
        return new Constant (c*c);

    }
    //an overloaded method divide(ConstantFunction)
    public Constant divide(Constant that){

        return new Constant(this.c / that.c);

    }
    //an overridden method toString()
    public String toString() {
        return c + "";
    }

    //an overridden method equals()
    public boolean equals(Object otherObject) {
        if(otherObject == null){
            return false;
        }
        if (!super.equals(otherObject)) {
            return false;
        }
        if (otherObject instanceof Constant) {
            Constant other = (Constant) otherObject;
            return (c == other.c);
        }
        return false;
    }
}
