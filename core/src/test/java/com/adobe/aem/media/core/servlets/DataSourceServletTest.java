package com.adobe.aem.media.core.servlets;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AemContextExtension.class)
class DataSourceServletTest {

    AemContext aemContext = new AemContext();

    DataSourceServlet dataSourceServlet = new DataSourceServlet();

    @BeforeEach
    void setUp() {


    }

    @Test
    void init() {
    }

    @Test
    void doGet() {
    }

    @Test
    void doPost() {
    }
}
