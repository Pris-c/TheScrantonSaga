package Util.Creator.EnvironmentCreator;


import Game.Challenge;
import Util.Creator.EntityCreator.NpcCreator;

import static Util.Strings.EnvironmentStrings.ChallengeStrings.*;

/**
 * A utility class for centralize the creation of Challenge instances.
 */
public class ChallengeCreator {

    private static ChallengeCreator instance;

    private ChallengeCreator() {
    }

    public static ChallengeCreator getInstance() {
        if (instance == null) {
            instance = new ChallengeCreator();
        }
        return instance;
    }

    public Challenge getById(int id) {
        switch (id) {
            case 1:
                return new Challenge(1, intChallenge1, victoryMessageC1, defeatMessageC1, NpcCreator.createMichaelLunch(), 2);
            case 2:
                return new Challenge(2, intChallenge2, victoryMessageC2, defeatMessageC2, NpcCreator.createFixingPrinter(), getById(1));
            case 3:
                return new Challenge(3, intChallenge3, victoryMessageC3, defeatMessageC3, NpcCreator.createRecoveringCustomer(), ShopkeeperCreator.getInstance().getShopkeeperById(2));
            case 4:
                return new Challenge(4, intChallenge4, victoryMessageC4, defeatMessageC4, NpcCreator.createParkourChallenge(), getById(6));
            case 5:
                return new Challenge(5, intChallenge5, victoryMessageC5, defeatMessageC5, NpcCreator.createRhMeeting(), 4);
            case 6:
                return new Challenge(6, intChallenge6, victoryMessageC6, defeatMessageC6, NpcCreator.createBasketGame(), 5);
            case 7:
                return new Challenge(7, intChallenge7, victoryMessageC7, defeatMessageC7, NpcCreator.createChristmasParty(), 0);
            default:
                return null;
        }
    }


}
