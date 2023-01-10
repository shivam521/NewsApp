package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.Models.NewsHeadlines;
import com.squareup.picasso.Picasso;

import java.util.List;

// first extends class to RecyclerView.Adapter
// now pass CustomViewHolder to RecyclerView.Adapter<CustomViewHolder>
// it shows error, creates methods onCreateViewHolder onBindViewHolder getItemCount
// now code is error less
// next work in Custom Adapter Class to create objects

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder>{

    //  we will create object that will pass for our custom adapter
    // and will also create a constructer
    // first create object for context
    private Context context;

    // then we will also pass a list of news headlines to our recycler view to show them
    // again create object
    private List<NewsHeadlines> headlines;

    // then I will create constructor for both of them

    private SelectListener listener;

    public CustomAdapter(Context context, List<NewsHeadlines> headlines, SelectListener listener) {
        this.listener = listener;
        this.context = context;
        this.headlines = headlines;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // after that her intead of returning null, return new

        return new CustomViewHolder(LayoutInflater.from(context).inflate(R.layout.headline_list_items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {

        // now here we will call textview, imageview and attach all data to it

        holder.text_title.setText(headlines.get(position).getTitle());

        // then we will also add the text source for our source of that new as you
        // can see inside the api response our "source name" is inside the source object which is
        // further inside the article array
        // so for that we have to write

        holder.text_source.setText(headlines.get(position).getSource().getName());

        // now we have also show the image of the news article inside the imageView
        // to show the news image we are going to use new library called picasso
        // go google search picasso and copy dependencies in gradle buil module

        // here may be problem .getUrlToImage method not found
        if(headlines.get(position).getUrlToImage()!= null) {

            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnNewsClicked((headlines.get(position)));

            }
        });
    }

    @Override
    public int getItemCount() {
        // return headlines.size
        return headlines.size();
    }
}
// now got main activity and download retrofit library to manage api request.