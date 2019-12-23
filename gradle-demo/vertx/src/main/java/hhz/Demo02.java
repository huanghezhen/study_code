package hhz;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerRequest;
import io.vertx.ext.web.Router;

/**
 * @ClassName: Demo02
 * @Description: TODO(概况)
 * @Author: huanghz
 * @Date: 2019/12/23 17:05
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        Vertx vertx = Vertx.vertx();

        Router router = Router.router(vertx);

        router.route("/").handler(context -> {
            //context.request();
            context.response().end("hello /");
        });

        router.route("/hello").handler(context -> {
            //context.request();
            HttpServerRequest request = context.request();
            String name = request.getParam("name");
            context.response().end("hello /hello "+name);
        });

        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router::accept);
        server.listen(8080);
    }
}
