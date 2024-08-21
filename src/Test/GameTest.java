package Test;

import Game.Game;
import Test.TestHelper.HeroCreator;

import static Game.Room.*;

public class GameTest {

    public static void main(String[] args) {

        Game game = new Game();

        //game.createHero().showDetails();

        //lunchChallenge(HeroCreator.createIntern());
        //printerChallenge(HeroCreator.createReceptionist());
        //clientChallenge(HeroCreator.createSalesRepresentative());
        //parkourChallenge(HeroCreator.createSalesRepresentative());
        //rhMeetingting(HeroCreator.createReceptionist());
        //basketGame(HeroCreator.createReceptionist());
        christmasParty(HeroCreator.createIntern());

    }
}
