package com.adobe.aem.media.core.models.banner;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = {SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = BannerModel.RESOURCE_TYPE
)
@Exporter(name = "jackson", selector = "banner", extensions = "json")
public class BannerModel {

    static final String RESOURCE_TYPE = "media/components/banner";

    @ValueMapValue
    private String bannerImage;

    @ValueMapValue
    private String bannerHeading;

    @ValueMapValue
    private String bannerDescription;

    @ValueMapValue
    private String bannerCtaLabel;

    @ValueMapValue
    private String bannerCtaLink;

    @ValueMapValue
    private String linkColor;

    public static String getResourceType() {
        return RESOURCE_TYPE;
    }

    public String getBannerImage() {
        return bannerImage;
    }

    public String getBannerHeading() {
        return bannerHeading;
    }

    public String getBannerDescription() {
        return bannerDescription;
    }

    public String getBannerCtaLabel() {
        return bannerCtaLabel;
    }

    public String getBannerCtaLink() {
        return bannerCtaLink;
    }

    public String getLinkColor(){ return linkColor;}
}
