package fr.rphstudio.chess.game;

import fr.rphstudio.chess.interf.IChess;
import org.lwjgl.Sys;

public class Timer {
    long timeWhite = 0;
    long secondaryWhite = 0;
    long timeBlack = 0;
    long secondaryBlack = 0;
    long startTime = System.currentTimeMillis();
    boolean passTime = false;


    /**
     * startTime is a timer create at the beginning
     * @return actual time - startTime
     */
    public long getCurrentTime() {
        return System.currentTimeMillis() - startTime;
    }

    /**
     * reset the start time
     */
    public void startNewTime() {
        startTime = System.currentTimeMillis();
    }

    /**
     * give actual player time
     * @param color of the actual player
     * @param isPlaying if the player plays
     * @return player time
     */
    public long getPlayertime(IChess.ChessColor color, boolean isPlaying) {
        long time = 0;
        if (color == IChess.ChessColor.CLR_WHITE)
        {
            time = timeWhite;
            secondaryWhite = timeWhite;
        }
        else if (color == IChess.ChessColor.CLR_BLACK)
        {
            time = timeBlack;
            secondaryBlack =timeBlack;
        }
        if (isPlaying == true) {
            time += getCurrentTime();
        }

        return time;
    }

    /**
     * reset all
     */
    public void reset() {
        timeBlack = 0;
        timeWhite = 0;
        startNewTime();
    }

    /**
     * increments player time when playing
     * @param color of the player
     */
    public void newTour(IChess.ChessColor color)
    {
        passTime = false;
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
