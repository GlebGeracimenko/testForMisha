import com.sun.org.apache.regexp.internal.RE;

/**
 * @author gleb.gerasimenko.
 */
public class GameField {

    private Model.Value[][] field;

    private int size;

    public enum Result {
        WIN_x, WIN_Y, DRAW
    }

    public GameField() {
        this.field = new Model.Value[3][3];
        size = 0;
    }

    public Model.Value[][] getField() {
        return field;
    }

    public Result add(Model model) {
        field[model.getI()][model.getJ()] = model.getValue();
        size++;
        if (size == 9) {
            return Result.DRAW;
        }
        return null;
    }

    private Result validate() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {

            }
        }
        return null;
    }
}
