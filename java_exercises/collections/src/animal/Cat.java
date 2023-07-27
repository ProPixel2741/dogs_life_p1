package animal;

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat{}" + super.toString();
    }

    @Override
    public String sayHello() {
        return "oh its you. Hello. " + getName();
    }

    @Override
    public String move() {
        return "if you insist...";
    }
}
