package com.adobe.aem.media.core.models.header;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.util.List;

@Model(
        adaptables = Resource.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
@Exporter(name="jackson", selector = "srikanth", extensions = "json")
public class HeaderListModel {

    @ValueMapValue
    @Optional
    private String navText;

    @ValueMapValue
    @Optional
    private String navLink;

    @ValueMapValue
    @Optional
    private Boolean navNewTab;

    @ValueMapValue
    @Optional
    private String navLinkTitle;

    @ValueMapValue
    @Optional
    private String navLinkDescription;

    @ChildResource
    private List<HeaderMenuModel> subMenus;

    public String getNavText() {
        return navText;
    }

    public String getNavLink() {
        return navLink;
    }

    public Boolean getNavNewTab() {
        return navNewTab;
    }

    public String getNavLinkTitle() {
        return navLinkTitle;
    }

    public String getNavLinkDescription() {
        return navLinkDescription;
    }

    public List<HeaderMenuModel> getSubMenus() {
        return subMenus;
    }
}
