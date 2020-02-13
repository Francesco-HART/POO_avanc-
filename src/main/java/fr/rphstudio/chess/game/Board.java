package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import fr.rphstudio.chess.interf.IMove;
import fr.rphstudio.chess.interf.OutOfBoardException;
import fr.rphstudio.chess.pieces.*;

import java.util.ArrayList;
import java.util.List;


public class Board
{

    private Piece grid[][];
    private IChess.ChessType[] gridType =
            new IChess.ChessType[]{IChess.ChessType.TYP_ROOK,  IChess.ChessType.TYP_KNIGHT, IChess.ChessType.TYP_BISHOP , IChess.ChessType.TYP_KING, IChess.ChessType.TYP_QUEEN, IChess.ChessType.TYP_BISHOP , IChess.ChessType.TYP_KNIGHT, IChess.ChessType.TYP_ROOK};
    private IMove[] gridMoves = new IMove[]{new Rook(), new Knight(), new Bishop(), new King(), new Queen(), new Bishop(), new Knight(), new Rook()};
    private Piece retardedBoard [][];
    public Board()
    {
        this.grid = new Piece[8][8];
        createInitBoard();
    }

    public Piece findPiece(IChess.ChessPosition p)
    {
        if (p.y < 0 || p.y > 7 || p.x < 0 || p.x >  7)
        {
            return null;
        }
        return this.grid[p.y][p.x];
    }

    public int countColor(IChess.ChessColor c)
    {
        int count = 0;
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                if(grid[i][j] != null && grid[i][j].getColor() == c)
                {
                    count++;
                }
            }
        }
        return count;
    }

    public void createInitBoard()
    {
        for(int l = 0; l < 8;l++)
        {
            for (int c = 0; c < 8;c++)
            {
                if (l == 0 ){
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_WHITE , gridType[c] , gridMoves[c]);
                }
                if (l == 1 ) {
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_WHITE , IChess.ChessType.TYP_PAWN, new Pawn());
                }


                if(l == 6)
                {
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_BLACK , IChess.ChessType.TYP_PAWN, new Pawn());
                }
                if(l == 7)
                {
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_BLACK , gridType[c],  gridMoves[c]);
                }
            }
        }
    }

    public IChess.ChessKingState findKing(IChess.ChessColor color)
    {
        IChess.ChessKingState kingState = IChess.ChessKingState.KING_SAFE;
        List<IChess.ChessPosition> listPos;
        List<IChess.ChessPosition> alllistPos = new ArrayList<>();
        IChess.ChessPosition posKing = new IChess.ChessPosition();
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid.length; j++)
            {
                if(grid[i][j] != null)
                {
                    if(grid[i][j].getType() == IChess.ChessType.TYP_KING && grid[i][j].getColor() == color)
                    {
                        posKing.x = j;
                        posKing.y = i;
                    }
                    else if (grid[i][j].getType() != IChess.ChessType.TYP_KING && grid[i][j].getColor() != color)
                    {
                        IChess.ChessPosition posOther = new IChess.ChessPosition(j,i);
                        listPos = grid[i][j].getMoves(posOther,this);
                        alllistPos.addAll(listPos);
                    }
                }
            }
        }
        for (int k = 0; k < alllistPos.size(); k++)
        {
            if (alllistPos.get(k).y == posKing.y && alllistPos.get(k).x == posKing.x)
            {
                kingState = IChess.ChessKingState.KING_THREATEN;
                return kingState;
            }
            else
            {
                kingState = IChess.ChessKingState.KING_SAFE;
            }
        }
        return kingState;
    }

    public void movePiece(IChess.ChessPosition p0,IChess.ChessPosition p1)
    {
        grid[p1.y][p1.x] = grid[p0.y][p0.x];
        grid[p0.y][p0.x] = null;
    }

    public void previousBoard()
    {
        this.retardedBoard = new Piece[8][8];
        for (int i = 0; i < this.grid.length ; i++) {
            for (int j = 0; j < this.grid.length; j++) {
                retardedBoard[i][j] = this.grid [i][j];
            }
        }
    }

    public boolean getPrevious()
    {
        grid = retardedBoard;
        return true;
    }

}
