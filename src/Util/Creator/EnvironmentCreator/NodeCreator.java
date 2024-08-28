package Util.Creator.EnvironmentCreator;

import Game.Node;

import java.util.ArrayList;
import java.util.List;

import static Util.Strings.EnvironmentStrings.NodeStrings.*;

public class NodeCreator {

    public static Node getNodeById(int id) {
        switch (id) {
            case 1:
                return new Node(
                        1,
                        intNode1,
                        optNode1,
                        new ArrayList<>(List.of(ChallengeCreator.getInstance().getById(1))),
                        new ArrayList<>(List.of(
                                ChallengeCreator.getInstance().getById(2),
                                ChallengeCreator.getInstance().getById(1))),
                        2,
                        2
                );
            case 2:
                return new Node(
                        2,
                        intNode2,
                        optNode2,
                        new ArrayList<>(List.of(
                                ChallengeCreator.getInstance().getById(3),
                                ShopkeeperCreator.getShopkeeperById(2))),
                        new ArrayList<>(List.of(
                                RoomCreator.getInstance().getById(1),
                                ChallengeCreator.getInstance().getById(3),
                                ShopkeeperCreator.getShopkeeperById(2))),
                        3,
                        3
                );
            case 3:
                return new Node(
                        3,
                        intNode3,
                        optNode3,
                        new ArrayList<>(List.of(
                                RoomCreator.getInstance().getById(2),
                                ChallengeCreator.getInstance().getById(4),
                                ChallengeCreator.getInstance().getById(6))),
                        new ArrayList<>(List.of(
                                ChallengeCreator.getInstance().getById(5))),
                        5,
                        4
                );
            case 4:
                return new Node(
                        4,
                        intNode4,
                        optNode4,
                        new ArrayList<>(List.of(
                                ChallengeCreator.getInstance().getById(6))),
                        new ArrayList<>(List.of(
                                RoomCreator.getInstance().getById(3),
                                ChallengeCreator.getInstance().getById(6))),
                        5,
                        5);
            case 5:
                return new Node(
                        5,
                        intNode5,
                        optNode5,
                        new ArrayList<>(List.of(
                                ShopkeeperCreator.getShopkeeperById(3),
                                ChallengeCreator.getInstance().getById(7))),
                        new ArrayList<>(List.of(
                                ChallengeCreator.getInstance().getById(7))),
                        0,
                        0);
            default:
                return null;
        }
    }

}
