package org.example.test.filter;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SpecialCharacterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 필터 초기화
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String requestURI = httpRequest.getRequestURI();
        String queryString = httpRequest.getQueryString();

        if (containsSpecialCharacters(requestURI) || (queryString != null && containsSpecialCharacters(queryString))) {
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "URL contains illegal characters");
            return;
        }

        chain.doFilter(request, response);
    }

    private boolean containsSpecialCharacters(String value) {
        // 허용된 문자: ? & = : //
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._~:/?&=+#";
        for (char c : value.toCharArray()) {
            if (allowedCharacters.indexOf(c) == -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {
        // 필터 종료
    }
}
