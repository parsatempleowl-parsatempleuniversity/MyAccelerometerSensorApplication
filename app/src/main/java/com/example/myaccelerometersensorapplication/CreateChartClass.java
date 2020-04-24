package com.example.myaccelerometersensorapplication;

import android.graphics.Color;
import android.hardware.SensorEvent;

import com.github.mikephil.charting.charts.BarLineChartBase;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class CreateChartClass {

    private List<String> var = new ArrayList<String>();
    private ArrayList<String> xAXES = new ArrayList<>();
    private ArrayList<Entry> yAXESsin = new ArrayList<>();
    private ArrayList<Entry> yAXEScos = new ArrayList<>();
    private ArrayList<Entry> var1Array = new ArrayList<>();
    private ArrayList<Entry> var2Array = new ArrayList<>();
    private ArrayList<Entry> var3Array = new ArrayList<>();
    private LineChart lineChart;

    public  void create(SensorEvent event){
        arrayXY(event);

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();
        LineDataSet lineDataSet1 = new LineDataSet(yAXEScos,"actual production");
        lineDataSet1.setDrawCircles(false);
        lineDataSet1.setColor(Color.BLUE);
        lineDataSet1.setLineWidth(4.5f);
        lineDataSet1.setValueTextSize(12f);
        lineDataSet1.setValueTextColor(Color.BLUE);

        LineDataSet lineDataSet2 = new LineDataSet(yAXESsin,"cumulative production");
        lineDataSet2.setDrawCircles(false);
        lineDataSet2.setColor(Color.RED);
        lineDataSet2.setLineWidth(3.5f);
        lineDataSet2.setValueTextSize(12f);
        lineDataSet2.setValueTextColor(Color.RED);

        LineDataSet lineDataSet3 = new LineDataSet(var1Array,"var1");
        lineDataSet3.setDrawCircles(false);
        lineDataSet3.setColor(Color.CYAN);
        lineDataSet3.setLineWidth(2.5f);
        lineDataSet3.setValueTextSize(12f);
        lineDataSet3.setValueTextColor(Color.CYAN);

        LineDataSet lineDataSet4 = new LineDataSet(var2Array,"var2");
        lineDataSet4.setDrawCircles(false);
        lineDataSet4.setColor(Color.BLACK);
        lineDataSet4.setLineWidth(2f);
        lineDataSet4.setValueTextSize(12f);
        lineDataSet4.setValueTextColor(Color.BLACK);

        LineDataSet lineDataSet5 = new LineDataSet(var3Array,"var3");
        lineDataSet5.setDrawCircles(false);
        lineDataSet5.setColor(Color.GREEN);
        lineDataSet5.setValueTextColor(Color.GREEN);
        lineDataSet5.setValueTextSize(12f);

        lineDataSets.add(lineDataSet1);
        lineDataSets.add(lineDataSet2);
        lineDataSets.add(lineDataSet3);
        lineDataSets.add(lineDataSet4);
        lineDataSets.add(lineDataSet5);

        BarLineChartBase mChart;
        lineChart.setData(new LineData(lineDataSets));

        lineChart.notifyDataSetChanged();
        lineChart.invalidate();
        lineChart.setVisibleXRangeMaximum(65f);
    }

    private void arrayXY(SensorEvent event) {
        yAXESsin.add(new Entry(40, 0));
        yAXEScos.add(new Entry(40, 0));
        var1Array.add(new Entry(0, event.values[0] + 2));
        var2Array.add(new Entry(0, event.values[1] + 2));
        var3Array.add(new Entry(0, event.values[2] + 2));
    }
}
