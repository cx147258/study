package MyFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程
 */
public class SocketServer {
    public static void main(String[] args) throws Exception{
        //指定监听端口
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        //server等待连接
        System.out.println("等待连接..................");
        //创建线程池
        ExecutorService threadpool = Executors.newFixedThreadPool(100);

        while(true){
            Socket socket = server.accept();
            /**
             * 实现并启动线程有两种方法
             * 1、写一个类继承自Thread类，重写run方法。用start方法启动线程
             * 2、写一个类实现Runnable接口，实现run方法。用new Thread(Runnable target).start()方法来启动
             */
            Runnable runnable=()->{  //eg.() -> 5 不需要参数,返回值为 5
                try{
                    //建立连接后，从socket中获取输入流，并建立缓冲区进行读取
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    StringBuilder sb = new StringBuilder();
                    while((len = inputStream.read(bytes)) != -1){//read输入流中读取一定数量的字节，并将其存储在缓冲区数组bytes中,以整数形式返回实际读取的字节数
                        sb.append(new String(bytes, 0 , len,"UTF-8"));//bytes要解码为字符得到数组,0解码开始的位置，len解码结束的位置
                    }
                    System.out.println("get client message:"+sb);

                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("hello......".getBytes("UTF-8"));

                    inputStream.close();
                    outputStream.close();
                    socket.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            };
            threadpool.submit(runnable);//
            //server.close();
        }
    }
}

/**
 * 循环
 */
//public class SocketServer -{
//    public static void main(String[] args) throws Exception{
//        //指定监听端口
//        int port = 55533;
//        ServerSocket server = new ServerSocket(port);
//
//        //server等待连接
//        System.out.println("等待连接..................");
//        while(true){
//            Socket socket = server.accept();
//
//            //建立连接后，从socket中获取输入流，并建立缓冲区进行读取
//            InputStream inputStream = socket.getInputStream();
//            byte[] bytes = new byte[1024];
//            int len;
//            StringBuilder sb = new StringBuilder();
//            while((len = inputStream.read(bytes)) != -1){//read输入流中读取一定数量的字节，并将其存储在缓冲区数组bytes中,以整数形式返回实际读取的字节数
//                sb.append(new String(bytes, 0 , len,"UTF-8"));//bytes要解码为字符得到数组,0解码开始的位置，len解码结束的位置
//            }
//            System.out.println("get client message:"+sb);
//
//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write("hello......".getBytes("UTF-8"));
//
//            inputStream.close();
//            outputStream.close();
//            socket.close();
//            //server.close();
//        }
//    }
//}
