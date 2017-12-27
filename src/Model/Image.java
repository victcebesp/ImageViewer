package Model;

import java.io.FileNotFoundException;
import java.io.InputStream;

public interface Image {
    byte[] bitmap();
    Image next();
    Image prev();
}
