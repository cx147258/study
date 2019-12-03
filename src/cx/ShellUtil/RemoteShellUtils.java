package cx.ShellUtil;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

/**
 * 远程调用脚本工具类
 *
 * @author yuhao
 * @date 2018-08-07
 */
public class RemoteShellUtils {

    private Connection conn;
    private String ipAddr;
    private String charset = Charset.defaultCharset().toString();
    private String userName;
    private String password;

    public RemoteShellUtils(String ipAddr, String userName, String password, String charset) {
        this.ipAddr = ipAddr;
        this.userName = userName;
        this.password = password;
        if (charset != null) {
            this.charset = charset;
        }
    }

    public RemoteShellUtils(String ipAddr, String userName, String password) {
        this(ipAddr, userName, password, null);
    }

    /*
     * 远程登录
     */
    public boolean login() throws IOException {
        conn = new Connection(ipAddr);
        conn.connect(); // 连接
        return conn.authenticateWithPassword(userName, password); // 认证
    }

    /*
     * 执行命令 return 执行结果
     */
    public String exec(String cmds) {
        InputStream inStr = null;// 标准输出
        String result = "";
        Session session = null;
        try {
            if (this.login()) {
                session = conn.openSession(); // 打开一个会话
                session.execCommand(cmds); // 执行命令
                inStr = session.getStdout();
                result = this.processStdout(inStr, this.charset);

            } else {
                System.out.println("ssh远程登录失败，ip：" + ipAddr + "user:" + userName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
            conn.close();
        }
        return result;
    }

    private String processStdout(InputStream in, String charset) {

        byte[] buf = new byte[1024];
        StringBuffer sb = new StringBuffer();
        try {
            while (in.read(buf) != -1) {
                sb.append(new String(buf, charset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
