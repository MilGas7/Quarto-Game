package am.aua.quarto.core;

import java.util.Random;

public class StarBoard extends Board{

    public static final int STARNUMBER = 4;
    private boolean[] starArray;
    private ChangeablePiece[] tiles;

    public StarBoard(){
        super();
        Random randomGen = new Random();
        this.tiles = new ChangeablePiece[SIZE * SIZE];
        starArray = new boolean[SIZE * SIZE];
        int i = 0;
        while(i < STARNUMBER){
            int thisStar = randomGen.nextInt(SIZE * SIZE);
            if(!starArray[thisStar]){
                starArray[thisStar] = true;
                i++;
            }
        }
    }

    public StarBoard(StarBoard original){
        super(original);
        this.tiles = new ChangeablePiece[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.tiles[i] = original.tiles[i] != null ?
                    new ChangeablePiece(original.tiles[i]) : null;
        }
        this.starArray = new boolean[SIZE * SIZE];
        for(int i = 0; i < SIZE * SIZE; i++)
            this.starArray[i] = original.starArray[i];
    }

    public boolean hasStar(int index){ return starArray[index]; }

    @Override
    public void setTile(int index, Piece piece) {
        super.setTile(index, piece);
        this.tiles[index] = ChangeablePiece.fromPiece(piece);
    }

    @Override
    public ChangeablePiece getTile(int index) {
        Piece piece = super.getTile(index);
        return piece != null ? (ChangeablePiece)piece : null;
    }
}
