public class SudokuCell {
    private int value;
    private boolean fixed;
    public SudokuCell(int v, boolean f){

        value = v;

        fixed = f;

    }
    public void setValue(int v){value = v;}
    public void setFixed(boolean f){fixed = f;}

    public int getValue(){

        return this.value;
    }
    public boolean getFixed(){

        return this.fixed;
    }

}
