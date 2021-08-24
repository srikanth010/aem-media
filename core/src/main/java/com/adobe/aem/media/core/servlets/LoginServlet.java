package com.adobe.aem.media.core.servlets;

import com.adobe.aem.media.core.services.LoginDao;
import com.adobe.aem.media.core.services.People;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=post",
                "sling.servlet.paths=/bin/loginConnection"
        })
public class LoginServlet extends SlingAllMethodsServlet {
    private static final long serialVersionUID = 1L;

    private Logger logger = LoggerFactory.getLogger(LoginServlet.class);

    private String HOME_PAGE="/content/media/us/en/home.html";
    private String ERROR_PAGE="/content/media/us/en/errors/404.html";

    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(final SlingHttpServletRequest request,
                         final SlingHttpServletResponse response) throws ServletException, IOException {
        logger.info("Inside the doGet method of the SlingSafeMethodsServlet type servlet");
        try {
            PrintWriter out = response.getWriter();
            out.println("Read only servlet got executed!!!");
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
    }

    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        People people = new People();
        LoginDao dao = new LoginDao();
        people.setEmail(email);
        people.setPassword(password);

        if (dao.vaildate(people)) {
            PrintWriter out = response.getWriter();
            response.sendRedirect(HOME_PAGE);
            out.println("Successfully Redirected ");
        } else {
            response.sendRedirect(ERROR_PAGE);
            PrintWriter out = response.getWriter();
            out.println("Successfully Else Condition ");
        }
        PrintWriter out = response.getWriter();
        out.println("Nothing Done");
    }
}
