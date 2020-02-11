package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Rook implements IMove
{

    @Override
    public List<IChess.ChessPosition> move(IChess.ChessPosition p)
    {
        List<IChess.ChessPosition> plausible = new ArrayList<>();
        Board grid = new Board();
        grid.getBoard();
        p.y = p.y + 1;
        plausible.add(p);
        return null;
    }
}
