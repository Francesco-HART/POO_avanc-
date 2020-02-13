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

    public void resetTimer(ChessColor color, boolean isPlaying) {

        new Timer();
        //ok

    }


    public void reinit() {

        board.createInitBoard();

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
        if (p.x>7 || p.x<0 || p.y>7 || p.y<0){
            throw new OutOfBoardException();
        }
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
        Piece piece = board.findPiece(p);
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
        Piece piece = board.findPiece(p0);
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
        return false;
    }

    @Override
    public long getPlayerDuration(ChessColor color, boolean isPlaying)
    {
        return time.getPlayertime(color,isPlaying);
    }
}
