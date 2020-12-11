package com.example.ex024;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Tahel Hazan <th8887@bs.amalnet.k12.il>
 * @version 1.1.5
 * @since 11.12.2020  The user can add plus 1 to the counter and write his name and when he will exit the app the data will be saved.
 */
public class MainActivity extends AppCompatActivity {
    /**
     * @param n = number in TextView
     */
    TextView n;
    EditText name;
    /**
     * @param num = counter.
     */
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n=(TextView) findViewById(R.id.n);
        name=(EditText) findViewById(R.id.name);

        SharedPreferences settings=getSharedPreferences("stm",MODE_PRIVATE);
        n.setText(""+settings.getInt("score",-1));
        name.setText(settings.getString("txtname",null));
    }

    /**
     * Adds 1 to the number above.
     *
     * @param view the view
     */
    public void add1(View view) {
        num+=1;
        n.setText(""+num);
    }

    /**
     * Resets the number above.
     *
     * @param view the view
     */
    public void res(View view) {
        n.setText("0");
        num=0;
    }

    /**
     * exits the app and saves the data.
     *
     * @param view stm- Short Term Memory.
     */
    public void exit(View view) {
        String s= name.getText().toString();
        SharedPreferences settings =getSharedPreferences("stm",MODE_PRIVATE);
        SharedPreferences.Editor editor=settings.edit();
        editor.putString("txtname",s);
        editor.putInt("score",num);
        editor.commit();
        finish();
    }

    /**
     * Btnp.
     *
     * @param item the item Sends a Toast to let the user know he is in the current page
     *             he chose from the OptionMenu.
     */
    public void btnp(MenuItem item) {
        Toast.makeText(this, "You are already here :)", Toast.LENGTH_SHORT).show();
    }
    /**
     * Cred.
     *
     * @param item the item Moves from main activity to Credits.
     */
    public void cred(MenuItem item) {
        Intent c= new Intent(this,Credits.class);
        startActivity(c);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}