package Files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) {
        FileIO test=new FileIO();
        try{
            test.replace("in.txt", "out.txt");
        }catch(Exception ex){
            System.out.println("Что то пошло не так: "+ex.getMessage());
        }
    }

    void replace(String fileIn,String fileOut) throws FileNotFoundException {
        File in=new File(fileIn);
        File out=new File(fileOut);
        Scanner sc=new Scanner(in);
        PrintWriter pw=new PrintWriter(out);
        while(sc.hasNext()){
            String word=sc.next();
            if(word.equals("School"))
                word="Школа";
            pw.print(word+" ");
        }
        sc.close();
        pw.close();
    }
}
