package com.example.appsb.sqlitedemo;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabase myDatabase;
    private ArrayList<dbModel> wordList;
    private ArrayList<dbModel> imageList;
    Button btn;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.btn);
        iv=findViewById(R.id.img);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        wordList=new ArrayList<>();
        imageList=new ArrayList<>();

        myDatabase=new MyDatabase(MainActivity.this);
        wordList=myDatabase.getWord();
//        for(int i=0;i<wordList.size();i++){
//
//        }
        imageList=myDatabase.getImage(wordList.get(0).getWordid());
        Log.e("TAG",imageList.get(0).getImage());
        Log.e("TAG",imageList.get(1).getImage());
        Log.e("TAG",imageList.get(2).getImage());
        Log.e("TAG",imageList.get(3).getImage());

        setImage();

    }

    private void setImage() {
        // Get the AssetManager
        AssetManager manager = getAssets();

        // Read a Bitmap from Assets
        try {
            InputStream open = manager.open("images/"+imageList.get(1).getImage());
            Bitmap bitmap = BitmapFactory.decodeStream(open);
            // Assign the bitmap to an ImageView in this layout
            iv.setImageBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
