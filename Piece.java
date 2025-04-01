/**
 * Each piece to byte
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
        if (isWhite)
            this.color = Color.WHITE;
        else
            this.color = Color.BLACK;

        if (isBig)
            this.size = Size.BIG;
        else
            this.size = Size.SMALL;

        if(isCircle)
            this.shape = Shape.CIRCLE;
        else
            this.shape = Shape.SQUARE;

        if(isWithHole)
            this.hole = Hole.WITH;
        else
            this.hole = Hole.WITHOUT;
    }

    public byte toByte(){
        if (this.color == Color.WHITE && this.size == Size.BIG && this.shape == Shape.CIRCLE && this.hole == Hole.WITH)
            return 'a';
        if (this.color == Color.WHITE && this.size == Size.BIG && this.shape == Shape.CIRCLE && this.hole == Hole.WITHOUT)
            return 'b';
        if (this.color == Color.WHITE && this.size == Size.BIG && this.shape == Shape.SQUARE && this.hole == Hole.WITH)
            return 'c';
        if (this.color == Color.WHITE && this.size == Size.BIG && this.shape == Shape.SQUARE && this.hole == Hole.WITHOUT)
            return 'd';
        if (this.color == Color.WHITE && this.size == Size.SMALL && this.shape == Shape.CIRCLE && this.hole == Hole.WITH)
            return 'e';
        if (this.color == Color.WHITE && this.size == Size.SMALL && this.shape == Shape.CIRCLE && this.hole == Hole.WITHOUT)
            return 'f';
        if (this.color == Color.WHITE && this.size == Size.SMALL && this.shape == Shape.SQUARE && this.hole == Hole.WITH)
            return 'g';
        if (this.color == Color.WHITE && this.size == Size.SMALL && this.shape == Shape.SQUARE && this.hole == Hole.WITHOUT)
            return 'h';
        if (this.color == Color.BLACK && this.size == Size.BIG && this.shape == Shape.CIRCLE && this.hole == Hole.WITH)
            return 'i';
        if (this.color == Color.BLACK && this.size == Size.BIG && this.shape == Shape.CIRCLE && this.hole == Hole.WITHOUT)
            return 'j';
        if (this.color == Color.BLACK && this.size == Size.BIG && this.shape == Shape.SQUARE && this.hole == Hole.WITH)
            return 'k';
        if (this.color == Color.BLACK && this.size == Size.BIG && this.shape == Shape.SQUARE && this.hole == Hole.WITHOUT)
            return 'l';
        if (this.color == Color.BLACK && this.size == Size.SMALL && this.shape == Shape.CIRCLE && this.hole == Hole.WITH)
            return 'm';
        if (this.color == Color.BLACK && this.size == Size.SMALL && this.shape == Shape.CIRCLE && this.hole == Hole.WITHOUT)
            return 'n';
        if (this.color == Color.BLACK && this.size == Size.SMALL && this.shape == Shape.SQUARE && this.hole == Hole.WITH)
            return 'o';
        return 'p';
    }

}