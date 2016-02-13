package com.cs246.johnmeyer.multi_threads;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String fileName = "numbers.txt";
    ArrayAdapter<String> arrayAdapter;

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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    public void createFile(View v) {
        //Log.d("Debug", "Inside OnclickWriteFile");
        new Create().execute(getFilesDir() + "numbers.txt");
    }

    public void loadFile(View v) {

        new Load().execute(getFilesDir() + "numbers.txt");
    }

    private class Create extends AsyncTask<String, Integer, Void> {

        @Override
        protected void onPreExecute() {
            ((ProgressBar) findViewById(R.id.progressBar)).setProgress(0);
        }

        @Override
        protected Void doInBackground(String... params) {
            try {
                FileWriter fileWriter = new FileWriter(params[0]);

                for (int i = 1; i < 11; i++) {
                    fileWriter.write(i + "\n");
                    try {
                        Thread.sleep(250);
                        publishProgress(i);
                    } catch (InterruptedException e) {
                        // should never get here
                    }
                }
                fileWriter.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            ((ProgressBar) findViewById(R.id.progressBar)).setProgress(10 * progress[0]);
        }

        @Override
        protected void onPostExecute(Void v) {
            Toast.makeText(getApplicationContext(), "File Created", Toast.LENGTH_SHORT).show();
        }
    }

    private class Load extends AsyncTask<String, Integer, Void> {

        List<String> contents = new ArrayList<>();

        @Override
        protected void onPreExecute() {
            ((ProgressBar) findViewById(R.id.progressBar)).setProgress(0);
        }

        @Override
        protected Void doInBackground(String... params) {

            File filesDir = getFilesDir();
            File toOpen = new File(filesDir, fileName);

            try {
                BufferedReader br = new BufferedReader(new FileReader(toOpen));
                String line;

                while ((line = br.readLine()) != null) {
                    contents.add(line);
                    try {
                        Thread.sleep(250);
                        publishProgress(10);
                    } catch (InterruptedException e) {
                        // should never get here
                    }
                }
                br.close();
            } catch (IOException e) {
                System.out.println(e);
            }

            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            ProgressBar bar = ((ProgressBar) findViewById(R.id.progressBar));
            bar.setProgress(bar.getProgress() + values[0]);
        }

        @Override
        protected void onPostExecute(Void thisVoid) {
            ListView listViewHandle = (ListView) findViewById(R.id.listView);
            arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, contents);
            listViewHandle.setAdapter(arrayAdapter);
        }

    }

    public void clearContents(View v) {
        arrayAdapter.clear();
        ((ProgressBar) findViewById(R.id.progressBar)).setProgress(0);
    }
}
