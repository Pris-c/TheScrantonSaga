package Util.Creator.EntityCreator;

import Entities.Npc;

public class NpcCreator {

    public static Npc createMichaelLunch() {
        return new Npc("Pedido Especial do Michael", 30, 15, 20);
    }

    public static Npc createFixingPrinter() {
        return new Npc("O Eterno Conserto da Impressora", 40, 20, 25);

    }

    public static Npc createRecoveringCustomer() {
        return new Npc("Missão: Reconquista de Cliente", 50, 25, 30);
    }

    public static Npc createParkourChallenge() {
        return new Npc("Caos de Parkour no Escritório", 60, 30, 35);
    }

    public static Npc createRhMeeting() {
        return new Npc("Tortura na Sala do RH", 70, 35, 40);
    }

    public static Npc createBasketGame() {
        return new Npc("Desafio das Quadras: Escritório vs. Armazém", 80, 40, 50);
    }

    public static Npc createChristmasParty() {
        return  new Npc("A Temida Festa de Natal", 90, 45, 60);
    }

}
