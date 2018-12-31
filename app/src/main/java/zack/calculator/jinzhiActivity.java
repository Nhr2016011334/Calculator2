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
import android.widget.Toast;

public class jinzhiActivity extends AppCompatActivity implements OnClickListener {
    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_jinzhi, menu);
        return true;
    }
    private boolean result_flag = false;
    private EditText editText1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
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
        findViewById(R.id.btn_clean).setOnClickListener(this);
        findViewById(R.id.btn_del).setOnClickListener(this);
        findViewById(R.id.btn_10zhuan2).setOnClickListener(this);
        findViewById(R.id.btn_10zhuan8).setOnClickListener(this);
        findViewById(R.id.btn_10zhuan16).setOnClickListener(this);
        findViewById(R.id.btn_2zhuan10).setOnClickListener(this);
        findViewById(R.id.btn_8zhuan10).setOnClickListener(this);
        findViewById(R.id.btn_16zhuan10).setOnClickListener(this);
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
            case R.id.btn_10zhuan2:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                    int z_102 = Integer.parseInt(editText1.getText().toString());
                    String Z_102 = String.valueOf(Integer.toBinaryString(z_102));
                    editText1.setText(Z_102);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }
                break;

            case R.id.btn_10zhuan8:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                    int z_108 = Integer.parseInt(editText1.getText().toString());
                    String Z_108 = String.valueOf(Integer.toOctalString(z_108));
                    editText1.setText(Z_108);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }
                break;

            case R.id.btn_10zhuan16:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                    int z_1016 = Integer.parseInt(editText1.getText().toString());
                    String Z_1016 = String.valueOf(Integer.toHexString(z_1016));
                    editText1.setText(Z_1016);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }
                break;

            case R.id.btn_2zhuan10:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                String z_210 = Integer.valueOf(editText1.getText().toString(),2).toString();
                    editText1.setText(z_210);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }

                break;

            case R.id.btn_8zhuan10:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                    String z_810 = Integer.valueOf(editText1.getText().toString(),8).toString();
                    editText1.setText(z_810);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }
                break;

            case R.id.btn_16zhuan10:
                if(editText1.length()==0)
                {
                    break;
                }
                try{
                    String z_1610 = Integer.valueOf(editText1.getText().toString(),16).toString();
                    editText1.setText(z_1610);
                    result_flag = true;
                }
                catch (Exception e){
                    editText1.setText("Error");
                    result_flag = true;
                }
                    break;


            case R.id.btn_clean:

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
                Intent intent = new Intent (jinzhiActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_hanshu:
                Intent intent1 = new Intent (jinzhiActivity.this, hanshuActivity.class);
                startActivity(intent1);
                break;
            case R.id.menu_length:
                Intent intent2 = new Intent (jinzhiActivity.this, lengthActivity.class);
                startActivity(intent2);
                break;
            case R.id.menu_weight:
                Intent intent3 = new Intent (jinzhiActivity.this, weightActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_temperature:
                Intent intent4 = new Intent (jinzhiActivity.this, temperatureActivity.class);
                startActivity(intent4);
                break;
            case R.id.menu_setting:
                Toast.makeText(jinzhiActivity.this, "功能暂未开放", Toast.LENGTH_LONG).show();
                break;
            case R.id.menu_help:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(jinzhiActivity.this);
                builder1.setMessage("* 请先输入要转换的数字，再选择要进行的转换\n* 输入的数字大于9位或者无法进行选择的进制转换则会输出：Error")
                        .setTitle("进制转换");
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
                AlertDialog.Builder builder = new AlertDialog.Builder(jinzhiActivity.this);
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




