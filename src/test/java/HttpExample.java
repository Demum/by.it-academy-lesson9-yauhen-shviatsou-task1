import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class HttpExample {
    @Test
    public void testGetMethod() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://yandex.by/");
        try {
            HttpResponse response = httpClient.execute(httpGet);
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200);
            System.out.println("GetCodResponse: " + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpClient.close();
    }
    @Test
    public void testPutMethod() throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPut httpPut = new HttpPut("https://yandex.by/put");
        try {
            httpPut.setEntity(new StringEntity("Hello"));
            HttpResponse responsePut = httpClient.execute(httpPut);
            System.out.println("PutCodeResponse" + responsePut.getStatusLine().getStatusCode());
            Assert.assertEquals(responsePut.getStatusLine().getStatusCode(), 403);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        httpClient.close();
    }
}


