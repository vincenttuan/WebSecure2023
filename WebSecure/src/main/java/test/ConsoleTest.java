package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConsoleTest {

	public static void main(String[] args) {
        try {
            URL url = new URL("https://localhost:8443/WebSecure/servlet/hello");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 設定 User-Agent header
            connection.setRequestProperty("user-agent", "Chrome");

            // 建立並開啟連線
            connection.connect();

            // 取得回應
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 關閉連線
            reader.close();
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
