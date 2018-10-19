package com.md.common.intercept;

import ch.qos.logback.classic.Logger;
import com.md.service.impl.PcInfoServiceImpl;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * Created by zyc on 2018/10/16.
 * license 拦截器
 */
public class LicenseIntercept extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag = false;

        if (!flag) {
            if (!PcInfoServiceImpl.isLicense) {//未登录
                String servletPath = request.getServletPath();
                if (request.getHeader("x-requested-with") != null &&
                        request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){

                    response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
                    response.setCharacterEncoding("utf-8");
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().print("error");
                } else {
                    response.sendRedirect("/errora");
                }
                return false;
            } else {
            	/*User user = (User)obj;
            	if(!RightUtil.hasRight(currentURLTemp, request)){
            		if(!"iisAdminTmp".equals(user.getName()) && !"/index".equals(targetURL)){
            			//response.sendRedirect(request.getContextPath()+"/login/login");//应该返回到没有权限的页面
            			//request.getRequestDispatcher("/login/login").forward(request, response);
            			return false;
            		}
            	}*/
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

}
