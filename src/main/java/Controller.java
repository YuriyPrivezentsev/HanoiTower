import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucky on 22.08.16.
 */
public class Controller {

    public static final int POLE_COUNT = 3;
    private static int counter = 0;

    public static void main(String[] args) {
        final int size = 5;
        List<Pole> poles = new ArrayList<>(size);

        for(int i = 1; i <= POLE_COUNT; i++){
            poles.add(new Pole("Pole #" + i, size));
        }

        for(int i = size; i > 0; i--){
            poles.get(0).placeDisk(new Disc(i));
        }

        move(poles.get(0), poles.get(1), poles.get(2), size);
        System.out.println("steps = " + counter);
    }

    private static void move(Pole source, Pole medium, Pole target, int numerOfDisks) {
        if(numerOfDisks == 1){
            moveDisk(source, target);
        } else {
            move(source, target, medium, numerOfDisks - 1);
            moveDisk(source, target);
            move(medium, source, target, numerOfDisks - 1);
        }
    }

    private static void moveDisk(Pole source, Pole target) {
        Disc disc = source.removeDisk();
        System.out.println("Move " + disc +": " + source + " -> " + target);
        target.placeDisk(disc);
        counter++;
    }

}
