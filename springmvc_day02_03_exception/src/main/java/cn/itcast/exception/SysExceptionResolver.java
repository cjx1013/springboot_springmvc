package cn.itcast.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    //处理异常业务逻辑
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException) e;
        }else{
            ex = new SysException("系统维护中……");
        }
//        创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg", ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}
