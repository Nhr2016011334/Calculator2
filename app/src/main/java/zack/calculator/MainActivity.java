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

public class MainActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private List<Double> value_list = new ArrayList<Double>();// 存用户输入的数字
    private List<Integer> operator_list = new ArrayList<Integer>();// 存用户输入的运算符，定义+为0，-为1，×为2，÷为3
    // 状态记录
    private boolean add_flag = false;// +按下
    private boolean minus_flag = false;// -按下
    private boolean multi_flag = false;// ×按下
    private boolean div_flag = false;// ÷按下
    private boolean result_flag = false;// =按下
    private boolean can_operate_flag = false;// 按下=是否响应

    private TextView textView1;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        findViewById(R.id.btn_pluse).setOnClickListener(this);
        findViewById(R.id.btn_minus).setOnClickListener(this);
        findViewById(R.id.btn_multiply).setOnClickListener(this);
        findViewById(R.id.btn_divide).setOnClickListener(this);
        findViewById(R.id.btn_equal).setOnClickListener(this);

        textView1 = (TextView) findViewById(R.id.textView1);
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
            case R.id.btn_pluse:
                if(editText1.length()==0)
                {
                    break;
                }
                if (add_flag || minus_flag || multi_flag || div_flag)
                {
                    operator_list.remove(operator_list.size()-1);
                    operator_list.add(0);
                    add_flag=minus_flag=multi_flag=div_flag=false;
                    add_flag = true;
                    textView1.setText(textView1.getText().toString().substring(0,textView1.getText().toString().length()-1)+'+');
                    break;
                }
                    result_flag = false;
                    value_list.add(Double.parseDouble(editText1.getText()
                            .toString()));// 将当前已输入的数字放入value_list
                    operator_list.add(0);
                    textView1.setText(textView1.getText() + "+");
                    add_flag = true;
                    can_operate_flag = false;// 刚刚输入完符号，不能构成一条正常的表达式，如111+，设置为不可运行状态
                break;
            case R.id.btn_minus:
                if(editText1.length()==0)
                {
                    break;
                }
                if (add_flag || minus_flag || multi_flag || div_flag)
                {
                    operator_list.remove(operator_list.size()-1);
                    operator_list.add(1);
                    add_flag=minus_flag=multi_flag=div_flag=false;
                    minus_flag = true;
                    textView1.setText(textView1.getText().toString().substring(0,textView1.getText().toString().length()-1)+'-');
                    break;
                }
                    result_flag = false;
                    value_list.add(Double.parseDouble(editText1.getText()
                            .toString()));
                    operator_list.add(1);
                    textView1.setText(textView1.getText() + "-");
                    minus_flag = true;
                    can_operate_flag = false;
                    break;
            case R.id.btn_multiply:
                if(editText1.length()==0)
                {
                    break;
                }
                if (add_flag || minus_flag || multi_flag || div_flag)
                {
                    operator_list.remove(operator_list.size()-1);
                    operator_list.add(2);
                    add_flag=minus_flag=multi_flag=div_flag=false;
                    multi_flag = true;
                    textView1.setText(textView1.getText().toString().substring(0,textView1.getText().toString().length()-1)+'×');
                    break;
                }
                    result_flag = false;
                    value_list.add(Double.parseDouble(editText1.getText()
                            .toString()));
                    operator_list.add(2);
                    textView1.setText("(" + textView1.getText() + ")×");// 给前面的已经输入的东西加个括号。（运算符栈问题是一个很复杂的数据结构问题，这里不做，：P）
                    multi_flag = true;
                    can_operate_flag = false;
                    break;
            case R.id.btn_divide:
                if(editText1.length()==0)
                {
                    break;
                }
                if (add_flag || minus_flag || multi_flag || div_flag)
                {
                    operator_list.remove(operator_list.size()-1);
                    operator_list.add(3);
                    add_flag=minus_flag=multi_flag=div_flag=false;
                    div_flag = true;
                    textView1.setText(textView1.getText().toString().substring(0,textView1.getText().toString().length()-1)+'÷');
                    break;
                }
                    result_flag = false;
                    value_list.add(Double.parseDouble(editText1.getText()
                            .toString()));
                    operator_list.add(3);
                    textView1.setText("(" + textView1.getText() + ")÷");
                    div_flag = true;
                    can_operate_flag = false;
                break;
            case R.id.btn_equal:
                if (value_list.size() > 0 && operator_list.size() > 0
                        && can_operate_flag) {// 需要防止用户没输入数字，或者只输入了一个数，就按=。
                    value_list.add(Double.parseDouble(editText1.getText()
                            .toString()));
                    double total = value_list.get(0);
                    for (int i = 0; i < operator_list.size(); i++) {
                        int _operator = operator_list.get(i);// operator是C#的运算符重载的关键字，前面加个_来区别
                        switch (_operator) {
                            case 0:
                                total += value_list.get(i + 1);
                                break;
                            case 1:
                                total -= value_list.get(i + 1);
                                break;
                            case 2:
                                total *= value_list.get(i + 1);
                                break;
                            case 3:
                                total /= value_list.get(i + 1);
                                break;
                        }
                    }
                    editText1.setText(total + "");
                    textView1.setText(total + "");
                    operator_list.clear();// 算完，就清空累积数字与运算数组
                    value_list.clear();
                    result_flag = true;// 表示=按下
                }
                break;
            case R.id.btn_clean:
                operator_list.clear();
                value_list.clear();
                add_flag = false;
                minus_flag = false;
                multi_flag = false;
                div_flag = false;
                result_flag = false;
                can_operate_flag = false;
                editText1.setText("");
                textView1.setText("");
                break;
            case R.id.btn_del:
                if(editText1.length()>0)
                {
                    editText1.setText(editText1.getText().toString().substring(0,editText1.getText().toString().length()-1));
                    textView1.setText(textView1.getText().toString().substring(0,textView1.getText().toString().length()-1));
                }
        }
    }

    // 数字键按下，含0与.，类似000001223这类情况这里允许，因为java可以讲000001223自己转化为1223
    private void num_down(String num) {
        if (add_flag || minus_flag || multi_flag || div_flag || result_flag) {
            if (result_flag)// 按下等号，刚刚算完一个运算的状态
            {
                textView1.setText("");
            }
            editText1.setText("");// 如果用户刚刚输入完一个运算符
            add_flag = false;
            minus_flag = false;
            multi_flag = false;
            div_flag = false;
            result_flag = false;
        }
        if ((num.equals(".") && editText1.getText().toString().indexOf(".") < 0)
                || !num.equals(".")) {
            // 如果用户输入的是小数点.，则要判断当前已输入的数字中是否含有小数点.才允许输入
            editText1.setText(editText1.getText() + num);
            textView1.setText(textView1.getText() + num);
            can_operate_flag = true;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_hanshu:
                Intent intent = new Intent (MainActivity.this, hanshuActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_jinzhi:
                Intent intent1 = new Intent (MainActivity.this, jinzhiActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_length:
                Intent intent2 = new Intent (MainActivity.this, lengthActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_weight:
                Intent intent3 = new Intent (MainActivity.this, weightActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_temperature:
                Intent intent4 = new Intent (MainActivity.this, temperatureActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_setting:
                Toast.makeText(MainActivity.this, "功能暂未开放", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setMessage("* AC为清空输入框，DEL为删除输入框最后一位\n* 支持连续输入")
                        .setTitle("简单计算");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
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




