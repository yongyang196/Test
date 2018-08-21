package File;

import java.io.*;

public class ReadFile {
    private String resultstr;
    public void readfile(File file){
        StringBuilder result=new StringBuilder();
        try {
            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
            BufferedReader br=new BufferedReader(read);
            String s=null;
            while ((s=br.readLine())!=null){
                result.append(System.lineSeparator()+s);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        resultstr= result.toString();
    }

    public String getResultstr() {
        return resultstr;
    }

    public void setResultstr(String resultstr) {
        this.resultstr = resultstr;
    }
}
