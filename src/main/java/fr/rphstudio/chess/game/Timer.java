package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import org.lwjgl.Sys;

public class Timer
{
    long timeWhite = 0;
    long timeBlack = 0;
    long startTime = System.currentTimeMillis();
    public long getTimer(IChess.ChessColor color,boolean isPlaying) {
        if (color == IChess.ChessColor.CLR_WHITE && isPlaying == true)
        {

            timeWhite = System.currentTimeMillis() - startTime;
            return timeWhite;
        }
        else if(color == IChess.ChessColor.CLR_BLACK && isPlaying == true)
        {
            timeBlack = System.currentTimeMillis() - startTime;
            return timeBlack;
        }
        return 0;
    }
}
