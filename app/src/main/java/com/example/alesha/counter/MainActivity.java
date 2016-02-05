package com.example.alesha.counter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Integer barsa = 0;
    public Integer real = 0;

    private TextView counterBarsa;
    private TextView counterReal;
    private Button realB;
    private Button barsaB;
    private Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        counterBarsa = (TextView) findViewById(R.id.barsaArea);
        counterReal = (TextView) findViewById(R.id.realArea);
        realB = (Button) findViewById(R.id.button2);
        barsaB = (Button) findViewById(R.id.button);
        reset = (Button) findViewById(R.id.reset);
    }

    @Override
    public void onStart(){
        super.onStart();
        initRealButton();
        initBarsaButton();
        initResetButton();
    }

    private void initRealButton(){
        realB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                real++;
                resetUI();
            }
        });
    }

    private void initBarsaButton(){
        barsaB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                barsa++;
                resetUI();
            }
        });
    }

    private void initResetButton(){
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                real=0;
                barsa=0;
                resetUI();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("barsacount",barsa);
        outState.putInt("realcount", real);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        barsa=savedInstanceState.getInt("barsacount");
        real=savedInstanceState.getInt("realcount");
        resetUI();

    }

    public void resetUI(){
        counterBarsa.setText(barsa.toString());
        counterReal.setText(real.toString());
    }
}
