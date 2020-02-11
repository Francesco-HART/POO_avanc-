package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;
import fr.rphstudio.chess.interf.IChess.*;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {

    @Override
    public List<ChessPosition> move(ChessPosition p, Board brd) {
        List<ChessPosition> plausible = new ArrayList<>();
        Piece piece = brd.findPiece(p);
        ChessColor ownColor = piece.getColor();

        if (ownColor == ChessColor.CLR_WHITE) {
            ChessPosition pos = new ChessPosition(p.x, p.y + 1);
            plausible.add(pos);
        } else if (ownColor == ChessColor.CLR_BLACK) {
            ChessPosition pos = new ChessPosition(p.x, p.y - 1);
            plausible.add(pos);
        }
        return plausible;
    }
}

