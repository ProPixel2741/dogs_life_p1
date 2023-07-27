package animal;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Dog{}" + super.toString();
    }

    @Override
    public String sayHello() {
        return "Hello!";
    }

    @Override
    public String move() {
        return "Runnn";
    }
}
