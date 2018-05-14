package ChartsSetting;

import android.graphics.Color;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by kkjsu on 2018/5/4.
 */

public class LineChartSetting {
    LineChart lineChart;
    TextView date, price;
    public LineChartSetting(LineChart lineChart, TextView text, TextView text2) {
        this.lineChart=lineChart;
        this.date=text2;
        this.price=text;
        initLineChart();
    }

    private void initLineChart()
    {
        lineChart.setDrawGridBackground(false);
        lineChart.setTouchEnabled(true);//是否能觸摸
        lineChart.setDragDecelerationFrictionCoef(0.9f);
        lineChart.setDragEnabled(true);//是否能拖拉
        lineChart.setScaleEnabled(false);//是否能放大
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(true);
        lineChart.setPinchZoom(true);
        //lineChart.setBackgroundColor(Color.LTGRAY);
        lineChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry entry, Highlight highlight) {
                float p=entry.getX();
                float d=entry.getY();
                date.setText(""+d);
                price.setText(""+p);
            }

            @Override
            public void onNothingSelected() {

            }
        });

        lineChart.animateX(2500);
    }

    public void setData()
    {
        ArrayList<Entry> values = new ArrayList<Entry>();

        values = new ArrayList<>();
        values.add(new Entry(0, 10));
        values.add(new Entry(1, 15));
        values.add(new Entry(2, 25));
        values.add(new Entry(3, 19));
        values.add(new Entry(4, 25));
        values.add(new Entry(5, 16));
        values.add(new Entry(6, 40));
        values.add(new Entry(7, 27));
        values.add(new Entry(8, 15));
        values.add(new Entry(9, 25));
        values.add(new Entry(10, 19));
        values.add(new Entry(11, 25));
        values.add(new Entry(12, 16));
        values.add(new Entry(13, 40));
        values.add(new Entry(14, 27));

        // create a dataset and give it a type
        LineDataSet set1 = new LineDataSet(values, "折線圖");
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setColor(ColorTemplate.getHoloBlue());
        set1.setValueTextColor(ColorTemplate.getHoloBlue());
        set1.setLineWidth(1.5f);
        set1.setDrawCircles(true);
        set1.setDrawValues(false);
        set1.setHighlightEnabled(true);
        set1.setFillAlpha(65);
        set1.setFillColor(ColorTemplate.getHoloBlue());
        set1.setHighLightColor(Color.rgb(244, 117, 117));
        set1.setDrawCircleHole(false);

        Legend mLegend = lineChart.getLegend();
        mLegend.setForm(Legend.LegendForm.CIRCLE);// 样式
        mLegend.setFormSize(7f);//7 字体
        mLegend.setTextColor(Color.BLACK);// 颜色
//      mLegend.setTypeface(mTf);// 字体

        // create a data object with the datasets

        LineData data = new LineData();
        data.setHighlightEnabled(true);
        data.setDrawValues(true);
        data.addDataSet(set1);
        data.setValueTextColor(Color.BLACK);
        data.setValueTextSize(9f);

        XAxis xAxis=lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawAxisLine(true);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float v, AxisBase axisBase) {
                //String[] date={"1月", "2月", "3月", "4月", "5月", "6月", "7月", "8月"};
                //int month=(int)v;
                //String tmp=date[month];
                String tmp=v+"m";
                return tmp;
            }
        });
        lineChart.setData(data);
    }
}
