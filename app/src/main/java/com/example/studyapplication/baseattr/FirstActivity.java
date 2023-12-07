package com.example.studyapplication.baseattr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.ActionBar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.studyapplication.R;

/**
 * 各种案例textview，editview，button，imageview，
 * intent跳转，menu菜单注册，dialog，toast，ProgressBar,ActionBar实现
 * 以及在相应xml中include引入导航栏layout布局
 */
public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //注册第一个主页面   在java/res下创建layout目录创建first_layout.xml文件
        //在AndroidManifest.xml中配置
        setContentView(R.layout.first_layout);


        //**********************************************************************************************
        //引入layout需要将自带的隐藏掉
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.hide();
        }

        //**********************************************************************************************
        EditText editText = findViewById(R.id.edit);
        editText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(FirstActivity.this,editText.getText(),Toast.LENGTH_SHORT).show();
            }
        });

        //**********************************************************************************************
        ImageView imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageResource(R.drawable.beauty1);
                Toast.makeText(FirstActivity.this,"图片转换完成",Toast.LENGTH_SHORT).show();
            }
        });

        //**********************************************************************************************
        ProgressBar progressBar = findViewById(R.id.bar);
        progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(progressBar.getVisibility() == View.VISIBLE){
//                    progressBar.setVisibility(View.INVISIBLE);
//                    progressBar.setVisibility(View.GONE);
//                    int progress = progressBar.getProgress();
//                    progress += 10;
//                    progressBar.setProgress(progress);

                    dialog();
                }else{

                }
            }
        });

        //**********************************************************************************************
        //获取按钮并且注册点击事件
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示
//                Toast.makeText(FirstActivity.this,"点击事件内容",Toast.LENGTH_SHORT).show();
            }
        });


    }

    //**********************************************************************************************

    /**
     * 弹窗
     */
    public void dialog(){
        //1.  AlertDialog.Builder
//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle("标题信息");
//        dialog.setMessage("信息");
//        dialog.setCancelable(false);
//        //确认按钮的点击事件
//        dialog.setPositiveButton("ok信息", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//
//            }
//        });
//        dialog.show();

        //2.
    }

    //**********************************************************************************************
    /**
     * 跳转布局页面
     */
    public void jumpLayout(){
        //1.   显示跳转只需要类名
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);

        //2.   隐式跳转需要在AndroidManifest.xml中配置action标签名称匹配
        //AndroidManifest.xml只能有一个action可以多个category   要全部匹配
//                Intent intent = new Intent("secondactivity");
//                intent.addCategory("secondactivitymany");

        //3.   跳转默认游览器网址
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                intent.setData(Uri.parse("tel:10086"));

        //4.   传递数据
        Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
        intent.putExtra("data","接受第一个数据");


        Bundle bundle = new Bundle();
        bundle.putString("aa","bbb");
        intent.putExtras(bundle);

        intent.putExtra("user",new UserSerializable(1,"",""));

        UserParcelable userParcelable = new UserParcelable();
        userParcelable.name = "";
        userParcelable.age = 1;
        intent.putExtra("userquick",userParcelable);

        startActivity(intent);
    }


    //**********************************************************************************************

    /**
     * 注册menu菜单显示
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.first_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        if(itemid == R.id.addmenu){
            Toast.makeText(this,"点击添加事件内容",Toast.LENGTH_SHORT).show();
        } else if (itemid == R.id.delmenu) {
            Toast.makeText(this,"点击删除事件内容",Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}