package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {
	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest)req;

		System.out.println(request.getHeader("Referer"));
	    chain.doFilter(req, res);

	}

	@Override
	public void init(FilterConfig config) throws ServletException {
//		this.encoding = config.getInitParameter("encoding");

	}

}
