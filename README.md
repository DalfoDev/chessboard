1. **Chessboard Class:**

   The `Chessboard` class extends the `JPanel` class from the Swing library and represents a graphical representation of a chessboard. It displays alternating light and dark squares and can display chess pieces based on a given FEN (Forsyth-Edwards Notation) string.

   **Functionality:**

   - The class constructor takes a FEN string as an argument and initializes various attributes, including board size, square colors, and square size.
   - The `paintComponent` method overrides the default painting behavior and is responsible for drawing the chessboard and pieces.
   - The `drawBoard` method draws the alternating light and dark squares on the chessboard.
   - The `drawSquare` method is a helper method to draw an individual square with a given color.
   - The `drawPieces` method parses the FEN string and draws the corresponding chess pieces on the board.
   - The `main` method creates a Swing GUI window displaying the chessboard using the given FEN string.

2. **Pieces Class:**

   The `Pieces` class is a utility class responsible for loading and managing chess piece icons (images) that are used in the chessboard application.

   **Functionality:**

   - The `ICONS_PATH` constant specifies the directory path where the chess piece icon images are located.
   - The `pieceIcons` map stores `ImageIcon` objects representing the icons of different chess pieces. Icons are loaded based on color and piece type and stored with the corresponding keys.
   - The static block initializes the `pieceIcons` map by loading images for different colors and piece types.
   - The `getPieceIcon` method retrieves a specific chess piece's icon based on color and piece type.

Together, these two code snippets create a functional graphical chessboard application. The `Chessboard` class draws the board and pieces, while the `Pieces` class handles the loading and retrieval of piece icons. When you run the application, it displays a window with a chessboard layout and places the chess pieces on the board according to the provided FEN string.
