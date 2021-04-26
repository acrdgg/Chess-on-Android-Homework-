package com.example.chesstry;

import java.util.ArrayList;

public class Piece {
    public boolean white;

    Piece(boolean white){
        this.white = white;
    }

    public boolean isWhite(){
        return white;
    }
    public void setWhite(boolean white){
        this.white = white;
    }

    public boolean canMove(Coordinate before,Coordinate after, Board[][] b){
        boolean move = true;

        return move;
    }
}
