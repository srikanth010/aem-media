package com.adobe.aem.media.core.models.carousel;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CarouselModelTest {

    private AemContext aemContext;

    private CarouselModel carouselModel;

    @BeforeEach
    void Setup(){
        aemContext.addModelsForClasses(CarouselModel.class);
        aemContext.load().json("/com/adobe/aem/media/core/models/carousel/CarouselModel.json","/carouselContent");
    }

    @Test
    void getResourceType() {
    }

    @Test
    void getCarouselLinkItems() {
        aemContext.currentResource("/carouselContent/carousel");
        carouselModel = aemContext.request().adaptTo(CarouselModel.class);
        final int expectedSize = 2;
        final int actualSize = carouselModel.getCarouselLinkItems().size();
        assertEquals(expectedSize,actualSize);
        assertEquals("Dwa",carouselModel.getCarouselLinkItems().get(0).getCarouselDescription());
        assertEquals("/content/dam/we-retail/en/people/womens/women_2.jpg",carouselModel.getCarouselLinkItems().get(0).getImage());
        assertEquals("Label",carouselModel.getCarouselLinkItems().get(0).getCtaTextLabel());
        assertEquals("#",carouselModel.getCarouselLinkItems().get(0).getCtaLink());
        assertEquals("<p>This is Carousel Image</p>\r\n",carouselModel.getCarouselLinkItems().get(0).getCaroselHeading());
        assertEquals("The description for image.",carouselModel.getCarouselLinkItems().get(1).getCarouselDescription());
        assertEquals("/content/dam/we-retail/en/people/womens/women_6.jpg",carouselModel.getCarouselLinkItems().get(1).getImage());
        assertEquals("Click Here",carouselModel.getCarouselLinkItems().get(1).getCtaTextLabel());
        assertEquals("#",carouselModel.getCarouselLinkItems().get(1).getCtaLink());
        assertEquals("<p>This is another image&nbsp;This is another image&nbsp;This is another image&nbsp;This is another image.</p>\r\n",carouselModel.getCarouselLinkItems().get(1).getCaroselHeading());
    }
}
