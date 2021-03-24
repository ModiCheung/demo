package com.jwt.demo.design.cor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

public class ServletFilterChainDemo {

	@Data
	@AllArgsConstructor
	public static class Request {
		private String context;
	}
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Response {
		private String context;
	}

	public interface Filter {
		void doFilter(Request request, Response response, Filter filter);
	}
	public static class AuthenticationFilter implements Filter {

		@Override
		public void doFilter(Request request, Response response, Filter filter) {
			System.out.println("登录认证Filter");
			filter.doFilter(request, response, filter);
		}
	}
	public static class AuthorizationFilter implements Filter {

		@Override
		public void doFilter(Request request, Response response, Filter filter) {
			System.out.println("权限校验Filter");
			filter.doFilter(request, response, filter);
		}
	}

	@Data
	public static class FilterChain implements Filter {

		private List<Filter> filters = new ArrayList<>();
		private int index;

		public FilterChain addFilter(Filter filter) {
			filters.add(filter);
			return this;
		}

		@Override
		public void doFilter(Request request, Response response, Filter filter) {
			if (index == filters.size()) {
				return;
			}
			Filter f = filters.get(index);
			index++;
			f.doFilter(request, response, filter);
		}
	}

	public static void main(String[] args) {
		Request request = new Request("正文部分");

		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		AuthorizationFilter authorizationFilter = new AuthorizationFilter();
		FilterChain filterChain = new FilterChain();
		filterChain.addFilter(authenticationFilter);
		filterChain.addFilter(authorizationFilter);

		filterChain.doFilter(request, new Response(), filterChain);
	}


}
