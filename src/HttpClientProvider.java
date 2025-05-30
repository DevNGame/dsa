

import java.net.http.HttpClient;

public class HttpClientProvider {
    private static HttpClient httpClient;

    private HttpClientProvider() {

    }

    public static HttpClient getHttpClient() {
        if (httpClient == null) {
            synchronized (HttpClientProvider.class) {
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