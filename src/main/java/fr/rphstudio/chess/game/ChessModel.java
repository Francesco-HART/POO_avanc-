package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.OutOfBoardException;


import java.util.ArrayList;
import java.util.List;

/**
 * scene
 */
public class ChessModel implements IChess {
    private static ChessModel chessModel = new ChessModel();
    private Board board = new Board();
    private Timer time = new Timer();
    private List<IChess.ChessType> whitePiecesEat = new ArrayList<>();
    private List<IChess.ChessType> blackPiecesEat = new ArrayList<>();
    private List<ChessType> tabPiecesEat;
    private boolean eat = false;


    private ChessModel() {

    }

    /**
     * return the scene
     *
     * @return
     */
    public static ChessModel getInstance() {
        return chessModel;
    }

    /**
     * crea an init board , reset the board and the time
     */
    public void reinit() {
        try {
            eat = false;
            board.createInitBoard();
            board.resetSave();
            time.reset();
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            whitePiecesEat.clear();
            blackPiecesEat.clear();
            tabPiecesEat.clear();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * find piece type
     *
     * @param p x/y position on the board where we want to get the piece type.
     * @return the type of one piece get with pos
     * @throws EmptyCellException  get type of null case
     * @throws OutOfBoardException out of board
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
     * find piece color
     *
     * @param p x/y position on the board where we want to get the piece color.
     * @return the type of one piece get with pos
     * @throws EmptyCellException  get type of null case
     * @throws OutOfBoardException out of board
     */
    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        if (p.x > 7 || p.x < 0 || p.y > 7 || p.y < 0) {
            throw new OutOfBoardException();
        }
        Piece myPiece = board.findPiece(p);
        if (myPiece != null) {
            return myPiece.getColor();
        }
        throw new EmptyCellException();
    }

    /**
     * counts the number of pieces not left depending on the color
     *
     * @param color the requested color of the pieces to count.
     * @return number of pieces not left depending on the color
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
     * find all moves for one piece get with pos
     *
     * @param p requested piece position.
     * @return all moves for one piece get with pos
     */
    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
       try {
           Piece piece = board.findPiece(p);
           if (piece == null) {
               return new ArrayList<>();
           } else {
               List<ChessPosition> moves = piece.getMoves(p, board);
               List<ChessPosition> validMoves = new ArrayList<>();
               for (ChessPosition move : moves) {
                   if (board.tryMove(p, move))
                       validMoves.add(move);
               }
               return validMoves;
           }
       }catch (Exception e){
           System.out.println(e);
           return new ArrayList<>();
       }
    }

    /**
     * to move a piece on the board
     *
     * @param p0 source position on the board.
     * @param p1 destination position on the board.
     */
    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1) {
        try {
            board.previousBoard();
            Piece piece = null;
            piece = board.findPiece(p0);

            eat = false;
            if (board.findPiece(p1) != null && board.findPiece(p0).getColor() != board.findPiece(p1).getColor()) {
                eat = true;
                if (board.findPiece(p1).getColor() == ChessColor.CLR_WHITE)
                    whitePiecesEat.add(0, board.findPiece(p1).getType());

                else if (board.findPiece(p1).getColor() == ChessColor.CLR_BLACK)
                    blackPiecesEat.add(0, board.findPiece(p1).getType());

            }

            board.movePiece(p0, p1);

            time.newTour(piece.getColor());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * get if king is in check
     *
     * @param color the requested king color.
     * @return state of king
     */
    @Override
    public ChessKingState getKingState(ChessColor color) {
        return board.findKing(color);
    }

    /**
     * get all pieces eat
     *
     * @param color color of the removed pieces
     * @return tab of pieces eat depending of color
     */
    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        try {
            if (color == ChessColor.CLR_WHITE)
                tabPiecesEat = whitePiecesEat;

            else
                tabPiecesEat = blackPiecesEat;
        } catch (Exception e) {
            System.out.println(e);
        }


        return tabPiecesEat;

    }

    /**
     * back to the previous board remove the last value on the tab of pieces eat
     *
     * @return previous board
     */
    @Override
    public boolean undoLastMove() {
        try {
            if (eat)
                tabPiecesEat.remove(0);
        } catch (Exception e) {
            System.out.println(e);
        }


        return board.getPrevious();
    }

    /**
     * time of play , depending color
     *
     * @param color     The color of the player from whom we want to get the current duration.
     * @param isPlaying Indicates if the player color is the one currently playing.
     * @return time play
     */
    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying) {
        return time.getPlayertime(color, isPlaying);
    }
}
