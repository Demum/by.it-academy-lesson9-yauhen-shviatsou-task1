import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Assert;
import org.junit.Test;

public class FourpdaTest {
    @Test
    public void testGtestGetMethidetMethod() {
        try (
                CloseableHttpClient client = HttpClients.createDefault();
            CloseableHttpResponse response = client.execute(new HttpGet("https://4pda.to/"))
        ) {
            Assert.assertEquals(response.getStatusLine().getStatusCode(),200);
            System.out.println(response.getStatusLine().getStatusCode());
        } catch (Throwable cause) {
            cause.printStackTrace();
        }
    }
}




