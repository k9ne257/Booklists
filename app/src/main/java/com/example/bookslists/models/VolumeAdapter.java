package com.example.bookslists.models;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.bookslists.R;

import java.util.ArrayList;

public class VolumeAdapter extends ArrayAdapter<Volume> {

    public VolumeAdapter(Context context, ArrayList<Volume> volumes) {
        super(context, 0, volumes);
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Volume currentVolume = getItem(position);
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.tv_title);
        titleTextView.setText(currentVolume.getTitle());

        //TODO get image from url

        TextView authorTextView = (TextView) listItemView.findViewById(R.id.tv_author);
        authorTextView.setText(currentVolume.getAuthoren());

        TextView priceTextView = (TextView) listItemView.findViewById(R.id.tv_price);
        priceTextView.setText(currentVolume.getPrice());

        TextView publisherTextView = (TextView) listItemView.findViewById(R.id.tv_publisher);
        publisherTextView.setText(currentVolume.getPublisher());

        TextView isbnTextView = (TextView) listItemView.findViewById(R.id.tv_isbn);
        isbnTextView.setText(currentVolume.getIsbn());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.tv_pubDate);
        dateTextView.setText(currentVolume.getPublishDate());

        return listItemView;
    }


}
