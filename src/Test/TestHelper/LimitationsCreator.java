package Test.TestHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class LimitationsCreator {

    protected static ArrayList<String> allHeroes(){
        return new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist"));
    }

    protected static ArrayList<String> internOnly() {
        return new ArrayList<>(Arrays.asList("Intern"));
    }

    protected static ArrayList<String> salesOnly() {
        return new ArrayList<>(Arrays.asList("SalesRepresentative"));
    }

    protected static ArrayList<String> receptionistOnly() {
        return new ArrayList<>(Arrays.asList("Receptionist"));
    }

    protected static ArrayList<String> internAndSales() {
        return new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative"));
    }

    protected static ArrayList<String> internAndReceptionist() {
        return new ArrayList<>(Arrays.asList("Intern", "Receptionist"));
    }

    protected static ArrayList<String> salesAndReceptionist() {
        return new ArrayList<>(Arrays.asList("SalesRepresentative", "Receptionist"));
    }

}
