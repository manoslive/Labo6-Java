import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    Fait par Emmanuel Beloin et Shaun Cooper
    Le 09/04/15
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
        } catch (IOException e)
        {

        }

        String content = contentBuilder.toString();
}

    public void FileWriter(String text, String file)
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
