package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class King implements IMove {
    @Override
    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd) {
        List<IChess.ChessPosition> tabPos = new ArrayList<>();
        int POSX_KING = p.x;
        int POSY_KING = p.y;

        for (int x = POSX_KING - 1; x <= POSX_KING + 1; x++) {
            for (int y = POSY_KING - 1; y <= POSY_KING + 1; y++) {
                if (x <= 7 && y <= 7 && x > -1 && y > -1) {
                    IChess.ChessPosition myPos = new IChess.ChessPosition(x, y);
                    if (brd.findPiece(myPos) == null || brd.findPiece(myPos).getColor() != brd.findPiece(p).getColor()) {
                        tabPos.add(myPos);
                    }
                }

                if (brd.findPiece(p).getCountMove() == 0) {

                    IChess.ChessPosition towerPos = new IChess.ChessPosition(p.x + 4, p.y);
                    boolean wayVoid = true;
                    if (brd.findPiece(towerPos) != null && brd.findPiece(towerPos).getCountMove() == 0) {

                        for (int i = 3; i > 0; i--) {
                            if (brd.findPiece(new IChess.ChessPosition(POSX_KING + i, POSY_KING)) != null) {
                                wayVoid = false;
                                break;
                            }
                        }
                        if (wayVoid) {
                            tabPos.add(new IChess.ChessPosition(POSX_KING + 3, POSY_KING));
                        }
                    }

                    wayVoid = true;
                    towerPos = new IChess.ChessPosition(p.x - 3, p.y);
                    if (brd.findPiece(towerPos) != null && brd.findPiece(towerPos).getCountMove() == 0) {
                        for (int i = 2; i > 0; i--) {
                            if (brd.findPiece(new IChess.ChessPosition(POSX_KING - i, POSY_KING)) != null) {
                                wayVoid = false;
                                break;
                            }
                        }
                        if (wayVoid) {
                            tabPos.add(new IChess.ChessPosition(POSX_KING - 2, POSY_KING));
                        }
                    }
                }
            }
        }

        return tabPos;
    }
}
