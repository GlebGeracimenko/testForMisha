/**
 * @author gleb.gerasimenko.
 */
public class Model {

    private int j;

    private int i;

    private Value value;

    public enum Value {
        X, O
    }

    public Model(int j, int i, Value value) {
        this.j = j;
        this.i = i;
        this.value = value;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }
}
