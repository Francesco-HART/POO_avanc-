package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

        @Override
        public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd) {
            List<IChess.ChessPosition> plausible = new ArrayList<>();
            IChess.ChessPosition pos = new IChess.ChessPosition(p.x,p.y+1);
            plausible.add(pos);
            return plausible;
        }
    }

