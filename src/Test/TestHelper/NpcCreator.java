package Test.TestHelper;

import Entities.Npc;

public class NpcCreator {

    public static Npc createChallenge1() {
        return new Npc("Desafio 1", 50, 10, 5);
    }

    public static Npc createChallenge2() {
        return new Npc("Desafio 2", 100, 20, 10);
    }

    public static Npc createChallenge3() {
        return new Npc("Desafio 3", 200, 40, 20);
    }

}
