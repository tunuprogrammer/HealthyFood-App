package com.example.healthyfoodcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.appcompat.widget.Toolbar;

public class share extends AppCompatActivity {
Toolbar toolbar;
Button  sharingButton;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        Button sharingbutton;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharing);
//        toolbar=findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //create a share button
//        ImageButton sharingButton=new ImageButton(this);
//        sharingButton.setLayoutParams(new ViewGroup.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT));
//        sharingButton.setImageResource(R.drawable.ic_share_black_24dp);

        //listen for button click
        sharingButton=findViewById(R.id.share);
        sharingButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //create a send intent
                Intent share=new Intent(Intent.ACTION_SEND);
                //Set the sharing type
                //It can be image.jpg,video/mp4,application/pdf,text/html
                share.setType("text/plain");
                //Build the Share content
                String app_url="https://play.google.com/store/movies";
                //pass content to the Intent
                //You can add extra_email,extra_cc,extra_bcc,extra_subject
                share.putExtra(android.content.Intent.EXTRA_TEXT,app_url);
                Intent shareIntent=Intent.createChooser(share,"Share Via");
                startActivity(shareIntent);
            }
        });

    }
}
