package IOTest;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //要被压缩的文件夹
        File file = new File("d:"+File.separator+"test");
        //压缩后的文件夹
        File zipFile = new File("d:\\testzip\\testzip2\\testzip3"+File.separator+"zipFile.zip");
        InputStream input = null;

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
        zipOut.setComment("hello");
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                input = new FileInputStream(files[i]);
                zipOut.putNextEntry(new ZipEntry(file.getName()+File.separator+files[i].getName()));
                int temp = 0;
                while((temp = input.read())!=-1){
                    zipOut.write(temp);
                }
                input.close();
            }
        }
        zipOut.close();
    }
}
