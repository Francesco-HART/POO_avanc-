package fr.rphstudio.chess.interf;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;

import java.util.List;

public interface IMove {
    /**
     * interface for adapt moves depend of type piece
     * @param p position of one piece in the board
     * @param brd board with all pieces
     * @return list of all moves adapt to the piece
     */
    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd );

}
