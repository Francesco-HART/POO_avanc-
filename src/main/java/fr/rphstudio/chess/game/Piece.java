package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

public class Piece
{
    private IChess.ChessColor color;
    private IChess.ChessType type;

    public Piece(IChess.ChessColor color, IChess.ChessType type)
    {
        this.color = color;
        this.type = type;
    }

    public IChess.ChessColor getColor()
    {
        return this.color;
    }

    public IChess.ChessType getType()
    {
        return this.type;
    }
}
