package Util.Creator.EnvironmentCreator;

import Game.Room;

import static Util.Strings.EnvironmentStrings.RoomStrings.*;

/**
 * A utility class for centralize the creation of Room instances.
 */
public class RoomCreator {

    private static RoomCreator instance;

    private RoomCreator() {
    }

    public static RoomCreator getInstance() {
        if (instance == null) {
            instance = new RoomCreator();
        }
        return instance;
    }

    public Room getById(int id) {
        switch (id) {
            case 1:
                return new Room(
                        1,
                        intRoom1,
                        optRoom1,
                        50,
                        2,
                        4,
                        20,
                        20,
                        ChallengeCreator.getInstance().getById(3)
                );
            case 2:
                return new Room(2,
                        intRoom2,
                        optRoom2,
                        40,
                        3,
                        6,
                        20,
                        25,
                        ChallengeCreator.getInstance().getById(4)
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
                        30,
                        ChallengeCreator.getInstance().getById(6)
                );
            default:
                return null;
        }
    }
}
