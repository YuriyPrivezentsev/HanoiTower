import java.security.InvalidParameterException;
import org.junit.Test;

import java.security.InvalidParameterException;

/**
 * Created by lucky on 20.08.16.
 */
public class DiscTest {
    @Test(expected = InvalidParameterException.class)
    public void discWithNegativeSize(){
        new Disc(-1);
    }
}
