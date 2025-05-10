package am.aua.quarto.core;


//Each piece to char
//0 - White, Big, Circle, Hollow
//1 - White, Big, Circle, Solid
//2 - White, Big, Square, Hollow
//3 - White, Big, Square, Solid
//4 - White, Small, Circle, Hollow
//5 - White, Small, Circle, Solid
//6 - White, Small, Square, Hollow
//7 - White, Small, Square, Solid
//8 - Black, Big, Circle, Hollow
//9 - Black, Big, Circle, Solid
//10 - Black, Big, Square, Hollow
//11 - Black, Big, Square, Solid
//12 - Black, Small, Circle, Hollow
//13 - Black, Small, Circle, Solid
//14 - Black, Small, Square, Hollow
//15 - Black, Small, Square, Solid

/**
 * Represents a Quarto game piece characterized by four binary traits:
 */
public class Piece {

    /**
     * Enum representing the 16 unique piece names based on their traits.
     */
    public enum NameOfPiece {WBCS, WBCH, WBSS, WBSH, WSCS, WSCH, WSSS, WSSH, BBCS, BBCH, BBSS, BBSH, BSCS, BSCH, BSSS, BSSH}

    ;

    /**
     * Enum for the color trait.
     */
    public enum Color {WHITE, BLACK}

    ;

    /**
     * Enum for the size trait.
     */
    public enum Size {BIG, SMALL}

    ;

    /**
     * Enum for the shape trait.
     */
    public enum Shape {CIRCLE, SQUARE}

    ;

    /**
     * Enum for the hole trait.
     */
    public enum Hole {SOLID, HOLLOW}

    ;

    private Color color;
    private Size size;
    private Shape shape;
    private Hole hole;
    private NameOfPiece nameOfPiece;

