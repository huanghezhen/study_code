package hhz;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * @ClassName: Demo02
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 17:05
 */
public class Demo04 {
    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();

        Router router = Router.router(vertx);

        router.get("/sync").handler(context -> {
            // 同步
            context.response().end("hello /sync");

            System.out.println("sync:"+ Thread.currentThread().getName());
        });
        router.get("/async").blockingHandler(context -> {
            // 异步
            context.response().end("hello /async");

            System.out.println("async:"+ Thread.currentThread().getName());
        });

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept);
        server.listen(8080);
    }
}
