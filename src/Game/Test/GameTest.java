package Game.Test;

import Game.ScrantonSaga;
import Test.TestHelper.HeroCreator;

public class GameTest {

    public static void main(String[] args) {


        ScrantonSaga game = new ScrantonSaga();
        //game.theScrantonSaga();

        game.labyrinth(HeroCreator.createIntern());
    }
}