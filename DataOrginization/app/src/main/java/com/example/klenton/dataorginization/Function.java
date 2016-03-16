package com.example.klenton.dataorginization;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import junit.framework.Test;

import org.w3c.dom.Text;

public class Function extends AppCompatActivity {
    private String title;
    private String descriptOfFunction;
    private String syntaxOfFunction;
    private String synOfFuncWithPram;
    private String synOfFuncWithOutPram;
    private String synOfFunctionCall;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);

        title = "Functions";
        descriptOfFunction = "Functions are pieces of a computer program. In your first program, Hello World, main() is a function. Up to this point we have put everything in main(). Now we are going to branch out and create our own functions.";

        syntaxOfFunction = "Below is the format in which you create functions. \n" +
                "<return type> <function name>(<parameter list>) \n" +
                "{\n" +
                "    <statement list>    \n" +
                "    return <return value>; \n" +
                "}\n";

        synOfFunctionCall = "Calling a function (what does this mean anyway?), well simply stated " +
                "it is like your mom calling you from another room. She first calls your name " +
                "and if she needs something tells you to bring it with you. This is a basic model " +
                "of the concept known as function calling. To do this write it in this " +
                "format:\n" +
                "nameOfFunction(<arguments list>);\n";
        synOfFuncWithOutPram = "Functions without parameters are similar to this scenario see if " +
                "you can determine why? \n" +
                "Think of a General (your main()) in charge of an army of soldiers (your " +
                "functions). The General calls soldiers and tells them to go and perform a " +
                "specific task. When finished the soldiers return their results to the " +
                "General (main()).\n ";
        synOfFuncWithPram = "Functions with parameters are similar to this scenario see if you " +
                "can determine why? \n" +
                "The general (main()) from the above example gives a soldier (a function) a " +
                "piece of paper and the soldier in turn takes the paper to the secretary " +
                "(another function) she copies the paper and the paper is returned to the " +
                "soldier who then returns with the results to the general.\n";

        TextView v3 = (TextView)findViewById(R.id.textView3);
        TextView v4 = (TextView)findViewById(R.id.textView4);
        TextView v5 = (TextView)findViewById(R.id.textView5);
        TextView v6 = (TextView)findViewById(R.id.textView6);
        TextView v7 = (TextView)findViewById(R.id.textView7);
        TextView v8 = (TextView) findViewById(R.id.textView8);
        TextView v9 = (TextView)findViewById(R.id.textView9);
        TextView v10 = (TextView) findViewById(R.id.textView10);
        TextView v11 = (TextView) findViewById(R.id.textView11);
        TextView v12 = (TextView) findViewById(R.id.textView12);

        v3.setTypeface(null, Typeface.BOLD);
        v3.setText(title);
        v4.setText(descriptOfFunction);

        v8.setTypeface(null, Typeface.BOLD);
        v8.setText("Declaring a Function");
        v5.setText(syntaxOfFunction);

        v9.setTypeface(null, Typeface.BOLD);
        v9.setText("Calling Functions");
        v6.setText(synOfFunctionCall);

        v10.setTypeface(null, Typeface.BOLD);
        v10.setText("Functions without Parameters");
        v7.setText(synOfFuncWithOutPram);

        v11.setTypeface(null, Typeface.BOLD);
        v11.setText("Functions with Parameters");
        v12.setText(synOfFuncWithPram);
    }

    public void onClickNextPage(View v) {
        Intent intent = new Intent(Function.this, AdvancedCon.class);
        startActivity(intent);
    }
}
