# Quarto
Before starting the game the player can become familiar with the pieces below. 
* Each piece to char
* 0 - White, Big, Circle, Hollow
* 1 - White, Big, Circle, Solid
* 2 - White, Big, Square, Hollow
* 3 - White, Big, Square, Solid
* 4 - White, Small, Circle, Hollow
* 5 - White, Small, Circle, Solid
* 6 - White, Small, Square, Hollow
* 7 - White, Small, Square, Solid
* 8 - Black, Big, Circle, Hollow
* 9 - Black, Big, Circle, Solid
* 10 - Black, Big, Square, Hollow
* 11 - Black, Big, Square, Solid
* 12 - Black, Small, Circle, Hollow
* 13 - Black, Small, Circle, Solid
* 14 - Black, Small, Square, Hollow
* 15 - Black, Small, Square, Solid

Classes:
1. Board class 

This class represents the 4×4 game board and tracks placed pieces and used piece types.

Includes the following methods.

Board(Board original) – Copy constructor that duplicates another board’s state.
setPieceCount(int index) – Marks a piece as used by its index.
getTile(int index) – Returns the piece at the given board index.
setTile(int index, Piece piece) – Places a piece at the given board index.
checkIndex(int row, int col) – Validates that an index is within bounds and not occupied.
checkPiece(int pieceInt) – Ensures the piece index is valid and not already used.
isQuarto(int row, int col) – Checks if placing a piece at the given row and column creates a winning condition.

2. Piece class   

This class represents a Quarto piece and is defined by four binary features: color (white/black), size (big/small), shape (circle/square), and the presence of hole (solid/hollow). There are 16 unique pieces.

Includes the following methods.

Piece(boolean, boolean, boolean, boolean) – Creates a piece with specified attributes.
Piece(Piece) – Copy constructor.
setNamePiece() – Assigns the piece a unique name based on the first letters of its traits.
Setters/Getters – setColor(), setSize(), setShape(), setHole(), and their corresponding get methods retrieve or update attributes.
getNameOfPiece() – Returns the piece's enum-based name.
makePiece(int) – Static method to create a piece by its index (0–15).
toInt(Piece) – Static method that converts a Piece object to its corresponding index.
haveCommonAttribute(Piece, ..., Piece) – Static method that checks if four pieces share any one common attribute. This is used to detect the winner.
Overrides toString() method.

3. Player class

This class handles user input for choosing a piece and a tile during gameplay.

Includes the following methods

choosePiece(Board board, IOHandler io) - Asks the player to choose an unused piece (0–15). Validates input and ensures the piece hasn't already been used. Returns the piece index.
chooseTile(Board board, IOHandler io)  - Asks the player to choose a board position . Validates input and ensures the tile is empty and within board bounds. Returns the tile index.

4. RandomPlayer Class 

This class is a child class of Player base class. Represents a player that selects moves randomly.

Includes the following overridden methods from Player Class. 

choosePiece(Board board, IOHandler io) - Randomly selects a proper, unused piece. Retries until a valid choice is made. Displays the traits of chosen pieces.
chooseTile(Board board, IOHandler io) - Randomly selects an empty tile on the board. Retries until a valid tile is found and returns its index.

5. SoloGame Class
This is the first child class of the Game class. Represents a solo Quarto game where the player competes against a random player. The game alternates turns until a "Quarto" is achieved.
Includes the following methods:

SoloGame(IOHandler ioHandler): Initializes the game, setting Player 1 as the human player and Player 2 as a RandomPlayer.
Overrides play() method from the Game class.
play(): Runs the game loop, alternating turns between the player and computer, placing pieces on the board, and checking for a winner.

6. DuelGame Class 
This is the second child class of the Game class.  Represents a two-player Quarto game. Players alternate turns to choose pieces and tiles. The game continues until one player wins.

Includes the following methods:

DuelGame(IOHandler ioHandler) - Initializes the game with two players, using the provided IOHandler.
Overrides play() method from the Game class.
play() -  The main game loop where players take turns to choose a piece and a tile. The game checks for a "Quarto" after each move and declares a winner.


7. Adventurous Class 
The AdventurousGame is the last child class of the Game class. This represents a two-player Quarto game with additional "star" logic. Players take turns choosing pieces and tiles, with some tiles containing a "star" that allows changing a piece's trait.

Includes the following methods:

AdventurousGame(IOHandler ioHandler) - Initializes the game, setting up a custom StarBoard and two players.
getBoard() - Returns the current game board as a StarBoard.
Overrides play() method from the Game class. 
play() - Main game loop where players alternate turns, selecting pieces and tiles. When a tile contains a star, players can change the piece's trait. The game checks for a "Quarto" and announces a winner.

8. StarBoaard Class 
The StarBoard class extends the Board class to implement a Quarto board with special "star" tiles. These tiles allow for changing a piece's trait when it is being used. The game randomly assigns star tiles to the board at the beginning.
Contains a constant STARNUMBER, which represents the number of star tiles on the board (is equal to 4).

Includes the following methods:

