package com.adobe.aem.media.core.models.header;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name="jackson", selector = "srikanth", extensions = "json")
public class HeaderMenuModel {

    @ValueMapValue
    @Optional
    private  String navSubMenuImage;

    @ValueMapValue
    @Optional
    private String navSubMenuImageAlt;

    @ValueMapValue
    @Optional
    private String navSubMenuTitle;

    @ValueMapValue
    @Optional
    private String navSubMenuDescription;

    @ValueMapValue
    @Optional
    private String navSubMenuLink;

    @ValueMapValue
    @Optional
    private Boolean navSubMenuNewTab;

    @ValueMapValue
    @Optional
    private String navSubMenuLinkTitle;

    public String getNavSubMenuImage() {
        return navSubMenuImage;
    }

    public String getNavSubMenuImageAlt() {
        return navSubMenuImageAlt;
    }

    public String getNavSubMenuTitle() {
        return navSubMenuTitle;
    }

    public String getNavSubMenuDescription() {
        return navSubMenuDescription;
    }

    public String getNavSubMenuLink() {
        return navSubMenuLink;
    }

    public Boolean getNavSubMenuNewTab() {
        return navSubMenuNewTab;
    }

    public String getNavSubMenuLinkTitle() {
        return navSubMenuLinkTitle;
    }
}
