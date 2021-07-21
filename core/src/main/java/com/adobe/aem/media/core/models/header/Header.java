package com.adobe.aem.media.core.models.header;

import com.day.cq.wcm.api.Page;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;

import java.util.List;

/* http://localhost:4504/content/macbook/us/en/demo/jcr:content/root/container/container/header.srikanth.json */

@Model(
        adaptables = {SlingHttpServletRequest.class},
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL,
        resourceType = Header.RESOURCE_TYPE
)
@Exporter(name="jackson", selector = "srikanth", extensions = "json")
public class Header {

    static final String RESOURCE_TYPE = "wknd/components/header";

    @ScriptVariable
    Page currentPage;

    @SlingObject
    ResourceResolver resourceResolver;

    @Self
    SlingHttpServletRequest slingHttpServletRequest;

    @RequestAttribute(name = "rattribute")
    private String reqAttribute;

    @ResourcePath(path = "/content/wknd/us/en/branding") @Via("resource")
    Resource resource;

    @ValueMapValue
    @Optional
    private String whiteLogo;

    @ValueMapValue
    @Optional
    private String logoLink;

    @ValueMapValue
    @Optional
    private String logoLinkTitle;

    @ValueMapValue
    @Optional
    private Boolean logoLinkNewTab;

    @ValueMapValue
    @Optional
    private String logInText;

    @ValueMapValue
    @Optional
    private String logInlink;

    @ValueMapValue
    @Optional
    private Boolean logInNewTab;

    @ValueMapValue
    @Optional
    private String logInlinkTitle;

    @ValueMapValue
    @Optional
    private String signUpText;

    @ValueMapValue
    @Optional
    private String signUplink;

    @ValueMapValue
    @Optional
    private Boolean signUpNewTab;

    @ValueMapValue
    @Optional
    private String signUplinkTitle;

    @ChildResource
    private List<HeaderListModel> headerLinks;


    public String getWhiteLogo() {
        return whiteLogo;
    }

    public String getLogoLink() {
        return logoLink;
    }

    public String getLogoLinkTitle() {
        return logoLinkTitle;
    }

    public Boolean getLogoLinkNewTab() {
        return logoLinkNewTab;
    }

    public String getLogInText() {
        return logInText;
    }

    public String getLogInlink() {
        return logInlink;
    }

    public Boolean getLogInNewTab() {
        return logInNewTab;
    }

    public String getLogInlinkTitle() {
        return logInlinkTitle;
    }

    public String getSignUpText() {
        return signUpText;
    }

    public String getSignUpLink() {
        return signUplink;
    }

    public Boolean getSignUpNewTab() {
        return signUpNewTab;
    }

    public String getSignUplinkTitle() {
        return signUplinkTitle;
    }

    public List<HeaderListModel> getHeaderLinks() {
        return headerLinks;
    }

    public String getCurrentPage(){
        return currentPage.getName();
    }

    public String getHomePageName(){
        return resource.getName();
    }
}
