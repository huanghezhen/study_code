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
public class Demo03 {
    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();

        Router router = Router.router(vertx);

        router.get("/get").handler(context -> {
            //context.request();
            context.response().end("hello /get");
        });

        router.post("/post").handler(context -> {
            //context.request();
            context.response().end("hello /post");
        });

        router.get("/get/*").handler(context -> {
            //context.request();
            context.response().end("hello /get/*");
        });

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept);
        server.listen(8080);
    }
}
