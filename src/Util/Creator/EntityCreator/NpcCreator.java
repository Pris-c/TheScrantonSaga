package Util.Creator.EntityCreator;

import Entities.Npc;

/**
 * A utility class for centralize the creation of NPC instances.
 */
public class NpcCreator {

    public static Npc createMichaelLunch() {
        return new Npc("Pedido Especial do Michael", 60, 25, 10);
    }

    public static Npc createFixingPrinter() {
        return new Npc("O Eterno Conserto da Impressora", 75, 25, 15);

    }

    public static Npc createRecoveringCustomer() {
        return new Npc("Missão: Reconquista de Cliente", 90, 30, 20);
    }

    public static Npc createParkourChallenge() {
        return new Npc("Caos de Parkour no Escritório", 120, 30, 25);
    }

    public static Npc createRhMeeting() {
        return new Npc("Tortura na Sala do RH", 130, 35, 25);
    }

    public static Npc createBasketGame() {
        return new Npc("Desafio das Quadras: Escritório vs. Armazém", 150, 35, 50);
    }

    public static Npc createChristmasParty() {
        return  new Npc("A Temida Festa de Natal", 160, 40, 0);
    }

}
