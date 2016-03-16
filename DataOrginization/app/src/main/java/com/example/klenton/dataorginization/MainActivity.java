package com.example.klenton.dataorginization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String functionData;
    private String advanConData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        functionData = "Main Page!!";
        advanConData = "";

        TextView v1 = (TextView)findViewById(R.id.textView);
        v1.setMovementMethod(new ScrollingMovementMethod());
        v1.setText(functionData);
        TextView v2 = (TextView)findViewById(R.id.textView2);
        v2.setMovementMethod(new ScrollingMovementMethod());
        v2.setText(advanConData);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId())
        {
            case R.id.action_home:
                startActivity(new Intent(this, Function.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickNextPage(View v){
        Intent intent = new Intent(MainActivity.this,Function.class);
        startActivity(intent);
    }
}
