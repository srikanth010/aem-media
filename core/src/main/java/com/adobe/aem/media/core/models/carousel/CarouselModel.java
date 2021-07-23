package com.adobe.aem.media.core.models.carousel;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(adaptables = {SlingHttpServletRequest.class}, adapters = CarouselModel.class, resourceType = CarouselModel.RESOURCE_TYPE)
public class CarouselModel {

    static final String RESOURCE_TYPE = "media/components/carousel";

    @ChildResource
    private List<CarouselItemModel>carouselLinkItems;

    public static String getResourceType() {
        return RESOURCE_TYPE;
    }

    public List<CarouselItemModel> getCarouselLinkItems() {
        return carouselLinkItems;
    }
}
