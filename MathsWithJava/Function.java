public abstract class Function {

    //Good luck checking all of those homeworks dear TAs, don't give up!! (ﾉ◕ヮ◕)ﾉ*:･ﾟ✧

    // Returns the value of the function for a given input.
    public abstract double value(double input);

    // Returns the derivative of the function.
    public abstract Function derivative();

    // Scales the function by a given scalar.
    public abstract void scale(double scalar);
    // Returns the quotient of this function and another function.

    public Function divide(Function that){

        return new ComplexFunction(ComplexFunction.Type.QUOTIENT, this, that);

    }
    // Returns the difference of this function and another function.
    public Function subtract(Function that){
        return new ComplexFunction(ComplexFunction.Type.DIFFERENCE, this, that);

    }
    // Returns the sum of this function and another function.
    public Function add(Function that){

        return new ComplexFunction(ComplexFunction.Type.SUM, this, that);


    }
    // Returns the product of this function and another function.
    public Function multiply(Function that){
        return new ComplexFunction(ComplexFunction.Type.PRODUCT, this, that);

    }
    // Returns the square of the function.
    public Function square(){
        return this.multiply(this);

    }
    //Returns a copy of a given function.

    //Go back to class Function and provide implementations for methods divide,
    //subtract, add, multiply, square().
    //Inside method copy(that) add code that would return a new instance of ComplexFunction con
    // structed through a copy-constructor of class ComplexFunction (given that the argument is an
    // instance of ComplexFunction class).
    public static Function copy(Function that){

        if(that instanceof ComplexFunction){
            return new ComplexFunction((ComplexFunction)that);
        }


        if(that instanceof Exponential){
            return new Exponential((Exponential) that);
        }
        if(that instanceof Ln){
            return new Ln((Ln) that);
        }
        if(that instanceof Logarithm){
            return new Logarithm((Logarithm) that);
        }
        if(that instanceof Sine){
            return new Sine((Sine) that);

        }
        if(that instanceof Cosine){
            return new Cosine((Cosine) that);
        }

        if(that instanceof Cotan){
            return new Cotan((Cotan) that);
        }

        if(that instanceof Tan){
            return new Tan((Tan) that);
        }



        return null;

    }



}
