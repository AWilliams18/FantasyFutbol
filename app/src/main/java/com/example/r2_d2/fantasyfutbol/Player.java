package com.example.r2_d2.fantasyfutbol;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.LinearLayout;

/**
 * Created by R2-D2 on 9/20/15.
 */
public class Player {

    // ---=== Instance Variables ===--- //

    private String playerName;
    private int numGoals;
    private int numSaves;
    private int numAssists;
    private int drawableID;
    private LinearLayout display;


    // ---=== Methods ===--- //

    public Player(String initPlayerName, int initDrawableID) {
        playerName = initPlayerName;
        if(playerName == null) {
            playerName = "Unnamed Guy";
        }
        numGoals = 0;
        numSaves = 0;
        numAssists = 0;

        drawableID = initDrawableID;

        //todo: figure out icons and creating layouts
//        display = new LinearLayout(MainGameActivity.class);
    }//ctor


    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String initPlayerName) {
        playerName = initPlayerName;
    }

    public int getDrawableID() {
        return drawableID;
    }

    public void setDrawableID(int initID) {
        drawableID = initID;
    }


    public int getNumGoals() {
        return numGoals;
    }

    public void addAssist() {
        ++numAssists;
    }

    public void setNumGoals(int newNumGoals) {
        numGoals = newNumGoals;
    }

    public int getNumAssists() {
        return numAssists;
    }

    public void addGoals() {
        ++numGoals;
    }

    public void setNumAssists(int newNumAssists) {
        numAssists = newNumAssists;
    }

    public int getNumSaves() {
        return numSaves;
    }

    public void addSaves() {
        ++numSaves;
    }

    public void setNumSaves(int newNumSaves) {
        numSaves = newNumSaves;
    }


    public String toString() {
        return playerName + "\n" + numGoals + " goals, " + numSaves + " saves, " +
                            numAssists + " assists";
    }



}
