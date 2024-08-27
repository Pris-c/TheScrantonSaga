package Game.EnvironmentCreator;

import Entities.Hero;
import Game.Node;

import static Game.EnvironmentCreator.Strings.NodeStrings.*;

public class NodeCreator {

    public static Node getNodeById(int id) {
        switch (id) {
            case 1:
                return new Node(
                        1,
                        intNode1,
                        optNode1,
                        ChallengeCreator.getInstance().getById(1),
                        ChallengeCreator.getInstance().getById(2),
                        2,
                        2
                );
            case 2:
                return new Node(
                        2,
                        intNode2,
                        optNode2,
                        ChallengeCreator.getInstance().getById(3),
                        RoomCreator.getInstance().getById(1),
                        3,
                        3
                );
            case 3:
                return new Node(
                        3,
                        intNode3,
                        optNode3,
                        RoomCreator.getInstance().getById(2),
                        ChallengeCreator.getInstance().getById(5),
                        5,
                        4
                );
            case 4:
                return new Node(
                        4,
                        intNode4,
                        optNode4,
                        ChallengeCreator.getInstance().getById(6),
                        RoomCreator.getInstance().getById(3),
                        0,
                        0);
            case 5:
                return new Node(
                        5,
                        intNode4,
                        optNode4,
                        ShopkeeperCreator.getShopkeeperById(3),
                        ChallengeCreator.getInstance().getById(7),
                        0,
                        0);
            default:
                return null;
        }
    }

}
