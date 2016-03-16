package com.example.klenton.dataorginization;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdvancedCon extends AppCompatActivity {
    private String title;
    private String descOfConditional;
    private String synOfIfElse;
    private String synOfSwitch;
    private String synOfTernary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_con);
        title = "Conditionals";
        descOfConditional = "What are conditional statements? These are statements that can " +
                "be phrased as if something happens then do this otherwise do that, or if " +
                "this case happens then perform this type of action. \n";

        synOfIfElse = "";
        synOfSwitch = "Syntax for a switch statement is: \n" +
                " switch (<Expression>)\n" +
                "{\n" +
                "     case <labels>\n" +
                "          <body statement> ; \n" +
                "          <break statement>;\n" +
                "     case <labels>\n" +
                "          <body statement> ; \n" +
                "          <break statement>;\n" +
                "     <default:>\n" +
                "          <body statement>;\n" +
                "    \n" +
                "}\n";
        synOfTernary = "This is a special type of conditional it basically a compacted " +
                "if statement it can be read like this. \n" +
                "      if true ? then do this : otherwise do this\n" +
                "<Boolean expression> ? <true expression> : <false expression>";

        TextView v15 = (TextView)findViewById(R.id.textView15);
        TextView v13 = (TextView)findViewById(R.id.textView13);
        TextView v14 = (TextView)findViewById(R.id.textView14);
        TextView v16 = (TextView)findViewById(R.id.textView16);
        TextView v17 = (TextView)findViewById(R.id.textView17);
        TextView v18 = (TextView)findViewById(R.id.textView18);

        v15.setTypeface(null, Typeface.BOLD);
        v15.setText(title);
        v14.setText(descOfConditional);

        v13.setTypeface(null, Typeface.BOLD);
        v13.setText("Advanced Conditionals");
        v16.setText(synOfSwitch);

        v18.setTypeface(null, Typeface.BOLD);
        v18.setText("Ternary Conditional");
        v17.setText(synOfTernary);

    }
}
