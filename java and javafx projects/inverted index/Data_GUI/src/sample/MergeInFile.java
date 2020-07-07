package sample;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

import java.io.*;

public class MergeInFile {

   private int numberOfFiles;

    public MergeInFile(int numberOfFiles , ProgressBar progressBar) throws IOException {
        this.numberOfFiles = numberOfFiles;
        try {
            PrintWriter out = new PrintWriter("F:\\data\\wholeDocuments.txt");
            for(int i=0 ; i<this.numberOfFiles ; i++){
                File file = new File("F:\\data\\questions\\"+i+".txt");
                BufferedReader reader = new BufferedReader(new FileReader(file));
                out.println(reader.readLine());
                System.out.println(i+": "+reader.readLine());
                progressBar.setProgress((float)i/100_000);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mergeInFile(String path){
        try{
            File file = new File(path);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            PrintWriter out = new PrintWriter(new FileWriter("F:\\data\\wholeDocuments.txt",true));
            out.append(reader.readLine());
            out.close();
            this.numberOfFiles++;
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public int getNumberOfFiles() {
        return numberOfFiles;
    }
}
