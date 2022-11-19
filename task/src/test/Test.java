package test;

import actions_with_db.Data;
import actions_with_db.DataBaseCommunication;
import actions_with_db.Requests;
import converters.InsertDataToDB;
import json_reader.JsonReader;
import player_structure.Player;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class Test {

    public static void deleteAllTabels(Data d){
        DataBaseCommunication.deleteTabel(Requests.getDropTabelRequest(d.getPlayerTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDropTabelRequest(d.getItemsTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDropTabelRequest(d.getCurrenciesTabelName()), d.getConnection());
        DataBaseCommunication.deleteTabel(Requests.getDropTabelRequest(d.getProgressesTabelName()), d.getConnection());
    }

    public static void createAllTabels(Data d) throws SQLException {
        DataBaseCommunication.createTabel(d.getCreatePlayerTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateItemTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateCurrencieTabel(), d.getConnection());
        DataBaseCommunication.createTabel(d.getCreateProgressesTabel(), d.getConnection());
    }

    public static void insertData(Data data, int n) throws SQLException, IOException {
        List<Player> l = JsonReader.getpostgres("D:\\Учеба\\5 сем\\Java\\Переделка на постгрес\\untitled\\src\\json\\player.json");
        InsertDataToDB.insertInformation(l, data, n);
    }



}
