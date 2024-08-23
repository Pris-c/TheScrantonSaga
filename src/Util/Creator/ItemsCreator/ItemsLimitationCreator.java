package Util.Creator.ItemsCreator;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemsLimitationCreator {


    public static ArrayList<String> allHeroes(){
        return new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative", "Receptionist"));
    }

    public static ArrayList<String> internOnly() {
        return new ArrayList<>(Arrays.asList("Intern"));
    }

    public static ArrayList<String> salesOnly() {
        return new ArrayList<>(Arrays.asList("SalesRepresentative"));
    }

    public static ArrayList<String> receptionistOnly() {
        return new ArrayList<>(Arrays.asList("Receptionist"));
    }

    public static ArrayList<String> internAndSales() {
        return new ArrayList<>(Arrays.asList("Intern", "SalesRepresentative"));
    }

    public static ArrayList<String> internAndReceptionist() {
        return new ArrayList<>(Arrays.asList("Intern", "Receptionist"));
    }

    public static ArrayList<String> salesAndReceptionist() {
        return new ArrayList<>(Arrays.asList("SalesRepresentative", "Receptionist"));
    }
}
