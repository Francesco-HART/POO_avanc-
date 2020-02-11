package fr.rphstudio.chess.interf;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;

import java.util.List;

public interface IMove {

    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd );

}
