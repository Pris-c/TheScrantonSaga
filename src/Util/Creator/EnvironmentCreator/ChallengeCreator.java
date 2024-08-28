package Util.Creator.EnvironmentCreator;


import Game.Challenge;
import Util.Creator.EntityCreator.NpcCreator;

import static Util.Strings.EnvironmentStrings.ChallengeStrings.*;

public class ChallengeCreator {

    private static ChallengeCreator instance;

    private ChallengeCreator(){}

    public static ChallengeCreator getInstance(){
        if (instance == null){
            instance = new ChallengeCreator();
        }
            return instance;
    }

    public Challenge getById(int id){
        switch (id){
            case 1:
                return new Challenge(1, intChallenge1, victoryMessageC1, defeatMessageC1, NpcCreator.createMichaelLunch());
            case 2:
                return new Challenge(2, intChallenge2, victoryMessageC2, defeatMessageC2, NpcCreator.createFixingPrinter());
            case 3:
                return new Challenge(3, intChallenge3, victoryMessageC3, defeatMessageC3, NpcCreator.createRecoveringCustomer());
            case 4:
                return new Challenge(4, intChallenge4, victoryMessageC4, defeatMessageC4, NpcCreator.createParkourChallenge());
            case 5:
                return new Challenge(5, intChallenge5, victoryMessageC5, defeatMessageC5, NpcCreator.createRhMeeting());
            case 6:
                return new Challenge(6, intChallenge6, victoryMessageC6, defeatMessageC6, NpcCreator.createBasketGame());
            case 7:
                return new Challenge(7, intChallenge7, victoryMessageC7, defeatMessageC7, NpcCreator.createChristmasParty(),true);
            default:
            return null;
        }
    }







}
