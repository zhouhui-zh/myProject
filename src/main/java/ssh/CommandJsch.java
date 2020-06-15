package ssh;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.InputStream;

public class CommandJsch {

    static String ip = "172.18.48.55";
    static int port = 22;
    static String username = "root";
    static String password = "root";

    public static void main(String[] args) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();

        String command = "uname -a";

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, ip, port);
        System.out.println(session);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect(60 * 1000);
        Channel channel = session.openChannel("exec");
        ((ChannelExec) channel).setCommand(command);

        channel.setInputStream(null);

        ((ChannelExec) channel).setErrStream(System.err);
        InputStream in = channel.getInputStream();

        channel.connect();

        byte[] tmp = new byte[1024];
        while (true) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) break;
                System.out.print(new String(tmp, 0, i));
            }
            if (channel.isClosed()) {
                if (in.available() > 0) continue;
                System.out.println("exit-status: " + channel.getExitStatus());
                break;
            }
            try {
                Thread.sleep(1000);
            } catch (Exception ee) {
            }
        }
        channel.disconnect();
        session.disconnect();

        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("Jsch方式" + (currentTimeMillis1 - currentTimeMillis));
    }
}
