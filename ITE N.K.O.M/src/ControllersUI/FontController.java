package ControllersUI;

import java.awt.Font;

public class FontController {
    public static Font getPrimaryFont(int style, int size) {
        return new Font("Arial", style, size);
    }

    public static Font getSecondryFont(int style, int size) {
        return new Font("Roboto", style, size);
    }
}
