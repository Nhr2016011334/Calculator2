package zack.calculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class temperatureActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_temperature, menu);
        return true;
    }

    double result;
    String result1;

    private List<Double> value_list = new ArrayList<Double>();// 存用户输入的数字
    private boolean ssd_flag = false;
    private boolean hsd_flag = false;
    private boolean ksd_flag = false;
    private boolean lsd_flag = false;
    private boolean result_flag = false;
    private boolean huansuan_flag = false;
    private boolean num_flag = false;
    private EditText editText1;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);
        findViewById(R.id.btn_0).setOnClickListener(this);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
        findViewById(R.id.btn_6).setOnClickListener(this);
        findViewById(R.id.btn_7).setOnClickListener(this);
        findViewById(R.id.btn_8).setOnClickListener(this);
        findViewById(R.id.btn_9).setOnClickListener(this);
        findViewById(R.id.btn_point).setOnClickListener(this);
        findViewById(R.id.btn_clean).setOnClickListener(this);
        findViewById(R.id.btn_del).setOnClickListener(this);
        findViewById(R.id.btn_ssd).setOnClickListener(this);
        findViewById(R.id.btn_hsd).setOnClickListener(this);
        findViewById(R.id.btn_ksd).setOnClickListener(this);
        findViewById(R.id.btn_lsd).setOnClickListener(this);
        findViewById(R.id.btn_huansuan).setOnClickListener(this);
        editText1 = (EditText) findViewById(R.id.editText1);
        textView1 = (TextView) findViewById(R.id.textView1);
    }

        @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                num_down("0");
                break;
            case R.id.btn_1:
                num_down("1");
                break;
            case R.id.btn_2:
                num_down("2");
                break;
            case R.id.btn_3:
                num_down("3");
                break;
            case R.id.btn_4:
                num_down("4");
                break;
            case R.id.btn_5:
                num_down("5");
                break;
            case R.id.btn_6:
                num_down("6");
                break;
            case R.id.btn_7:
                num_down("7");
                break;
            case R.id.btn_8:
                num_down("8");
                break;
            case R.id.btn_9:
                num_down("9");
                break;
            case R.id.btn_point:
                num_down(".");
                break;
            case R.id.btn_ssd:
                if(editText1.length()==0)
                {
                    break;
                }
                if (ssd_flag || hsd_flag || ksd_flag || lsd_flag)
                {
                    if(huansuan_flag)
                    {
                        if(ssd_flag)
                        {
                            result = value_list.get(0);
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("摄氏");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(hsd_flag)
                        {
                            result = (value_list.get(0)-32)/1.8;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("摄氏");
                            num_flag = true;
                            hsd_flag = false;
                            ssd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(ksd_flag)
                        {
                            result = value_list.get(0)-273.15;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("摄氏");
                            num_flag = true;
                            ksd_flag = false;
                            ssd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(lsd_flag)
                        {
                            result = value_list.get(0)/0.8;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("摄氏");
                            num_flag = true;
                            lsd_flag = false;
                            ssd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        ssd_flag = hsd_flag = ksd_flag = lsd_flag = false;
                        ssd_flag = true;
                        textView1.setText("摄氏");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("摄氏");
                ssd_flag = true;
                num_flag = true;
                break;


            case R.id.btn_hsd:
                if(editText1.length()==0)
                {
                    break;
                }
                if (ssd_flag || hsd_flag || ksd_flag || lsd_flag)
                {
                    if(huansuan_flag)
                    {
                        if(ssd_flag)
                        {
                            result = value_list.get(0)*1.8+32;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("华氏");
                            num_flag = true;
                            ssd_flag = false;
                            hsd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(hsd_flag)
                        {
                            result = value_list.get(0);
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("华氏");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(ksd_flag)
                        {
                            result = (value_list.get(0)-273.15)*1.8+32;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("华氏");
                            num_flag = true;
                            ksd_flag = false;
                            hsd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(lsd_flag)
                        {
                            result = (value_list.get(0)/0.8)*1.8+32;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("华氏");
                            num_flag = true;
                            lsd_flag = false;
                            ssd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        ssd_flag = hsd_flag = ksd_flag = lsd_flag = false;
                        hsd_flag = true;
                        textView1.setText("华氏");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("华氏");
                hsd_flag = true;
                num_flag = true;
                break;

            case R.id.btn_ksd:
                if(editText1.length()==0)
                {
                    break;
                }
                if (ssd_flag || hsd_flag || ksd_flag || lsd_flag)
                {
                    if(huansuan_flag)
                    {
                        if(ssd_flag)
                        {
                            result = value_list.get(0)+273.15;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("开氏");
                            num_flag = true;
                            ssd_flag = false;
                            ksd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(hsd_flag)
                        {
                            result = ((value_list.get(0)-32)/1.8)+273.15;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("开氏");
                            num_flag = true;
                            hsd_flag = false;
                            ksd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(ksd_flag)
                        {
                            result = value_list.get(0);
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("开氏");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(lsd_flag)
                        {
                            result = (value_list.get(0)/0.8)+273.15;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("开氏");
                            num_flag = true;
                            lsd_flag = false;
                            ksd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        ssd_flag = hsd_flag = ksd_flag = lsd_flag = false;
                        ksd_flag = true;
                        textView1.setText("开氏");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("开氏");
                ksd_flag = true;
                num_flag = true;
                break;

            case R.id.btn_lsd:
                if(editText1.length()==0)
                {
                    break;
                }
                if (ssd_flag || hsd_flag || ksd_flag || lsd_flag)
                {
                    if(huansuan_flag)
                    {
                        if(ssd_flag)
                        {
                            result = value_list.get(0)*0.8;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("列氏");
                            num_flag = true;
                            ssd_flag = false;
                            lsd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(hsd_flag)
                        {
                            result = ((value_list.get(0)-32)/1.8)*0.8;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("列氏");
                            num_flag = true;
                            hsd_flag = false;
                            lsd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(ksd_flag)
                        {
                            result = (value_list.get(0)-273.15)*0.8;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("列氏");
                            num_flag = true;
                            ksd_flag = false;
                            lsd_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(lsd_flag)
                        {
                            result = value_list.get(0);
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("列氏");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        ssd_flag = hsd_flag = ksd_flag = lsd_flag = false;
                        lsd_flag = true;
                        textView1.setText("列氏");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("列氏");
                lsd_flag = true;
                num_flag = true;
                break;

            case R.id.btn_huansuan:
                if(editText1.length()==0)
                {
                    break;
                }
                if (result_flag){
                    huansuan_flag = true;
                    num_flag = true;
                }
                break;

            case R.id.btn_clean:
                value_list.clear();
                editText1.setText("");
                textView1.setText("");
                ssd_flag = false;
                hsd_flag = false;
                ksd_flag = false;
                lsd_flag = false;
                result_flag = false;
                huansuan_flag = false;
                num_flag = false;
                break;

            case R.id.btn_del:
                if(editText1.length()>0)
                {
                    editText1.setText(editText1.getText().toString().substring(0,editText1.getText().toString().length()-1));
                }
        }
    }

    // 数字键按下，含0与.，类似000001223这类情况这里允许，因为java可以讲000001223自己转化为1223
    private void num_down(String num) {
        if (num_flag)// 按下等号，刚刚算完一个运算的状态
        {
            if (ssd_flag || hsd_flag || ksd_flag || lsd_flag){
                ssd_flag = hsd_flag = ksd_flag = lsd_flag = false;
                textView1.setText("");
            }
            value_list.clear();
            editText1.setText("");
            num_flag = false;
        }
        if ((num.equals(".") && editText1.getText().toString().indexOf(".") < 0)
                || !num.equals(".")) {
            // 如果用户输入的是小数点.，则要判断当前已输入的数字中是否含有小数点.才允许输入
            editText1.setText(editText1.getText() + num);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_index:
                Intent intent = new Intent (temperatureActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_hanshu:
                Intent intent1 = new Intent (temperatureActivity.this, hanshuActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_jinzhi:
                Intent intent2 = new Intent (temperatureActivity.this, jinzhiActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_length:
                Intent intent3 = new Intent (temperatureActivity.this, lengthActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_weight:
                Intent intent4 = new Intent (temperatureActivity.this, weightActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_setting:
                Toast.makeText(temperatureActivity.this, "功能未开放", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(temperatureActivity.this);
                builder1.setMessage("* 请先输入要转换的数字，再选择转换前的单位，点击换算后选择要转换的单位")
                        .setTitle("温度换算");
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder1.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder1.show();
                break;
            case R.id.menu_about:
                AlertDialog.Builder builder = new AlertDialog.Builder(temperatureActivity.this);
                builder.setMessage("应用名：快捷计算器\n版本号：beta-1.0")
                        .setTitle("关于");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
                break;
            case R.id.menu_exit:
                System.exit(0);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}




