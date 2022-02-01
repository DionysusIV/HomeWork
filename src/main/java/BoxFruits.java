import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxFruits<T extends Fruit> {
    private List<T> container;

    public BoxFruits(List<T> container) {
        this.container = new ArrayList<>();
    }

    public BoxFruits(T... fruits){
        this.container = new ArrayList(Arrays.asList(fruits));
    }

    public float getWeight(){
        float w = 0.0f;
        for (T fruit : container){
            w += fruit.getWeight();
        }
        return w;
    }

    public boolean sameAvg(BoxFruits<?>another){
        return Math.abs(this.getWeight()-another.getWeight()) < 0.01;
    }

    public void transfer(BoxFruits<? super T> another){
        if (another == this){
            return;
        }
        another.container.addAll(this.container);
        this.container.clear();
    }
    public void add(T fruit){
        container.add(fruit);
    }
}
