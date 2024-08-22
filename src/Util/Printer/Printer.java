package Util.Printer;

public class Printer {

    public static void printInitMessage() {
        System.out.print(" ___________________________________________________\n");
        System.out.print("/                                                   \\\n");
        System.out.print("|                                                 |\n");
        System.out.print("|  \033[1mBem-vindo ao escritório mais caótico e\033[0m         |\n");
        System.out.print("|  \033[1mimprevisível que você já conheceu!!\033[0m            |\n");
        System.out.print("|                                                 |\n");
        System.out.print("|  Como um novo membro da equipe da Dunder Mifflin,|\n");
        System.out.print("|  você está prestes a enfrentar desafios          |\n");
        System.out.print("|  que vão muito além de vendas e papelada.        |\n");
        System.out.print("|  Desde sobreviver a reuniões tensas até se       |\n");
        System.out.print("|  esquivar de tarefas impossíveis, cada dia é uma |\n");
        System.out.print("|  nova aventura.                                 |\n");
        System.out.print("|                                                 |\n");
        System.out.print("|  Escolha seu personagem, equipe-se com coragem,  |\n");
        System.out.print("|  e prepare-se para navegar pelas loucuras do     |\n");
        System.out.print("|  escritório. Lembre-se: a sobrevivência aqui não |\n");
        System.out.print("|  depende apenas de habilidades, mas também de    |\n");
        System.out.print("|  quem você conhece e como você joga suas cartas. |\n");
        System.out.print("|                                                 |\n");
        System.out.print("|  Boa sorte, porque no fim do dia, só os mais     |\n");
        System.out.print("|  astutos saem vitoriosos!                       |\n");
        System.out.print("|                                                 |\n");
        System.out.print("|  Você está pronto para começar?                 |\n");
        System.out.print("\\___________________________________________________/\n");
    }

    public static void printFirstShopkeeperMessage() {

        System.out.println(" ___________________________________________________________");
        System.out.println("/                                                           \\");
        System.out.println("|                                                            |");
        System.out.println("|     \033[1mAgora começa a sua Scranton Saga!\033[0m                      |");
        System.out.println("|                                                            |");
        System.out.println("|     É o seu primeiro dia e você logo encontra o famoso     |");
        System.out.println("|     armário de suprimentos. Conhecido por ter de tudo,     |");
        System.out.println("|     desde papel higiênico até grampeadores, o armário      |");
        System.out.println("|     também esconde lanches, objetos perdidos e até mesmo   |");
        System.out.println("|     desculpas perfeitas para sair do trabalho mais cedo!   |");
        System.out.println("|     Fazer um lanchinho extra pode te deixar mais disposto  |");
        System.out.println("|     para encarar os desafios do dia. Devolver um item      |");
        System.out.println("|     perdido de um colega pode garantir uma ajuda valiosa   |");
        System.out.println("|     quando você mais precisar. E, claro, ter uma desculpa  |");
        System.out.println("|     na manga para escapar do escritório em momentos        |");
        System.out.println("|     difíceis nunca é uma má ideia!                         |");
        System.out.println("|                                                            |");
        System.out.println("|     \033[3mO armário range ao se abrir...\033[0m                         |");
        System.out.println("|                                                            |");
        System.out.println("|     \033[1mAlgum dos itens disponíveis te interessa?\033[0m              |");
        System.out.println("|                                                            |");
        System.out.println("\\___________________________________________________________/");

    }

    public static void printCreationPointsTable() {
        System.out.println("\t\t+--------------------------------------+");
        System.out.println("\t\t|          Tabelas de Conversão         |");
        System.out.println("\t\t+--------------------------------------+");
        System.out.println("\t\t|     1 ponto de força = 5 moedas       |");
        System.out.println("\t\t|     1 ponto de vida  = 1 moeda        |");
        System.out.println("\t\t+--------------------------------------+\n\n");

    }

    public static void printHeroCreationInfo(String name, int creationPoints, int strength, int hp) {
        String singleTextFormat = "\t\t| %-35s |\n";

        System.out.println("Você possui " + creationPoints + " moedas disponíveis para preparar o seu personagem.");
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(singleTextFormat, "  Jogador: " + name.toUpperCase());
        System.out.println("\t\t+-------------------------------------+");
        System.out.printf(singleTextFormat, "   FORÇA : " + strength);
        System.out.printf(singleTextFormat, "   HP    : " + hp);
        System.out.println("\t\t+-------------------------------------+\n");
    }
}
