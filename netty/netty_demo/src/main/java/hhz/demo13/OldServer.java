package hhz.demo13;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: OldServer
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/10 上午 09:37
 */
public class OldServer
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(8899);
        while (true)
        {
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            byte[] byteArray = new byte[4096];
            while (true)
            {
                int readCount = dataInputStream.read(byteArray);
                if (-1 == readCount)
                {
                    break;
                }
            }
        }
    }
}
