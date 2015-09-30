package com.example.r2_d2.fantasyfutbol;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Hashtable;

public class MainGameActivity extends AppCompatActivity {


    // ---=== Instance Variables ===--- //



    // ---=== Methods ===--- //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);


        // Starting Teams and Players only if none exist//
        if(Team.teamList.size() == 0) {
            Team teamSupplies = new Team("Official Buisness");
            teamSupplies.addPlayer(new Player("James Tape", R.drawable.tape));
            teamSupplies.addPlayer(new Player("Jimmy Pencil", R.drawable.pencil));
            teamSupplies.addPlayer(new Player("Sven Stapler", R.drawable.stapler));
            teamSupplies.addPlayer(new Player("Bobby Pen", R.drawable.pen));

            Team teamStuff = new Team("Other Stuff");
            teamStuff.addPlayer(new Player("Kyle Keys", R.drawable.keys));
            teamStuff.addPlayer(new Player("Steve Sock", R.drawable.sock));
            teamStuff.addPlayer(new Player("Harry Headphones", R.drawable.headphones));
            teamStuff.addPlayer(new Player("Wally Wallet", R.drawable.wallet));

        }

        // Back Button
        Button backButton = (Button)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



        TextView teamText = (TextView)findViewById(R.id.teamText);
        teamText.setText(Team.teamList.get(0).toString());

        SeekBar teamSelectBar = (SeekBar)findViewById(R.id.seekBarTeam);
        teamSelectBar.setMax(Team.teamList.size() - 1);
        teamSelectBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                TextView teamText = (TextView)findViewById(R.id.teamText);
                teamText.setText(Team.teamList.get(progress).toString());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                seekBar.setMax(Team.teamList.size()-1);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });//seekBar


        Button teamSelectButton = (Button)findViewById(R.id.teamSelectButton);
        teamSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainGameActivity.this, PlayerListActivity.class));

                SeekBar teamSelectBar = (SeekBar)findViewById(R.id.seekBarTeam);
                PlayerListActivity.setInspectTeam(Team.teamList.get(teamSelectBar.getProgress()));


            }
        });//inspect button



//        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.activity_main_game, R.id.textView ,Team.teamList);
//        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//
//        Spinner teamList = (Spinner)findViewById(R.id.teamList);
//        teamList.setAdapter(adapter);
//        teamList.setWillNotDraw(false);
//
//        teamList.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main_game, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
