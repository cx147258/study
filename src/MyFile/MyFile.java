package MyFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;

public class MyFile {
    public static void main(String[] args) throws IOException {
        //fileOutputStreamTest();
        //fileCreateAndDelete();
        //traverse(new File("D:\\tomcat_8"));
        traverseBSP(new File("D:\\study"));

    }

    /**
     * 文件的创建与删除
     */
    public static void fileCreateAndDelete() throws IOException {
        File file1 = new File("d:/study/myfile1.txt");
        file1.createNewFile();
        File file2 = new File("d:/study/","myfile2.txt");
        file2.createNewFile();
        File file3 = new File("d:/study/");
        File file4 = new File(file3,"myfile4.txt");
        file4.createNewFile();
        file2.delete();

        if(!file1.exists()){
            try{
                file1.createNewFile();
                System.out.println("文件以创建");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        else{
            file1.getAbsolutePath();
            System.out.println(file1.getAbsolutePath());
            file1.delete();
            System.out.println("文件以删除");
        }
    }

    /**
     *  文件输入输出
     *  FileInputStream（String name）
     *  FileInputStream（File file）
     */
    /**
     * 1.Java的字节流
     *   InputStream是所有字节输入流的祖先，而OutputStream是所有字节输出流的祖先。
     * 2.Java的字符流
     *   Reader是所有读取字符串输入流的祖先，而writer是所有输出字符串的祖先。
     *   InputStream，OutputStream,Reader,Writer都是抽象类。所以不能直接new
     */
    public static void fileOutputStreamTest(){
        File file = new File("d:/study/test5.txt");
        try{
            FileOutputStream out = new FileOutputStream(file);//创建FileOutoutStrem对象
            byte[] b = "hello world".getBytes();//创建byte数组，把字符串变成字节数组
            out.write(b);//流实例对象以字节流的方式把字节写入文件
            out.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }
        try{
            FileInputStream in = new FileInputStream(file);//创建写入流，把file中的内容写出来
            byte b[] = new byte[1024];
//            int len = in.read(b);
//            System.out.println(new String(b,0,len));
            in.read(b);//file中的内容读到数组b中
            String str = new String(b);
            System.out.println(str);
            in.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  文件夹的删除：删除文件夹时，必须保证文件夹为空
     */
    public static void deleteFiles(String path){
        File file = new File(path);
        if(!file.exists()){
            return;
        }
        if(file.isFile()){
            file.delete();
        }
        else if(file.isDirectory()){
            File[] files = file.listFiles();//返回目录下的文件和目录数组，返回的是绝对路径
            for(File myfile:files){
                deleteFiles(myfile.getAbsolutePath());
            }
            file.delete();
        }
    }


    /**
     *  遍历目录及文件
     *  1.回溯法
     *  2.广度优先遍历
     */

    //回溯法
    private static void traverse(File file){
        File files[] = file.listFiles();
        if(files == null || files.length == 0){
            return;
        }
        for(File f :files){
            if(f.isDirectory()){
                System.out.println("dir:"+f.getName());
                traverse(f);//递归遍历文件夹
            }
            else{
                System.out.println("file:"+f.getName());
            }
        }
    }

    //广度优先遍历
    private static void traverseBSP(File file){
        Queue<File> q = new LinkedList<File>();
        if(file != null){
            q.add(file);
        }
        while(!q.isEmpty()){
            System.out.println(q.peek().getName());
            File files[] = q.poll().listFiles();
            if(files == null || files.length == 0){
                continue;
            }
            //将目录下的一层全部加入队列
            for(File f :files){
                q.add(f);
            }
        }
    }

    /**
     *  File类中的重要方法
     *  File(String pathname)根据指定的路径创建文件，File并不会在系统的硬盘中创建一个不存在的文件
     *  creatNewFile()若目录或文件存在返回false，否则创建文件或文件夹，会创建一个不存在的文件
     *  delete()删除文件或文件夹
     *  isFile()判断是否是文件
     *  idDirectory()判断是否是目录
     *  mkdir()根据当前指定的对象创建目录，在给定的目录下创建文件，目录不存在，创建失败
     *  mkdirs()根据当前指定的对象创建目录，给定的目录不存在则将路径中所有目录一起创建
     *  length()文件长度
     *  listFiles()文件列表文件形式，返回File数组
     *  list()文件列表字符串形式，返回字符串数组
     *  rnameTo()文件或文件夹重命名
     */
}
