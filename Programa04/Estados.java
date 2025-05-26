//Hernández Hernández Luis Fernando
package com.example.programa04;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Estados extends Activity {
    private Spinner stateSpinner;
    private TextView capitalTextView;
    private Map<String, String> stateCapitalMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estados);

        stateSpinner = findViewById(R.id.stateSpinner);
        capitalTextView = findViewById(R.id.capitalTextView);

        stateCapitalMap = new HashMap<>();
        stateCapitalMap.put("California", "Sacramento");
        stateCapitalMap.put("Texas", "Austin");
        stateCapitalMap.put("Florida", "Tallahassee");
        stateCapitalMap.put("New York", "Albany");
        stateCapitalMap.put("Illinois", "Springfield");

        // Create an array of state names
        String[] states = stateCapitalMap.keySet().toArray(new String[0]);

        // Create an ArrayAdapter using the string array and a default spinner Layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, states);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        stateSpinner.setAdapter(adapter);

        // Set an item selected Listener for the spinner
        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Get the selected state
                String selectedState = parent.getItemAtPosition(position).toString();

                // Get the capital for the selected state
                String capital = stateCapitalMap.get(selectedState);

                // Display the capital in the TextView
                capitalTextView.setText("Capital: " + capital);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}