package com.adobe.aem.media.core.models.carousel;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name = "jackson", selector = "carousel", extensions = "json")
public class CarouselItemModel {

    @ValueMapValue
    private String image;

    @ValueMapValue
    private String caroselHeading;

    @ValueMapValue
    private String carouselDescription;

    @ValueMapValue
    private String ctaTextLabel;

    @ValueMapValue
    private String ctaLink;

    public String getImage() {
        return image;
    }

    public String getCaroselHeading() {
        return caroselHeading;
    }

    public String getCarouselDescription() {
        return carouselDescription;
    }

    public String getCtaTextLabel() {
        return ctaTextLabel;
    }

    public String getCtaLink() {
        return ctaLink;
    }
}
