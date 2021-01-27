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

    public void write(List<String[]> csv,File f, String separator) {
        try{
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));

            for (int i = 0; i < csv.size(); i++) {
                for (int j = 0; j < csv.get(i).length; j++){
                    writer.write(csv.get(i)[j]);
                    if (j < csv.get(i).length - 1) {
                        writer.write(separator);
                    }
                }
                writer.newLine();
            }
            writer.close();
        } catch (Exception er) {
            System.out.println(er.getMessage());
        }
    }

}
