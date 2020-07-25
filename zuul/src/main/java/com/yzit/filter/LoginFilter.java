package com.yzit.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginFilter extends ZuulFilter {

    /**
     * 返回字符串，代表过滤器的类型。包含以下4种：
     *   pre：请求在被路由之前执行
     *   routing：在路由请求时调用
     *   post：在routing和error过滤器之后调用
     *   error：处理请求时发生错误调用
     * @return
     */
    @Override
    public String filterType() {
        // 登录校验，在最前边拦截
        return "pre";
    }

    /**
     * 通过返回的int值来定义过滤器的执行顺序，数字越小优先级越高。
     * @return
     */
    @Override
    public int filterOrder() {
        // 返回顺序1
        return 0;
    }

    /**
     * 返回一个Boolean值，判断该过滤器是否需要执行。返回true执行，返回false不执行。
     * @return
     */
    @Override
    public boolean shouldFilter() {
        // 返回true代表过滤器生效
        return true;
    }

    /**
     * 过滤器的具体业务逻辑。
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        // 登录校验
        // 1、获取Zuul提供的，当前的请求上下文
        RequestContext currentContext = RequestContext.getCurrentContext();
        // 2、从上下文中获取request对象
        HttpServletRequest req = currentContext.getRequest();
        // 3、从request中获取到session 这里写死了，只是做个demo，登录的时候看是否包含access-token
        String token = req.getParameter("access-token");
        // 4、判断
        if(token == null || "".equals(token.trim())){
            // 没有token，登录校验失败，拦截
            currentContext.setSendZuulResponse(false);

            //  返回401状态码。也可以考虑重定向到登录页。
            currentContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            currentContext.getResponse().setContentType("text/html; charset = utf-8");
            currentContext.setResponseBody("请登录后在访问");
        }

        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        // 返回null是正常，向下继续执行
        return null;
    }
}
