package com.interview.newsreader.service;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.interview.newsreader.dto.ArticleBundleDTO;
import com.interview.newsreader.dto.ParametersNewsAPI;
import com.interview.newsreader.enuns.LanguageNewsEnum;
import com.interview.newsreader.enuns.SortNewsEnum;

public class NewsApiService {

    private static final String URL = "https://newsapi.org/v2/everything?";

    public static ArticleBundleDTO getArticles(ParametersNewsAPI parameters) throws Exception {        

        HashMap<String, Object> map = new HashMap<>();
        map.put("q", parameters.getQ());
        map.put("from", parameters.getFrom());
        map.put("to", parameters.getTo());
        map.put("language", parameters.getLanguage());
        map.put("sortBy", parameters.getSortBy());
        map.put("pageSize", parameters.getPageSize());
        map.put("page", parameters.getPage());
        map.put("apiKey", parameters.getApiKey());

        String completeUrl = getURL(map);
        System.out.println("API URL: " + completeUrl);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ArticleBundleDTO> response = restTemplate.getForEntity(completeUrl, ArticleBundleDTO.class);
        
        return response.getBody();
    }

    public static String getURL(Map<String, Object> parameters) throws Exception {
        StringBuilder completeUrl = new StringBuilder(URL);

        if (parameters != null && !parameters.isEmpty()) {
            boolean firstParam = true;

            System.out.println(parameters.entrySet());

            for (Map.Entry<String, Object> entry : parameters.entrySet()) {
                System.out.println(entry.getKey() + " ----  " + entry.getValue());
                if (entry.getValue() != null) {
                    
                    if (!firstParam) {
                        completeUrl.append("&");
                    } else {
                        firstParam = false;
                    }

                    try {
                        String stringValue = "";

                        if (entry.getValue() instanceof Date) {
                            SimpleDateFormat dt1 = new SimpleDateFormat("yyyyy-mm-dd");
                            stringValue = dt1.format(entry.getValue());

                        }
                        
                        if (entry.getValue() instanceof LanguageNewsEnum) {
                            stringValue = ((LanguageNewsEnum) entry.getValue()).getAbbreviation();

                        }
                        
                        if (entry.getValue() instanceof SortNewsEnum) {
                            stringValue = ((SortNewsEnum) entry.getValue()).getValue();
                            
                        }

                        if(entry.getValue() instanceof String || entry.getValue() instanceof Integer) {
                            stringValue = entry.getValue().toString();
                        }
                    
                        String key = URLEncoder.encode(entry.getKey(), "UTF-8");
                        String value = URLEncoder.encode(stringValue, "UTF-8");                        
                        
                        completeUrl.append(key).append("=").append(value);
                    } catch (Exception e) {
                        throw new Exception("Erro ao gerar url", e);
                    }
                }
            }
        }

        return completeUrl.toString();
    }
}
