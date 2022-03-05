package com.adobe.aem.media.core.services.linkrewriter;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.rewriter.ProcessingComponentConfiguration;
import org.apache.sling.rewriter.ProcessingContext;
import org.apache.sling.rewriter.Transformer;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import java.io.IOException;
import java.util.Optional;

public class TransformerDemo implements Transformer {

    private static final String CONTENT_MEDIA = "/content/media";

    private static final String HREF = "href";

    private ContentHandler handler;

    private SlingHttpServletRequest slingRequest;

    private Element element;

    @Override
    public void startElement(String uri, String name, String qName, Attributes pAttributes) throws SAXException {
        AttributesImpl attributes = new AttributesImpl(pAttributes);

        String hrefTag = attributes.getValue(HREF);

        if (Optional.ofNullable(hrefTag).isPresent()) {

            for (int i = 0; i < attributes.getLength(); i++) {
                if (HREF.equalsIgnoreCase(attributes.getQName(i))) {
                    String value = "";
                    if (attributes.getValue(i).contains(CONTENT_MEDIA)) {
                        attributes.setAttribute(1,"","rel","","","nofollow");
                        break;

                    }

                }
            }
        }

        handler.startElement(uri, name, qName, attributes);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        handler.characters(ch, start, length);
    }

    @Override
    public void dispose() {
    }

    @Override
    public void endDocument() throws SAXException {
        handler.endDocument();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        handler.endElement(uri, localName, qName);
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        handler.endPrefixMapping(prefix);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        handler.ignorableWhitespace(ch, start, length);
    }

    @Override
    public void init(ProcessingContext context, ProcessingComponentConfiguration config) throws IOException {
        slingRequest = context.getRequest();
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        handler.processingInstruction(target, data);
    }

    @Override
    public void setContentHandler(ContentHandler handler) {
        this.handler = handler;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
        handler.setDocumentLocator(locator);
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        handler.skippedEntity(name);
    }

    @Override
    public void startDocument() throws SAXException {
        handler.startDocument();
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        handler.startPrefixMapping(prefix, uri);

    }
}