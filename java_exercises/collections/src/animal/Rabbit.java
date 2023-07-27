package animal;

public class Rabbit extends Animal {
    @Override
    public String toString() {
        return "Rabbit{}" + super.toString();
    }

    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public String sayHello() {
        return "Snuffle";
    }

    @Override
    public String move() {
        return "Hop Hop Hop";
    }
}
