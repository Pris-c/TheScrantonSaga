package Game;

import static Util.Util.*;

public class GameNode {

    private String introduction;
    private String messageToPlayer;

    public GameNode(String introduction, String messageToPlayer) {
        this.introduction = introduction;
        this.messageToPlayer = messageToPlayer;
    }

    public int run(){
        System.out.println(this.introduction);
        return readAndValidateInput(this.messageToPlayer, 1, 2);
    }

}
