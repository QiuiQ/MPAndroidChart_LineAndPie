package com.example.kkjsu.modularization_for_charts;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;

import ChartsSetting.LineChartSetting;
import ChartsSetting.MyMarkerView;
import ChartsSetting.PieChartSetting;

public class MainActivity extends AppCompatActivity {
    //TableLayout childlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //childlayout=(TableLayout)findViewById(R.id.child_layout);
        PieChart pieChart=(PieChart) findViewById(R.id.pieChart);
        LineChart lineChart=(LineChart)findViewById(R.id.lineChart);
        TextView priceInfo=(TextView)findViewById(R.id.price);
        TextView dateInfo=(TextView)findViewById(R.id.date);

        LineChartSetting lineChartSetting=new LineChartSetting(lineChart, dateInfo, priceInfo);
        lineChartSetting.setData();

        String[]x=new String[]{"A基金", "B基金", "C基金", "D基金", "E基金", "F基金", "G基金", "H基金", "I基金"};
        double[] data = new double[]{10, 500, 499, 200, 300, 150, 310, 20, 35};

        PieChartSetting pieChartSetting=new PieChartSetting(pieChart);
        pieChartSetting.setPieChartData(x,data,x.length);

        //legendSetting(pieChart,x);

    }


}
