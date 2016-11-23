import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lucky on 20.08.16.
 */
public class PoleTest {
    @Test
    public void placeDisksInARow(){
        Pole pole = new Pole("Test", 3);
        for (int i = 3; i > 0; i--){
            pole.placeDisk(new Disc(i));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void placeMoreDiscs(){
        Pole pole = new Pole("Test", 3);
        for (int i = 4; i > 0; i--){
            pole.placeDisk(new Disc(i));
        }
    }

    @Test(expected = IllegalStateException.class)
    public void placeLargerDiscOnSmaller(){
        Pole pole = new Pole("Test", 3);
        pole.placeDisk(new Disc(2));
        pole.placeDisk(new Disc(4));
    }

    @Test(expected = IllegalStateException.class)
    public void removeFromEmptyPole(){
        Pole pole = new Pole("Test", 3);
        pole.removeDisk();
    }

    @Test
    public void removeLastPlacedDisk(){
        Pole pole = new Pole("Test", 3);
        pole.placeDisk(new Disc(2));
        Disc expected = new Disc(1);
        pole.placeDisk(expected);
        Disc actual = pole.removeDisk();
        assertEquals(expected.getSize(), actual.getSize());
    }
}
