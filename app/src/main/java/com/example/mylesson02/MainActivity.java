package com.example.mylesson02;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static List<String> images = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = this.findViewById(R.id.button);
        final ImageView imageView = this.findViewById(R.id.imageView4);
        button.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
                        Toast.makeText(MainActivity.this,"Loading image...",Toast.LENGTH_SHORT)
                                .show();

                         Picasso.get()
                                 .load(getRandomPicture())
                                 .into(imageView);
                    }


                }

        );
    }

    static{
        images.add("https://www.mononews.gr/wp-content/uploads/2017/11/balayage.jpg");
        images.add("https://content2.latest-hairstyles.com/wp-content/uploads/black-and-burgundy-ombre-500x625.jpg");
        images.add("https://i.pinimg.com/originals/f7/ff/7d/f7ff7d669b73e0563a5d8e114ccca95a.jpg");
    }

    private static String getRandomPicture(){
        Random r = new Random();
        return images.get(r.nextInt(images.size()));
    }
}
