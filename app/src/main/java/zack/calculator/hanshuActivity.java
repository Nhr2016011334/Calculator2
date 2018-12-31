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
import android.widget.LinearLayout;
import android.widget.Toast;
import static java.lang.Double.parseDouble;

public class hanshuActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_hanshu, menu);
        return true;
    }

    private List<Double> value_list = new ArrayList<Double>();// 存用户输入的数字
    private boolean result_flag = false;
    private EditText editText1;
    LinearLayout mi;
    EditText zhishu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanshu);
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
        findViewById(R.id.btn_sin).setOnClickListener(this);
        findViewById(R.id.btn_cos).setOnClickListener(this);
        findViewById(R.id.btn_tan).setOnClickListener(this);
        findViewById(R.id.btn_kaifang).setOnClickListener(this);
        findViewById(R.id.btn_mi).setOnClickListener(this);
        editText1 = (EditText) findViewById(R.id.editText1);
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
            case R.id.btn_sin:
                if(editText1.length()==0)
                {
                    break;
                }
                value_list.add(parseDouble(editText1.getText().toString()));
                double sin = Math.sin(value_list.get(0));
                String sin1 = String.valueOf(sin);
                editText1.setText(sin1);
                result_flag = true;
                break;

            case R.id.btn_cos:
                if(editText1.length()==0)
                {
                    break;
                }
                value_list.add(parseDouble(editText1.getText().toString()));
                double cos = Math.cos(value_list.get(0));
                String cos1 = String.valueOf(cos);
                editText1.setText(cos1);
                result_flag = true;
                break;

            case R.id.btn_tan:
                if(editText1.length()==0)
                {
                    break;
                }
                value_list.add(parseDouble(editText1.getText().toString()));
                double tan = Math.tan(value_list.get(0));
                String tan1 = String.valueOf(tan);
                editText1.setText(tan1);
                result_flag = true;
                break;

            case R.id.btn_kaifang:
                if(editText1.length()==0)
                {
                    break;
                }
                value_list.add(parseDouble(editText1.getText().toString()));
                double kaifang = Math.sqrt(value_list.get(0));
                String kaifang1 = String.valueOf(kaifang);
                editText1.setText(kaifang1);
                result_flag = true;
                break;

            case R.id.btn_mi:
                if(editText1.length()==0)
                {
                    break;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(hanshuActivity.this);
                mi = (LinearLayout)getLayoutInflater().inflate(R.layout.mi,null);

                builder.setView(mi);

                builder.setTitle("幂运算");
                value_list.add(parseDouble(editText1.getText().toString()));
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        zhishu=(EditText) mi.findViewById(R.id.zhishu2);
                        if(zhishu.getText().toString().isEmpty())
                        {

                        }
                        else
                        {
                            for (int i = 0; i < zhishu.getText().toString().length(); i++)
                            {
                                if (Character.isDigit(zhishu.getText().toString().charAt(i)))
                                {
                                    double zs = Double.valueOf(zhishu.getText().toString()).doubleValue();
                                    double rt = Math.pow(value_list.get(0),zs);
                                    String rt1 = String.valueOf(rt);
                                    editText1.setText(rt1);
                                    result_flag = true;
                                }
                                else{
                                    Toast.makeText(hanshuActivity.this, "请输入数字！", Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }
                });
                builder.create();
                builder.show();
                break;

            case R.id.btn_clean:
                value_list.clear();
                editText1.setText("");
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
        if (result_flag)// 按下等号，刚刚算完一个运算的状态
        {
            value_list.clear();
            editText1.setText("");
            result_flag = false;
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
                Intent intent = new Intent (hanshuActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_jinzhi:
                Intent intent1 = new Intent (hanshuActivity.this, jinzhiActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_length:
                Intent intent2 = new Intent (hanshuActivity.this, lengthActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_weight:
                Intent intent3 = new Intent (hanshuActivity.this, weightActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_temperature:
                Intent intent4 = new Intent (hanshuActivity.this, temperatureActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_setting:
                Toast.makeText(hanshuActivity.this, "功能暂未开放", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(hanshuActivity.this);
                builder1.setMessage("* 请先输入要运算的数字，再选择要进行的运算\n* 三角函数运算输入的数字为弧度\n* 幂运算请先输入底数，再输入指数")
                        .setTitle("科学计算");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(hanshuActivity.this);
                builder.setMessage("应用名：计算器\n版本号：beta-1.0")
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




