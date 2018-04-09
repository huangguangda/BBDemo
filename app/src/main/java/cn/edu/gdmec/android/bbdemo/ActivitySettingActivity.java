package cn.edu.gdmec.android.bbdemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.bbdemo.utils.AnalysisUtils;

public class ActivitySettingActivity extends Activity implements View.OnClickListener{

    private RelativeLayout rl_modify_psw;
    private RelativeLayout rl_security_setting;
    private RelativeLayout rl_exit_login;
    private RelativeLayout rl_title_bar;
    private TextView tv_back;
    private TextView tv_main_title;
    public static ActivitySettingActivity instance=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        instance=this;
        initView();
    }

    private void initView() {
        rl_modify_psw = (RelativeLayout) findViewById(R.id.rl_modify_psw);
        rl_security_setting = (RelativeLayout) findViewById(R.id.rl_security_setting);
        rl_exit_login = (RelativeLayout) findViewById(R.id.rl_exit_login);
        rl_title_bar=(RelativeLayout)findViewById(R.id.title_bar);

        rl_title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));
        tv_back = (TextView) findViewById(R.id.tv_back);
        tv_main_title = (TextView) findViewById(R.id.tv_main_title);
        tv_main_title.setText("设置");
        tv_back.setOnClickListener(this);
        rl_modify_psw.setOnClickListener(this);
        rl_security_setting.setOnClickListener(this);
        rl_exit_login.setOnClickListener(this);

    }

    private void clearLoginStatus() {
        SharedPreferences sp=getSharedPreferences("loginInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putBoolean("isLogin",false);
        editor.putString("loginUserName","");
        editor.commit();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.tv_back:
                ActivitySettingActivity.this.finish();
                break;
            case R.id.rl_modify_psw:
                Intent intent = new Intent(ActivitySettingActivity.this,ActivityModifyPswActivity.class);
                startActivity(intent);
                break;
            case R.id.rl_security_setting:
                Intent intent2 = new Intent(ActivitySettingActivity.this,ActivityFindPswActivity.class);
                intent2.putExtra("from","security");
                startActivity(intent2);
                break;
            case R.id.rl_exit_login:
                Toast.makeText(this,"退出登录成功",Toast.LENGTH_SHORT).show();
                AnalysisUtils.clearLoginStatus(this);
                Intent data = new Intent();
                data.putExtra("isLogin",false);
                setResult(RESULT_OK,data);
                //clearLoginStatus();
                finish();
                break;
        }
    }
}