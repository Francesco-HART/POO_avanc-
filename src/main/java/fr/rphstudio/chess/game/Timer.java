package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import org.lwjgl.Sys;

public class Timer {
    long timeWhite = 0;
    long timeBlack = 0;
    long startTime = System.currentTimeMillis();

    public long getCurrentTime() {
        return System.currentTimeMillis() - startTime;
    }

    public void startNewTime() {
        startTime = System.currentTimeMillis();
    }

    public long getPlayertime(IChess.ChessColor color, boolean isPlaying) {
        long time = 0;
        if (color == IChess.ChessColor.CLR_WHITE) {
            time = timeWhite;
        } else if (color == IChess.ChessColor.CLR_BLACK) {
            time = timeBlack;
        }
        if (isPlaying == true) {
            time += getCurrentTime();
        }
        if (passTime == true)
        {
            if (color == IChess.ChessColor.CLR_BLACK)
            {
                time -= timeWhite;
            }
            else if (color == IChess.ChessColor.CLR_WHITE)
            {
                time -= timeBlack;
            }
        }
        return time;
    }

    public void reset() {
        timeBlack = 0;
        timeWhite = 0;
        startTime = System.currentTimeMillis();

    }


    public void newTour(IChess.ChessColor color) {
        if (color == IChess.ChessColor.CLR_WHITE) {
            timeWhite += getCurrentTime();
        } else if (color == IChess.ChessColor.CLR_BLACK) {
            timeBlack += getCurrentTime();
        }
        startNewTime();
    }
    public void previousTime()
    {
        passTime = true;
    }
}
