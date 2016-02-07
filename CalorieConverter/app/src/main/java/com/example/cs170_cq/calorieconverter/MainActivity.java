package com.example.cs170_cq.calorieconverter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    public String selectedExercise = "";


    public class MyOnItemSelectedListener implements OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            final Set<String> repExerList = new HashSet<String>();
            repExerList.add("Pushups");
            repExerList.add("Situps");
            repExerList.add("Pullups");
            repExerList.add("Squats");
            selectedExercise = parent.getItemAtPosition(pos).toString();
            TextView texxxxvieewww = (TextView) findViewById(R.id.ChoseRepOrMinute);
            texxxxvieewww.setText(getExRepr(selectedExercise, repExerList));
        }

        @Override
        public void onNothingSelected(AdapterView<?> arg0) {
            // TODO Auto-generated method stub
            selectedExercise = "";
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText handleField = (EditText) findViewById(R.id.edit_message);
        final Button btn = (Button) findViewById(R.id.calculate_button);
        final HashMap<String, Double> calorieExerciseMapping = new HashMap<String, Double>();
        calorieExerciseMapping.put("Pushups", 350.0);
        calorieExerciseMapping.put("Situps", 200.0);
        calorieExerciseMapping.put("Squats", 225.0);
        calorieExerciseMapping.put("Pullups", 100.0);
        calorieExerciseMapping.put("Jumping Jacks", 10.0);
        calorieExerciseMapping.put("Jogging", 12.0);
        calorieExerciseMapping.put("Leg-lifts", 25.0);
        calorieExerciseMapping.put("Planks", 25.0);
        calorieExerciseMapping.put("Cycling", 12.0);
        calorieExerciseMapping.put("Walking", 20.0);
        calorieExerciseMapping.put("Swimming", 13.0);
        calorieExerciseMapping.put("Stair-Climbing", 15.0);
        final String[] exer_list = {"Pushups", "Situps", "Squats", "Pullups", "Jumping Jacks", "Jogging","Leg-lifts", "Planks","Cycling", "Walking", "Swimming", "Stair-Climbing"};
        final Set<String> repExerList = new HashSet<String>();
        repExerList.add("Pushups");
        repExerList.add("Situps");
        repExerList.add("Pullups");
        repExerList.add("Squats");

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, exer_list);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new MyOnItemSelectedListener());

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //setContentView(R.layout.yourlayout):
                TextView tv1 = (TextView)findViewById(R.id.resulting_calories);
                if((!(((handleField.getText()).toString()).isEmpty())) && (!(selectedExercise.equals("")))) {
                    double howManyCalories = convert_to_cal(Double.parseDouble(handleField.getText().toString()), calorieExerciseMapping);
                    tv1.setText(String.valueOf((int) Math.ceil(howManyCalories)) + " Calories");
                    ArrayList<String> alExer = new ArrayList <String>();
                    for (int i = 0; i < exer_list.length; i++) {
                            if (!(selectedExercise.equals(exer_list[i]))) {
                            alExer.add(exer_list[i]);
                        }
                    }
                    for (int j = 1; j <= alExer.size(); j++) {
                        if (j == 1) {
                            TextView tvEx1 = (TextView) findViewById(R.id.exBox1);
                            tvEx1.setText(alExer.get(j - 1));
                            TextView tvConvBox1 = (TextView) findViewById(R.id.convertedBox1);
                            tvConvBox1.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j - 1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 2) {
                            TextView tvEx2 = (TextView) findViewById(R.id.exBox2);
                            tvEx2.setText(alExer.get(j - 1));
                            TextView tvConvBox2 = (TextView) findViewById(R.id.convertedBox2);
                            tvConvBox2.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 3) {
                            TextView tvEx3 = (TextView) findViewById(R.id.exBox3);
                            tvEx3.setText(alExer.get(j - 1));
                            TextView tvConvBox3 = (TextView) findViewById(R.id.convertedBox3);
                            tvConvBox3.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 4) {
                            TextView tvEx4 = (TextView) findViewById(R.id.exBox4);
                            tvEx4.setText(alExer.get(j - 1));
                            TextView tvConvBox4 = (TextView) findViewById(R.id.convertedBox4);
                            tvConvBox4.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 5) {
                            TextView tvEx5 = (TextView) findViewById(R.id.exBox5);
                            tvEx5.setText(alExer.get(j - 1));
                            TextView tvConvBox5 = (TextView) findViewById(R.id.convertedBox5);
                            tvConvBox5.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 6) {
                            TextView tvEx6 = (TextView) findViewById(R.id.exBox6);
                            tvEx6.setText(alExer.get(j - 1));
                            TextView tvConvBox6 = (TextView) findViewById(R.id.convertedBox6);
                            tvConvBox6.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 7) {
                            TextView tvEx7 = (TextView) findViewById(R.id.exBox7);
                            tvEx7.setText(alExer.get(j - 1));
                            TextView tvConvBox7 = (TextView) findViewById(R.id.convertedBox7);
                            tvConvBox7.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 8) {
                            TextView tvEx8 = (TextView) findViewById(R.id.exBox8);
                            tvEx8.setText(alExer.get(j - 1));
                            TextView tvConvBox8 = (TextView) findViewById(R.id.convertedBox8);
                            tvConvBox8.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 9) {
                            TextView tvEx9 = (TextView) findViewById(R.id.exBox9);
                            tvEx9.setText(alExer.get(j - 1));
                            TextView tvConvBox9 = (TextView) findViewById(R.id.convertedBox9);
                            tvConvBox9.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 10) {
                            TextView tvEx10 = (TextView) findViewById(R.id.exBox10);
                            tvEx10.setText(alExer.get(j - 1));
                            TextView tvConvBox10 = (TextView) findViewById(R.id.convertedBox10);
                            tvConvBox10.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         } else if (j == 11) {
                            TextView tvEx11 = (TextView) findViewById(R.id.exBox11);
                            tvEx11.setText(alExer.get(j - 1));
                            TextView tvConvBox11 = (TextView) findViewById(R.id.convertedBox11);
                            tvConvBox11.setText((String.valueOf((int) Math.ceil(convert_from_cal(howManyCalories, calorieExerciseMapping, alExer.get(j-1))))) + getExRepr(alExer.get(j-1), repExerList));
                         }
                    }
                }

            }
        });

    }

    public double convert_to_cal (double ex_amount, HashMap<String, Double> calorieExerciseMapping) {
        if(selectedExercise != null)
            return (100.0 * ex_amount) / calorieExerciseMapping.get(selectedExercise);
        else
            return 0.0;
    }

    public double convert_from_cal (double cal_amount, HashMap<String, Double> calorieExerciseMapping, String ex_type) {
        return (cal_amount * calorieExerciseMapping.get(ex_type)) / 100.0;
    }

    public String getExRepr (String ex_type, Set<String> repSet) {
        if(repSet.contains(ex_type)) {
            return " Reps";
        }
        else {
            return " Minutes";
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
}