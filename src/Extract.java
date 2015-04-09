import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Emmanuel on 2015-04-09.
 */

public class Extract {
    static void main(String[] args) {
        monFileWriter(monFileReader(args[0]), args[1]);
    }
    static String monFileReader(String file)
    {
        final String startBaliseLien = "<a href";
        final String finBaliseLien = "</a>";
        int startIndex = 0;
        int stopIndex = 0;
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String str;
            while ((str = in.readLine()) != null) {
                do
                {
                    String lien = null;
                    startIndex = str.indexOf(startBaliseLien, startIndex);
                    stopIndex = str.indexOf(finBaliseLien, stopIndex);
                    lien = str.substring(startIndex,stopIndex);
                    contentBuilder.append(lien);
                }while(str.lastIndexOf(startBaliseLien) != startIndex);
            }
            in.close();
        } catch (
                IOException e
                )

        {
        }
        String content = contentBuilder.toString();
        return content;
    }
    static void monFileWriter(String text, String file)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter( file));
            writer.write( text);

        }
        catch ( IOException e)
        {
        }
        finally
        {
            try
            {
                if ( writer != null)
                    writer.close( );
            }
            catch ( IOException e)
            {
            }
        }
    }
}
