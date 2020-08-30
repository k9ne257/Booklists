package com.example.bookslists.utilites;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.example.bookslists.models.Volume;
import java.util.List;

public class VolumeLoader extends AsyncTaskLoader<List<Volume>> {
    private static final String LOG_TAG = VolumeLoader.class.getName();
    private String url;

    public VolumeLoader(Context context, String url) {
        super(context);
        this.url = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Volume> loadInBackground() {
        if (url == null) {
            return null;
        }
        return QueryUtils.fetchVolumeData(url);
    }
}