package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;

import java.util.ArrayList;
import java.util.List;

/**
 * method for move bishop , rook and queen
 */
public class MovePiece {
    /**
     * pemis to access all moves in line for the queen and the rook
     * @param p pos of the target piece
     * @param brd board
     * @return tab with all moves in line for rook and queen
     */
    public List<IChess.ChessPosition> moveDiagonal(IChess.ChessPosition p, Board brd) {
        List<IChess.ChessPosition> moves = new ArrayList<>();

        for (int dir = 0; dir <= 3; dir++) {
            int dx = 0;
            int dy = 0;
            switch (dir) {
                case 0:
                    dx = -1;
                    dy = -1;
                    break;
                case 1:
                    dx = -1;
                    dy = +1;
                    break;
                case 2:
                    dx = +1;
                    dy = -1;
                    break;
                case 3:
                    dx = +1;
                    dy = +1;
                    break;
                default:
                    break;
            }
            for (int dist = 1; dist <= 7; dist++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + dx * dist, p.y + dy * dist);
                if (pos.x < 8 && pos.y < 8 && pos.x >= 0 && pos.y >= 0) {
                    if (brd.findPiece(pos) == null) {

                        moves.add(pos);
                    } else if (brd.findPiece(pos).getColor() != brd.findPiece(p).getColor()) {

                        moves.add(pos);
                        break;

                    } else break;

                } else {
                    break;
                }
            }
        }
        return moves;
    }

    /**
     * pemis to access all moves in diagonal for the queen and the rook
     * @param p pos of the target piece
     * @param brd board
     * @return tab with all moves in digonalfor rook and queen
     */
    public List<IChess.ChessPosition> moveForward(IChess.ChessPosition p, Board brd) {
        List<IChess.ChessPosition> moves = new ArrayList<>();

        for (int dir = 0; dir <= 3; dir++) {
            int dx = 0;
            int dy = 0;
            switch (dir) {
                case 0:
                    dy = -1;
                    break;
                case 1:
                    dx = +1;
                    break;
                case 2:
                    dy = +1;
                    break;
                case 3:
                    dx = -1;
                    break;
                default:
                    break;
            }
            for (int dist = 1; dist <= 7; dist++) {
                IChess.ChessPosition pos = new IChess.ChessPosition(p.x + dx * dist, p.y + dy * dist);
                if (pos.x < 8 && pos.y < 8 && pos.x >= 0 && pos.y >= 0) {
                    if (brd.findPiece(pos) == null) {

                        moves.add(pos);
                    } else if (brd.findPiece(pos).getColor() != brd.findPiece(p).getColor()) {
                        moves.add(pos);
                        break;

                    } else break;
                } else {
                    break;
                }
            }
        }
        return moves;
    }
}
