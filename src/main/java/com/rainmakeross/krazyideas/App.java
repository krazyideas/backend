package com.rainmakeross.krazyideas;

import com.rainmakeross.krazyideas.models.Idea;
import com.rainmakeross.krazyideas.models.Person;
import com.rainmakeross.krazyideas.models.Vote;
import com.rainmakeross.krazyideas.repositories.IdeaRepository;
import com.rainmakeross.krazyideas.repositories.PersonRepository;
import com.rainmakeross.krazyideas.repositories.VoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


@Import(RepositoryConfig.class)
@SpringBootApplication
public class App extends SpringBootServletInitializer {


    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }




}
