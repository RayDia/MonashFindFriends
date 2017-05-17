package com.example.dyl59.report_screen;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PieChart mPieChart;
    private String[] x = new String[] { "AItem", "BItem", "CItem", "DItem", "EItem" };
    private float[] y = { 21.1f, 20f, 21.5f, 18.5f, 18.9f };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PieChart chart =(PieChart) findViewById(R.id.chart);
        List<PieEntry> entries = new ArrayList<PieEntry>();

        ArrayList<String> xVals = new ArrayList<String>();
        //for (int i=0; i<xAxis.length; i++){
        //    xVals.add(i, x[i]);
        //    entries.add(new PieEntry((float)(y[i]), xVals));
        //}
        entries.add(new PieEntry(18.5f, "FIT5183"));
        entries.add(new PieEntry(26.7f, "FIB5663"));
        entries.add(new PieEntry(24.0f, "FDS4562"));
        entries.add(new PieEntry(30.8f, "FIT5186"));

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


        PieDataSet dataSet = new PieDataSet(entries, "Pie chart");
        dataSet.setColors(colors);
        dataSet.setValueTextSize(11f);
        PieData lineData = new PieData(dataSet);
        chart.setData(lineData);
        chart.setHoleRadius(0f);
        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(12f);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

    }
}
