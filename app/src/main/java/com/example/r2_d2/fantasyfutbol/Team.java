package com.example.r2_d2.fantasyfutbol;

import android.graphics.Color;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by R2-D2 on 9/28/15.
 */
public class Team {

    // ---=== Instance Variables ===--- //

    public static ArrayList<Team> teamList = new ArrayList<>();

    private String teamName;
    private Hashtable<String, Player> playerList;
    private int numTeamMembers;
//    private Color teamColor1;
//    private Color teamColor2;



    // ---=== Methods ===--- //

    public Team(String initTeamName) {
        teamName = initTeamName;
        if(initTeamName == null) {
            teamName = "Unnamed Team";
        }

        playerList = new Hashtable<String, Player>();

        teamList.add(this);

    }//ctor


    //todo: implimant team colors
//    public Team(String initTeamName, Color initColor1, Color initColor2) {
//        teamName = initTeamName;
//
//        playerList = new Hashtable<String, Player>();
//
//        teamList.put(initTeamName, this);
//
//
//    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String initTeamName) {
        teamName = initTeamName;
    }

    public int getNumTeamMembers() {
        return numTeamMembers;
    }

    public void setNumTeamMembers(int initNumTeamMembers) {
        numTeamMembers = initNumTeamMembers;
    }

    public Hashtable<String, Player> getPlayerList() {
        return playerList;
    }


    public void addPlayer(Player player) {
        playerList.put(player.getPlayerName(), player);
        ++numTeamMembers;
    }


    public String toString() {
        String message = teamName + "\n\n" + numTeamMembers + " members\n";
        for(Player player : this.playerList.values()) {
            message += (player.getPlayerName() + ", ");
        }

        return message;
    }





}
