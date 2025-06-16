package DesignPatterns;

import java.net.http.HttpClient;

public class ThreadSafeSingleton {
    private static HttpClient httpClient;

    private ThreadSafeSingleton() {

    }

    public static HttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (httpClient == null) {
                    httpClient = HttpClient.newBuilder()
                            .version(HttpClient.Version.HTTP_1_1)
                            .build();
                }
            }
        }
        return httpClient;
    }
}