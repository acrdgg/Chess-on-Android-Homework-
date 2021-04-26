package com.example.chesstry;

import java.util.ArrayList;

public class Bishop extends Piece {
    public Bishop(boolean white){
        super(white);
    }
    public final int code = 3;
    @Override
    public boolean canMove(Coordinate before,Coordinate after,Board[][] b){
        boolean move = false;
        int x;
        int y;

        x = Math.abs(before.getX() - after.getX());
        y = Math.abs(before.getY() - after.getY());

        if(x == y){
            move = true;
        }
        return move;
    }
    public int getCode(){
        return code;
    }
}
