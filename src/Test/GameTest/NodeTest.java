package Test.GameTest;

import Util.Creator.EnvironmentCreator.NodeCreator;
import Game.Node;
import Test.TestHelper.HeroCreator;

public class NodeTest {

    public static void main(String[] args) {

        Node node1 = NodeCreator.getInstance().getNodeById(1);
        Node node2 = NodeCreator.getInstance().getNodeById(2);
        Node node3 = NodeCreator.getInstance().getNodeById(3);
        Node node4 = NodeCreator.getInstance().getNodeById(4);
        Node node5 = NodeCreator.getInstance().getNodeById(5);

        System.out.println("NODE 1");
        System.out.println("Next node1: " + node1.run(HeroCreator.createIntern()));
        System.out.println();


        System.out.println("NODE 2");
        System.out.println("Next node2: " + node2.run(HeroCreator.createSalesRepresentative()));
        System.out.println();


        System.out.println("NODE 3");
        System.out.println("Next node3: " + node3.run(HeroCreator.createReceptionist()));
        System.out.println();


        System.out.println("NODE 4");
        System.out.println("Next node4: " + node4.run(HeroCreator.createIntern()));
        System.out.println();


        System.out.println("NODE 5");
        System.out.println("Next node5: " + node5.run(HeroCreator.createIntern()));
        System.out.println();

    }

}
