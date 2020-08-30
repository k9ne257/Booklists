package com.example.bookslists.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bookslists.R;
import com.example.bookslists.models.Volume;
import com.example.bookslists.models.VolumeAdapter;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    private static ArrayList<Volume> volumes;
    private VolumeAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ListView volumeListView = (ListView) findViewById(R.id.list);

        volumes = new ArrayList<Volume>();

        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "https://www.youtube.com/watch?v=vsypFJ5mNw0", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "https://www.youtube.com/watch?v=vsypFJ5mNw0", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "https://www.youtube.com/watch?v=vsypFJ5mNw0", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));
        volumes.add(new Volume("Max Mustermann", "Book Printing GmbH", "07-07-2007", "Das Geile Buch", "", "9783446433151", "http://books.google.com/books/content?id=FLBPAgAAQBAJ&printsec=frontcover&img=1&zoom=6&edge=curl&imgtk=AFLRE71cU0KH06z9ilG7YQHrPbfbOvmazBHYUyHoyzp_ELFCT94QPjLmdFyc22s8OcYdA7TmJoYbv0NmxiZJk1ZGNr_hqMcPwzEHIuV6UTdzZ7dAmMkLJ3ZP89ZefiECbxWlQ_E1z43K&source=gbs_api", "19.99"));

        adapter = new VolumeAdapter(this, volumes);
        volumeListView.setAdapter(adapter);

        volumeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Volume currentVolume = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri volumeUri = Uri.parse(currentVolume.getLink());

                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, volumeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });


    }
}