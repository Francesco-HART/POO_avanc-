package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;
import fr.rphstudio.chess.interf.IChess;
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
        int POSX_PAWN = p.x;
        int POSY_PAWN = p.y;
        int LINEPAWN_TOP = 1;
        int LINEPAWN_BOTTOM = 6;


                if (ownColor == ChessColor.CLR_WHITE) {
                    ChessPosition pos2 = new ChessPosition(p.x, p.y + 2);
                    ChessPosition pos = new ChessPosition(p.x, p.y + 1);

                    if (p.y == LINEPAWN_TOP && brd.findPiece(pos2) == null && brd.findPiece(pos) == null)
                        plausible.add(pos2);

                    if (brd.findPiece(pos) == null)
                        plausible.add(pos);

//                    if (((i == POSX_PAWN - 1 && j == POSY_PAWN + 1) || (i == POSX_PAWN + 1 && j == POSY_PAWN + 1)) && (brd.findPiece(pos) != null) ) {
//                        ChessPosition posAdj = new ChessPosition(i, j);
//                        if (brd.findPiece(posAdj).getColor() == ChessColor.CLR_BLACK)
//                            plausible.add(posAdj);
//                    }


                } else if (ownColor == ChessColor.CLR_BLACK) {
                    ChessPosition pos2 = new ChessPosition(p.x, p.y - 2);
                    ChessPosition pos = new ChessPosition(p.x, p.y - 1);

                    if (p.y == LINEPAWN_BOTTOM && brd.findPiece(pos2) == null)
                        plausible.add(pos2);

                    if (brd.findPiece(pos) == null)
                        plausible.add(pos);
//
//                    for (int i = POSX_PAWN - 1 ; i < POSX_PAWN + 1; i++) {
//                        for (int j = POSY_PAWN - 1 ; j < POSY_PAWN + 1; j++) {
//                            if ((i == POSX_PAWN - 1 && j == POSY_PAWN - 1) && (i == POSX_PAWN + 1 && j == POSY_PAWN - 1) && brd.findPiece(pos) != null) {
//                                ChessPosition posAdj = new ChessPosition(i, j);
//                                if (brd.findPiece(posAdj).getColor() == ChessColor.CLR_WHITE)
//                                    plausible.add(posAdj);
//                            }
//                        }
//                    }
        }
        return plausible;
    }
}

