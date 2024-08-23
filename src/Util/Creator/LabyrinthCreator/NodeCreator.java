package Util.Creator.LabyrinthCreator;

import Game.GameNode;

import static Util.Strings.PlotStrings.node1Introduction;
import static Util.Strings.PlotStrings.node1Options;

public class NodeCreator {

    public GameNode createNode1() {
        return new GameNode(
                node1Introduction,
                node1Options
        );
    }

}
