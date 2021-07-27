package com.adobe.aem.media.core.models.product;

import com.adobe.aem.media.core.services.product.ProductService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ProductGrid {

    @Reference
    private ResourceResolverFactory resourceResolverFactory;

    @Reference
    private ResourceResolver resourceResolver;

    @ValueMapValue
    private String productPath;

    @ValueMapValue
    private String productTitle;

    @ValueMapValue
    private String productDescription;

    @ValueMapValue
    private String productImage;

    @ValueMapValue
    private String productCtaLabel;

    @ValueMapValue
    private String productCtaLink;

    @ValueMapValue
    private String productPrice;

    @Inject
    private ProductService productService;

    @Inject
    private ValueMap properties;

    @PostConstruct
    public void init() throws LoginException {
        try {
            resourceResolver = productService.getResourceResolver();
            Resource res = resourceResolver.getResource(getProductPath() + "/jcr:content/root/container/container/product");
            properties = res.getValueMap();
            productTitle = properties.get("productTitle", String.class);
            productDescription = properties.get("productDescription", String.class);
            productImage = properties.get("productImage", String.class);
            productCtaLabel = properties.get("productCtaLabel", String.class);
            productCtaLink = properties.get("productCtaLink", String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductCtaLabel() {
        return productCtaLabel;
    }

    public String getProductCtaLink() {
        return productCtaLink;
    }

    public String getProductPrice(){
        return productPrice;
    }

    public String getProductPath() {
        return productPath;
    }

}