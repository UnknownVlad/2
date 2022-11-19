package json_reader;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import player_structure.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class JsonReader {
    public static List<Player> getpostgres(String fileName) throws IOException {
        return new ObjectMapper().readValue(new FileInputStream(new File(fileName)),new TypeReference<List<Player>>() {});
    }

}
