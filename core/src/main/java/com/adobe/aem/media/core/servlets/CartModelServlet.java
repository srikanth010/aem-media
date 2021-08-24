package com.adobe.aem.media.core.servlets;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

import javax.servlet.Servlet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component(service = {Servlet.class},
        property = {
                "sling.servlet.methods=post",
                "sling.servlet.paths=/bin/cartmodel"
        })
public class CartModelServlet extends SlingSafeMethodsServlet {

    private static final long serialVersionUID = 1L;

    public void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws IOException {
        try {
            URL url = new URL("http://localhost:4504/content/media/us/en/home/jcr:content/root/container/container/container/productgrid.product.json");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Basic YWRtaW46YWRtaW4=");
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
                JSONObject jsonObject = new JSONObject(inputLine);
                String title = jsonObject.getString("productTitle");
                response.getWriter().write(title);
            }
            in.close();
            con.disconnect();

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }

    }

}
