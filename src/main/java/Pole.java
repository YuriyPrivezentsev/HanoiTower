import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by lucky on 20.08.16.
 */
public class Pole {
    private final Deque<Disc> discs;
    private final int capacity;
    private final String poleName;

    public Pole(String name, int capacity) {
        this.capacity = capacity;
        this.discs = new ArrayDeque<>(capacity);
        poleName = name;
    }

    public void placeDisk(Disc disc){
        if(discs.size() == capacity){
            throw new IllegalStateException("You cannt place more discs on the pole " + poleName);
        }
        if(discs.size() > 0 && discs.peek().getSize() <= disc.getSize()){
            throw new IllegalStateException("You cannot place larger disc on the smaller one");
        }
        discs.push(disc);
    }

    public Disc removeDisk(){
        if (discs.size() == 0){
            throw new IllegalStateException("The pole \"" + poleName +"\" is empty");
        }
        return discs.pop();
    }

    @Override
    public String toString() {
        return poleName;
    }
}
