package Test;

import static Util.Util.readAndValidateInput;

public class UtilTest {

    public static void main(String[] args) {


        int test1 = readAndValidateInput("Validando 0 a 3", 0, 3);
        if (test1 >= 0 && test1 <=3){
            System.out.println("readAndValidadeInput funcionou para limite inferior = 0 e limite superior = 3");
        }
        int test2 = readAndValidateInput("Validando 1 a 3", 1, 3);
        if (test2 >= 1 && test1 <=3){
            System.out.println("readAndValidadeInput funcionou para limite inferior = 1 e limite superior = 3");
        }


    }
}
