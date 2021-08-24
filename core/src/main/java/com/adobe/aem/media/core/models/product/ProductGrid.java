package com.adobe.aem.media.core.models.product;

import com.adobe.aem.media.core.services.product.ProductService;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.*;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.osgi.service.component.annotations.Reference;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

@Model(adaptables = {SlingHttpServletRequest.class, Resource.class}, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = ProductGrid.RESOURCE_TYPE
                )
@Exporter(name = "jackson", selector = "product", extensions = "json")
public class ProductGrid {

    static final String RESOURCE_TYPE = "media/components/productgrid";

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

    @ValueMapValue
    private String parentPath;

    @ValueMapValue
    private String gridImage;

    @Inject
    private ProductService productService;

    @Inject
    private ValueMap properties;

    @PostConstruct
    public void init() throws LoginException, RepositoryException {
        try {
            resourceResolver = productService.getResourceResolver();
            Resource res = resourceResolver.getResource(getProductPath() + "/jcr:content/root/container/container/product");
            properties = res.getValueMap();
            productTitle = properties.get("productTitle", String.class);
            int maxLength = 167;
            String productDescriptionString = properties.get("productDescription", String.class);
            if (productDescriptionString.length() > maxLength) {
                productDescription = productDescriptionString.substring(0,maxLength);
            }else
            productDescription = properties.get("productDescription", String.class);
            productCtaLabel = properties.get("productCtaLabel", String.class);
            productCtaLink = properties.get("productCtaLink", String.class);
            Node node = res.adaptTo(Node.class);
            NodeIterator nodeItr = node.getNodes();
            while(nodeItr.hasNext())
            {
                Node cNode = nodeItr.nextNode();
                NodeIterator nodeItr1 = cNode.getNodes();
                Node cNode1 = nodeItr1.nextNode();
                productImage = cNode1.getProperty("productImage").getValue().getString();
            }
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

    public String getParentPath() {
        return parentPath;
    }

    public String getGridImage(){
        return gridImage;
    }
}