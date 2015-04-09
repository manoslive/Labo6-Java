import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Emmanuel on 2015-04-09.
 */

public class Extract {
    static void main(String[] args) {
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader("mypage.html"));
            String str;
            while ((str = in.readLine()) != null) {
                contentBuilder.append(str);
            }
            in.close();
        } catch (
                IOException e
                )

        {
        }

        String content = contentBuilder.toString();
    }
}
