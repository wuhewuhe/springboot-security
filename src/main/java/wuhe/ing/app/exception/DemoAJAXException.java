package wuhe.ing.app.exception;

import javax.servlet.http.HttpServletRequest;

import wuhe.ing.app.bean.JSONResult;

public class DemoAJAXException {
	public JSONResult defaultErrorHandler(HttpServletRequest req, 
			Exception e) throws Exception {

		e.printStackTrace();
		return JSONResult.errorException(e.getMessage());
	}
}
