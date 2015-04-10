import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Emmanuel Beloin & Shaun Cooper
 * 09/04/15
 */

public class Extract {
    public static void main(String[] args) {
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
        final String startBaliseLien = "<a";
        final String finBaliseLien = "</a>";
        int numLigne = 0;
        String content = "";
        int startIndex = 0;
        int stopIndex = 0;
        StringBuilder contentBuilder = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String str;
            contentBuilder.append("<ul>");
            while ((str = reader.readLine()) != null) {
                numLigne++;
                if(str.indexOf(startBaliseLien, startIndex) != -1) {
                    do {
                        String lien = null;
                        startIndex = str.indexOf(startBaliseLien, startIndex);
                        stopIndex = str.indexOf(finBaliseLien, stopIndex);
                        while(stopIndex == -1)
                        {
                            str.substring(startIndex,str.length());
                            str = reader.readLine();
                            stopIndex = str.indexOf(finBaliseLien, stopIndex);
                            // str.substring(0,stopIndex + 4);
                        }
                        lien = "<li>" + str.substring(startIndex, stopIndex) + "</li>" + "\n";
                        startIndex = stopIndex +4;
                        stopIndex += 4;
                        contentBuilder.append(lien);
                        content += contentBuilder.toString();
                        contentBuilder.delete(0,contentBuilder.length());
                    } while (str.lastIndexOf(finBaliseLien) + 4 != stopIndex);
                    startIndex = 0;
                    stopIndex = 0;
                }
            }
            reader.close();
            contentBuilder.append("</ul>");
            content += contentBuilder.toString();

        } catch (IOException e){
        }
        return content;
    }
    static void monFileWriter(String text, String file)
    {
        BufferedWriter writer = null;
        try
        {
            writer = new BufferedWriter( new FileWriter(file));
            writer.write(text);

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
