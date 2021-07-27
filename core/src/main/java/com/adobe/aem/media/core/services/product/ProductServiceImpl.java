package com.adobe.aem.media.core.services.product;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Anirudh Sharma
 * <p>
 * This service is responsible for returning an instance of ResourceResolver
 */
@Component(
        service = ProductService.class,
        property = {
                Constants.SERVICE_ID + "= AEM Tutorial Resource Resolver Service",
                Constants.SERVICE_DESCRIPTION + "= This service is responsible for returning an instance of ResourceResolver"
        })
public class ProductServiceImpl implements ProductService {

    private static final String TAG = ProductServiceImpl.class.getSimpleName();
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Reference
    ResourceResolverFactory resourceResolverFactory;

    private ResourceResolver resourceResolver;

    @Activate
    protected void activate() {
        try {
            // Service User map
            Map<String, Object> serviceUserMap = new HashMap<>();
            // Putting sub-service name in the map
            serviceUserMap.put(ResourceResolverFactory.SUBSERVICE, "resourceAccess");
            // Get the instance of Service Resource Resolver
            resourceResolver = resourceResolverFactory.getServiceResourceResolver(serviceUserMap);
        } catch (LoginException e) {
            LOGGER.error("{}: Exception occurred while getting resource resolver: {}", TAG, e.getMessage());
        }
    }

    @Override
    public ResourceResolver getResourceResolver() {
        return resourceResolver;
    }
}