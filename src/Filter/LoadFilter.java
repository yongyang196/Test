package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoadFilter")
public class LoadFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        chain.doFilter(req, resp);
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;
        HttpSession session=request.getSession();
        String username= (String) session.getAttribute("username");
        if (username==null){
            response.sendRedirect("load.jsp");
        }
        else {
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
