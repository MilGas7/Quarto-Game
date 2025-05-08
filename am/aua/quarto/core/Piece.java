package am.aua.quarto.core;

/**
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
 */

public class Piece {
    public enum NameOfPiece {WBCS, WBCH, WBSS, WBSH, WSCS, WSCH, WSSS, WSSH, BBCS, BBCH, BBSS, BBSH, BSCS, BSCH, BSSS, BSSH};
    public enum Color {WHITE, BLACK};
    public enum Size {BIG, SMALL};
    public enum Shape {CIRCLE, SQUARE};
    public enum Hole {SOLID, HOLLOW};

    private Color color;
    private Size size;
    private Shape shape;
    private Hole hole;
    private NameOfPiece nameOfPiece;

    public Piece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow){
        this.color = isWhite ? Color.WHITE : Color.BLACK;
        this.size = isBig ? Size.BIG : Size.SMALL;
        this.shape = isCircle ? Shape.CIRCLE : Shape.SQUARE;
        this.hole = isHollow ? Hole.HOLLOW : Hole.SOLID;
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

    public void setNamePiece() {
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
            name += "S";
        else
            name += "H";
        this.nameOfPiece = NameOfPiece.valueOf(name);
    }

    public void setColor(Color color) { this.color = color; }

    public void setSize(Size size) { this.size = size; }

    public void setShape(Shape shape) { this.shape = shape; }

    public void setHole(Hole hole) { this.hole = hole; }

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

    public static int toInt(Piece piece){
        switch (piece.getNameOfPiece()){
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