package rob.myappcompany.timetableapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    public void generateTimeTable(int timeTableNumber)
    {
        ArrayList<String> timetable = new ArrayList<String>();

        for(int i = 1 ; i <= 100 ; i++)
        {
            timetable.add(Integer.toString(timeTableNumber*i));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , timetable);
        listView.setAdapter(arrayAdapter);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar seekBar = findViewById(R.id.seekBar);
        listView = findViewById(R.id.listView);

        int max = 20;
        int startingPosition = 10;

        seekBar.setMax(max);
        seekBar.setProgress(startingPosition);

        generateTimeTable(startingPosition);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int min = 1;
            int timeTableNumber ;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress < min) {
                  timeTableNumber = min;
                  seekBar.setProgress(min);
                }
                else  {
                    timeTableNumber = progress;
                }
                Log.i("Time Table of: " , Integer.toString(timeTableNumber));

                generateTimeTable(timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
