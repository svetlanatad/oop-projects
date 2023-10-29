public abstract class TrigonometricFunction extends CompositeFunction{

    //The class should include a constructor matching the super constructor and an overridden method equals().
    public TrigonometricFunction(double c, Function g){
        super(c,g);
    }


    public boolean equals(Object otherObject){
        if (otherObject == null)
            return false;
        else if (getClass() != otherObject.getClass())
            return false;
        else{
            return super.equals(otherObject);
        }
    }

}
