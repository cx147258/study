package cx.IOTest;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import java.io.*;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;

public class TestZip {

    static String filePath = "D:\\cx.test";//需要压缩的文件夹的完整的路径
    static String fileName = "cx/test";//需要压缩的文件夹名
    static String outPath = "D:\\cx.test.zip";//压缩完后保存的文件名

    public static void main(String[] args) throws IOException{
        OutputStream is = new FileOutputStream(outPath);//创建test.zip文件
        CheckedOutputStream cos = new CheckedOutputStream(is,new CRC32());//检查输出流，采用CRC32算法，保证文件的一致性
        ZipOutputStream zos = new ZipOutputStream(cos);//创建zip文件的输出流
        zos.setEncoding("GBK");//设置编码，防止中文乱码
        File file = new File(filePath);//需要压缩的文件或文件夹对象
        ZipFile(zos,file);
        zos.close();
        cos.close();
        is.close();
        System.out.println("压缩完成");
    }

    //递归，需要获取要压缩的文件夹在所有的子文件夹，然后创建对应目录与文件，对文件进行压缩
    private static void ZipFile(ZipOutputStream zos, File file) throws IOException {
        if(file.isDirectory()) {
            //创建压缩文件的目录结构
            zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf(fileName))+File.separator));
            for(File f : file.listFiles()){
                ZipFile(zos,f);
            }
        }
        else{
            //打印正在压缩的文件
            System.out.println("正在压缩的文件 + "+file.getName());
            //创建压缩文件
            zos.putNextEntry(new ZipEntry(file.getPath().substring(file.getPath().indexOf(fileName))));
            //字节方式读取源文件
            InputStream is = new FileInputStream(file.getPath());
            //创建一个缓冲区
            BufferedInputStream bis = new BufferedInputStream(is);
            //字节数组，每次读取1024字节
            byte[] b = new byte[1024];
            //循环读取，边读边写
            while(bis.read(b) != -1){
                zos.write(b);//写入压缩文件
            }
            //关闭流
            bis.close();
            is.close();
        }
    }
}
