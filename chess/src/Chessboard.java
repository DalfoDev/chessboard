import javax.swing.*;
import java.awt.*;

public class Chessboard extends JPanel {
    private final int boardSize = 640; // Change this variable to adjust the board size (make it a multiple of 8)
    private final Color lightSquareColor = Color.decode("#f0d9b5");
    private final Color darkSquareColor = Color.decode("#b58863");
    private final int squareSize;
    private String fen;

    public Chessboard(String fen) {
        this.fen = fen;
        squareSize = boardSize / 8;
        setPreferredSize(new Dimension(boardSize, boardSize));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPieces(g);
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                int x = col * squareSize;
                int y = row * squareSize;
                Color squareColor = (row + col) % 2 == 0 ? lightSquareColor : darkSquareColor;
                drawSquare(g, x, y, squareColor);
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x, y, squareSize, squareSize);
    }

    private void drawPieces(Graphics g) {
        if (fen == null || fen.isEmpty()) return;

        String[] rows = fen.split("/");
        for (int row = 0; row < 8; row++) {
            int yOffset = row * squareSize;
            int xOffset = 0;
            for (char c : rows[row].toCharArray()) {
                if (Character.isDigit(c)) {
                    xOffset += Character.getNumericValue(c) * squareSize;
                } else {
                    char color = Character.isUpperCase(c) ? 'w' : 'b';
                    char piece = Character.toLowerCase(c);
                    ImageIcon icon = Pieces.getPieceIcon(color, piece);
                    if (icon != null) {
                        g.drawImage(icon.getImage(), xOffset, yOffset, squareSize, squareSize, null);
                    }
                    xOffset += squareSize;
                }
            }
        }
    }

    public static void main(String[] args) {
        String fenString = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Chessboard");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setUndecorated(true);
            frame.add(new Chessboard(fenString));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
