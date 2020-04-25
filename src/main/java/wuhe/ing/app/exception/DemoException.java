package wuhe.ing.app.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import wuhe.ing.app.bean.JSONResult;

@ControllerAdvice
public class DemoException {
	
	public static final String IMOOC_ERROR_VIEW = "error";
	
	@ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, 
    		HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
    	if (isAjax(reqest)) {
    		return JSONResult.errorException(e.getMessage());
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
            return mav;
    	}
    }
	
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest"
						.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}

}
