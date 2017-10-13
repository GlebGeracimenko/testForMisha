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

        System.out.println(json);

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(json);
        JsonArray games = jsonElement.getAsJsonArray().getAsJsonArray();

        int drawCount = 0;

        for (JsonElement game : games) {
            GameField gameField = new GameField();
            JsonArray turns = game.getAsJsonArray();
            for (JsonElement turn : turns) {
                JsonArray obj = turn.getAsJsonArray();
                Model model = new Model(obj.get(0).getAsInt(), obj.get(1).getAsInt(), Model.Value.valueOf(obj.get(2).getAsString()));
                if (GameField.Result.DRAW.equals(gameField.add(model))) {
                    drawCount++;
                    System.out.println(game);
                }
            }
        }

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
