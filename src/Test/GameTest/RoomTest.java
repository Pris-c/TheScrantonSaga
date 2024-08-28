package Test.GameTest;

import Entities.Hero;
import Util.Creator.EnvironmentCreator.RoomCreator;
import Game.Room;
import Test.TestHelper.HeroCreator;

public class RoomTest {

    public static void main(String[] args) {

        RoomCreator roomCreator = RoomCreator.getInstance();
        Room room1 = roomCreator.getById(1);
        Room room2 = roomCreator.getById(2);
        Room room3 = roomCreator.getById(3);

        Hero hero = HeroCreator.createIntern();

        System.out.println("ROOM 1");
        room1.run(hero);
        System.out.println();

        System.out.println("ROOM 2");
        room2.run(hero);
        System.out.println();

        System.out.println("ROOM 3");
        room3.run(hero);
        System.out.println();

    }
}
