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

    /**
     * get time play for one player
     *
     * @param color     color for the piece
     * @param isPlaying if true the color select play
     * @return the time play
     */
    public long getPlayertime(IChess.ChessColor color, boolean isPlaying) {
        long time = 0;
        try {
            if (color == IChess.ChessColor.CLR_WHITE) {
                time = timeWhite;
            } else if (color == IChess.ChessColor.CLR_BLACK) {
                time = timeBlack;
            }
            if (isPlaying == true) {
                time += getCurrentTime();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return time;
    }

    /**
     * reset the timer
     */
    public void reset() {
        timeBlack = 0;
        timeWhite = 0;
        startTime = System.currentTimeMillis();

    }

    /**
     * permis to change tour of game
     *
     * @param color
     */
    public void newTour(IChess.ChessColor color) {
        try {
            if (color == IChess.ChessColor.CLR_WHITE) {
                timeWhite += getCurrentTime();
            } else if (color == IChess.ChessColor.CLR_BLACK) {
                timeBlack += getCurrentTime();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        startNewTime();
    }
}
