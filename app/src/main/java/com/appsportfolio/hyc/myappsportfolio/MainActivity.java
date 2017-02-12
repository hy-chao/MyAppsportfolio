package com.appsportfolio.hyc.myappsportfolio;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Toast;
import android.view.View.OnClickListener;
import android.app.Activity;

public class MainActivity extends AppCompatActivity {

    //private LinearLayout linearLayout;
    private String[] str = {"热门电影","股票雄鹰","XYZ阅读器", "最新闻", "毕业设计"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Call me: 17602235606", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button one = (Button) findViewById(R.id.one);  //绑定按键1
        one.setOnClickListener(new View.OnClickListener(){   //设置触发事件
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(),"启动应用：热门电影",Toast.LENGTH_SHORT);
                toast.show();
            }
        });
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.linearLayout);

        for(int i = 1; i < 5; i++)
        {
            Button btn = new Button(this);
            btn.setId(i);
            btn.setText(str[i]);
            btn.setOnClickListener(new btnListener(btn, i));
            linearLayout.addView(btn);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    class btnListener implements OnClickListener { //事件监听器类
        private Button btn;
        private int i;
        //private String[] str = {"热门电影","股票雄鹰","XYZ阅读器", "最新闻", "毕业设计"};
        private btnListener(Button btn, int n) {
            this.btn = btn;
            i = n;
        }
        public void onClick(View v) {
            Toast toast = Toast.makeText(getApplicationContext(),"启动应用：" + str[i],Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
