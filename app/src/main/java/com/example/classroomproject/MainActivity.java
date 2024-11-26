package com.example.classroomproject;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    TextView tvFName, tvLName, tvBD, tvPNumber;
    ListView lv;
    Spinner spinner;
    String[] classArry;
    String[][] class1;
    String[][] class2;
    String[][] class3;
    String[][] class4;
    int classSlected;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvLName = findViewById(R.id.tvFName);
        tvFName = findViewById(R.id.tvLName);
        tvBD = findViewById(R.id.tvBD);
        tvPNumber = findViewById(R.id.tvPNumber);

        lv = findViewById(R.id.lv);
        spinner = findViewById(R.id.spinner);


        classArry = new String[]{"select class", "class1", "class2", "class3", "class4"};

        class1 = new String[][]{
                {"Cohen", "David", "2008-05-15", "050-1234567"},
                {"Levi", "Maya", "2008-08-22", "052-9876543"},
                {"Rosenberg", "Eitan", "2008-03-10", "053-4567890"},
                {"Shapiro", "Yael", "2008-11-05", "054-1122334"},
                {"Goldstein", "Noah", "2008-07-18", "055-6677889"},
                {"Friedman", "Shira", "2008-12-25", "050-2233445"},
                {"Peretz", "Adam", "2008-01-30", "052-4455667"},
                {"Ben-David", "Talia", "2008-06-12", "053-7788990"},
                {"Segal", "Yonatan", "2008-09-07", "054-9988776"},
                {"Kaplan", "Noga", "2008-04-14", "055-3344556"}
        };

        class2 = new String[][]{
                {"Abramson", "Lior", "2008-03-22", "050-9876543"},
                {"Baruch", "Ella", "2008-07-15", "052-1234987"},
                {"Golan", "Omer", "2008-02-18", "053-7645890"},
                {"Dayan", "Noa", "2008-11-10", "054-3456789"},
                {"Weiss", "Tomer", "2008-08-08", "055-9876543"},
                {"Aviv", "Roni", "2008-12-01", "050-1234560"},
                {"Katz", "Alon", "2008-06-25", "052-7654321"},
                {"Mor", "Dana", "2008-01-12", "053-3344556"},
                {"Shalev", "Gil", "2008-04-09", "054-2233445"},
                {"Zohar", "Adi", "2008-05-28", "055-9988770"}
        };

        class3 = new String[][]{
                {"Harari", "Yossi", "2008-09-18", "050-6789012"},
                {"Navon", "Hila", "2008-10-22", "052-1123581"},
                {"Tzur", "Bar", "2008-05-14", "053-9988776"},
                {"Eldar", "Lea", "2008-03-03", "054-4455667"},
                {"Amir", "Nadav", "2008-02-21", "055-1239876"},
                {"Blum", "Sara", "2008-11-27", "050-4567890"},
                {"Tamir", "Itai", "2008-12-31", "052-7890123"},
                {"Nir", "Tamar", "2008-01-05", "053-5678901"},
                {"Gal", "Erez", "2008-07-02", "054-6781234"},
                {"Barak", "Michal", "2008-06-16", "055-8765432"}
        };

        class4 = new String[][]{
                {"Ashkenazi", "Ron", "2008-10-10", "050-2345678"},
                {"Livni", "Yaara", "2008-09-30", "052-4561234"},
                {"Perry", "Amit", "2008-04-20", "053-7894561"},
                {"Rubin", "Galit", "2008-12-19", "054-9876123"},
                {"Shani", "Eli", "2008-01-23", "055-6543210"},
                {"Carmel", "Tamar", "2008-03-29", "050-1122334"},
                {"Levanon", "Yair", "2008-06-01", "052-3344556"},
                {"Shaul", "Rivka", "2008-08-15", "053-2233445"},
                {"Moran", "Dani", "2008-02-11", "054-6655443"},
                {"Oren", "Shani", "2008-07-21", "055-4433221"}
        };

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, classArry);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(this);

        lv.setOnItemClickListener(this);

    }

    public String[] extractNames(String[][] classArray)
    {
        String[] names = new String[10];
        for (int i = 0; i < 10; i++)
        {
            names[i] = classArray[i][1] + " " + classArray[i][0];
        }
        return names;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
        lv.setVisibility(View.INVISIBLE);
        tvLName.setVisibility(View.INVISIBLE);
        tvFName.setVisibility(View.INVISIBLE);
        tvBD.setVisibility(View.INVISIBLE);
        tvPNumber.setVisibility(View.INVISIBLE);

        if ( i != 0 )
        {
            String [] names = null;

            switch (i)
            {
                case 1:
                    names = extractNames(class1);
                    classSlected = 1;
                    break;

                case 2:
                    names = extractNames(class2);
                    classSlected = 2;
                    break;

                case 3:
                    names = extractNames(class3);
                    classSlected = 3;
                    break;

                case 4:
                    names = extractNames(class4);
                    classSlected = 4;
                    break;
            }

            if (names != null)
            {
                ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);
                lv.setAdapter(listAdapter);
            }

            lv.setVisibility(View.VISIBLE);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
    {
        switch (classSlected)
        {
            case 1:
                tvLName.setText(class1[i][0]);
                tvFName.setText(class1[i][1]);
                tvBD.setText(class1[i][2]);
                tvPNumber.setText(class1[i][3]);
                break;

            case 2:
                tvLName.setText(class2[i][0]);
                tvFName.setText(class2[i][1]);
                tvBD.setText(class2[i][2]);
                tvPNumber.setText(class2[i][3]);
                break;

            case 3:
                tvLName.setText(class3[i][0]);
                tvFName.setText(class3[i][1]);
                tvBD.setText(class3[i][2]);
                tvPNumber.setText(class3[i][3]);
                break;

            case 4:
                tvLName.setText(class4[i][0]);
                tvFName.setText(class4[i][1]);
                tvBD.setText(class4[i][2]);
                tvPNumber.setText(class4[i][3]);
                break;
        }

        tvLName.setVisibility(View.VISIBLE);
        tvFName.setVisibility(View.VISIBLE);
        tvBD.setVisibility(View.VISIBLE);
        tvPNumber.setVisibility(View.VISIBLE);
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
}