package com.adobe.aem.media.core.services.search;

import com.day.cq.search.result.SearchResult;
import org.apache.sling.api.resource.ResourceResolver;

public interface SearchService {
    public SearchResult getSearchResult(String searchText, ResourceResolver resolver);
}
