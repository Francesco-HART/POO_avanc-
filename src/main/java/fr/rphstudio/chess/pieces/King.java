package fr.rphstudio.chess.pieces;
import fr.rphstudio.chess.game.Board;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
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
            }
        }
        System.out.println(tabPos);
        return tabPos;
    }
}