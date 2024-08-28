package Game.EnvironmentCreator;

import Game.Room;

import static Game.EnvironmentCreator.Strings.RoomStrings.*;
import static Util.Strings.PlotStrings.*;

public class RoomCreator {

    private static RoomCreator instance;

    private RoomCreator(){}

    public static RoomCreator getInstance(){
        if (instance == null){
            instance = new RoomCreator();
        }
        return instance;
    }

    public Room getById(int id){
        switch (id){
            case 1:
                return new Room(
                        1,
                        intRoom1,
                        optRoom1,
                        50,
                        2,
                        4,
                        20,
                        20
                        );
            case 2:
                return new Room(2,
                        intRoom2,
                        optRoom2,
                        40,
                        3,
                        6,
                        20,
                        25
                );
            case 3:
                return new Room(
                        3,
                        intRoom3,
                        optRoom3,
                        20,
                        5,
                        10,
                        30,
                        30
                );
            default:
                return null;
        }
    }
}
