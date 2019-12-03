package cx.IOTest;

import java.io.*;

public class CopyLines {
    public static void main(String[] args) throws IOException{
        BufferedReader inputStrem = null;
        PrintWriter outputStrem = null;

        try{
            inputStrem = new BufferedReader(new FileReader("D:\\IdeaProjects\\study\\src\\cx.IOTest\\in"));
            outputStrem = new PrintWriter(new FileWriter("D:\\IdeaProjects\\study\\src\\cx.IOTest\\out"));

            String l;
            outputStrem.close();
            while((l = inputStrem.readLine()) != null){
                outputStrem.println(l);
            }
        } finally {
            if(inputStrem != null){
                inputStrem.close();
            }
            if(outputStrem != null){
            }
        }
    }
}
