package am.aua.quarto.core;

/**
 * Each piece to char
 * 1 - White, Big, Circle, Hollow
 * 2 - White, Big, Circle, Solid
 * 3 - White, Big, Square, Hollow
 * 4 - White, Big, Square, Solid
 * 5 - White, Small, Circle, Hollow
 * 6 - White, Small, Circle, Solid
 * 7 - White, Small, Square, Hollow
 * 8 - White, Small, Square, Solid
 * 9 - Black, Big, Circle, Hollow
 * 10 - Black, Big, Circle, Solid
 * 11 - Black, Big, Square, Hollow
 * 12 - Black, Big, Square, Solid
 * 13 - Black, Small, Circle, Hollow
 * 14 - Black, Small, Circle, Solid
 * 15 - Black, Small, Square, Hollow
 * 16 - Black, Small, Square, Solid
 */

public class Piece {
    enum NameOfPiece {WBCS, WBCH, WBSS, WBSH, WSCS, WSCH, WSSS, WSSH, BBCS, BBCH, BBSS, BBSH, BSCS, BSCH, BSSS, BSSH};
    enum Color {WHITE, BLACK};
    enum Size {BIG, SMALL};
    enum Shape {CIRCLE, SQUARE};
    enum Hole {SOLID, HOLLOW};

    private Color color;
    private Size size;
    private Shape shape;
    private Hole hole;
    private NameOfPiece nameOfPiece;

    public Piece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow){
        this.color = isWhite ? Color.WHITE : Color.BLACK;
        this.size = isBig ? Size.BIG : Size.SMALL;
        this.shape = isCircle ? Shape.CIRCLE : Shape.SQUARE;
        this.hole = isHollow ? Hole.SOLID : Hole.HOLLOW;
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
        if(this.hole.equals(Hole.SOLID))
            name += "H";
        else
            name += "S";
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
                this.getHole();
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
        if(piece1.getHole() == Hole.SOLID && piece2.getHole() == Hole.SOLID && piece3.getHole() == Hole.SOLID && piece4.getHole() == Hole.SOLID)
            return true;
        if(piece1.getHole() == Hole.HOLLOW && piece2.getHole() == Hole.HOLLOW && piece3.getHole() == Hole.HOLLOW && piece4.getHole() == Hole.HOLLOW)
            return true;
        return false;
    }
}