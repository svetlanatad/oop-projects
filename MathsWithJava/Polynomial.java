

public class Polynomial extends SimpleFunction {

    //The class should include three instance variables– the degree, an array of coefficients [cd, cd−1, . . . , c1] and a Constant function representing the last (c0) term.
    private int d;

    private double[] coefficients;



    private Constant c0;





    //a constructor that takes as an argument an array of double values and initializes all the instance variables

    public Polynomial(double[] arr) {
        this.c0 = new Constant(arr[arr.length - 1]);
        this.d = arr.length - 1;
        coefficients = new double[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            coefficients[i] = arr[i];
        }


    }
    //a copy constructor

    public Polynomial(Polynomial that) {
        this.d = that.d;
        this.c0 = that.c0;
        coefficients = new double[ d ];
        for (int i = 0; i < d - 1; i++) {
            coefficients[i] = that.coefficients[i];
        }


    }
    //an overridden method value() that returns the value of this function

    public double value(double input) {
        double result = 0;
        for (int i = d ; i > 0; i--) {
            result += coefficients[d-i] * Math.pow(input, i);
        }
        return result + c0.value();
    }

//an overridden method derivative()
    public Function derivative() {
        double[] derivativeCoefficients = new double[d-1];
        if (d == 1) {
            return new Constant(coefficients[0]);
        }
        for (int i = d-1; i >= 1; i--) {
            derivativeCoefficients[(d - 1 - i)] = i * coefficients[(d - 1 -  i)];
        }
        return new Polynomial(derivativeCoefficients);
    }

    //an overridden method scale()
    public void scale(double scalar) {
        for (int i = 0; i < d; i++) {
            coefficients[i] = coefficients[i] * scalar;
        }
    }
//an overridden method add(SimpleFunction that)
    public Function add(SimpleFunction that) {


        if (that instanceof Constant) {
            double[] newCoefficients = new double[d + 1];
            for (int i = 0; i < d; i++) {
                newCoefficients[i] = coefficients[i];
            }
            newCoefficients[d] = ((Constant) that).value() + this.c0.value();
            return new Polynomial(newCoefficients);


//        if (that instanceof Constant) {
//            double[] newCoefficients = new double[d-1];
//            for (int i = 0; i < d-1; i++) {
//                newCoefficients[i] = coefficients[i];
//            }
//            double[] newnewCoefficients = new double[d];
//            for (int i = 0; i < d-1; i++) {
//                newnewCoefficients[i] = newCoefficients[i];
//            }
//            newnewCoefficients[d-1] = this.c0.value() + ((Constant) that).value();
//
//
//            newCoefficients[d] = this.c0.value() + ((Constant) that).value();
//
//            return new Polynomial(newnewCoefficients);


// 5 + 3 = 5
// [x^4 + x^3 0 0 0] + [x^2 + 0 +1] = [x^4 + x^3 + x^2 + 0 + 1]
            //[x + 1] + [x^4 + 0 + 0 + 0 + 0] = [x^4 + 0 + 0 + x + 1]

            //7.0x^3 + 6.0x^2 + 4.0x + 3.0 + 2.0x^2 + 1.0x + 2.0 = 7.0X^3 + 8X^2 + 5.0X + 5.0
            // 9.0x^3 + 7.0x^2 + 4.0x + 5.0

        } else if (that instanceof Polynomial) {
            Polynomial p = (Polynomial) that;

            int maxDegree = Math.max(d, p.d);
            double[] newCoefficients = new double[maxDegree+1];

            for (int i = 0; i < maxDegree; i++) {

                double thisCoefficient = i >= d ? 0 : coefficients[i];

                double thatCoefficient = i >= p.d ? 0 : p.coefficients[i];

                newCoefficients[i] = thisCoefficient + thatCoefficient;
            }





//                double thisCoefficient = 0;
//                double thatCoefficient = 0;
//                for(int j = 0; j < maxDegree; j++){
//                    if(i>d-1){
//                    thisCoefficient += coefficients[i];
//                }else{
//                    thisCoefficient += 0;
//                }if(j>polynomial.d-1){
//                    thatCoefficient += polynomial.coefficients[j];
//                }else{
//                    thatCoefficient += 0;
//                }

//                if(i>d-1){
//                    thisCoefficient += coefficients[i];
//                }else{
//                    thisCoefficient += 0;
//                }if(i>polynomial.d-1){
//                    thatCoefficient += polynomial.coefficients[i];
//                }else{
//                    thatCoefficient += 0;
//                }
//                newCoefficients[i] = thisCoefficient + thatCoefficient;

            newCoefficients[maxDegree] = this.c0.value() + p.c0.value();
            return new Polynomial (newCoefficients);

        }
        return null;
    }
    //an overridden method subtract(SimpleFunction that)
    public Function subtract(SimpleFunction that) {


        if (that instanceof Constant) {

            Constant constantcopy = new Constant((Constant) that);
            constantcopy.scale(-1);
            return add(that);


            //Constant c1 = new Constant((Constant)that);


        } else if (that instanceof Polynomial) {

            Polynomial polynomialcopy = new Polynomial((Polynomial) that);
            polynomialcopy.scale(-1);
            return add(that);
        }


        return null;

    }
//an overridden method multiply(SimpleFunction that)

    public Function multiply(SimpleFunction that) {

        if (that instanceof Constant) {
            double[] newCoefficients = new double[d];
            for (int i = 0; i < d; i++) {

                newCoefficients[i] = coefficients[i] * ((Constant) that).value();
            }
            return new Polynomial(newCoefficients);
        } else if (that instanceof Polynomial) {
            Polynomial polynomial = (Polynomial) that;

            double[] newCoefficients = new double[d + polynomial.d +1];

            for (int i = 0; i < d; i++) {
                for (int j = 0; j < polynomial.d; j++) {
                    newCoefficients[i + j] += coefficients[i] * polynomial.coefficients[j];
                }
            }
            return new Polynomial(newCoefficients);
        }
        return null;
    }

// an overridden method square()
    public Function square() {
        return this.multiply(this);
    }





    //an overridden method toString()
    public String toString() {
        String str = "";
        for (int i = 0; i < this.coefficients.length; i++) {
            if(coefficients[i] == 0){
                str += "";
                continue;
            }

            if(d-i == 1){
                str += coefficients[i] + "x" + " + " + c0;
               // str +=  "" + c0;
                break;

            }

            str += coefficients[i] + "x^" + (this.coefficients.length-i) + " + ";


        }
        return str;
    }

    //an overridden method equals()

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (!(object instanceof Polynomial)) {
            return false;
        }

        Polynomial other = (Polynomial) object;

        if (this.coefficients.length != other.coefficients.length) {
            return false;
        }

        for (int i = 0; i < this.coefficients.length; i++) {
            if (this.coefficients[i] != other.coefficients[i]) {
                return false;
            }
        }

        return true;
    }
}

// やった！　。.:☆*:･'(*⌒―⌒*)))


