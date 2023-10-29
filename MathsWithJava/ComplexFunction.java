public class ComplexFunction extends Function{

    //The class definition should include enum Type that describes the type of the complex function (“SUM”, “DIFFERENCE”, “PRODUCT”, “QUOTIENT”).
    enum Type {
        SUM,
        DIFFERENCE,
        PRODUCT,
        QUOTIENT
    }

    //The class should include three instance variables– Type type, Function f and Function g.
    private Type type;
    private Function f;

    private Function g;

    //• a copy constructor
    public ComplexFunction(ComplexFunction that){
        this.type = that.type;
        this.f = copy(that.f);
        this.g = copy(that.g);
    }

    //• a three-argument constructor
    public ComplexFunction(Type type, Function f, Function g){

        this.type = type;
        this.f = copy(f);
        this.g = copy(g);

    }

    //• an overridden method scale() that uses a switch on the type to determine how the function should be modified
        public void scale(double scalar){

            switch (type) {
                case SUM:
                    f.scale(scalar);
                    g.scale(scalar);
                    break;
                case DIFFERENCE:
                    f.scale(scalar);
                    g.scale(scalar);

                    break;
                case PRODUCT:
                    f.scale(scalar);

                    break;
                case QUOTIENT:
                    f.scale(scalar);

                    break;
                default:
                    System.out.println("Never gonna give you up");
                    System.exit(0);
            }
        }

        //an overridden method value() that uses a switch on the type to determine what value should be returned
    public double value(double input){
        switch (type) {
            case SUM:
                return f.value(input) + g.value(input);

            case DIFFERENCE:
                return f.value(input) - g.value(input);


            case PRODUCT:
                return f.value(input) * g.value(input);


            case QUOTIENT:
                return (f.value(input) / g.value(input));

            default:
                System.out.println("Never gonna let you down");
                return 0;


        }
    }
    //an overridden method derivative() that uses a switch on the type to determine what function should be returned. Please be reminded of the following derivation rules:

    public Function derivative(){

        switch (type) {
            case SUM:
                return f.derivative().add(g.derivative());

            case DIFFERENCE:
                return f.derivative().subtract(g.derivative());


            case PRODUCT:
                return f.multiply(g.derivative()).add(g.multiply(f.derivative()));


            case QUOTIENT:
                return (f.derivative().multiply(g).subtract(g.derivative().multiply(f))).divide(g.square());


        }

return null;
    }

//an overridden method toString() that uses a switch on the type to construct and return a
//string representing this function. Use the following formatting for each of the cases:
public String toString(){
    switch (type) {
        case SUM:
            return f.add(g).toString();

        case DIFFERENCE:
            return f.subtract(g).toString();


        case PRODUCT:
            return f.multiply(g).toString();


        case QUOTIENT:
            return f.divide(g).toString();


        default:

            throw new IllegalArgumentException("死ぬのが良い");
    }
}




}


