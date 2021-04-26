package com.example.chesstry;

public class Board {
    public Piece piece;

    Board(Piece p){
        this.piece = p;
    }

    public void setPiece(Piece p){
        this.piece = p;
    }

    public Piece getPiece(){
        return piece;
    }

}
