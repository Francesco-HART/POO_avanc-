package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.Piece;
import fr.rphstudio.chess.interf.IChess.*;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Pawn implements IMove {
    /**
     *  all pawn moves in front 1
     *  in front 2 if it's one the first line
     *  eat in diagonal
     *  and change on dame
     * @param p position of one piece in the board
     * @param brd board with all pieces
     * @return list of all moves
     */
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

            ChessPosition posAdjBlackLeft = new ChessPosition(POSX_PAWN - 1, POSY_PAWN + 1);
            ChessPosition posAdjBlackRight = new ChessPosition(POSX_PAWN + 1, POSY_PAWN + 1);

            if (posAdjBlackLeft.x >= 0 && posAdjBlackLeft.y < 8 ) {
                if (brd.findPiece(posAdjBlackLeft) != null ) {

                    if (brd.findPiece(posAdjBlackLeft).getColor() == ChessColor.CLR_BLACK)
                        plausible.add(posAdjBlackLeft);
                }
            }
            if (posAdjBlackRight.x < 8 && posAdjBlackRight.y < 8) {
                if (brd.findPiece(posAdjBlackRight) != null) {

                    if (brd.findPiece(posAdjBlackRight).getColor() == ChessColor.CLR_BLACK)
                        plausible.add(posAdjBlackRight);
                }
            }


        } else if (ownColor == ChessColor.CLR_BLACK) {
            ChessPosition pos2 = new ChessPosition(p.x, p.y - 2);
            ChessPosition pos = new ChessPosition(p.x, p.y - 1);

            if (p.y == LINEPAWN_BOTTOM && brd.findPiece(pos2) == null && brd.findPiece(pos) == null)
                plausible.add(pos2);

            if (brd.findPiece(pos) == null)
                plausible.add(pos);


            ChessPosition posAdjBlackLeft = new ChessPosition(POSX_PAWN - 1, POSY_PAWN - 1);
            ChessPosition posAdjBlackRight = new ChessPosition(POSX_PAWN + 1, POSY_PAWN - 1);

            if (posAdjBlackLeft.x >= 0 && posAdjBlackLeft.y >= 0 ) {
                if (brd.findPiece(posAdjBlackLeft) != null ) {

                    if (brd.findPiece(posAdjBlackLeft).getColor() == ChessColor.CLR_WHITE)
                        plausible.add(posAdjBlackLeft);
                }
            }
            if (posAdjBlackRight.x < 8 && posAdjBlackRight.y >= 0) {
                if (brd.findPiece(posAdjBlackRight) != null) {

                    if (brd.findPiece(posAdjBlackRight).getColor() == ChessColor.CLR_WHITE)
                        plausible.add(posAdjBlackRight);
                }
            }
        }



        return plausible;
    }
}



