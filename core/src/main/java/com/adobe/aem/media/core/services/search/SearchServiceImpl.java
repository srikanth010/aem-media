package com.adobe.aem.media.core.services.search;

import java.util.HashMap;

import javax.jcr.Session;

import com.adobe.aem.media.core.services.search.SearchService;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.SearchResult;

@Component(service = SearchService.class)
public class SearchServiceImpl implements SearchService {

    @Override
    public SearchResult getSearchResult(String searchText, ResourceResolver resolver) {

        QueryBuilder queryBuilder = resolver.adaptTo(QueryBuilder.class);
        HashMap<String, String> queryMap = new HashMap<String, String>();
        queryMap.put("type", "cq:Page");
        queryMap.put("path", "/content/media");
        queryMap.put("group.1_fulltext", searchText);
        queryMap.put("group.1_fulltext.relPath", "jcr:content");
        queryMap.put("p.limit", "-1");
        Query query = queryBuilder.createQuery(PredicateGroup.create(queryMap), resolver.adaptTo(Session.class));
        SearchResult result = query.getResult();
        return result;
    }

}