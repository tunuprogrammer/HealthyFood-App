package com.example.healthyfoodcare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Dashboard_page extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setTitle("HOME");
        setSupportActionBar(toolbar);
        //toolbar.setNavigationIcon(R.drawable.back);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.person);
         //getSupportActionBar().setHomeButtonEnabled(true);
    } //END OF CREATE METHOD

    public void linear6(View view)
    {
        Intent intent=new Intent(Dashboard_page.this,DiseasesPage.class);
        startActivity(intent);
    }

    public void linear7(View view)
    {
        Intent i=new Intent(Dashboard_page.this,apps_info.class);
        startActivity(i);
    }
    public void linear5(View v)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String app_url="https://play.google.com/store/movies";
        i.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
        Intent shareIntent=Intent.createChooser(i,"Share Via");
        startActivity(shareIntent);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    //calling an item
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {

        if(item.getItemId() ==R.id.rate_us_menu)
        {
            Intent i=new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://play.google.com/store/apps/details?id=cn.xender"));
            //pass com.android.vending into package() so that users see ur app's details in google play store instead of chooser
            i.setPackage("com.android.vending");
            startActivity(i);
        }
        if(item.getItemId() == R.id.share_menu)
        {
            //create a send intent
            Intent i=new Intent(Intent.ACTION_SEND);
            //Set the sharing type
            //It can be image/jpg,video/mp4,application/pdf,text/html
            i.setType("text/plain");
            //Build the Share content
            String app_url="https://play.google.com/store/movies";
            //pass content to the Intent
            //You can add extra_email,extra_cc,extra_bcc,extra_subject
            i.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
            Intent shareIntent=Intent.createChooser(i,"Share Via");
            startActivity(shareIntent);
        }
        if(item.getItemId() == R.id.other_apps_menu)
        {
           Intent i=new Intent(Intent.ACTION_VIEW);
           //COLLECTION NAMES::topselling_paid,movers_shakers,topselling_new_free,topselling_new_paid,topgrossing
           i.setData(Uri.parse("https://play.google.com/store/apps/collection/topselling_free"));
           //pass com.android.vending into package() so that users see ur app's details in google play store instead of chooser
           i.setPackage("com.android.vending");
           startActivity(i);
        }

        if(item.getItemId() == R.id.term_of_use)
        {
            Intent intent = new Intent(getApplicationContext(),Terms_of_use.class);
            startActivity(intent);
        }
       // Toast.makeText(getApplicationContext(),"YOU HAVE CLICKED SHARE",Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
