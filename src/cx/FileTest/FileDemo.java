package cx.FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileDemo {

    /**
     * 创建与删除文件
     */
    public static void creatFile(){

        File file = new File("cx/test");

        if(file.exists()){
            file.delete();
            System.out.println("删除文件test");
        }else{
            try{
                file.createNewFile();
                System.out.println("创建文件test");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取文件信息
     */
    public static void getFileMessage(){

        File file = new File("cx/test");
        if(file.exists()){

            String name = file.getName();
            System.out.println("文件的名字："+name);

            long length = file.length();
            System.out.println("文件的长度："+length);

            boolean hidden = file.isHidden();
            System.out.println("文件是否为隐藏文件："+hidden);
        }else{
            System.out.println("文件不存在");
        }
    }

    /**
     * 文件读写
     */
    public static void readAndWrite(){

        File file = new File("cx/test");

        try{
            FileOutputStream out = new FileOutputStream(file);
            byte byt[] = "HHHHHHHHHHHHHHHHHHHHHHHHH".getBytes();
            out.write(byt);
            out.close();

        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1025];
            in.read(byt);
            System.out.println(new String(byt));
            in.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 创建文件目录
     */
    public static void creatDirs(){
        /**
         * public boolean mkdir()
         *
         * 　　创建目录，成功返回true。只能创建一个文件夹，要求所有的父目录都存在，否则创建失败。
         *
         * 　　public boolean mkdirs()
         *
         * 　　创建目录，成功返回true，会创建所有不存在的父目录。(注意即便最后创建失败，但是也可能创建了一些中间目录)。
         *
         * 　　上面两个方法如果要创建的目录已经存在，不再重新创建，都返回false，只有新建目录返回true。
         */
    }

    public static void main(String[] args) {

        File file = new File("D:\\cx.test.txt");
        System.out.println(file.exists());

    }


}
