package com.lenzi.server.config;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by federico on 06/04/14.
 */
@Configuration
public class AppConfig {

    @Bean(name = "jsonProvider")
    public JacksonJsonProvider jacksonJsonProviderConfig(){
        JacksonJsonProvider jacksonJsonProvider = new JacksonJsonProvider();
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);
        jacksonJsonProvider.setMapper(mapper);
        return jacksonJsonProvider;
    }
}
