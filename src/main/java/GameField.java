import com.sun.org.apache.regexp.internal.RE;

/**
 * @author gleb.gerasimenko.
 */
public class GameField {

    private Model.Value[][] field;

    private int size;

    public enum Result {
        WIN_X, WIN_O, DRAW
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
        if (size > 4) {
            return validate();
        }
        return null;
    }

    private Result validate() {
        String res;
        for (int i = 0; i < field.length; i++) {
            res = "";
            for (int j = 0; j < field[i].length; j++) {
                res += field[i][j];
            }
            if (res.equals("XXX")) {
                return Result.WIN_X;
            } else if (res.equals("OOO")) {
                return Result.WIN_O;
            }
        }

        for (int i = 0; i < field.length; i++) {
            res = "";
            for (int j = 0; j < field[i].length; j++) {
                res += field[j][i];
            }
            if (res.equals("XXX")) {
                return Result.WIN_X;
            } else if (res.equals("OOO")) {
                return Result.WIN_O;
            }
        }

        res = "" + field[0][0] + field[1][1] + field[2][2];
        if (res.equals("XXX")) {
            return Result.WIN_X;
        } else if (res.equals("OOO")) {
            return Result.WIN_O;
        }

        res = "" + field[0][2] + field[1][1] + field[2][0];
        if (res.equals("XXX")) {
            return Result.WIN_X;
        } else if (res.equals("OOO")) {
            return Result.WIN_O;
        }
        if (size == 9) {
            return Result.DRAW;
        }
        return null;
    }
}
