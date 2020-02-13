package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.MovePiece;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Queen implements IMove {
    /**
     * use moveForward for get all inline moves and moveDiagonal for all diagonal move
     * @param p position of one piece in the board
     * @param brd board with all pieces
     * @return list with all moves
     */
    @Override
    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd)
    {
        List<IChess.ChessPosition> movePos = new ArrayList<>();
        List<IChess.ChessPosition> list1;
        List<IChess.ChessPosition> list2;
        MovePiece movement = new MovePiece();
        list1 = movement.moveForward(p, brd);
        list2 = movement.moveDiagonal(p, brd);
        for (int i = 0; i < list2.size(); i++) {
            list1.add(list2.get(i));
        }
        movePos = list1;
        return movePos;
    }
}
