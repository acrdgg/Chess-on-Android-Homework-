package com.example.chesstry;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class chessTry extends AppCompatActivity implements View.OnClickListener{

    //test area
    CharSequence wtest = "This is a white block";
    CharSequence btest = "This is a black block";
    int duration = Toast.LENGTH_SHORT;

    //Initialize Pieces
    Piece b_King, b_Queen, b_Knight, b_Knight1, b_Rook, b_Rook1, b_Bishop, b_Bishop1, b_Pawn1, b_Pawn2, b_Pawn3, b_Pawn4, b_Pawn5, b_Pawn6, b_Pawn7, b_Pawn8;
    Piece w_King, w_Queen, w_Knight, w_Knight1, w_Rook, w_Rook1, w_Bishop, w_Bishop1, w_Pawn1, w_Pawn2, w_Pawn3, w_Pawn4, w_Pawn5, w_Pawn6, w_Pawn7, w_Pawn8;
    public TextView game_over;
    public TextView game_draw;

    //board and view
    public TextView[][] ChessView = new TextView[8][8];
    public Board[][] ChessBoard = new Board[8][8];
    public Coordinate currc = new Coordinate(0,0);
    public Coordinate recordc = null;
    public boolean selectfirst = false;
    public boolean whiteturn = true;
    Boolean allowmove = false;
    boolean gameover = false;
    int countdraw = 0;

    ArrayList<Coordinate> history_undo = new ArrayList<>();
    ArrayList<Piece> history_piece = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chessview_main);

        bindview(ChessView);
        initialBoard(ChessBoard);

        game_over = (TextView)findViewById(R.id.game_over);
        game_over.setVisibility(View.INVISIBLE);
        game_draw = (TextView)findViewById(R.id.game_draw);
        game_draw.setVisibility(View.INVISIBLE);


    }


    public void undo(View v){
        if(history_piece.size()<=0 || gameover){
            Toast.makeText(this, "Does not match undo requirement", Toast.LENGTH_SHORT).show();
        }else{
            int bfx, bfy, afx, afy;
            bfx = history_undo.get(0).getX();
            bfy = history_undo.get(0).getY();
            afx = history_undo.get(1).getX();
            afy = history_undo.get(1).getY();

            Piece recOne = history_piece.get(0);
            Piece recTwo = history_piece.get(1);

            ChessBoard[bfx][bfy].setPiece(recOne);
            ChessBoard[afx][afy].setPiece(recTwo);

            setView();

            history_piece.clear();
            history_undo.clear();
            whiteturn = !whiteturn;
        }
    }

    public void newgame(View v){
        selectfirst = false;
        whiteturn = true;
        allowmove = false;
        gameover = false;
        currc = new Coordinate(0,0);
        recordc = null;
        history_undo.clear();
        history_piece.clear();
        countdraw = 0;

        game_draw.setVisibility(View.INVISIBLE);
        game_over.setVisibility(View.INVISIBLE);
        initialBoard(ChessBoard);
        setView();
    }

    public void resign(View v){
        if(whiteturn){
            Toast.makeText(this, "Game Over, Black Win", Toast.LENGTH_SHORT).show();
            game_over.setVisibility(View.VISIBLE);
            gameover = true;
        }else{
            Toast.makeText(this, "Game Over, White Win", Toast.LENGTH_SHORT).show();
            game_over.setVisibility(View.VISIBLE);
            gameover = true;
        }
    }



    public void draw(View v){
        if(!gameover){
            countdraw++;
            if(countdraw<2){
                Toast.makeText(this, "The other side ask a draw, if agree, click draw", Toast.LENGTH_SHORT).show();
            }
            if(countdraw==2){
                gameover = true;
                game_draw.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Game Over, Draw", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            //first row
            case R.id.R00:
                currc = new Coordinate(0,0);
                String temp = "Coordinate: 0,0";
                Toast ww = Toast.makeText(this, temp, duration);
                ww.show();
                break;
            case R.id.R10:
                currc.setX(1);
                currc.setY(0);
                String temp1 = "Coordinate: 1,0";
                Toast bb = Toast.makeText(this, temp1, duration);
                bb.show();
                break;
            case R.id.R20:
                currc.setX(2);
                currc.setY(0);
                break;
            case R.id.R30:
                currc.setX(3);
                currc.setY(0);
                break;
            case R.id.R40:
                currc.setX(4);
                currc.setY(0);
                break;
            case R.id.R50:
                currc.setX(5);
                currc.setY(0);
                break;
            case R.id.R60:
                currc.setX(6);
                currc.setY(0);
                break;
            case R.id.R70:
                currc.setX(7);
                currc.setY(0);
                break;
            //second row
            case R.id.R01:
                currc.setX(0);
                currc.setY(1);
                break;
            case R.id.R11:
                currc.setX(1);
                currc.setY(1);
                break;
            case R.id.R21:
                currc.setX(2);
                currc.setY(1);
                break;
            case R.id.R31:
                currc.setX(3);
                currc.setY(1);
                break;
            case R.id.R41:
                currc.setX(4);
                currc.setY(1);
                break;
            case R.id.R51:
                currc.setX(5);
                currc.setY(1);
                break;
            case R.id.R61:
                currc.setX(6);
                currc.setY(1);
                break;
            case R.id.R71:
                currc.setX(7);
                currc.setY(1);
                break;
            //row 3
            case R.id.R02:
                currc.setX(0);
                currc.setY(2);
                break;
            case R.id.R12:
                currc.setX(1);
                currc.setY(2);
                break;
            case R.id.R22:
                currc.setX(2);
                currc.setY(2);
                break;
            case R.id.R32:
                currc.setX(3);
                currc.setY(2);
                break;
            case R.id.R42:
                currc.setX(4);
                currc.setY(2);
                break;
            case R.id.R52:
                currc.setX(5);
                currc.setY(2);
                break;
            case R.id.R62:
                currc.setX(6);
                currc.setY(2);
                break;
            case R.id.R72:
                currc.setX(7);
                currc.setY(2);
                break;
            //row 4
            case R.id.R03:
                currc.setX(0);
                currc.setY(3);
                break;
            case R.id.R13:
                currc.setX(1);
                currc.setY(3);
                break;
            case R.id.R23:
                currc.setX(2);
                currc.setY(3);
                break;
            case R.id.R33:
                currc.setX(3);
                currc.setY(3);
                break;
            case R.id.R43:
                currc.setX(4);
                currc.setY(3);
                break;
            case R.id.R53:
                currc.setX(5);
                currc.setY(3);
                break;
            case R.id.R63:
                currc.setX(6);
                currc.setY(3);
                break;
            case R.id.R73:
                currc.setX(7);
                currc.setY(3);
                break;
            //row 5
            case R.id.R04:
                currc.setX(0);
                currc.setY(4);
                break;
            case R.id.R14:
                currc.setX(1);
                currc.setY(4);
                break;
            case R.id.R24:
                currc.setX(2);
                currc.setY(4);
                break;
            case R.id.R34:
                currc.setX(3);
                currc.setY(4);
                break;
            case R.id.R44:
                currc.setX(4);
                currc.setY(4);
                break;
            case R.id.R54:
                currc.setX(5);
                currc.setY(4);
                break;
            case R.id.R64:
                currc.setX(6);
                currc.setY(4);
                break;
            case R.id.R74:
                currc.setX(7);
                currc.setY(4);
                break;
            //row 6
            case R.id.R05:
                currc.setX(0);
                currc.setY(5);
                break;
            case R.id.R15:
                currc.setX(1);
                currc.setY(5);
                break;
            case R.id.R25:
                currc.setX(2);
                currc.setY(5);
                break;
            case R.id.R35:
                currc.setX(3);
                currc.setY(5);
                break;
            case R.id.R45:
                currc.setX(4);
                currc.setY(5);
                break;
            case R.id.R55:
                currc.setX(5);
                currc.setY(5);
                break;
            case R.id.R65:
                currc.setX(6);
                currc.setY(5);
                break;
            case R.id.R75:
                currc.setX(7);
                currc.setY(5);
                break;
            //row 7
            case R.id.R06:
                currc.setX(0);
                currc.setY(6);
                break;
            case R.id.R16:
                currc.setX(1);
                currc.setY(6);
                break;
            case R.id.R26:
                currc.setX(2);
                currc.setY(6);
                break;
            case R.id.R36:
                currc.setX(3);
                currc.setY(6);
                break;
            case R.id.R46:
                currc.setX(4);
                currc.setY(6);
                break;
            case R.id.R56:
                currc.setX(5);
                currc.setY(6);
                break;
            case R.id.R66:
                currc.setX(6);
                currc.setY(6);
                break;
            case R.id.R76:
                currc.setX(7);
                currc.setY(6);
                break;
            //row 8
            case R.id.R07:
                currc.setX(0);
                currc.setY(7);
                break;
            case R.id.R17:
                currc.setX(1);
                currc.setY(7);
                break;
            case R.id.R27:
                currc.setX(2);
                currc.setY(7);
                break;
            case R.id.R37:
                currc.setX(3);
                currc.setY(7);
                break;
            case R.id.R47:
                currc.setX(4);
                currc.setY(7);
                break;
            case R.id.R57:
                currc.setX(5);
                currc.setY(7);
                break;
            case R.id.R67:
                currc.setX(6);
                currc.setY(7);
                break;
            case R.id.R77:
                currc.setX(7);
                currc.setY(7);
                break;
        }
        //if nothing haven been selected before
        if(!selectfirst && !gameover){
            //if select a null block or select a piece that is not belong to your turn
            if(ChessBoard[currc.getX()][currc.getY()].getPiece() == null){
                return;
            }else{
                if(ChessBoard[currc.getX()][currc.getY()].getPiece().isWhite() != whiteturn){
                    return;
                }else{
                    recordc = new Coordinate(currc.getX(), currc.getY());
                    selectfirst = true;
                }
            }
        //if select the first one
        }else if(selectfirst && !gameover){
            Piece p = ChessBoard[recordc.getX()][recordc.getY()].getPiece();
            allowmove = p.canMove(recordc,currc,ChessBoard);
            boolean dangerking = false;
            boolean colorking = false;
            if(ChessBoard[currc.getX()][currc.getY()].getPiece() instanceof King){
                dangerking = true;
                colorking = ChessBoard[currc.getX()][currc.getY()].getPiece().isWhite();
            }

            if(allowmove) {

                //cancel draw
                countdraw = 0;

                //if hasnt use undo last time
                history_undo.clear();
                history_piece.clear();


                //record for undo
                history_undo.add(recordc);
                history_undo.add(currc);
                Piece tempOne = ChessBoard[recordc.getX()][recordc.getY()].getPiece();
                Piece tempTwo = ChessBoard[currc.getX()][currc.getY()].getPiece();
                history_piece.add(tempOne);
                history_piece.add(tempTwo);



                //apply change and clear data
                ChessBoard[currc.getX()][currc.getY()].setPiece(p);
                ChessBoard[recordc.getX()][recordc.getY()].setPiece(null);
                recordc = null;
                //currc.setX(0);
                //currc.setY(0);
                selectfirst = false;
                whiteturn = !whiteturn;
                if(dangerking){
                    gameover = true;
                    game_over.setVisibility(View.VISIBLE);
                    if(colorking) {
                        Toast.makeText(this, "Game Over, Black Win", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(this, "Game Over, White Win", Toast.LENGTH_SHORT).show();
                    }
                }


            }else{
                recordc = null;
                currc.setX(0);
                currc.setY(0);
                selectfirst = false;
                Toast.makeText( this, "not a legal move", Toast.LENGTH_SHORT).show();
            }

                setView();

        }

    }

    //set pieces and call the method for binding image resource
    public void initialBoard(Board[][] bd){
        //set all blocks on the board as nul
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                bd[i][j] = new Board(null);
            }
        }

        //put pieces on the board
        b_King = new King(false);
        b_Queen = new Queen(false);
        b_Bishop = new Bishop(false);
        b_Bishop1 = new Bishop(false);
        b_Knight = new Knight(false);
        b_Knight1 = new Knight(false);
        b_Rook = new Rook(false);
        b_Rook1 = new Rook(false);
        b_Pawn1 = new Pawn(false);
        b_Pawn2 = new Pawn(false);
        b_Pawn3 = new Pawn(false);
        b_Pawn4 = new Pawn(false);
        b_Pawn5 = new Pawn(false);
        b_Pawn6 = new Pawn(false);
        b_Pawn7 = new Pawn(false);
        b_Pawn8 = new Pawn(false);

        w_King = new King(true);
        w_Queen = new Queen(true);
        w_Bishop = new Bishop(true);
        w_Bishop1 = new Bishop(true);
        w_Knight = new Knight(true);
        w_Knight1 = new Knight(true);
        w_Rook = new Rook(true);
        w_Rook1 = new Rook(true);
        w_Pawn1 = new Pawn(true);
        w_Pawn2 = new Pawn(true);
        w_Pawn3 = new Pawn(true);
        w_Pawn4 = new Pawn(true);
        w_Pawn5 = new Pawn(true);
        w_Pawn6 = new Pawn(true);
        w_Pawn7 = new Pawn(true);
        w_Pawn8 = new Pawn(true);

        bd[0][7].setPiece(w_Rook);
        bd[1][7].setPiece(w_Knight);
        bd[2][7].setPiece(w_Bishop);
        bd[3][7].setPiece(w_Queen);
        bd[4][7].setPiece(w_King);
        bd[5][7].setPiece(w_Bishop1);
        bd[6][7].setPiece(w_Knight1);
        bd[7][7].setPiece(w_Rook1);
        bd[0][6].setPiece(w_Pawn1);
        bd[1][6].setPiece(w_Pawn2);
        bd[2][6].setPiece(w_Pawn3);
        bd[3][6].setPiece(w_Pawn4);
        bd[4][6].setPiece(w_Pawn5);
        bd[5][6].setPiece(w_Pawn6);
        bd[6][6].setPiece(w_Pawn7);
        bd[7][6].setPiece(w_Pawn8);

        bd[0][0].setPiece(b_Rook);
        bd[1][0].setPiece(b_Knight);
        bd[2][0].setPiece(b_Bishop);
        bd[3][0].setPiece(b_Queen);
        bd[4][0].setPiece(b_King);
        bd[5][0].setPiece(b_Bishop1);
        bd[6][0].setPiece(b_Knight1);
        bd[7][0].setPiece(b_Rook1);
        bd[0][1].setPiece(b_Pawn1);
        bd[1][1].setPiece(b_Pawn2);
        bd[2][1].setPiece(b_Pawn3);
        bd[3][1].setPiece(b_Pawn4);
        bd[4][1].setPiece(b_Pawn5);
        bd[5][1].setPiece(b_Pawn6);
        bd[6][1].setPiece(b_Pawn7);
        bd[7][1].setPiece(b_Pawn8);

        setView();
    }

    //get picture resource for the chessview
    public void setView(){
        boolean blackalive = false;
        boolean whitealive = false;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                Piece p = ChessBoard[i][j].getPiece();
                int code;

                if(p != null){
                    if(p instanceof King) code = 0;
                    else if(p instanceof Queen) code = 1;
                    else if(p instanceof Rook) code = 2;
                    else if(p instanceof Bishop) code = 3;
                    else if(p instanceof Knight) code = 4;
                    else if(p instanceof Pawn) code = 5;
                    else code = 6;

                    switch(code){
                        case 0:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_king_ed);
                                whitealive = true;
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_king_ed);
                                blackalive = true;
                            }
                            break;
                        case 1:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_queen_ed);
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_queen_ed);
                            }
                            break;
                        case 2:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_tower_ed);
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_tower_ed);
                            }
                            break;
                        case 3:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_plus_ed);
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_plus_ed);
                            }
                            break;
                        case 4:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_horse_ed);
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_horse_ed);
                            }
                            break;
                        case 5:
                            if(p.isWhite()){
                                ChessView[i][j].setBackgroundResource(R.drawable.w_solder_ed);
                            } else{
                                ChessView[i][j].setBackgroundResource(R.drawable.b_solder_ed);
                            }
                            break;
                        default:
                    }
                }else{
                    ChessView[i][j].setBackgroundResource(0);
                }
            }
        }

    }


    public void bindview(TextView[][] cb){
        cb[0][0] = (TextView) findViewById(R.id.R00);
        cb[1][0] = (TextView) findViewById(R.id.R10);
        cb[2][0] = (TextView) findViewById(R.id.R20);
        cb[3][0] = (TextView) findViewById(R.id.R30);
        cb[4][0] = (TextView) findViewById(R.id.R40);
        cb[5][0] = (TextView) findViewById(R.id.R50);
        cb[6][0] = (TextView) findViewById(R.id.R60);
        cb[7][0] = (TextView) findViewById(R.id.R70);
        //
        cb[0][1] = (TextView) findViewById(R.id.R01);
        cb[1][1] = (TextView) findViewById(R.id.R11);
        cb[2][1] = (TextView) findViewById(R.id.R21);
        cb[3][1] = (TextView) findViewById(R.id.R31);
        cb[4][1] = (TextView) findViewById(R.id.R41);
        cb[5][1] = (TextView) findViewById(R.id.R51);
        cb[6][1] = (TextView) findViewById(R.id.R61);
        cb[7][1] = (TextView) findViewById(R.id.R71);
        //
        cb[0][2] = (TextView) findViewById(R.id.R02);
        cb[1][2] = (TextView) findViewById(R.id.R12);
        cb[2][2] = (TextView) findViewById(R.id.R22);
        cb[3][2] = (TextView) findViewById(R.id.R32);
        cb[4][2] = (TextView) findViewById(R.id.R42);
        cb[5][2] = (TextView) findViewById(R.id.R52);
        cb[6][2] = (TextView) findViewById(R.id.R62);
        cb[7][2] = (TextView) findViewById(R.id.R72);
        //
        cb[0][3] = (TextView) findViewById(R.id.R03);
        cb[1][3] = (TextView) findViewById(R.id.R13);
        cb[2][3] = (TextView) findViewById(R.id.R23);
        cb[3][3] = (TextView) findViewById(R.id.R33);
        cb[4][3] = (TextView) findViewById(R.id.R43);
        cb[5][3] = (TextView) findViewById(R.id.R53);
        cb[6][3] = (TextView) findViewById(R.id.R63);
        cb[7][3] = (TextView) findViewById(R.id.R73);
        //
        cb[0][4] = (TextView) findViewById(R.id.R04);
        cb[1][4] = (TextView) findViewById(R.id.R14);
        cb[2][4] = (TextView) findViewById(R.id.R24);
        cb[3][4] = (TextView) findViewById(R.id.R34);
        cb[4][4] = (TextView) findViewById(R.id.R44);
        cb[5][4] = (TextView) findViewById(R.id.R54);
        cb[6][4] = (TextView) findViewById(R.id.R64);
        cb[7][4] = (TextView) findViewById(R.id.R74);
        //
        cb[0][5] = (TextView) findViewById(R.id.R05);
        cb[1][5] = (TextView) findViewById(R.id.R15);
        cb[2][5] = (TextView) findViewById(R.id.R25);
        cb[3][5] = (TextView) findViewById(R.id.R35);
        cb[4][5] = (TextView) findViewById(R.id.R45);
        cb[5][5] = (TextView) findViewById(R.id.R55);
        cb[6][5] = (TextView) findViewById(R.id.R65);
        cb[7][5] = (TextView) findViewById(R.id.R75);
        //
        cb[0][6] = (TextView) findViewById(R.id.R06);
        cb[1][6] = (TextView) findViewById(R.id.R16);
        cb[2][6] = (TextView) findViewById(R.id.R26);
        cb[3][6] = (TextView) findViewById(R.id.R36);
        cb[4][6] = (TextView) findViewById(R.id.R46);
        cb[5][6] = (TextView) findViewById(R.id.R56);
        cb[6][6] = (TextView) findViewById(R.id.R66);
        cb[7][6] = (TextView) findViewById(R.id.R76);
        //
        cb[0][7] = (TextView) findViewById(R.id.R07);
        cb[1][7] = (TextView) findViewById(R.id.R17);
        cb[2][7] = (TextView) findViewById(R.id.R27);
        cb[3][7] = (TextView) findViewById(R.id.R37);
        cb[4][7] = (TextView) findViewById(R.id.R47);
        cb[5][7] = (TextView) findViewById(R.id.R57);
        cb[6][7] = (TextView) findViewById(R.id.R67);
        cb[7][7] = (TextView) findViewById(R.id.R77);
    }
}