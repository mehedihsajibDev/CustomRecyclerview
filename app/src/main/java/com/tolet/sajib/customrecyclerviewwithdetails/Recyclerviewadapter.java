package com.tolet.sajib.customrecyclerviewwithdetails;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder> {
    Context mcontext;
    ArrayList<String>mImagename=new ArrayList<>();
    ArrayList<String>mImageview=new ArrayList<>();

    public Recyclerviewadapter(Context mcontext, ArrayList<String> mImagename, ArrayList<String> mImageview) {
        this.mcontext = mcontext;
        this.mImagename = mImagename;
        this.mImageview = mImageview;
    }

    @NonNull
    @Override
    public Recyclerviewadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.sampleview,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewadapter.ViewHolder holder, final int position) {
   Glide.with(mcontext)
           .asBitmap()
           .load(mImageview.get(position))
           .into(holder.mImage);
   holder.textView.setText(mImagename.get(position));
  holder.parentLayout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
          String value=mImagename.get(position);
          Toast.makeText(mcontext,value, Toast.LENGTH_SHORT).show();
          Intent intent=new Intent(mcontext,GalleryActivity.class);
          intent.putExtra("image_url",mImageview.get(position));
          intent.putExtra("image_name",mImagename.get(position));
          mcontext.startActivity(intent);
      }
  });
    }

    @Override
    public int getItemCount() {
        return mImagename.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView mImage;
        TextView textView;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            mImage=itemView.findViewById(R.id.circleimageview);
            textView=itemView.findViewById(R.id.textviewnameid);
            parentLayout=itemView.findViewById(R.id.parent_layoutid);


        }
    }
}
