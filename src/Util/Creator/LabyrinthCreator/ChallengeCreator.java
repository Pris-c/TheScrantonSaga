package Util.Creator.LabyrinthCreator;

import Game.Challenge;
import Util.Creator.EntityCreator.NpcCreator;

import static Util.Strings.PlotStrings.*;

public class ChallengeCreator {

    public Challenge createChallenge1(){
        return new Challenge(NpcCreator.createMichaelLunch(), challenge1Introduction, challenge1VictoryMessage, challenge1DefeatMessage);
    }

    public Challenge createChallenge2(){
        return new Challenge(NpcCreator.createFixingPrinter(), challenge2Introduction, challenge2VictoryMessage, challenge2DefeatMessage);
    }

    public Challenge createChallenge3(){
        return new Challenge(NpcCreator.createRecoveringCustomer(), challenge3Introduction, challenge3VictoryMessage, challenge3DefeatMessage);
    }

    public Challenge createChallenge4(){
        return new Challenge(NpcCreator.createParkourChallenge(), challenge4Introduction, challenge4VictoryMessage, challenge4DefeatMessage);
    }

    public Challenge createChallenge5(){
        return new Challenge(NpcCreator.createRhMeeting(), challenge5Introduction, challenge5VictoryMessage, challenge5DefeatMessage);
    }

    public Challenge createChallenge6(){
        return new Challenge(NpcCreator.createBasketGame(), challenge6Introduction, challenge6VictoryMessage, challenge6DefeatMessage);
    }

    public Challenge createChallenge7(){
        return new Challenge(NpcCreator.createChristmasParty(), challenge7Introduction, challenge7VictoryMessage, challenge7DefeatMessage);
    }
}
