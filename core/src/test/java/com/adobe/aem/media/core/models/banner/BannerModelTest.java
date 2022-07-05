package com.adobe.aem.media.core.models.banner;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class BannerModelTest {

    private final AemContext aemContext=new AemContext();

   @InjectMocks
    private BannerModel bannerModel;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(BannerModel.class);
        aemContext.load().json("/com/adobe/aem/media/core/models/banner/BannerModelTest.json","/bannerContent");
    }

    @Test
    void getResourceType() {
    }

    @Test
    void getBannerImage() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedImage = "/content/dam/we-retail/en/activities/skiing/ski%20touring.jpg";
        final String actualImage = bannerModel.getBannerImage();
        assertEquals(expectedImage,actualImage);
    }

    @Test
    void getBannerHeading() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedHead = "<p>This is Banner Image</p>\r\n";
        final String actualHead = bannerModel.getBannerHeading();
        assertEquals(expectedHead,actualHead);
    }

    @Test
    void getBannerDescription() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedDescription = "Banner Description";
        final String actualDescription = bannerModel.getBannerDescription();
        assertEquals(expectedDescription,actualDescription);
    }

    @Test
    void getBannerCtaLabel() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedCtaLabel = "Label";
        final String actualCtaLabel = bannerModel.getBannerCtaLabel();
        assertEquals(expectedCtaLabel,actualCtaLabel);
    }

    @Test
    void getBannerCtaLink() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedCta = "#";
        final String actualCta = bannerModel.getBannerCtaLink();
        assertEquals(expectedCta,actualCta);
    }

    @Test
    void getLinkColor() {
        aemContext.currentResource("/bannerContent/banner");
        bannerModel=aemContext.request().adaptTo(BannerModel.class);
        final String expectedLinkColor = "black";
        final String actualLinkColor = bannerModel.getLinkColor();
        assertEquals(expectedLinkColor,actualLinkColor);
    }
}
