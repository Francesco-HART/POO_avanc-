package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.EmptyCellException;
import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.interf.OutOfBoardException;
import fr.rphstudio.chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class ChessModel implements IChess
{
    private static ChessModel chessModel = new ChessModel();
    private Board board = new Board();
    private Timer time = new Timer();
    private ChessModel ()
    {

    }
    public static ChessModel getInstance()
    {
        return chessModel;
    }

    @Override
    public void reinit() {

    }

    @Override
    public ChessType getPieceType(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece myPiece = board.findPiece(p);
        if (myPiece != null){
            return myPiece.getType();
        }
        throw new EmptyCellException();
    }

    @Override
    public ChessColor getPieceColor(ChessPosition p) throws EmptyCellException, OutOfBoardException {
        Piece myPiece = board.findPiece(p);
        if (myPiece != null){
            return myPiece.getColor();
        }
        throw new EmptyCellException();
    }


    @Override
    public int getNbRemainingPieces(ChessColor color) {

        if (color != null){
            if ( color == ChessColor.CLR_BLACK){
                int count = board.countColor(color);
                return  count;
            }
            else if ( color == ChessColor.CLR_WHITE){
                int count = board.countColor(color);
                return  count;
            }
        }
        return 0;
    }

    @Override
    public List<ChessPosition> getPieceMoves(ChessPosition p) {
        Piece piece = null;
            piece = board.findPiece(p);
        if(piece == null){
            return new ArrayList<>();
        }
       else{
            return piece.getMoves(p, board);
        }
    }

    @Override
    public void movePiece(ChessPosition p0, ChessPosition p1)
    {
        board.previousBoard();
        Piece piece = null;
            piece = board.findPiece(p0);
        board.movePiece(p0 , p1);
        int nbMoves = piece.countMoves();
        time.newTour(piece.getColor());
    }

    @Override
    public ChessKingState getKingState(ChessColor color)
    {
        return board.findKing(color);
    }

    @Override
    public List<ChessType> getRemovedPieces(ChessColor color) {
        return new ArrayList<>();
    }

    @Override
    public boolean undoLastMove() {
        return board.getPrevious();
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying)
    {
        return time.getPlayertime(color,isPlaying);
    }
}
