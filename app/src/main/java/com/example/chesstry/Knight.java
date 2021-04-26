package com.example.chesstry;

import java.util.ArrayList;

public class Knight extends Piece{
    public Knight(boolean white){
        super(white);
    }
    public final int code = 4;
    @Override
    public boolean canMove(Coordinate before,Coordinate after, Board[][] b){
        boolean move = false;
        int x;
        int y;

        x = Math.abs(after.getX() - before.getX());
        y = Math.abs(after.getY() - before.getY());
        if((x==2&&y==1)||(x==1&&y==2)){
            move = true;
        }

        return move;
    }
    public int getCode(){
        return code;
    }
}
