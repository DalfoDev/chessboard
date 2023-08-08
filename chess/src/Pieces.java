import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Pieces {
    private static final String ICONS_PATH = "/Users/dominicalfonso/Desktop/chess/src/icons/";

    private static final Map<String, ImageIcon> pieceIcons = new HashMap<>();

    static {
        // Load piece icons
        char[] pieces = {'k', 'q', 'r', 'b', 'n', 'p'};
        char[] colors = {'w', 'b'};

        for (char color : colors) {
            for (char piece : pieces) {
                String fileName = color + Character.toString(piece) + ".png";
                String path = ICONS_PATH + fileName;
                ImageIcon icon = new ImageIcon(path);
                pieceIcons.put(color + Character.toString(piece), icon);
            }
        }
    }

    public static ImageIcon getPieceIcon(char color, char piece) {
        return pieceIcons.get(color + Character.toString(piece));
    }
}
