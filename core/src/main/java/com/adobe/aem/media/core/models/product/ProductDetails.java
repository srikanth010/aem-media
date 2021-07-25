package com.adobe.aem.media.core.models.product;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name="jackson", selector = "product", extensions = "json")
public class ProductDetails {

    @ValueMapValue
    private String productImage;

    @ValueMapValue
    private String productColor;


    public String getProductImage() {
        return productImage;
    }

    public String getProductColor() {
        return productColor;
    }
}
