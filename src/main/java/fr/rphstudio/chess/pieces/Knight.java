package fr.rphstudio.chess.pieces;

import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.game.MovePiece;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;

import java.util.ArrayList;
import java.util.List;

public class Knight implements IMove {
    @Override
    public List<IChess.ChessPosition> move(IChess.ChessPosition p, Board brd) {
        List<IChess.ChessPosition> tabPos = new ArrayList<>();
        int POSX_KNIGHT = p.x;
        int POSY_KNIGHT = p.y;

        for (int i = POSX_KNIGHT - 2; i <= POSX_KNIGHT + 2; i++) {
            for (int j = POSY_KNIGHT - 2; j <= POSY_KNIGHT + 2; j++) {
                int dx = Math.abs(p.x - i);
                int dy = Math.abs(p.y - j);
                if (dx + dy == 3) {
                    IChess.ChessPosition posCan = new IChess.ChessPosition(i, j);
                    if (posCan.x < 8 && posCan.y < 8 && posCan.x >= 0 && posCan.y >= 0) {

                        if (brd.findPiece(posCan) == null || brd.findPiece(posCan).getColor() != brd.findPiece(p).getColor())
                        {
                                    tabPos.add(posCan);
                        }

                    }

                }
            }
        }


        /*
        tabPos.add(new IChess.ChessPosition(p.x+1, p.y-2));
        tabPos.add(new IChess.ChessPosition(p.x-1, p.y-2));
        tabPos.add(new IChess.ChessPosition(p.x+1, p.y+2));
        tabPos.add(new IChess.ChessPosition(p.x-1, p.y+2));
        tabPos.add(new IChess.ChessPosition(p.x+2, p.y-1));
        tabPos.add(new IChess.ChessPosition(p.x-2, p.y-1));
        tabPos.add(new IChess.ChessPosition(p.x+2, p.y+1));
        tabPos.add(new IChess.ChessPosition(p.x-2, p.y+1));
        */


        return tabPos;
    }
}