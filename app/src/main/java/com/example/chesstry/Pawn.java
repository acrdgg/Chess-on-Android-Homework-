package com.example.chesstry;

public class Pawn extends Piece{
    public Pawn(boolean white){
        super(white);
    }
    public final int code = 5;
    @Override
    public boolean canMove(Coordinate before,Coordinate after, Board[][] b){
        boolean color = b[before.getX()][before.getY()].getPiece().isWhite();
        boolean legal = false;
        boolean firstmove = false;
        int x;
        int y;
        // get color, and check whether it is the first term
        if(color && before.getY() == 6){
            firstmove = true;
        }else if(!color && before.getY() == 1){
            firstmove = true;
        }else{
            firstmove = false;
        }
        //if white
        if(color){
            y = before.getY() - after.getY();
        }else{
            y = after.getY()-before.getY();
        }
        x = Math.abs(after.getX()-before.getX());

        if(y == 1 && x == 0 && b[after.getX()][after.getY()].getPiece() == null) {
            legal = true;
        }else if(x == 1 && y == 1 && b[after.getX()][after.getY()].getPiece() != null){
            legal = true;
        } else if((firstmove == true) && (y == 2) && (x == 0) && (b[after.getX()][after.getY()].getPiece() == null)){
            legal = true;
        }
        return legal;
    }
    public int getCode(){
        return code;
    }
}
