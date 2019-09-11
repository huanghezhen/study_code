package hhz;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: Server
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/11 上午 09:29
 */
public class Server
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket serverSocket = new ServerSocket(8899);
        System.out.println("服务已启动");
        Socket socket = serverSocket.accept();

        InputStream inputStream = socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String info = bufferedReader.readLine();
        while (info != null)
        {
            System.out.println(info);
            info = bufferedReader.readLine();
        }

        socket.shutdownInput();

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
