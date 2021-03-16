package com.example.demo.dubbo.protocol.http;

import com.example.demo.dubbo.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {
    public String post(String hostName, Integer port, Invocation invocation) throws IOException {

        URL url = new URL("HTTP", hostName, port, "/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true);
        OutputStream outputStream = httpURLConnection.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(invocation);
        objectOutputStream.flush();
        objectOutputStream.close();

        InputStream inputStream = httpURLConnection.getInputStream();

        return IOUtils.toString(inputStream);
    }
}
