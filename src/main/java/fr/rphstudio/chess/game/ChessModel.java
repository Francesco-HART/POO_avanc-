package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.interf.OutOfBoardException;
import fr.rphstudio.chess.launcher.MainLauncher;
import fr.rphstudio.chess.pieces.Pawn;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess {
    private static ChessModel chessModel = new ChessModel();
    private Board board = new Board();
    private Timer time = new Timer();
    private ChessModel() {

    }

    /**
     *
     * @return
     */
    public static ChessModel getInstance() {
        return chessModel;
    }

    /**
     * clear the board
     */
    public void reinit() {

        board.createInitBoard();
        board.restartSave();
        time.reset();

    }

    /**
     * take the piece type
     * @param p x/y position on the board where we want to get the piece type.
     * @return the type
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece myPiece = board.findPiece(p);
        if (myPiece != null) {
            return myPiece.getType();
        }
        throw new EmptyCellException();
    }

    /**
     * take piece color
     * @param p x/y position on the board where we want to get the piece color.
     * @return the color
     * @throws EmptyCellException
     * @throws OutOfBoardException
     */
    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x>7 || p.x<0 || p.y>7 || p.y<0){
            throw new OutOfBoardException();
        }
        Piece myPiece = board.findPiece(p);
        if (myPiece != null) {
            return myPiece.getColor();
        }
        throw new EmptyCellException();
    }

    /**
     * count the number of pieces for the player
     * @param color the requested color of the pieces to count.
     * @return the number of pieces
     */
    @Override
    public int getNbRemainingPieces(ChessColor color) {

        if (color != null) {
            if (color == ChessColor.CLR_BLACK) {
                int count = board.countColor(color);
                return count;
            } else if (color == ChessColor.CLR_WHITE) {
                int count = board.countColor(color);
                return count;
            }
        }
        return 0;
    }

    /**
     *
     * @param p requested piece position.
     * @return the number of possible movement
     */
    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        Piece piece = null;
        piece = board.findPiece(p);
        if (piece == null) {
            return new ArrayList<>();
        } else {
            return piece.getMoves(p, board);
        }
    }

    /**
     * Move a piece to the selected position
     * @param p0 source position on the board.
     * @param p1 destination position on the board.
     */
    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        board.previousBoard();
        Piece piece = null;
        piece = board.findPiece(p0);
        board.findPiece(p0).setCountMove(board.findPiece(p0).getCountMove());
        board.movePiece(p0, p1);

        time.newTour(piece.getColor());
    }

    /**
     * take the king color
     * @param color the requested king color.
     * @return the color of the king
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        return board.findKing(color);
    }

    /**
     *
     * @param color color of the removed pieces
     * @return a list of each piece removed
     */
    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();
    }

    /**
     * save the time for the previous move
     * @return time when the last move was played
     */
    @Override
    public boolean undoLastMove() {
        time.previousTime();
        return board.getPrevious();
    }

    /**
     * take time of the player
     * @param color The color of the player from whom we want to get the current duration.
     * @param isPlaying Indicates if the player color is the one currently playing.
     * @return time of a player when playing
     */
    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return time.getPlayertime(color, isPlaying);
    }
}
