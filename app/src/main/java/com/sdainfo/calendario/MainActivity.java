package com.sdainfo.calendario;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.OnMonthChangedListener;

public class MainActivity extends AppCompatActivity {

    private MaterialCalendarView materialCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialCalendarView = findViewById(R.id.calendarView);
        materialCalendarView.state().edit().setMinimumDate(CalendarDay.from(2020, 1,1)).commit();
        materialCalendarView.state().edit().setMaximumDate(CalendarDay.from(2021,12,1)).commit();

        CharSequence meses[] = {"jan","fev","mar","abr","mai","jun","jul","ago","set","out","nov", "dez"};
        CharSequence semana[] = {"dom","seg","ter","qua","qui","sex","sab"};

        materialCalendarView.setTitleMonths(meses);
        materialCalendarView.setWeekDayLabels(semana);


        materialCalendarView.setOnMonthChangedListener(new OnMonthChangedListener() {
            @Override
            public void onMonthChanged(MaterialCalendarView widget, CalendarDay date) {
                Log.i("mes", "data" + (date.getMonth() + 1 +"/"+ date.getCalendar()));
            }
        });


    }
}