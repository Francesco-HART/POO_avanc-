package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.MovePiece;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Bishop implements IMove {

    @Override
    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd)
    {
        MovePiece movement = new MovePiece();
        return movement.moveDiagonal(p,brd);
    }
}