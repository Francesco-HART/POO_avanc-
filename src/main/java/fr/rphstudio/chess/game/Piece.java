package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.pieces.Bishop;
import fr.rphstudio.chess.pieces.Pawn;
import fr.rphstudio.chess.pieces.Queen;
import fr.rphstudio.chess.pieces.Rook;

import java.util.List;

public class Piece
{
    private IChess.ChessColor color;
    private IChess.ChessType type;
    private IMove iMove;

    public Piece(IChess.ChessColor color, IChess.ChessType type)
    {
        this.color = color;
        this.type = type;
        this.iMove = new Queen();
    }

    public IChess.ChessColor getColor()
    {
        return this.color;
    }

    public IChess.ChessType getType()
    {
        return this.type;
    }

    public List<IChess.ChessPosition> getMoves(IChess.ChessPosition p, Board brd){
       return iMove.move(p, brd);

    }
}
