package com.adobe.aem.media.core.servlets;

import com.adobe.aem.media.core.services.People;
import com.adobe.aem.media.core.services.PeopleService;
import com.adobe.fd.fp.util.DataBaseService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Repository;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=post",
                "sling.servlet.paths=/bin/dataConnection"
        })
public class DataSourceServlet extends SlingAllMethodsServlet {

    private static final long serialVersionUID = 1L;

    private PeopleService peopleService;
    private Logger logger = LoggerFactory.getLogger(DataBaseService.class);
    @Reference
    private Repository repository;

    public void init() {
        peopleService = new PeopleService();
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
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
            throws ServletException, IOException {
        int birth_year = Integer.valueOf(request.getParameter("birth_year"));
        String first_name = request.getParameter("first_name");
        String last_name = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phone= request.getParameter("phone");
        String password = request.getParameter("password");

        People people = new People();
        people.setBirth_year(birth_year);
        people.setFirst_name(first_name);
        people.setLast_name(last_name);
        people.setEmail(email);
        people.setPhone(phone);
        people.setPassword(password);

        try {
            peopleService.registerPeople(people);
            PrintWriter out = response.getWriter();
            out.println("Successfully Inserted "
                    + people.getFirst_name()+ " "+ people.getLast_name() + " "+ people.getBirth_year());
        } catch (Exception e) {
            logger.info("Error occured while establishing the connection ::{}", e);

        }
    }
}