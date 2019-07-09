package ShellUtil;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;


/**
 * jsch实现远程执行shell命令
 */
public class JschCommand {
    private Session session = null;
    private Channel channel = null;

    private String Host;
    private int Port = 22;
    private String UserName;
    private String Password;
    private int timeout = 30000;

    public JschCommand(String UserName, String Password, String Host) {
        this.UserName = UserName;
        this.Password = Password;
        this.Host = Host;
    }
    /**
     * 获取连接
     * @return
     */
    private ChannelExec getChannelExec() {
        try {
            if (channel != null && channel.isConnected()) {
                return (ChannelExec) channel;
            }
            JSch jSch = new JSch();
            if (session == null || !session.isConnected()) {
                session = jSch.getSession(UserName, Host, Port);
                session.setPassword(Password);
                Properties config = new Properties();
                config.put("StrictHostKeyChecking", "no");
                session.setConfig(config);
                session.setTimeout(timeout);
                session.connect();
            }
            channel = session.openChannel("exec");
        } catch (Exception e) {
            if (session != null) {
                session.disconnect();
                session = null;
            }
            channel = null;
        }
        return channel == null ? null : (ChannelExec) channel;
    }

    /**
     * 关闭连接
     */
    private void closeChannel() {
        try {
            if (channel != null) {
                channel.disconnect();
                channel = null;
            }
            if (session != null) {
                session.disconnect();
                session = null;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * 执行服务器端命令
     */
    public boolean executeCommand(String command) {
        boolean flag = false;
        ChannelExec channelExec = getChannelExec();
        if (channelExec == null) {
            return false;
        }
        try {
            channelExec.setInputStream(null);
            channelExec.setErrStream(System.err);
            channelExec.setCommand(command);

            InputStream in = channelExec.getInputStream();
            channelExec.connect();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
            closeChannel();

            flag = true;
        } catch (Exception e) {
            System.out.println(e);
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        JschCommand jschCommand = new JschCommand("esbtxd","esbtxd","14.1.78.191");

        System.out.println(jschCommand.executeCommand("pwd"));
        System.out.println("----------------------------------");
        System.out.println(jschCommand.executeCommand("ls -a"));
        System.out.println("----------------------------------");
        System.out.println(jschCommand.executeCommand("cd esb"));
        System.out.println(jschCommand.executeCommand("ls -a"));

        System.out.println("----------------------------------");
        System.out.println(jschCommand.executeCommand("pwd"));

//        System.out.println(jschCommand.executeCommand("ps -ef|grep  FILESEND"));
//        System.out.println("----------------------------------");
//        System.out.println(jschCommand.executeCommand("ps -ef|grep  FILERECV"));
//        System.out.println("----------------------------------");
//        System.out.println(jschCommand.executeCommand("ps -ef|grep  TCCBAPSV"));
        System.out.println("----------------------------------");
    }
}
