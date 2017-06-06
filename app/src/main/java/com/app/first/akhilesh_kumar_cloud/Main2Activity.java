package com.app.first.akhilesh_kumar_cloud;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class Main2Activity extends AppCompatActivity {

    connectionCheck ch;
    private File imageFile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ch=new connectionCheck(this);


    }
    public void onClick(View view){

        if (view.getId()==R.id.button5){

            Intent i=new Intent(this ,MapsActivity.class);
            startActivity(i);
        }
        if (view.getId()==R.id.button_Check){

            if (ch.isConnected()){

                Toast.makeText(Main2Activity.this,"Internet connected ", Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(Main2Activity.this,"Internet not connected",Toast.LENGTH_LONG).show();
            }

        }
        if (view.getId()==R.id.button_camrera){
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            imageFile=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
            Uri tempr=Uri.fromFile(imageFile);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, tempr);
            intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
            startActivityForResult(intent ,0);
        }
        if (view.getId()==R.id.button_weather){
            Intent i=new Intent(this ,WeatherA.class);
            startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode==0){
            switch (requestCode){
                case Activity.RESULT_OK:
                    if(imageFile.exists())
                    {
                        Toast.makeText(this,"the file was saved"+imageFile.getAbsolutePath(),Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(this,"the image was not save ",Toast.LENGTH_SHORT).show();
                    }
                    break;
                case Activity.RESULT_CANCELED:
                    break;

            }


        }
    }


}

