package Test.TestHelper;

import Entities.Npc;

public class NpcCreator {

    public static Npc createChallenge1() {
        return new Npc("Pedido Especial do Michael", 30, 15, 20,
                "Michael esqueceu de trazer o almoço novamente e você foi encarregado de buscar. Cuidado, ele pode ser exigente!");
    }

    public static Npc createChallenge2() {
        return new Npc("O Eterno Conserto da Impressora", 40, 20, 25,
                "A impressora do escritório quebrou de novo, e todos estão esperando por você para consertá-la. Este é um trabalho delicado!");

    }

    public static Npc createRecoveringCustomer() {
        return new Npc("Missão: Reconquista de Cliente", 50, 25, 30,
                "Um cliente importante está pensando em cancelar o contrato. Você precisa usar todo o seu charme e persuasão para mantê-lo.");
    }

    public static Npc createParkourChallenge() {
        return new Npc("Caos de Parkour no Escritório", 60, 30, 35,
                "Dwight está fazendo parkour no escritório novamente. Mantenha o controle para não deixar tudo virar um caos.");
    }

    public static Npc createRhMeeting() {
        return new Npc("Tortura na Sala do RH", 70, 35, 40,
                "Toby convocou mais uma reunião. Você precisará de toda a sua paciência e diplomacia para sobreviver a esta.");
    }

    public static Npc createBasketGame() {
        return new Npc("Desafio das Quadras: Escritório vs. Armazém", 80, 40, 50,
                "É hora do jogo anual de basquete contra o pessoal do armazém. Prepare-se para um confronto acirrado!");
    }

    public static Npc createChristmasParty() {
        return  new Npc("A Temida Festa de Natal", 90, 45, 60,
                "O escritório confiou a você a organização da festa de Natal. Mas cuidado, satisfazer todos os gostos é uma tarefa heróica!");
    }

}
