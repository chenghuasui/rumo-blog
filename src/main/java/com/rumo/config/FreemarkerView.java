package com.rumo.config;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

public class FreemarkerView extends FreeMarkerView {

	@Override
	protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
		String base = RequestUtil.getBasePath(request);
		//如果你要给freemaker的模板定义一些常量可以在这里来
		model.put("basePath", base);
		super.exposeHelpers(model, request);
	}
}
