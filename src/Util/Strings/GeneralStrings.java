package Util.Strings;

/**
 * Keeps the Strings to be used along the game
 */
public class GeneralStrings {

    public static String title =
            "\n" +
                    "\t\t\t\t\t████████╗██╗  ██╗███████╗\n" +
                    "\t\t\t\t\t╚══██╔══╝██║  ██║██╔════╝\n" +
                    "\t\t\t\t\t   ██║   ███████║█████╗  \n" +
                    "\t\t\t\t\t   ██║   ██╔══██║██╔══╝  \n" +
                    "\t\t\t\t\t   ██║   ██║  ██║███████╗\n" +
                    "\t\t\t\t\t   ╚═╝   ╚═╝  ╚═╝╚══════╝\n" +
                    "\n" +
                    "\n" +
                    "███████╗ ██████╗██████╗  █████╗ ███╗   ██╗████████╗ ██████╗ ███╗   ██╗    ███████╗ █████╗  ██████╗  █████╗ \n" +
                    "██╔════╝██╔════╝██╔══██╗██╔══██╗████╗  ██║╚══██╔══╝██╔═══██╗████╗  ██║    ██╔════╝██╔══██╗██╔════╝ ██╔══██╗\n" +
                    "███████╗██║     ██████╔╝███████║██╔██╗ ██║   ██║   ██║   ██║██╔██╗ ██║    ███████╗███████║██║  ███╗███████║\n" +
                    "╚════██║██║     ██╔══██╗██╔══██║██║╚██╗██║   ██║   ██║   ██║██║╚██╗██║    ╚════██║██╔══██║██║   ██║██╔══██║\n" +
                    "███████║╚██████╗██║  ██║██║  ██║██║ ╚████║   ██║   ╚██████╔╝██║ ╚████║    ███████║██║  ██║╚██████╔╝██║  ██║\n" +
                    "╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝   ╚═╝    ╚═════╝ ╚═╝  ╚═══╝    ╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝  ╚═╝\n";

    public static String initMessage =
            "   _.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.__.-.\n" +
                    " ,'_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._`..-\n" +
                    "( (                                                            ) )\n" +
                    " ) )                                                          ( (\n" +
                    "( (   \033[1mBem-vindo ao escritório mais caótico e imprevisível\033[0m      ) )\n" +
                    " ) )                    \033[1mque você já conheceu!!\033[0m                ( (\n" +
                    "( (                                                            ) )\n" +
                    " ) )  Como um novo membro da equipe da Dunder Mifflin, você   ( (\n" +
                    "( (   está prestes a enfrentar desafios que vão muito          ) )\n" +
                    " ) )  além de vendas e papelada. Desde sobreviver a reuniões  ( (\n" +
                    "( (   tensas até se esquivar de tarefas impossíveis,           ) )\n" +
                    " ) )  cada dia é uma nova aventura.                           ( (\n" +
                    "( (                                                            ) )\n" +
                    " ) )  Prepare-se para navegar pelas loucuras do escritório.   ( (\n" +
                    "( (   Lembre-se: a sobrevivência aqui não depende apenas de    ) )\n" +
                    " ) )  habilidades, mas também de quem você conhece e como     ( (\n" +
                    "( (   você joga suas cartas. Boa sorte, porque no fim do dia,  ) )\n" +
                    " ) )  só os mais astutos saem vitoriosos!                     ( (\n" +
                    "( (                                                            ) )\n" +
                    " ) )  \033[1mVocê está pronto para começar?\033[0m                          ( (\n" +
                    "( (                                                            ) )\n" +
                    " ) )                                                          ( (\n" +
                    "( (_.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-.) )\n" +
                    " `._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._.-._,.-.'\n";

    public static String aboutHeroes =

