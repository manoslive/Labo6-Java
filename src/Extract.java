/**
 * Created by Emmanuel on 2015-04-09.
 */

public class Extract {
    StringBuilder contentBuilder = new StringBuilder();
    try {
        BufferedReader in = new BufferedReader(new FileReader("mypage.html"));
        String str;
        while ((str = in.readLine()) != null) {
            contentBuilder.append(str);
        }
        in.close();
    } catch (IOException e) {
    }
    String content = contentBuilder.toString();
}
