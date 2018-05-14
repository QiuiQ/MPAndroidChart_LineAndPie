package ChartsSetting;

import android.graphics.Color;
import android.graphics.Typeface;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * Created by kkjsu on 2018/5/4.
 */

public class PieChartSetting {
    PieChart pieChart;
    public PieChartSetting(PieChart pieChart)
    {
        this.pieChart=pieChart;
        initPieChart();
    }

    void initPieChart()
    {
        String[]x=new String[]{"A基金", "B基金", "C基金"};
        double[] data = new double[]{1, 500, 499};
        pieChart.setUsePercentValues(true);
        pieChart.animateXY(1000, 1000);
        pieChart.setHoleRadius(68f);

        /*Legend legend=pieChart.getLegend();
        legend.setEnabled(true);
        legend.setWordWrapEnabled(true);
        legend.setYEntrySpace(20f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);*/


        setPieChartData(x, data, data.length);
        //pieChart.setCenterText("智能決策");

        //pieChart.setNoDataTextDescription("NO DATA");
        pieChart.setDrawHoleEnabled(true);
    }

    void legendSetting(PieChart l)
    {
        Legend legend=l.getLegend();
        legend.setEnabled(true);
        legend.setWordWrapEnabled(true);
        legend.setYEntrySpace(20f);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        LinearLayout.LayoutParams params_left_layout=new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params_left_layout.weight=1F;
        //LinearLayout left_layout=new LinearLayout();
    }

    public void setPieChartData(String []id, double []data, int count)
    {
        ArrayList<PieEntry> values=new ArrayList<PieEntry>();

        for(int i=0; i<count; i++) values.add(new PieEntry((float)data[i], id[i]));

        PieDataSet pieDataSet=new PieDataSet(values, "");
        pieDataSet.setValueTextSize(20f);

        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.rgb(200, 200, 200));
        colors.add(Color.rgb(245, 166, 35));
        colors.add(Color.rgb(184, 233, 134));
        colors.add(Color.rgb(184, 254, 134));
        colors.add(Color.rgb(184, 100, 134));
        colors.add(Color.rgb(184, 20, 134));
        colors.add(Color.rgb(100, 233, 134));
        colors.add(Color.rgb(130, 233, 134));
        colors.add(Color.rgb(184, 233, 150));

        pieDataSet.setColors(colors);//颜色设置
        pieDataSet.setSliceSpace(2f);
        pieDataSet.setValueTextColor(Color.BLACK);
        /*pieDataSet.setValueLinePart1OffsetPercentage(0.5f);
        pieDataSet.setValueLinePart1Length(0.3f);
        pieDataSet.setValueLinePart2Length(0.4f);
        pieDataSet.setValueLineColor(Color.BLACK);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);*/

        PieData pieData=new PieData();
        pieData.addDataSet(pieDataSet);
        pieData.setDrawValues(false);
        pieData.setHighlightEnabled(true);

        pieChart.setDrawEntryLabels(false);
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setData(pieData);
        pieChart.setCenterText(generateCenterSpannableText());

    }

    private SpannableString generateCenterSpannableText() {
        //MPAndroidChart\ndeveloped by Philipp Jahoda
        SpannableString s = new SpannableString("ALOT\n智能投顧");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 4, 0);
        s.setSpan(new StyleSpan(Typeface.BOLD), 0, 4 , 0);
        s.setSpan(new ForegroundColorSpan(Color.rgb(126,186,247)), 0, 4 , 0);
        s.setSpan(new ForegroundColorSpan(Color.BLACK), 4, s.length() , 0);
        s.setSpan(new RelativeSizeSpan(.8f), 4, s.length(), 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 4, s.length(), 0);
        //s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), 0 , s.length()-4, 0);
        return s;
    }
}
