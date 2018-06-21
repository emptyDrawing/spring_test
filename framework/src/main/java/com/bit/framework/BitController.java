package com.bit.framework;

import javax.servlet.http.HttpServletRequest;

public interface BitController {

	String execute(HttpServletRequest req);
	
}
