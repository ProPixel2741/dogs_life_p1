import animal.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Cat c1 = new Cat("Whiskers", 10);
        Cat c2 = new Cat("Midas", 8);
        Dog d = new Dog("Spot", 2);
        Rabbit r = new Rabbit("Peter", 2);
        Rabbit r2 = new Rabbit("Cottontail", 3);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(c1);
        animals.add(c2);
        animals.add(d);
        animals.add(r);
        animals.add(r2);
        for (int i = 0; i < animals.size(); i++) {
            System.out.println(animals.get(i));
        }

        HashMap<String, Animal> animalHashMap = new HashMap<>();
        animalHashMap.put(c1.getName(), c1);
        animalHashMap.put(c2.getName(), c2);
        animalHashMap.put(d.getName(), d);
        animalHashMap.put(r.getName(), r);
        animalHashMap.put(r2.getName(), r2);


        HashMap<Animal, String> animalStringHashMap = new HashMap<>();
        animalStringHashMap.put(c1, "Fluffy");
        animalStringHashMap.put(c2, "Doesnt like being picked up");
        animalStringHashMap.put(d, "Runs a lot");
        animalStringHashMap.put(r, "may be sick");
        animalStringHashMap.put(r2, "may be evil");

        for (String key : animalHashMap.keySet()) {
            System.out.println("key: " + key + " value: " + animalHashMap.get(key));
        }

        HashSet<Animal> set = new HashSet<>();
        set.addAll(animals);
        set.add(c1);

        Iterator<Animal> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}