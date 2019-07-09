package MyFile;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args)throws Exception{
        //
        String host = "127.0.0.1";
        int port = 55533;

        //与服务端建立连接
        Socket socket = new Socket(host,port);

        //建立连接后获得输出流
        OutputStream outputStream = socket.getOutputStream();
        String message = "111111111111111111";//要发送给服务器的消息
        outputStream.write(message.getBytes("UTF-8"));
        //通过shutdownOutput高速服务器已经发送完数据，后续只能接受数据
        socket.shutdownOutput();

        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while((len = inputStream.read(bytes)) != -1){
            sb.append(new String(bytes,0,len,"UTF-8"));
        }
        System.out.println("get server message "+sb);

        inputStream.close();
        outputStream.close();
        socket.close();
    }
}