    /**
     * Constructs a piece with specified traits.
     *
     * @param isWhite  true if the piece is white, false if black
     * @param isBig    true if the piece is big, false if small
     * @param isCircle true if the piece is circular, false if square
     * @param isHollow true if the piece is hollow, false if solid
     */
    public Piece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow) {
        this.color = isWhite ? Color.WHITE : Color.BLACK;
        this.size = isBig ? Size.BIG : Size.SMALL;
        this.shape = isCircle ? Shape.CIRCLE : Shape.SQUARE;
        this.hole = isHollow ? Hole.HOLLOW : Hole.SOLID;
        setNamePiece();
    }

    /**
     * Copy constructor for Piece.
     *
     * @param piece the piece to copy
     */
    public Piece(Piece piece) {
        if (piece != null) {
            this.color = piece.color;
            this.size = piece.size;
            this.shape = piece.shape;
            this.hole = piece.hole;
            setNamePiece();
        }
    }

    /**
     * Derives the unique enum name for the piece based on its traits.
     */
    public void setNamePiece() {
        String name = "";
        if (this.color.equals(Color.WHITE))
            name += "W";
        else
            name += "B";
        if (this.size.equals(Size.BIG))
            name += "B";
        else
            name += "S";
        if (this.shape.equals(Shape.CIRCLE))
            name += "C";
        else
            name += "S";
        if (this.hole.equals(Hole.SOLID))
            name += "S";
        else
            name += "H";
        this.nameOfPiece = NameOfPiece.valueOf(name);
    }

    // Setters
    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setHole(Hole hole) {
        this.hole = hole;
    }

    // Getters
    public Color getColor() {
        return this.color;
    }

    public Size getSize() {
        return this.size;
    }

    public Shape getShape() {
        return this.shape;
    }

    public Hole getHole() {
        return this.hole;
    }

    public NameOfPiece getNameOfPiece() {
        return this.nameOfPiece;
    }

    /**
     * Returns a string representation of the piece's traits.
     */
    public String toString() {
        return this.getColor() + ", " + this.getSize() + ", " + this.getShape() + ", " +
                this.getHole();
    }

    /**
     * Creates a piece from its integer index (0 to 15), mapping to a unique trait combination.
     *
     * @param pieceInt index of the piece
     * @return a new Piece object, or null if the index is invalid
     */
    public static Piece makePiece(int pieceInt) {
        switch (pieceInt) {
            case 0:
                return new Piece(true, true, true, true);
            case 1:
                return new Piece(true, true, true, false);
            case 2:
                return new Piece(true, true, false, true);
            case 3:
                return new Piece(true, true, false, false);
            case 4:
                return new Piece(true, false, true, true);
            case 5:
                return new Piece(true, false, true, false);
            case 6:
                return new Piece(true, false, false, true);
            case 7:
                return new Piece(true, false, false, false);
            case 8:
                return new Piece(false, true, true, true);
            case 9:
                return new Piece(false, true, true, false);
            case 10:
                return new Piece(false, true, false, true);
            case 11:
                return new Piece(false, true, false, false);
            case 12:
                return new Piece(false, false, true, true);
            case 13:
                return new Piece(false, false, true, false);
            case 14:
                return new Piece(false, false, false, true);
            case 15:
                return new Piece(false, false, false, false);
            default:
                return null;
        }
    }

    /**
     * Converts a piece to its corresponding integer representation.
     *
     * @param piece the piece to convert
     * @return integer ID of the piece
     */
    public static int toInt(Piece piece) {
        switch (piece.getNameOfPiece()) {
            case NameOfPiece.WBCH:
                return 0;
            case NameOfPiece.WBCS:
                return 1;
            case NameOfPiece.WBSH:
                return 2;
            case NameOfPiece.WBSS:
                return 3;
            case NameOfPiece.WSCH:
                return 4;
            case NameOfPiece.WSCS:
                return 5;
            case NameOfPiece.WSSH:
                return 6;
            case NameOfPiece.WSSS:
                return 7;
            case NameOfPiece.BBCH:
                return 8;
            case NameOfPiece.BBCS:
                return 9;
            case NameOfPiece.BBSH:
                return 10;
            case NameOfPiece.BBSS:
                return 11;
            case NameOfPiece.BSCH:
                return 12;
            case NameOfPiece.BSCS:
                return 13;
            case NameOfPiece.BSSH:
                return 14;
            case NameOfPiece.BSSS:
                return 15;
            default:
                return 0;
        }
    }

    /**
     * Determines whether four pieces share any common trait.
     *
     * @param piece1 first piece
     * @param piece2 second piece
     * @param piece3 third piece
     * @param piece4 fourth piece
     * @return true if all pieces share a common trait, false otherwise
     */
    public static boolean haveCommonAttribute(Piece piece1, Piece piece2, Piece piece3, Piece piece4) {
        if (piece1 == null || piece2 == null || piece3 == null || piece4 == null)
            return false;
        if (piece1.getColor() == Color.WHITE && piece2.getColor() == Color.WHITE && piece3.getColor() == Color.WHITE && piece4.getColor() == Color.WHITE)
            return true;
        if (piece1.getColor() == Color.BLACK && piece2.getColor() == Color.BLACK && piece3.getColor() == Color.BLACK && piece4.getColor() == Color.BLACK)
            return true;
        if (piece1.getSize() == Size.BIG && piece2.getSize() == Size.BIG && piece3.getSize() == Size.BIG && piece4.getSize() == Size.BIG)
            return true;
        if (piece1.getSize() == Size.SMALL && piece2.getSize() == Size.SMALL && piece3.getSize() == Size.SMALL && piece4.getSize() == Size.SMALL)
            return true;
        if (piece1.getShape() == Shape.CIRCLE && piece2.getShape() == Shape.CIRCLE && piece3.getShape() == Shape.CIRCLE && piece4.getShape() == Shape.CIRCLE)
            return true;
        if (piece1.getShape() == Shape.SQUARE && piece2.getShape() == Shape.SQUARE && piece3.getShape() == Shape.SQUARE && piece4.getShape() == Shape.SQUARE)
            return true;
        if (piece1.getHole() == Hole.SOLID && piece2.getHole() == Hole.SOLID && piece3.getHole() == Hole.SOLID && piece4.getHole() == Hole.SOLID)
            return true;
        if (piece1.getHole() == Hole.HOLLOW && piece2.getHole() == Hole.HOLLOW && piece3.getHole() == Hole.HOLLOW && piece4.getHole() == Hole.HOLLOW)
            return true;
        return false;
    }
}