            """
                    \033[1m1 - Personagens\033[0m\s
                    
                    \033[1mRepresentante de Vendas:\033[0m\s
                    \tDurante os desafios, em cada fase do confronto, este funcionário reage ao desafio primeiro, 
                    \tenfrentando o impacto inicial antes de contra-atacar. No entanto, por ser um colaborador experiente
                    \tele consegue lidar melhor com a pressão, absorvendo apenas 80% do impacto dos desafios enfrentados.\s
                    
                    \033[1mRecepcionista:\033[0m\s
                    \tEnfrenta os desafios de maneira direta e equilibrada. Tanto ao enfrentar como ao reagir, suas ações
                    \tsão neutras, sem ganhos ou perdas adicionais de força.\s
                    
                    \033[1mEstagiário:\033[0m\s
                    \tDevido à pouca experiência no escritório, o estagiário é mais vulnerável aos desafios. A cada confronto,
                     \tele acaba sofrendo 10% a mais de impacto do que outros personagens, tornando-o mais suscetível às dificuldades.
                    """;

    public static String aboutGameElement =
            """
                    \033[1m2 - Elementos do Personagem\033[0m\s
                    
                    \033[1mVida Atual\033[0m
                    \tA quantidade de pontos de vida que seu personagem possui no momento. Durante o jogo, você pode perder pontos de vida
                    \tem desafios ou recuperá-lo utilizando itens de recuperação e salas da sorte.\s
                    
                    \033[1mVida Máximo\033[0m
                    \tO número máximo de pontos de vida que seu personagem pode ter. Ele é definido no inicio do jogo e aumentado após cada
                    \t desafio vencido. Aumentar sua vida máxima permite que você suporte mais danos durante os desafios.
                    
                    \033[1mForça\033[0m
                    \tRepresenta o poder de ataque do seu personagem. A força é somada ao poder do seu Instrumento de Poder em cada ataque.
                    \tQuanto maior for sua força, mais eficaz será seu ataque.\s
                    
                    \033[1mMoedas\033[0m
                    \tSão os recursos que você possui para adquirir itens no Armário de Suprimentos. Use moedas para comprar 
                    \tnovos Instrumentos de Poder, Ajuda Extra e Recursos Adicionais que ajudarão em seus desafios.
                    
                    \033[1mNível\033[0m
                    \tMostra o progresso do seu personagem. A cada desafio vencido, você sobe de nível, o que pode desbloquear 
                    \tnovas habilidades ou benefícios.
                    
                    \033[1mInstrumento de Poder\033[0m
                    O item que fortalece seus ataques. A força do Instrumento de Poder é combinada com sua própria força para determinar 
                    o total de dano em cada ataque. Lembre-se, você pode usar a Estratégia Criativa uma vez por desafio para causar um grande impacto.
                    
                    \033[1mSuplementos\033[0m
                    São itens que oferecem benefícios adicionais. As "AJUDAS" proporcionam um ataque instantâneo com força especial, substituindo
                    temporariamente sua força normal. Já os "LANCHES" aumentam seus pontos de vida e/ou força, ajudando a enfrentar os desafios com
                    mais eficácia.
                    """;


    public static String creationPointsTable =
            "\t\t+--------------------------------------+\n" +
                    "\t\t|          Tabelas de Conversão         |\n" +
                    "\t\t+--------------------------------------+\n" +
                    "\t\t|     1 ponto de força = 5 moedas       |\n" +
                    "\t\t|     1 ponto de vida  = 1 moeda        |\n" +
                    "\t\t+--------------------------------------+\n\n";


