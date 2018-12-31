package zack.calculator;

import java.util.*;
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



public class lengthActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_length, menu);
        return true;
    }

    double li_quanzhong = 1;
    double chi_quanzhong = 5280;
    double cun_quanzhong = 63360;
    double meter_quanzhong = 1609.344;
    double result;
    String result1;

    private List<Double> value_list = new ArrayList<Double>();// 存用户输入的数字
    private boolean meter_flag = false;
    private boolean cun_flag = false;
    private boolean chi_flag = false;
    private boolean li_flag = false;
    private boolean result_flag = false;
    private boolean huansuan_flag = false;
    private boolean num_flag = false;
    private EditText editText1;
    private TextView textView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);
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
        findViewById(R.id.btn_meter).setOnClickListener(this);
        findViewById(R.id.btn_cun).setOnClickListener(this);
        findViewById(R.id.btn_chi).setOnClickListener(this);
        findViewById(R.id.btn_li).setOnClickListener(this);
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
            case R.id.btn_meter:
                if(editText1.length()==0)
                {
                    break;
                }
                if (meter_flag || cun_flag || chi_flag || li_flag)
                {
                    if(huansuan_flag)
                    {
                        if(meter_flag)
                        {
                            result = value_list.get(0)/meter_quanzhong*meter_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("米");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(cun_flag)
                        {
                            result = value_list.get(0)/cun_quanzhong*meter_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("米");
                            num_flag = true;
                            cun_flag = false;
                            meter_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(chi_flag)
                        {
                            result = value_list.get(0)/chi_quanzhong*meter_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("米");
                            num_flag = true;
                            chi_flag = false;
                            meter_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(li_flag)
                        {
                            result = value_list.get(0)/li_quanzhong*meter_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("米");
                            num_flag = true;
                            li_flag = false;
                            meter_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        meter_flag = cun_flag = chi_flag = li_flag = false;
                        meter_flag = true;
                        textView1.setText("米");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("米");
                meter_flag = true;
                num_flag = true;
                break;


            case R.id.btn_cun:
                if(editText1.length()==0)
                {
                    break;
                }
                if (meter_flag || cun_flag || chi_flag || li_flag)
                {
                    if(huansuan_flag)
                    {
                        if(meter_flag)
                        {
                            result = value_list.get(0)/meter_quanzhong*cun_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英寸");
                            num_flag = true;
                            meter_flag =false;
                            cun_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(cun_flag)
                        {
                            result = value_list.get(0)/cun_quanzhong*cun_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英寸");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(chi_flag)
                        {
                            result = value_list.get(0)/chi_quanzhong*cun_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英寸");
                            num_flag = true;
                            chi_flag = false;
                            cun_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(li_flag)
                        {
                            result = value_list.get(0)/li_quanzhong*cun_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英寸");
                            num_flag = true;
                            li_flag = false;
                            cun_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        meter_flag = cun_flag = chi_flag = li_flag = false;
                        cun_flag = true;
                        textView1.setText("英寸");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("英寸");
                cun_flag = true;
                num_flag = true;
                break;

            case R.id.btn_chi:
                if(editText1.length()==0)
                {
                    break;
                }
                if (meter_flag || cun_flag || chi_flag || li_flag)
                {
                    if(huansuan_flag)
                    {
                        if(meter_flag)
                        {
                            result = value_list.get(0)/meter_quanzhong*chi_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英尺");
                            num_flag = true;
                            meter_flag =false;
                            chi_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(cun_flag)
                        {
                            result = value_list.get(0)/cun_quanzhong*chi_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英尺");
                            num_flag = true;
                            cun_flag = false;
                            chi_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(chi_flag)
                        {
                            result = value_list.get(0)/chi_quanzhong*chi_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英尺");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(li_flag)
                        {
                            result = value_list.get(0)/li_quanzhong*chi_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英尺");
                            num_flag = true;
                            li_flag = false;
                            chi_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        meter_flag = cun_flag = chi_flag = li_flag = false;
                        chi_flag = true;
                        textView1.setText("英尺");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("英尺");
                chi_flag = true;
                num_flag = true;
                break;

            case R.id.btn_li:
                if(editText1.length()==0)
                {
                    break;
                }
                if (meter_flag || cun_flag || chi_flag || li_flag)
                {
                    if(huansuan_flag)
                    {
                        if(meter_flag)
                        {
                            result = value_list.get(0)/meter_quanzhong*li_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英里");
                            num_flag = true;
                            meter_flag =false;
                            li_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(cun_flag)
                        {
                            result = value_list.get(0)/cun_quanzhong*li_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英里");
                            num_flag = true;
                            cun_flag = false;
                            li_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(chi_flag)
                        {
                            result = value_list.get(0)/chi_quanzhong*li_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英里");
                            num_flag = true;
                            chi_flag = false;
                            li_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                        if(li_flag)
                        {
                            result = value_list.get(0)/li_quanzhong*li_quanzhong;
                            result1 = String.valueOf(result);
                            editText1.setText(result1);
                            textView1.setText("英里");
                            num_flag = true;
                            huansuan_flag = false;
                            value_list.clear();
                            value_list.add(Double.parseDouble(editText1.getText().toString()));
                        }
                    }
                    else {
                        meter_flag = cun_flag = chi_flag = li_flag = false;
                        li_flag = true;
                        textView1.setText("英里");
                        num_flag = true;
                        break;
                    }
                    break;
                }
                result_flag = true;
                value_list.add(Double.parseDouble(editText1.getText().toString()));
                textView1.setText("英里");
                li_flag = true;
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
                meter_flag = false;
                cun_flag = false;
                chi_flag = false;
                li_flag = false;
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
            if (meter_flag || cun_flag || chi_flag || li_flag){
                meter_flag = cun_flag = chi_flag = li_flag = false;
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
                Intent intent = new Intent (lengthActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_hanshu:
                Intent intent1 = new Intent (lengthActivity.this, hanshuActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_jinzhi:
                Intent intent2 = new Intent (lengthActivity.this, jinzhiActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_weight:
                Intent intent3 = new Intent (lengthActivity.this, weightActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_temperature:
                Intent intent4 = new Intent (lengthActivity.this, temperatureActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_setting:
                Toast.makeText(lengthActivity.this, "功能未开放", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(lengthActivity.this);
                builder1.setMessage("* 请先输入要转换的数字，再选择转换前的单位，点击换算后选择要转换的单位")
                        .setTitle("长度换算");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(lengthActivity.this);
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




