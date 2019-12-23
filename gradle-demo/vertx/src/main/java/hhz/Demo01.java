package hhz;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;

/**
 * @ClassName: Demo01
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 16:56
 */
public class Demo01 {
    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();
        HttpServer httpServer = vertx.createHttpServer();

        httpServer.requestHandler(request -> {
            request.response().end("hello");
        });
        httpServer.listen(8080);
    }
}
