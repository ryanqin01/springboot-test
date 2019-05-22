package cn.ryan.springboot.gateway.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ZuulLoggingFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("request -> {} request uri -> {}", request, request.getRequestURI());
		if (request.getContentLength() < 1) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(HttpStatus.SC_BAD_REQUEST);
			try {
				ctx.getResponse().getWriter().write("bad request");
			} catch (IOException e) {
			}
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
