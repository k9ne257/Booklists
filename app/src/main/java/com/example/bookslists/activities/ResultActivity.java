package com.example.bookslists.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LoaderManager;
import android.content.Intent;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.bookslists.R;
import com.example.bookslists.models.Volume;
import com.example.bookslists.models.VolumeAdapter;
import com.example.bookslists.utilites.QueryUtils;
import com.example.bookslists.utilites.VolumeLoader;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Volume>>{

    static String searchKey;
    private VolumeAdapter adapter;
    private static String request;
    private static final int VOLUME_LOADER_ID = 1;
    private TextView mEmptyStateTextView;

    @Override
    public Loader<List<Volume>> onCreateLoader(int i, Bundle bundle) {
        return new VolumeLoader(this, request);
    }

    @Override
    public void onLoadFinished(Loader<List<Volume>> loader, List<Volume> earthquakes) {
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        mEmptyStateTextView.setText(R.string.no_volumes);

        // Clear the adapter of previous earthquake data
        adapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            adapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Volume>> loader) {
        // Loader reset, so we can clear out our existing data.
        adapter.clear();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent i = getIntent();
        searchKey = i.getStringExtra("key");
        request = "https://www.googleapis.com/books/v1/volumes?q=" + searchKey;

        ListView volumeListView = (ListView) findViewById(R.id.list);

        adapter = new VolumeAdapter(this, new ArrayList<Volume>());
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

        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        volumeListView.setEmptyView(mEmptyStateTextView);

        LoaderManager loaderManager = getLoaderManager();
        loaderManager.initLoader(VOLUME_LOADER_ID, null, this);


    }
}