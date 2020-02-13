package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.pieces.*;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.List;

public class Piece
{
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IMove iMove;
    private int nbMoves = 0;

    public Piece(IChess.ChessColor color, IChess.ChessType type , IMove moves)
    {
        this.color = color;
        this.type = type;
        this.iMove = moves;
    }

    public IChess.ChessColor getColor()
    {
        return this.color;
    }

    public IChess.ChessType getType()
    {
        return this.type;
    }

    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd)
    {
       return iMove.move(p, brd);
    }


    public int countMoves(){
        return nbMoves++;
    }
}
