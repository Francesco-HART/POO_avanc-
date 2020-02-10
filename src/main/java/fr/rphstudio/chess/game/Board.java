package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;


public class Board
{
    private Piece grid[][];
    private IChess.ChessType[] gridType = new IChess.ChessType[]{IChess.ChessType.TYP_ROOK,  IChess.ChessType.TYP_KNIGHT, IChess.ChessType.TYP_BISHOP , IChess.ChessType.TYP_KING, IChess.ChessType.TYP_QUEEN, IChess.ChessType.TYP_BISHOP , IChess.ChessType.TYP_KNIGHT, IChess.ChessType.TYP_ROOK};

    public Board()
    {
        this.grid = new Piece[8][8];
        createInitBoard();
    }

    public Piece findPiece(IChess.ChessPosition p){
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
                if (l == 1 ) {
                   grid[l][c] =  new Piece(IChess.ChessColor.CLR_WHITE , IChess.ChessType.TYP_PAWN);
                }
                if(l == 6)
                {
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_BLACK , IChess.ChessType.TYP_PAWN);
                }

                if (l == 0 ){
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_WHITE , gridType[c]);
                }
                if(l == 7)
                {
                    grid[l][c] =  new Piece(IChess.ChessColor.CLR_BLACK , gridType[c]);
                }

            }
        }
    }


}
