package Game;

import Entities.Hero;
import Entities.Npc;
import Util.ItemsCreator.NpcCreator;

public class Room {


    public static boolean lunchChallenge(Hero hero) {
        System.out.println("Michael decidiu que quer algo especial para o almoço, e é sua responsabilidade garantir " +
                "que ele receba exatamente o que pediu." +
                "\nO problema? Michael é indeciso, e suas demandas são cada vez mais absurdas." +
                "\nVocê precisa agir rápido antes que ele mude de ideia novamente." +
                "\nSerá que você consegue realizar essa tarefa sem perder a cabeça?");

        Npc challenge = new Npc("Pedido Especial do Michael", 30, 15, 20);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nO Andy ouviu a conversa e logo se voluntariou para ir comprar o almoço do Michael!" +
                    "\nEle não poderia perder essa oportunidade de ganhar créditos com o chefe!");
        } else {
            System.out.println("Oh não! Você trouxe tiramisú de sobremesa e o Michael se engasgou com o " +
                    "chocolate em pó!" +
                    "\nEle não quer que a vida dele volte a correr riscos tão grandes, e por isso você foi demitido!");
        }

        return heroWin;
    }


    public static boolean printerChallenge(Hero hero) {
        System.out.println("A impressora do escritório parou de funcionar novamente!" +
                "\nCom a produtividade em jogo e a paciência da equipe no limite, você foi escolhido para resolver" +
                " esse problema técnico." +
                "\nA pressão está em você para encontrar a solução antes que o caos se espalhe pelo escritório." +
                "\nVocê onseguirá consertar essa máquina infernal?");

        Npc challenge = new Npc("O Eterno Conserto da Impressora", 40, 20, 25);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nDepois de horas a te assistir a falhar na tentativa de consertar a impressora, a Pam " +
                    "finalmente te entregou o manual e facilitou as coisas!");
        } else {
            System.out.println("Oh não! Ao tentar religar a impressora, você começou um pequeno incendio que destruiu" +
                    " a máquina." +
                    "\nVocê foi demitido por destruir a impressora de estimação do Michael!");
        }
        return heroWin;
    }

    public static boolean clientChallenge(Hero hero) {
        System.out.println("Um cliente importante ameaçou levar seu negócio para outra empresa, e todos estão em" +
                " pânico." +
                "\nA responsabilidade de salvar essa conta recai sobre você." +
                "\nÉ hora de mostrar suas habilidades de persuasão e reconquistar o cliente antes que seja tarde " +
                "demais." +
                "\nVocê conseguirá trazer o cliente de volta, ou o escritório enfrentará uma crise?");

        Npc challenge = new Npc("Missão: Reconquista de Cliente", 50, 25, 30);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nDepois de horas a te assistir a falhar na tentativa de consertar a impressora, a Pam " +
                    "finalmente te entregou o manual e facilitou as coisas!");
        } else {
            System.out.println("Oh não! Ao tentar religar a impressora, você começou um pequeno incendio que " +
                    "destruiu a máquina." +
                    "\nVocê foi demitido por destruir a impressora de estimação do Michael!");
        }
        return heroWin;
    }

    public static boolean parkourChallenge(Hero hero) {
        System.out.println("Dwight e Michael decidiram animar o dia com um pouco de Parkour!" +
                "\nAgora, o escritório virou um campo de obstáculos improvisado." +
                "\nSua missão é simples: sobreviver à loucura sem causar muitos danos ao escritório (ou a si mesmo)." +
                "\nMas cuidado, a competição é acirrada! Está preparado para saltar sobre mesas e evitar cair" +
                " em apuros?");

        Npc challenge = new Npc("Caos de Parkour no Escritório", 60, 30, 35);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nO Stanley quis participar do desafio e se acidentou logo no primeiro salto! " +
                    "\nTodos estão a tentar ajudá-lo. A brincadeira acabou.");
        } else {
            System.out.println("Oh não! Você arrasou no Parkour e venceu o Michael!" +
                    "\nEle afirma que você trapaceou e o demite por isso!");
        }
        return heroWin;
    }

    public static boolean rhMeeting(Hero hero) {
        System.out.println("Toby convocou mais uma reunião." +
                        "\nVocê precisará de toda a sua paciência e diplomacia para atravessar esta sessão de monotonia." +
                        "\nConseguirá você sobreviver a essa maratona de formalidades e desentendimentos?");

        Npc challenge = new Npc("Tortura na Sala do RH", 70, 35, 40);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nMichael interrompeu a fala do Toby e resolveu transformar a reunião numa sessão de cinema!" +
                    "\nAproveite o happy hour!");
        } else {
            System.out.println("Oh não! Você cochilou durante as falas iniciais no Michael e foi demitido!");
        }
        return heroWin;
    }

    public static boolean basketGame(Hero hero) {
        System.out.println("O evento mais aguardado do ano chegou: o jogo de basquete contra o Armazém." +
                "\nAs rivalidades estão em alta, e a vitória significa mais do que apenas bragging rights." +
                "\nÉ hora de colocar suas habilidades à prova e levar seu time à glória." +
                "\nMas cuidado, o time do Armazém joga duro! Você conseguirá liderar seu time à vitória?");

        Npc challenge = new Npc("Desafio das Quadras: Escritório vs. Armazém", 80, 40, 50);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Yeah! Você se livrou dessa!" +
                    "\nDarryl se machucou e você precisou mudar de time para completar a equipe do Armazém!" +
                    "\nVitória garantida!");
        } else {
            System.out.println("Oh não! Você se empolgou e desafiou o Darryl pra 1x1 !" +
                    "\nO massacre foi garantido!" +
                    "\nMichal não gostou da vergonha a que você submeteu o escritório e você foi demitido!");
        }
        return heroWin;
    }

    public static boolean christmasParty(Hero hero) {
        System.out.println("A Festa de Natal do escritório está se aproximando, e você foi encarregado de organizar tudo." +
                "\nMas nada é simples quando se trata do Dunder Mifflin." +
                "\nEntre pedidos impossíveis, orçamentos apertados e expectativas absurdas, você terá que manter" +
                " todos felizes enquanto cria a festa perfeita." +
                "\nSerá que você conseguirá transformar essa bagunça em uma celebração memorável?");

        Npc challenge = new Npc("A Temida Festa de Natal", 90, 45, 60);
        boolean heroWin = hero.attack(challenge);

        if (heroWin) {
            System.out.println("Parabéns! Você se juntou ao comitê de Festas e conseguiu conciliar as " +
                    "ideias da Angela e da Phylis e a festa foi incrível!" +
                    "\nQuase uma missão impossível!");
        } else {
            System.out.println("Que desastre! Você tentou inovar e deixou a Phylis ser o Papai Noel da Festa!" +
                    "\nObviamente que o Michael não quis abrir mão do papel que sempre foi dele!" +
                    "\nVocê foi demitido!");
        }
        return heroWin;
    }

}
