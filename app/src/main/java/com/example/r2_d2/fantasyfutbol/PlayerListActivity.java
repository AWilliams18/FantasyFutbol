package com.example.r2_d2.fantasyfutbol;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerListActivity extends AppCompatActivity {

    private static Team inspectTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);


        TextView title = (TextView)findViewById(R.id.teamText);
        title.setText(inspectTeam.getTeamName());

        ImageView[] playerPics = new ImageView[4];
        playerPics[0] = (ImageView)findViewById(R.id.playerImage1);
        playerPics[1] = (ImageView)findViewById(R.id.playerImage2);
        playerPics[2] = (ImageView)findViewById(R.id.playerImage3);
        playerPics[3] = (ImageView)findViewById(R.id.playerImage4);





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

    }

    public static void setInspectTeam(Team initTeam) {
        inspectTeam = initTeam;
    }

}
