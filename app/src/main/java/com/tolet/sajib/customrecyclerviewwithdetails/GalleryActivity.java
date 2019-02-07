package com.tolet.sajib.customrecyclerviewwithdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GalleryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
          getInComingIntent();

}


    private void getInComingIntent() {
        if(getIntent().hasExtra("image_url")&&getIntent().hasExtra("image_name")){
            String imageurl=getIntent().getStringExtra("image_url");
            String imagename=getIntent().getStringExtra("image_name");
            setImage(imageurl,imagename);
        }
    }

    private void setImage(String imageurl,String imagename) {
        TextView name=findViewById(R.id.nameid);
        name.setText(imagename);
        ImageView img=findViewById(R.id.imgid);
        Glide.with(this)
                .asBitmap()
                .load(imageurl)
                .into(img);
    }
}
