package com.example.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        void generate(int timeTable){

            ArrayList<String> timeTableContent= new ArrayList<>();
            for(int i=1;i<=10;i++){
                timeTableContent.add(Integer.toString(i*timeTable));
            }
            ListView setTable=findViewById(R.id.table);

            ArrayAdapter arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timeTableContent);
            setTable.setAdapter(arrayAdapter);

        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar= findViewById(R.id.seekBar);
        seekBar.setMax(20);
        seekBar.setProgress(10);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTable;
                if(progress<min){
                    timesTable=min;
                    seekBar.setProgress(min);
                    generate(timesTable);
                }
                else {
                    timesTable = progress;
                }
                generate(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        generate(10);
    }
}
