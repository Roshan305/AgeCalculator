package com.example.agecalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuItem;

import java.time.LocalDate;
import java.util.Calendar;
import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    TextView txtDate, txtMonth, txtDay, txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item2:
                Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.item3:
                Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void buttonClicked(View view) {
        EditText yearEdit = findViewById(R.id.txtYear);
//        TextView txtResult = findViewById(R.id.txtResult);
        if (yearEdit.getText().toString().isEmpty()) {
            Context context = getApplicationContext();
            CharSequence text = "Values cannot be empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return;
        }

        int year = Integer.parseInt(yearEdit.getText().toString());
        int month = Integer.parseInt(((EditText) findViewById(R.id.txtMonth)).getText().toString());
        int day = Integer.parseInt(((EditText) findViewById(R.id.txtDay)).getText().toString());

        Calendar date = Calendar.getInstance();
        int currentYear = date.get(Calendar.YEAR);
        int currentMonth = date.get(Calendar.MONTH);
        int currentDay = date.get(Calendar.DAY_OF_MONTH);

        int finalYear = currentYear - year;

        int finalMonth = currentMonth - month;
        if (finalMonth < 0) {
            finalYear--;
            finalMonth = currentMonth + 12 - month;
        }

        int finalDay = currentDay - day;
        if (finalDay < 0) {
            finalMonth--;
            finalDay = currentDay + 30 - day;
        }

//        txtResult.setText(String.valueOf(finalYear) + "years" + String.valueOf(finalMonth) + "months" + String.valueOf(finalDay) + "days");
        String result = String.valueOf(finalYear) + "years" + String.valueOf(finalMonth) + "months" + String.valueOf(finalDay) + "days";

        new ResultDialog(result).show(getSupportFragmentManager(), ResultDialog.TAG);

    }
}

