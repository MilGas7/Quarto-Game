/**
 * Each piece to char
 * 1 - White, Big, Circle, With
 * 2 - White, Big, Circle, Without
 * 3 - White, Big, Square, With
 * 4 - White, Big, Square, Without
 * 5 - White, Small, Circle, With
 * 6 - White, Small, Circle, Without
 * 7 - White, Small, Square, With
 * 8 - White, Small, Square, Without
 * 9 - Black, Big, Circle, With
 * 10 - Black, Big, Circle, Without
 * 11 - Black, Big, Square, With
 * 12 - Black, Big, Square, Without
 * 13 - Black, Small, Circle, With
 * 14 - Black, Small, Circle, Without
 * 15 - Black, Small, Square, With
 * 16 - Black, Small, Square, Without
 */

public class Piece {
    enum NameOfPiece {WBCX, WBCO, WBSX, WBSO, WSCX, WSCO, WSSX, WSSO, BBCX, BBCO, BBSX, BBSO, BSCX, BSCO, BSSX, BSSO};
    enum Color {WHITE, BLACK};
    enum Size {BIG, SMALL};
    enum Shape {CIRCLE, SQUARE};
    enum Hole {WITH, WITHOUT};

    private Color color;
    private Size size;
    private Shape shape;
    private Hole hole;
    private NameOfPiece nameOfPiece;

    public Piece(boolean isWhite, boolean isBig, boolean isCircle, boolean isWithHole){
        this.color = isWhite ? Color.WHITE : Color.BLACK;
        this.size = isBig ? Size.BIG : Size.SMALL;
        this.shape = isCircle ? Shape.CIRCLE : Shape.SQUARE;
        this.hole = isWithHole ? Hole.WITH : Hole.WITHOUT;
        setNamePiece();
    }

    public Piece(Piece piece){
        if(piece != null){
            this.color = piece.color;
            this.size = piece.size;
            this.shape = piece.shape;
            this.hole = piece.hole;
            setNamePiece();
        }
    }

    private void setNamePiece() {
        String name = "";
        if(this.color.equals(Color.WHITE))
            name += "W";
        else
            name += "B";
        if(this.size.equals(Size.BIG))
            name += "B";
        else
            name += "S";
        if(this.shape.equals(Shape.CIRCLE))
            name += "C";
        else
            name += "S";
        if(this.hole.equals(Hole.WITH))
            name += "O";
        else
            name += "X";
        this.nameOfPiece = NameOfPiece.valueOf(name);
    }

    public Color getColor(){
        return this.color;
    }

    public Size getSize(){
        return this.size;
    }

    public Shape getShape(){
        return this.shape;
    }

    public Hole getHole(){
        return this.hole;
    }

    public NameOfPiece getNameOfPiece(){ return this.nameOfPiece; }

    public String toString(){
        return this.getColor() + ", " + this.getSize() + ", " + this.getShape() + ", " +
                this.getHole() + " HOLE";
    }

    public static Piece makePiece (int pieceInt) {
        switch (pieceInt) {
            case 1:
                return new Piece(true, true, true, true);
            case 2:
                return new Piece(true, true, true, false);
            case 3:
                return new Piece(true, true, false, true);
            case 4:
                return new Piece(true, true, false, false);
            case 5:
                return new Piece(true, false, true, true);
            case 6:
                return new Piece(true, false, true, false);
            case 7:
                return new Piece(true, false, false, true);
            case 8:
                return new Piece(true, false, false, false);
            case 9:
                return new Piece(false, true, true, true);
            case 10:
                return new Piece(false, true, true, false);
            case 11:
                return new Piece(false, true, false, true);
            case 12:
                return new Piece(false, true, false, false);
            case 13:
                return new Piece(false, false, true, true);
            case 14:
                return new Piece(false, false, true, false);
            case 15:
                return new Piece(false, false, false, true);
            case 16:
                return new Piece(false, false, false, false);
            default:
                return null;
        }
    }

    public static boolean haveCommonAttribute (Piece piece1, Piece piece2, Piece piece3, Piece piece4){
        if(piece1 == null || piece2 == null || piece3 == null || piece4 == null)
            return false;
        if(piece1.getColor() == Color.WHITE && piece2.getColor() == Color.WHITE && piece3.getColor() == Color.WHITE && piece4.getColor() == Color.WHITE)
            return true;
        if(piece1.getColor() == Color.BLACK && piece2.getColor() == Color.BLACK && piece3.getColor() == Color.BLACK && piece4.getColor() == Color.BLACK)
            return true;
        if(piece1.getSize() == Size.BIG && piece2.getSize() == Size.BIG && piece3.getSize() == Size.BIG && piece4.getSize() == Size.BIG)
            return true;
        if(piece1.getSize() == Size.SMALL && piece2.getSize() == Size.SMALL && piece3.getSize() == Size.SMALL && piece4.getSize() == Size.SMALL)
            return true;
        if(piece1.getShape() == Shape.CIRCLE && piece2.getShape() == Shape.CIRCLE && piece3.getShape() == Shape.CIRCLE && piece4.getShape() == Shape.CIRCLE)
            return true;
        if(piece1.getShape() == Shape.SQUARE && piece2.getShape() == Shape.SQUARE && piece3.getShape() == Shape.SQUARE && piece4.getShape() == Shape.SQUARE)
            return true;
        if(piece1.getHole() == Hole.WITH && piece2.getHole() == Hole.WITH && piece3.getHole() == Hole.WITH && piece4.getHole() == Hole.WITH)
            return true;
        if(piece1.getHole() == Hole.WITHOUT && piece2.getHole() == Hole.WITHOUT && piece3.getHole() == Hole.WITHOUT && piece4.getHole() == Hole.WITHOUT)
            return true;
        return false;
    }
}