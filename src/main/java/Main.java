import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author gleb.gerasimenko.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        String json = readFile("data/oxotestdata.json");

//        System.out.println(json);

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonArray games = jsonElement.getAsJsonArray();

        int drawCount = 0;
        int XCount = 0;
        int OCount = 0;

        for (JsonElement game : games) {
            GameField gameField = new GameField();
            JsonArray turns = game.getAsJsonArray();
            for (JsonElement turn : turns) {
                JsonArray obj = turn.getAsJsonArray();
                Model model = new Model(obj.get(0).getAsInt(), obj.get(1).getAsInt(), Model.Value.valueOf(obj.get(2).getAsString()));
                GameField.Result result = gameField.add(model);
                if (GameField.Result.DRAW.equals(result)) {
                    drawCount++;
//                    System.out.println(game);
                } else if (GameField.Result.WIN_X.equals(result)) {
                    XCount++;
                } else if (GameField.Result.WIN_O.equals(result)) {
                    OCount++;
                }
            }
        }

        System.out.println("X count = " + XCount);
        System.out.println("O count = " + OCount);
        System.out.println("Draw count = " + drawCount);
    }

    public static String readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        char[] buffer = new char[128];
        StringBuilder stringBuilder = new StringBuilder();

        while (fileReader.read(buffer) != -1) {
            stringBuilder.append(buffer);
            buffer = new char[128];
        }

        return stringBuilder.toString().trim();
    }

}