    public static String championMessage =
            "                                  ___________\n" +
                    "                             .---'::'        `---.\n" +
                    "                            (::::::'              )\n" +
                    "                            |`-----._______.-----'|\n" +
                    "                            |              :::::::|\n" +
                    "                           .|               ::::::!-.\n" +
                    "                           \\|               :::::/|/\n" +
                    "                            |               ::::::|\n" +
                    "                            |                :::::|\n" +
                    "                            |                :::::|\n" +
                    "                            |               ::::::|\n" +
                    "                            |              .::::::|\n" +
                    "                            J              :::::::F\n" +
                    "                             \\            :::::::/\n" +
                    "                              `.        .:::::::'\n" +
                    "                                `-._  .:::::::-'\n" +
                    " ____________________________________|  \"\"\"|\"____________________________________________\n" +
                    "|                                    |  :::|                                             |\n" +
                    "|                                    F   ::J                                             |\n" +
                    "|                                   /     ::\\                                            |\n" +
                    "|                              __.-'      :::`-.__                                       |\n" +
                    "|                             (_           ::::::_)                                      |\n" +
                    "|                                                                                        |\n" +
                    "|      Parabéns!                                                                         |\n" +
                    "|      Você sobreviveu a todos os desafios e conquistou seu lugar na Dunder Mifflin.     |\n" +
                    "|      Sua astúcia, determinação e habilidade para navegar pelo caos do escritório       |\n" +
                    "|      fizeram de você um verdadeiro herói!                                              |\n" +
                    "|      Agora, você pode finalmente relaxar e aproveitar a vitória – você merece.         |\n" +
                    "|      Até a próxima aventura!                                                           |\n" +
                    "|                                                                                        |\n" +
                    " ----------------------------------------------------------------------------------------'\n";

    public static String loserMessage =

            "                               ⡴⠒⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠉⠳⡆⠀\n" +
                    "                               ⣇⠰⠉⢙⡄⠀⠀⣴⠖⢦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣆⠁⠙⡆\n" +
                    "                               ⠘⡇⢠⠞⠉⠙⣾⠃⢀⡼⠀⠀⠀⠀⠀⠀⠀⢀⣼⡀⠄⢷⣄⣀⠀⠀⠀⠀⠀⠀⠀⠰⠒⠲⡄⠀⣏⣆⣀⡍\n" +
                    "                               ⠀⢠⡏⠀⡤⠒⠃⠀⡜⠀⠀⠀⠀⠀⢀⣴⠾⠛⡁⠀⠀⢀⣈⡉⠙⠳⣤⡀⠀⠀⠀⠘⣆⠀⣇⡼⢋⠀⠀⢱\n" +
                    "                               ⠀⠘⣇⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⡴⢋⡣⠊⡩⠋⠀⠀⠀⠣⡉⠲⣄⠀⠙⢆⠀⠀⠀⣸⠀⢉⠀⢀⠿⠀⢸\n" +
                    "                               ⠀⠀⠸⡄⠀⠈⢳⣄⡇⠀⠀⢀⡞⠀⠈⠀⢀⣴⣾⣿⣿⣿⣿⣦⡀⠀⠀⠀⠈⢧⠀⠀⢳⣰⠁⠀⠀⠀⣠⠃\n" +
                    "                               ⠀⠀⠀⠘⢄⣀⣸⠃⠀⠀⠀⡸⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠈⣇⠀⠀⠙⢄⣀⠤⠚⠁⠀\n" +
                    "                               ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⢹⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "                               ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠀⠀⢘⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    " _______________________________________⠀⠀⡇⠀⢰⣿⣿⣿⡿⠛⠁⠀⠉⠛⢿⣿⣿⣿⣧⠀⠀⣼ _________________________________\n" +
                    "|                               ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡀⣸⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⡀⢀⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀                        |\n" +
                    "|                               ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⡇⠹⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⡿⠁⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        |\n" +
                    "|                                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣤⣞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢢⣀⣠⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                        |\n" +
                    "|                              ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠀⠀⠀⠀⠀⠙⠲⢤⣀⣀⠀⢀⣀⣀⠤⠒⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                         |\n" +
                    "|                                                                                               |\n" +
                    "|          Parece que o escritório de Dunder Mifflin foi demais para você desta vez.            |\n" +
                    "|          Apesar de seus esforços, os desafios se mostraram insuperáveis. Mas não desanime     |\n" +
                    "|          – nem todos conseguem ser um herói na primeira tentativa.                            |\n" +
                    "|          Respire fundo, recomece e, quem sabe, da próxima vez, a história tenha um            |\n" +
                    "|          final diferente.                                                                     |\n" +
                    "|                                                                                               |\n" +
                    " -----------------------------------------------------------------------------------------------'\n";

}


