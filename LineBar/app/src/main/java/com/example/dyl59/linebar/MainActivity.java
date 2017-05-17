package com.example.dyl59.linebar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.List;
*/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BarChart barchart = (BarChart)findViewById(R.id.mBarChart);

        XAxis xAxis = barchart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        YAxis leftAxis = barchart.getAxisLeft();
        leftAxis.setLabelCount(8, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        YAxis rightAxis = barchart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setLabelCount(8, false);
        rightAxis.setSpaceTop(15f);
        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
        Legend l = barchart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);

        String[] xVals = new String[] { "AItem", "BItem", "CItem", "DItem", "EItem", "FItem" };
        float[] yVals = { 2f, 4f, 6f, 8f, 7f, 3f };
        List<BarEntry> entries = new ArrayList<BarEntry>();
        ArrayList<String> xVal = new ArrayList<>();//X轴数据
        //for (int i = 0; i < xVals.length; i++) {//添加数据源
        //    xVal.add(xVals[i]);
         //   entries.add(new BarEntry(((float)(yVals[i])), i));
        //}
        //entries.add(new BarEntry(1f, 28.5f));
        //entries.add(new BarEntry(2f, 32.5f));
        //entries.add(new BarEntry(3f, 39.0f));
        List<BarEntry> entriesGroup1 = new ArrayList<>();
        List<BarEntry> entriesGroup2 = new ArrayList<>();
        List<BarEntry> entriesGroup3 = new ArrayList<>();
        float[] group1 = { 28.5f, 32.5f, 39.0f};
        for(int i = 0; i < group1.length; i++) {
            entriesGroup1.add(new BarEntry(i, group1[i]));
            entriesGroup2.add(new BarEntry(i, group1[i]));
            entriesGroup3.add(new BarEntry(i, group1[i]));
        }
        BarDataSet set1 = new BarDataSet(entriesGroup1, "Caulfield Campus");
        BarDataSet set2 = new BarDataSet(entriesGroup2, "Chadstone");
        BarDataSet set3 = new BarDataSet(entriesGroup3, "Clayton Campus");
        BarData data = new BarData(set1, set2, set3);
        //data.setBarWidth(barWidth); // set the width of each bar
        BarDataSet barDataSet = new BarDataSet(entries, "BarChart");
        ArrayList<IBarDataSet> tbardata = new ArrayList<>();
        tbardata.add(barDataSet);
        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);
        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);
        colors.add(ColorTemplate.getHoloBlue());
        barDataSet.setColors(colors);
        BarData bardata = new BarData(tbardata);
                //(xVals, threebardata);
        barchart.setData(data);
        barchart.getXAxis().setDrawGridLines(true);
        barchart.getAxisRight().setEnabled(false);

    }
}