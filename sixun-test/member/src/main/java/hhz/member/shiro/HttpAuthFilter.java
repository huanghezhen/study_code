package hhz.member.shiro;

import org.apache.servicecomb.common.rest.filter.HttpServerFilter;
import org.apache.servicecomb.core.Const;
import org.apache.servicecomb.core.Invocation;
import org.apache.servicecomb.foundation.vertx.http.HttpServletRequestEx;
import org.apache.servicecomb.swagger.engine.SwaggerProducerOperation;
import org.apache.servicecomb.swagger.invocation.Response;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;


public class HttpAuthFilter implements HttpServerFilter {



    @Override
    public int getOrder() {
        return -10000;
    }

    @Override
    public Response afterReceiveRequest(Invocation invocation, HttpServletRequestEx httpServletRequestEx) {
        Subject subject = SecurityUtils.getSubject();

        SwaggerProducerOperation swaggerProducerOperation = invocation.getOperationMeta().getExtData(Const.PRODUCER_OPERATION);
        RequiresPermissions requiresPermissions = swaggerProducerOperation.getProducerMethod().getAnnotation(RequiresPermissions.class);
        if (requiresPermissions != null) {
            String[] permissions = requiresPermissions.value();
            try {
                subject.checkPermissions(permissions);
            } catch (AuthorizationException e) {
                System.out.println("Has no required roles!");  // 异常表示权限认证失败
                return Response.create(401, "Unauthorized", e.getMessage());
            }
        }
        return null;
    }
}
