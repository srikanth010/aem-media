package com.adobe.aem.media.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.jcr.Node;
import javax.servlet.Servlet;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=post",
                "sling.servlet.paths=/bin/resource"
        })
public class ResourceResolverServlet extends SlingSafeMethodsServlet {

    @Reference
    private transient ResourceResolverFactory resourceResolverFactory;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            Map<String, Object> serviceUserMap = new HashMap<>();
            // Putting sub-service name in the map
            serviceUserMap.put(ResourceResolverFactory.SUBSERVICE, "resourceAccess");
            ResourceResolver resourceResolver = resourceResolverFactory.getServiceResourceResolver(serviceUserMap);
            Resource res = resourceResolver.getResource("/content/media/us/en/products/men/coat-1/jcr:content/root/container/container/product");
            ValueMapValue properties = (ValueMapValue) res.adaptTo(Resource.class);
            String path = res.getValueMap().get("productDescription",String.class);
            response.getWriter().write(path);
        } catch (LoginException e) {
            e.printStackTrace();
            response.getWriter().write(e.getMessage());
        }
    }
}