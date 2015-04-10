import java.io.File;
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
        File file = new File(args[0]);
        if(args.length == 2)
            if(file.exists() && !file.isDirectory())
                monFileWriter(monFileReader(args[0]), args[1]);
            else
                System.out.println("Fichier d'entré n'existe pas ou le paramètre est un répertoire!");
        else
            System.out.println("Mauvais nombre de paramètres");
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
            contentBuilder.append("<ul>");
            while ((str = in.readLine()) != null) {
                do
                {
                    String lien=null;
                    startIndex = str.indexOf(startBaliseLien, startIndex);
                    stopIndex = str.indexOf(finBaliseLien, stopIndex);
                    lien = "<li>" + str.substring(startIndex,stopIndex)+ "</li>" + "\\n";
                    contentBuilder.append(lien);
                }while(str.lastIndexOf(startBaliseLien) != startIndex);
            }
            in.close();
        } catch (IOException e){
        }
        finally {
            contentBuilder.append("</ul>");
            String content = contentBuilder.toString();
            return content;
        }

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
