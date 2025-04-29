/**
 * Each piece to char
 * a - White, Big, Circle, With
 * b - White, Big, Circle, Without
 * c - White, Big, Square, With
 * d - White, Big, Square, Without
 * e - White, Small, Circle, With
 * f - White, Small, Circle, Without
 * g - White, Small, Square, With
 * h - White, Small, Square, Without
 * i - Black, Big, Circle, With
 * j - Black, Big, Circle, Without
 * k - Black, Big, Square, With
 * l - Black, Big, Square, Without
 * m - Black, Small, Circle, With
 * n - Black, Small, Circle, Without
 * o - Black, Small, Square, With
 * p - Black, Small, Square, Without
 */

public class Piece{

    enum Color {WHITE, BLACK};
    enum Size {BIG, SMALL};
    enum Shape {CIRCLE, SQUARE};
    enum Hole {WITH, WITHOUT};

    private Color color;
    private Size size;
    private Shape shape;
    private Hole hole;

    public Piece(boolean isWhite, boolean isBig, boolean isCircle, boolean isWithHole){
        this.color = isWhite ? Color.WHITE : Color.BLACK;
        this.size = isBig ? Size.BIG : Size.SMALL;
        this.shape = isCircle ? Shape.CIRCLE : Shape.SQUARE;
        this.hole = isWithHole ? Hole.WITH : Hole.WITHOUT;
    }

    public Piece (Piece piece){
        if(piece != null){
            this.color = piece.color;
            this.size = piece.size;
            this.shape = piece.shape;
            this.hole = piece.hole;
        }
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


    public static char toChar(Piece piece){
        if (piece.color == Color.WHITE && piece.size == Size.BIG && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITH)
            return 'a';
        if (piece.color == Color.WHITE && piece.size == Size.BIG && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITHOUT)
            return 'b';
        if (piece.color == Color.WHITE && piece.size == Size.BIG && piece.shape == Shape.SQUARE && piece.hole == Hole.WITH)
            return 'c';
        if (piece.color == Color.WHITE && piece.size == Size.BIG && piece.shape == Shape.SQUARE && piece.hole == Hole.WITHOUT)
            return 'd';
        if (piece.color == Color.WHITE && piece.size == Size.SMALL && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITH)
            return 'e';
        if (piece.color == Color.WHITE && piece.size == Size.SMALL && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITHOUT)
            return 'f';
        if (piece.color == Color.WHITE && piece.size == Size.SMALL && piece.shape == Shape.SQUARE && piece.hole == Hole.WITH)
            return 'g';
        if (piece.color == Color.WHITE && piece.size == Size.SMALL && piece.shape == Shape.SQUARE && piece.hole == Hole.WITHOUT)
            return 'h';
        if (piece.color == Color.BLACK && piece.size == Size.BIG && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITH)
            return 'i';
        if (piece.color == Color.BLACK && piece.size == Size.BIG && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITHOUT)
            return 'j';
        if (piece.color == Color.BLACK && piece.size == Size.BIG && piece.shape == Shape.SQUARE && piece.hole == Hole.WITH)
            return 'k';
        if (piece.color == Color.BLACK && piece.size == Size.BIG && piece.shape == Shape.SQUARE && piece.hole == Hole.WITHOUT)
            return 'l';
        if (piece.color == Color.BLACK && piece.size == Size.SMALL && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITH)
            return 'm';
        if (piece.color == Color.BLACK && piece.size == Size.SMALL && piece.shape == Shape.CIRCLE && piece.hole == Hole.WITHOUT)
            return 'n';
        if (piece.color == Color.BLACK && piece.size == Size.SMALL && piece.shape == Shape.SQUARE && piece.hole == Hole.WITH)
            return 'o';
        if (piece.color == Color.BLACK && piece.size == Size.SMALL && piece.shape == Shape.SQUARE && piece.hole == Hole.WITHOUT)
            return 'p';
        else{
            return 0;
        }
    }

    public static boolean isQuarto (Piece piece1, Piece piece2, Piece piece3, Piece piece4){
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