package com.example.healthyfoodcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

public class apps_info extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps_info);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(apps_info.this,Dashboard_page.class);
                startActivity(i);
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.app_info,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        if(item.getItemId() ==R.id.rate)
        {
            Intent i=new Intent(Intent.ACTION_VIEW);
            //COLLECTION NAMES::topselling_paid,movers_shakers,topselling_new_free,topselling_new_paid,topgrossing
            i.setData(Uri.parse("https://play.google.com/store/apps/details?id=cn.xender"));
            //pass com.android.vending into package() so that users see ur app's details in google play store instead of chooser
            i.setPackage("com.android.vending");
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}
