package com.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "AuthenticationFilter" , urlPatterns = {"/main"})
public class AuthenticationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);

        PrintWriter out=resp.getWriter();
        String password= req.getParameter("pass");

        if (password.equals("admin")){
            chain.doFilter(req,resp);
        }
        else {
            out.println("username or pass is incorrect");
            RequestDispatcher requestDispatcher=req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
