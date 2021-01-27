package Example.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileAccount {

    public List<String[]> read(String FileName) {
        File filename = new File(FileName);
        List<String[]> odczyt = new ArrayList<>();
        try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
                String line;
                while ((line = rd.readLine()) != null){
                    odczyt.add(line.split(";"));
                }
                rd.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return odczyt;
    }
}
