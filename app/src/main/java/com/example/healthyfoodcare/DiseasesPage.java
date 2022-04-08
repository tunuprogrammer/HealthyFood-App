package com.example.healthyfoodcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
//import android.support.v4.widget.SearchView;

public class DiseasesPage extends AppCompatActivity {
    Toolbar toolbar;
    ListView listView;
    //add an array which provide data for a listview
    String[] nameArray = {"Anemia","Lung Cancer","Leukemia","Malaria","Goiter","Diabetes",
            "Measles","Tuberculosis","Ebola","Influenza","HIV/AIDS","Dengue"};
    Integer[] imageArray = {R.drawable.anemia,
            R.drawable.lungcancer,
            R.drawable.leukemia,
            R.drawable.malaria,
            R.drawable.influenza,
            R.drawable.diabetes,R.drawable.measles,
            R.drawable.lungcancer,
            R.drawable.leukemia,
            R.drawable.influenza,
            R.drawable.hiv,
            R.drawable.diabetes};

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases_page);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
       // setTitle("DISEASES LIST");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(DiseasesPage.this,Dashboard_page.class);
                startActivity(i);
            }
        });

        final CustomListAdapter whatever = new CustomListAdapter(this, nameArray,imageArray);
        listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(whatever);

        //This basically “listens” for clicks on rows in the ListView, and provides the position
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (position ==0)
                {
                    Intent intent = new Intent(DiseasesPage.this, anemia_page.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
               else if (position ==1)
                {
                    Intent intent = new Intent(DiseasesPage.this, lungcancer.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
                else if (position ==2)
                {
                    Intent intent = new Intent(DiseasesPage.this, leukemia.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
                else if (position ==3)
                {
                    Intent intent = new Intent(DiseasesPage.this, malaria.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
                else if (position ==4)
                {
                    Intent intent = new Intent(DiseasesPage.this, Goitre.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
                else if (position ==5)
                {
                    Intent intent = new Intent(DiseasesPage.this, diabetes.class);
                    String message = nameArray[position];
                    startActivity(intent);
                }
                else
                    {
                        Intent intent = new Intent(DiseasesPage.this, Dashboard_page.class);
                        String message = nameArray[position];
                        startActivity(intent);
                        //finish();
                   }
            }
        });
    }
//    public boolean onCreateOptionsMenu(Menu menu)
//    {
//        getMenuInflater().inflate(R.menu.share,menu);
//        MenuItem menuItem=menu.findItem(R.id.search);
//
//    return  true;
//    }
}
