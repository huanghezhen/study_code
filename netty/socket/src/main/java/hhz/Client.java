package hhz;

import java.io.*;
import java.net.Socket;

/**
 * @ClassName: client
 * @Description: TODO(概况)
 * @author: huanghz
 * @date: 2019/9/11 上午 09:33
 */
public class Client
{
    public static void main(String[] args)throws Exception
    {
        Socket socket = new Socket("127.0.0.1", 8899);
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream);
        printWriter.write("hhhhhh");
        printWriter.flush();
        socket.shutdownOutput();


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
        printWriter.close();
        outputStream.close();
        socket.close();
    }
}
