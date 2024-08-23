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
}