StarBoard() - Constructor that initializes the board with random star tiles. The tiles array holds the current pieces, while starArray tracks which tiles have stars.
StarBoard(StarBoard original) - Copy constructor that creates a new StarBoard based on an existing one, copying both tiles and star positions.
hasStar(int index) - Checks if the tile at the given index has a star.
Overridden methods from Board class:
setTile(int index, Piece piece) - Sets a tile at the given index and converts it into a ChangeablePiece.
getTile(int index) - Returns the ChangeablePiece at the specified index.

9. BoardTerminalPrinter Class 
Provides a utility for displaying the Board (including its tiles and pieces) in a readable format on the terminal.

Includes the following method:

printBoard(Board board) - Prints the current state of the given Board object in a grid layout with row and column indices. Displays null tiles as empty. Shows piece names (via getNameOfPiece()) in their respective positions. Handles both standard and extended boards as long as they extend the Board.

10. StarBoardTerminalPrinter Class
Provides a utility method to print the current state of a StarBoard in a user-friendly terminal format.

Includes the following methods:

printBoard(StarBoard starBoard) - Prints the 4x4 StarBoard, including all placed ChangeablePiece instances in a grid layout with row and column numbers. Empty tiles are shown as blank. Placed tiles display the name of the piece. Stars are not visually marked but affect gameplay.

11. TerminalIOHandler Class
Implements: IOHandler interface
Purpose: Handles user interaction via the terminal — input, output, and board display.

Includes the following overridden methods:

showMessage(String message) - Displays a message to the user via standard output.
getInput(String prompt) - Prompts the user with a message and reads input from the terminal.
showBoard(Board board) - Prints the game board to the terminal. Automatically detects if the board is a StarBoard and uses StarBoardTerminalPrinter or BoardTerminalPrinter.

12. IOHandler Interface
The IOHandler interface defines the contract for input/output operations used in the Quarto game. It allows different implementations (terminal-based and GUI) to interact with the game logic in a consistent way.

Includes the following methods

showMessage(String message) - Displays a message to the user.
getInput(String prompt ) - Asks the user for input and returns the entered string.
showBoard(Board board) - Displays the current state of the game board.

13. Gameable Interface
The Gameable interface defines the basic structure for any playable game mode.
Include the following methods:
void play() - Starts and runs the game logic. Classes which implement this method define how the game is played.

14. ChangeablePiece Class
The ChangeablePiece class extends the Piece class and allows modifying a piece's traits during gameplay. It is used specifically in game modes where piece traits can change (e.g. in AdventurousGame).

Constructors:

ChangeablePiece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow) - 
Creates a piece with specific traits.
ChangeablePiece(Piece piece) -  Creates a changeable copy of a given Piece.

Includes the following methods:

changeTrait(String traitName) - Changes a specific trait (COLOR, SIZE, SHAPE, HOLE) of the piece. Throws TraitNotFoundException if the trait name is invalid.
ChangeablePiece fromPiece(Piece piece) - Converts a Piece to a ChangeablePiece.

15) Game Class
An abstract base class for all game modes. It manages players, board, turn logic, and defines the abstract play() method implemented by specific game types.

Includes the following mehtods:

Game(IOHandler ioHandler) – Constructor that initializes two players, a board, and sets Player 1 to start. Uses the given IO handler.
getPlayer1() / getPlayer2() – Return the respective player objects.
setPlayer1(Player) / setPlayer2(Player) – Set custom Player 1 or Player 2.
getPlayer1Turn() – Returns true if it’s Player 1’s turn.
changePlayer1Turn() – Toggles the current turn between players.

Overridden methods:

getBoard() – Returns the current board instance.
setBoard(Board) – Sets the board; uses StarBoard copy constructor if applicable, otherwise a regular board copy.
play() – Abstract method to be implemented in game mode subclasses, defining gameplay logic.

16. Main Class 

This is the entry point of the Quarto game application. It accepts a command-line argument to determine the type of  interface.  The user is then prompted to select a game mode:Duel Game (two-player), Solo Game (player vs Random generator), Adventurous Game (special game). Based on the selection, the appropriate game mode is instantiated and started using the play() method.


Exceptions of Quarto Game
1. NonEmptyTileException
Thrown when trying to perform an action on a tile that is already occupied.
Constructors:
Default: "Tile is not empty"
Custom message: Accepts a custom string message.


2. NoSuchPieceException
Thrown when a piece that doesn't exist is referenced.
Constructors:
Default: "No such piece found."
Custom message: Accepts a custom string message.


3. PieceRepeatException
Thrown when a piece is repeatedly selected.
Constructors:
Default: "Piece is repeating"
Custom message: Accepts a custom string message.


4. PositionOutOfBoardException
Thrown when a move is attempted outside the valid bounds of the board.
Constructors:
Default: "Position out of board exception"
Custom message: Accepts a custom string message.


5. TraitNotFoundException
Thrown when an invalid or non-existent trait is referenced.
Constructors:
Default: "Trait is not found exception"
Custom message: Accepts a custom string message.

