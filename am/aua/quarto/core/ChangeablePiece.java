package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.TraitNotFoundException;

public class ChangeablePiece extends Piece {

    public ChangeablePiece(boolean isWhite, boolean isBig, boolean isCircle, boolean isHollow){
        super(isWhite, isBig, isCircle, isHollow);
    }

    public ChangeablePiece(Piece piece){
        super(piece);
    }

    public void changeTrait(String traitName){
        switch(traitName.toUpperCase()){
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

    //A wrapper method to convert Piece to ChangeablePiece
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