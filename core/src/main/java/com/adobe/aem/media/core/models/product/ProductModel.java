package com.adobe.aem.media.core.models.product;


import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = ProductModel.RESOURCE_TYPE
)
@Exporter(name = "jackson", selector = "product", extensions = "json")
public class ProductModel {

    static final String RESOURCE_TYPE = "media/components/product";



    @ValueMapValue
    private String productType;

    @ValueMapValue
    private String productTitle;

    @ValueMapValue
    private String productDescription;

    @ValueMapValue
    private String productHelp;

    @ValueMapValue
    private String productCtaLabel;

    @ValueMapValue
    private String productCtaLink;

    @ValueMapValue
    private boolean enableColor;

    @ValueMapValue
    private boolean enableSize;

    @ValueMapValue
    private int productPrice;

    @ChildResource
    private List<ProductDetails> productDetail;


    public static String getResourceType() {
        return RESOURCE_TYPE;
    }


    public String getProductType() {
        return productType;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getProductHelp() {
        return productHelp;
    }

    public String getProductCtaLabel() {
        return productCtaLabel;
    }

    public String getProductCtaLink() {
        return productCtaLink;
    }

    public boolean isEnableColor() {
        return enableColor;
    }

    public boolean isEnableSize() {
        return enableSize;
    }

    public  int getProductPrice(){
        return productPrice;
    }

    public List<ProductDetails> getProductDetail() {
        return productDetail;
    }
}
