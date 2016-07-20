package com.rainmakeross.krazyideas;

import com.rainmakeross.krazyideas.models.Idea;
import com.rainmakeross.krazyideas.models.Person;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RepositoryConfig extends RepositoryRestMvcConfiguration {

    @Override
    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Person.class);
        config.exposeIdsFor(Idea.class);
    }
}
