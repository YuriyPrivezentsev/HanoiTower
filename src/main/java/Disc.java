import lombok.Getter;

import java.security.InvalidParameterException;

/**
 * Created by lucky on 20.08.16.
 */
@Getter
public final class Disc {
    private final int size;

    public Disc(int size) {
        if(size < 0){
            throw new InvalidParameterException("The disc size cannot be negative");
        }
        this.size = size;
    }

    @Override
    public String toString() {
        return "Disc{" + size + '}';
    }
}
