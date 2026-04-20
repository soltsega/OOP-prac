package googleClassroom;

/**
 * Demonstrates inheritance, method overriding, and dynamic method dispatch
 * using examples of Ethiopian natural heritage sites.
 */
public class EthiopianHeritage {
    public static void main(String[] args) {
        System.out.println("Ethiopian Natural Heritage");
        System.out.println();

        NaturalHeritage[] heritages = {
            new SimienMountains(), // this is intended for one time use, so we can directly create an instance of SimienMountains
            new DanakilDepression()
        };

        for (NaturalHeritage heritage : heritages) {
            heritage.showInfo();
            System.out.println();
        }
    }
}

class Heritage {
    protected final String name;  //we made this one protected so that it can be accessed by subclasses
    protected final String description;

    // constructor to initialize the name and description of the heritage site
    public Heritage(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // method to display information about the heritage site. Generic implementation that can be overridden by subclasses for more specific details.
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }
}


class NaturalHeritage extends Heritage {
    private final String naturalFeature;

    public NaturalHeritage(String name, String description, String naturalFeature) {
        super(name, description);
        this.naturalFeature = naturalFeature;
    }

    @Override
    public void showInfo() {
        System.out.println("Natural Heritage Site");
        super.showInfo();
        System.out.println("Natural Feature: " + naturalFeature);
    }
}

class SimienMountains extends NaturalHeritage {
    public SimienMountains() {
        super(
            "Simien Mountains",
            "A UNESCO World Heritage site known for dramatic cliffs, deep valleys, and rare wildlife.",
            "Mountain range"
        );
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Regional Highlight: Home to the Gelada baboon and Walia ibex.");
    }
}

class DanakilDepression extends NaturalHeritage {
    public DanakilDepression() {
        super(
            "Danakil Depression",
            "One of the hottest places on Earth, famous for colorful mineral deposits and active geology.",
            "Geological depression"
        );
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Regional Highlight: Known for salt flats, volcanoes, and hydrothermal fields.");
    }
}