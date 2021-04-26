package com.example.chesstry;

import java.util.ArrayList;

public class Rook extends Piece{
    public Rook(boolean white){
        super(white);
    }
    public final int code = 2;
    @Override
    public boolean canMove(Coordinate before,Coordinate after, Board[][] b){
        boolean move = false;
        int x;
        int y;

        x = Math.abs(after.getX() - before.getX());
        y = Math.abs(after.getY() - before.getY());
        if((x==0&&y!=0)||(x!=0&&y==0)){
            move = true;
        }
        return move;
    }
    public int getCode(){
        return code;
    }
}
