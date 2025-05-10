package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.TraitNotFoundException;

/**
 * Represents a special type of {@link Piece} whose traits (color, size, shape, hole) can be changed.
 */
public class ChangeablePiece extends Piece {

    /**
     * Constructs a {@code ChangeablePiece} with specified attributes.
     *
     * @param isWhite  {@code true} if the piece is white; {@code false} if black.
     * @param isBig    {@code true} if the piece is big; {@code false} if small.
     * @param isCircle {@code true} if the piece is a circle; {@code false} if square.
     * @param isHollow {@code true} if the piece is hollow; {@code false} if solid.
     */
    public ChangeablePiece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow) {
        super(isWhite, isBig, isCircle, isHollow);
    }

    /**
     * Constructs a {@code ChangeablePiece} from an existing {@link Piece} instance.
     *
     * @param piece the original piece to copy traits from.
     */
    public ChangeablePiece(Piece piece) {
        super(piece);
    }

    /**
     * Changes one trait of the piece based on the provided trait name.
     *
     * @param traitName the name of the trait to change.
     * @throws TraitNotFoundException if the trait name is invalid.
     */
    public void changeTrait(String traitName) {
        switch (traitName.toUpperCase()) {
            case "COLOR":
                setColor((getColor() == Color.WHITE) ? Color.BLACK : Color.WHITE);
                break;
            case "SIZE":
                setSize((getSize() == Size.BIG) ? Size.SMALL : Size.BIG);
                break;
            case "SHAPE":
                setShape((getShape() == Shape.SQUARE) ? Shape.CIRCLE : Shape.SQUARE);
                break;
            case "HOLE":
                setHole((getHole() == Hole.SOLID) ? Hole.HOLLOW : Hole.SOLID);
                break;
            default:
                throw new TraitNotFoundException("There is no such trait.");
        }
        this.setNamePiece();
    }

    /**
     * A method to convert a regular {@link Piece} into a {@code ChangeablePiece}.
     *
     * @param piece the original piece to convert.
     * @return a new {@code ChangeablePiece} with the same attributes as the input piece.
     * Returns {@code null} if the input piece is null.
     */
    public static ChangeablePiece fromPiece(Piece piece) {
        if (piece == null) return null;
        return new ChangeablePiece(
                piece.getColor() == Color.WHITE,
                piece.getSize() == Size.BIG,
                piece.getShape() == Shape.CIRCLE,
                piece.getHole() == Hole.HOLLOW
        );
    }

}