package ru.kpfu.itis.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Юлия on 31.08.2016.
 */
public class Utils {

    public static String sendHttpGetRequest(String url, String[] names, String[] values) {
        url += "?";
        for (int i = 0; i < names.length; i++) {
            url += names[i] + "=" + values[i] + "&";
        }
        url = url.substring(0, url.length() - 1);

        try {
            HttpClient client = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);

            HttpResponse response = client.execute(request);


            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " +
                    response.getStatusLine().getStatusCode());

            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent(), "UTF-8"));

            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }

            System.out.println(result.toString());
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
