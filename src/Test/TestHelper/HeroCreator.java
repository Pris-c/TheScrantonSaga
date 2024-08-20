package Test.TestHelper;

import Entities.Intern;
import Entities.Receptionist;
import Entities.SalesRepresentative;

public class HeroCreator {

    public static Intern createIntern() {
        return new Intern("José", 100, 10, 50);
    }

    public static SalesRepresentative createSalesRepresentative() {
        return new SalesRepresentative("Jéssica", 120, 12, 75);
    }

    public static Receptionist createReceptionist() {
        return new Receptionist("Diego", 110, 11, 60);
    }
}
