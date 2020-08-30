package com.example.bookslists.utilites;

import android.text.TextUtils;
import android.util.Log;

import com.example.bookslists.models.Volume;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtils {
    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {
    }

    public static List<Volume> fetchVolumeData(String request) {
        URL url = createUrl(request);
        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Error closing input stream", e);
        }

        return extractVolumes(jsonResponse);
    }

    public static List<Volume> extractVolumes(String jsonResponse) {

        if (TextUtils.isEmpty(jsonResponse)) {
            Log.e(LOG_TAG, "Keine Daten von der Webseite erhalten! ");
            return null;
        }

        List<Volume> volumes = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(jsonResponse);
            JSONArray rootArray = root.getJSONArray("items");
            for (int i = 0; i < rootArray.length(); i++) {
                JSONObject current = rootArray.getJSONObject(i);
                String url = current.getString("selfLink");
                JSONObject volumeInfo = current.getJSONObject("volumeInfo");
                String title = volumeInfo.getString("title");
                String date = volumeInfo.getString("publishedDate");
                String publisher = "";
                if (volumeInfo.has("publisher")) {
                    publisher = volumeInfo.getString("publisher");
                }
                else{
                    publisher = "n/A";
                }

                JSONArray authorArray;
                String authors = "";

                if (volumeInfo.has("authors")) {
                    authorArray = volumeInfo.getJSONArray("authors");
                    if (authorArray.length() > 1) {
                        for (int j = 0; j < authorArray.length() - 1; j++) {
                            authors += authorArray.getString(j) + ",\n";
                        }
                        authors += authorArray.getString(authorArray.length() - 1);
                    } else {
                        authors = authorArray.getString(0);
                    }
                }
                else{
                    authors = "Magazine ";
                }
                String isbn = "";
                JSONArray isbnArray;
                if(volumeInfo.has("industryIdentifiers")){
                    isbnArray = volumeInfo.getJSONArray("industryIdentifiers");
                    isbn = String.valueOf(isbnArray.getJSONObject(0).getString("identifier"));
                }
                volumes.add(new Volume(authors, publisher, date, title, url, isbn, ""));
            }
        }
        catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }
        return volumes;
    }

    private static URL createUrl(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            System.out.println("Error creating new URL");        }
        return url;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try{
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(1000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                System.out.println("Error response code: " + urlConnection.getResponseCode());
            }

        } catch (IOException e) {
            System.out.println("Error creating URL connection");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if(inputStream != null){
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null){
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}
