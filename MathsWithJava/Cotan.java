public class Cotan extends Tan{

//• a two-argument constructor that calls the super constructor with appropriate arguments
        public Cotan(double c, Function g){
            super(c,copy(g));

        }
        //• a copy constructor
        public Cotan(Cotan that){
            super(that.getC(), copy(that.getG()));

        }


    //• an overridden method value() that uses the value returned by super
        public double value(double input){

            double newC =  getC()*getC();
            return newC / super.value(input);






        }
        //an overridden method derivative()./<./.<>

        public Function derivative(){

            Function f1 = getG().derivative();
            f1.scale(-1*getC());
            Function sin = new Sine(1, getG());
            sin.multiply(sin);

            return f1.divide(sin);
        }
        //an overridden method toString() that returns the string representation of this function using the format
    // c*cot(g(x))

        public String toString(){
            return getC() + "*cot(" + getG().toString() + ")";
        }

//an overridden method equals()
        public boolean equals(Object otherObject) {
            if(otherObject == null){
                return false;
            }
            if (!super.equals(otherObject)) {
                return false;
            }
            if (otherObject instanceof Cotan) {
                Cotan other = (Cotan) otherObject;
                return (getC() == other.getC() && getG().equals(other.getG()));
            }
            return false;
        }




    }

