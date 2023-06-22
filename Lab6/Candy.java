package Lab6;

public class Candy {
    private String name;
    private double weight;

    @Override
    public boolean equals(Object obj) {
        return obj.toString().equals(toString());
    }

    public Candy(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + ", " + this.getClass().getSimpleName() + ", "+ weight + " grams.";
    }
}
