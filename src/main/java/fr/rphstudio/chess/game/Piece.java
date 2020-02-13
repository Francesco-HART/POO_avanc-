package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.pieces.*;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class Piece {
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IMove iMove;
    private int countMove = 0;

    /**
     * constructor of piece with attributs color , type and moves
     * @param color team color
     * @param type type of the piece
     * @param moves move can do in function of type
     */
    public Piece(IChess.ChessColor color, IChess.ChessType type, IMove moves) {
        this.color = color;
        this.type = type;
        this.iMove = moves;
    }

    /**
     * permis access to the color of one piece
     * @return color of one piece
     */
    public IChess.ChessColor getColor() {
        return this.color;
    }

    /**
     * permis access to the type of one piece
     * @return type of one piece
     */
    public IChess.ChessType getType() {
        return this.type;
    }

    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd) {
        return iMove.move(p, brd);
    }

    /**
     * count number of displacement for one piece
     */
    public void setCountMove() {
        this.countMove = countMove + 1;
    }
    /**
     * take of one displacement for one piece
     */
    public void resetCount() {
        this.countMove = countMove - 1 ;
    }

    /**
     * get the number of displacement
     * @return number of displacement
     */
    public int getCountMove() {
        return countMove;
    }


}
