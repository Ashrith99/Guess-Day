package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.GregorianCalendar;


public class Activity2 extends AppCompatActivity {
          TextView Qns,final_marks;
          Button b1,b2,b3,b4,b5;
          RelativeLayout R1;
          LinearLayout L1;
          int ans,marks = 0;
          String S1;

          private final View.OnClickListener click = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
               if (((Button)findViewById(v.getId())).getText().toString().equals(S1)){
                   que();
                   marks +=5;
               }else{
                    L1.setVisibility(View.INVISIBLE);
                    R1.setVisibility(View.INVISIBLE);
                    final_marks.setText("Your Score is " + marks) ;
               }

        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Qns = findViewById(R.id.textView4);
        b1 = findViewById(R.id.quizButton);
        b2 = findViewById(R.id.option1);
        b3 = findViewById(R.id.option2);
        b4 = findViewById(R.id.option3);
        b5 = findViewById(R.id.option4);
        R1 = findViewById(R.id.relativeLayout);
        L1 = findViewById(R.id.linearLayout);
        final_marks = findViewById(R.id.finalmarks);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L1.setVisibility(View.INVISIBLE);
                R1.setVisibility(View.VISIBLE);
            }{
                Qns.setText(random_Date());
                getOptions();
                b2.setText(options.get(0));
                b3.setText(options.get(1));
                b4.setText(options.get(2));
                b5.setText(options.get(3));
                options.clear();
            }
        });
        b2.setOnClickListener(click);
        b3.setOnClickListener(click);
        b4.setOnClickListener(click);
        b5.setOnClickListener(click);

    }

      ArrayList<String> days = new ArrayList<>();
    private String random_Date(){
        GregorianCalendar gc = new GregorianCalendar();

        int year = randbetween(2000,2100);
        gc.set(GregorianCalendar.YEAR,year);
        int dayOfYear = randbetween(1,gc.getActualMaximum(GregorianCalendar.DAY_OF_YEAR));
        gc.set(GregorianCalendar.DAY_OF_YEAR,dayOfYear);
        ans = gc.get(GregorianCalendar.DAY_OF_WEEK);
        return "What will be the day on " + gc.get(GregorianCalendar.DAY_OF_MONTH) + "-" + (gc.get(GregorianCalendar.MONTH)+1) + "-" + gc.get(GregorianCalendar.YEAR);


    }
         private static int randbetween(int start,int end){
           return start + (int)Math.round(Math.random()*(end - start));
         }
         private final ArrayList<String> options = new ArrayList<>();
          public void getOptions(){
              ArrayList<String> Day = new ArrayList<>();
              Day.add("SUNDAY");
              Day.add("MONDAY");
              Day.add("TUESDAY");
              Day.add("WEDNESDAY");
              Day.add("THURSDAY");
              Day.add("FRIDAY");
              Day.add("SATURDAY");
              S1 = Day.get(ans-1);
              Day.remove(ans-1);
              Collections.shuffle(Day);
              options.add(S1);
              for (int i=0;i<3;i++){
                  options.add(Day.get(i));
              }
              Collections.shuffle(options);



          }

          public void que(){
              Qns.setText(random_Date());
              getOptions();
              b2.setText(options.get(0));
              b3.setText(options.get(1));
              b4.setText(options.get(2));
              b5.setText(options.get(3));
              options.clear();
          }
}