package com.example.healthyfoodcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class anemia_page extends AppCompatActivity {
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_anemia_page);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        // setTitle("DISEASES LIST");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(anemia_page.this,DiseasesPage.class);
                startActivity(i);
            }
        });
    }
    public  void linear1(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_intro.class);
        startActivity(i);
    }
    public  void arrow1(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_intro.class);
        startActivity(i);
    }
    public  void linear2(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_causes.class);
        startActivity(i);
    }
    public  void arrow2(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_causes.class);
        startActivity(i);
    }
    public  void linear3(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_symptoms.class);
        startActivity(i);
    }
    public  void linear4(View v)
    {
        Intent i=new Intent(anemia_page.this,anemia_food.class);
        startActivity(i);
    }
}
