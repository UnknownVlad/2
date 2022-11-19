import actions_with_db.Data;
import console_handler.Handler;
import converters.UploadDataFromDB;
import player_structure.PlayerMap;
import test.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map<Integer, String> map  = new TreeMap<>();

        Data data = new Data();

        Test.deleteAllTabels(data);
        Test.createAllTabels(data);

        //Test.insertData(data, 10);


        List<String> commands = List.of(
                        "-add player 1 , 'p1'",
                        "-add player 2 , 'p2'",
                        "-add player 3 , 'p3'",
                        "-add player 4 , 'p2'",
                        "-rm player nickname='p2'"
        );
        PlayerMap cash =  new PlayerMap(UploadDataFromDB.upload(data));
        for (String s:commands) {
            //System.out.println(s);
            Handler.processing(data, s.trim(), cash);
            System.out.println("CASH");
            for (Integer p: cash.getPlayer().keySet()) {
                System.out.println(p +" "+cash.getPlayer().get(p));
            }


            System.out.println();
            System.out.println("_________________________");

            //System.out.println();
        }


        Handler.getInfo(data);
        Handler.getCommands(data);
        //ConsoleProcessor.go(data);



        //CRUD.UPDATE.execute(data, "player", "nickname='change1' where playerId=1", );*/
    }


}
