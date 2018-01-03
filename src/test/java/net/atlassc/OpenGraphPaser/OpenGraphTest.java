package net.atlassc.OpenGraphPaser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.atlassc.OpenGraphParser.OpenGraph;
import net.atlassc.OpenGraphParser.Parser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URLConnection;

public class OpenGraphTest {
    @Test
    public void testFields() {

        OkHttpClient client = new OkHttpClient();

        // Create request for remote resource.
        Request request = new Request.Builder()
                .url("https://www.theverge.com/2018/1/1/16838016/otto-smart-lock-startup-suspends-operations")
                .build();


        // Execute the request and retrieve the response.
        try (Response response = client.newCall(request).execute()) {
            // Deserialize HTTP response to concrete type.
            OpenGraph openGraph = Parser.parseOpenGraph(response.body().string());

            Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
            String json = gson.toJson(openGraph);
            System.out.println(json);


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
