package com.example.r2_d2.fantasyfutbol;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerListActivity extends AppCompatActivity {

    private static Team inspectTeam;
    private static ArrayList<Player> players;
    private static Player editPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);

////////
        players = new ArrayList<>();
        for(Player player : inspectTeam.getPlayerList().values()){
            players.add(player);

        }

        TextView title = (TextView)findViewById(R.id.teamText);
        title.setText(inspectTeam.getTeamName());

        //initiate player pictures
        ImageView[] playerPics = new ImageView[4];
        playerPics[0] = (ImageView)findViewById(R.id.playerImage1);
        playerPics[1] = (ImageView)findViewById(R.id.playerImage2);
        playerPics[2] = (ImageView)findViewById(R.id.playerImage3);
        playerPics[3] = (ImageView)findViewById(R.id.playerImage4);

        //initiate text fields
        TextView[] playerTexts = new TextView[4];
        playerTexts[0] = (TextView)findViewById(R.id.playerText1);
        playerTexts[1] = (TextView)findViewById(R.id.playerText2);
        playerTexts[2] = (TextView)findViewById(R.id.playerText3);
        playerTexts[3] = (TextView)findViewById(R.id.playerText4);

        //loop draws each player and picture
        int i = 0;
        for(Player player : inspectTeam.getPlayerList().values()) {
            playerTexts[i].setText(player.toString());
            if(player.getDrawableID()!=0) {
                playerPics[i].setImageResource(player.getDrawableID());
            }
            i++;
        }

        //Back Button
        Button backButton = (Button) findViewById(R.id.backButton2);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        //set clickable players
        LinearLayout[] playerLayouts = new LinearLayout[4];
        playerLayouts[0] = (LinearLayout)findViewById(R.id.playerLayout1);
        playerLayouts[1] = (LinearLayout)findViewById(R.id.playerLayout2);
        playerLayouts[2] = (LinearLayout)findViewById(R.id.playerLayout3);
        playerLayouts[3] = (LinearLayout)findViewById(R.id.playerLayout4);


        for(int j = 0; j < players.size(); j++) {
            playerLayouts[j].setOnClickListener(new NewOnCLickListener(playerLayouts[j], playerLayouts, players.get(j)));
        }



        //add listener for save atributes button

        Button saveEditButton = (Button)findViewById(R.id.saveNewButton);
        saveEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentView = (View)(((View)v.getParent()).getParent());

                EditText nameText = (EditText)parentView.findViewById(R.id.editName);
                EditText goalsText = (EditText)parentView.findViewById(R.id.editGoals);
                EditText assistsText = (EditText)parentView.findViewById(R.id.editAssists);
                EditText savesText = (EditText)parentView.findViewById(R.id.editSaves);



                try {
                    if (nameText.getText().toString().equals(editPlayer.getPlayerName())) {//save changes
                        editPlayer.setNumGoals(Integer.parseInt(goalsText.getText().toString()));
                        editPlayer.setNumAssists(Integer.parseInt(assistsText.getText().toString()));
                        editPlayer.setNumSaves(Integer.parseInt(savesText.getText().toString()));

                    }
                } catch(Exception e) {
                    //create new player
                        if (inspectTeam.getPlayerList().size() < 4) {//only add if space on team, max 4
                            Player steve = new Player(nameText.getText().toString(), R.drawable.newguy);
                            steve.setNumGoals(Integer.parseInt(goalsText.getText().toString()));
                            steve.setNumAssists(Integer.parseInt(assistsText.getText().toString()));
                            steve.setNumSaves(Integer.parseInt(savesText.getText().toString()));

                            inspectTeam.addPlayer(steve);//I just called him steve, ok? Dont be judgin'
                        }

                }

            }
        });
    }

    //sets the team and makes an indexed array of the players
    public static void setInspectTeam(Team initTeam) {
        inspectTeam = initTeam;

    }

    public static void setEditPlayer(Player player) {
        editPlayer = player;
    }



}




// ---=== New Class Listener ===--- //


class NewOnCLickListener implements View.OnClickListener{

    private LinearLayout playerLayout;
    private LinearLayout[] allPlayers;
    private Player player;

    public NewOnCLickListener(LinearLayout initPlayerLayout, LinearLayout[] initAllPlayers, Player initPlayer) {
        playerLayout = initPlayerLayout;
        allPlayers = initAllPlayers;
        player = initPlayer;

    }

    public void onClick(View view) {
        for(LinearLayout playerLay : allPlayers) {
            playerLay.setBackgroundColor(Color.TRANSPARENT);
        }
        playerLayout.setBackgroundColor(Color.GRAY);

        View parentView = (View)(((View)view.getParent()).getParent());//find outer parent

        EditText nameText = (EditText)parentView.findViewById(R.id.editName);
        EditText goalsText = (EditText)parentView.findViewById(R.id.editGoals);
        EditText assistsText = (EditText)parentView.findViewById(R.id.editAssists);
        EditText savesText = (EditText)parentView.findViewById(R.id.editSaves);

        nameText.setText(player.getPlayerName());
        goalsText.setText(""+player.getNumGoals());
        assistsText.setText(""+player.getNumAssists());
        savesText.setText(""+player.getNumSaves());

        PlayerListActivity.setEditPlayer(player);

    }
}
