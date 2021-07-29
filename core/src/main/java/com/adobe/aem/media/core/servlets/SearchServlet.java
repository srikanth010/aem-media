package com.adobe.aem.media.core.servlets;

import com.adobe.aem.media.core.services.search.SearchService;
import com.google.gson.Gson;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.result.SearchResult;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=post",
                "sling.servlet.paths=/bin/search"
        })
public class SearchServlet extends SlingSafeMethodsServlet {

    @Reference
    SearchService searchService;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {

        try {
           SearchResult result= searchService.getSearchResult("media",request.getResourceResolver());
            Iterator<Resource> resource = result.getResources();
            HashMap<String,String> hmap=new HashMap<>();
            Gson gson = new Gson();
            while(resource.hasNext()) {
                Resource next = resource.next();
                //next.getName()+"*"+next.getPath();

                hmap.put(next.getName(), next.getPath());

            }
            String json = gson.toJson(hmap);
            response.getWriter().println(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
