package hhz;

import java.io.OutputStream;
import java.io.PrintWriter;
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

        printWriter.close();
        outputStream.close();
        socket.close();
    }
}
