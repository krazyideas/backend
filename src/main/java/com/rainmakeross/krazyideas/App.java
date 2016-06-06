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
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;


@Import(RepositoryRestMvcConfiguration.class)
@SpringBootApplication
public class App extends SpringBootServletInitializer {


    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Bean
    public CommandLineRunner demo(PersonRepository repository,
        IdeaRepository ideaRepository, VoteRepository voteRepository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new Person("Jack", "Bauer"));
            repository.save(new Person("Chloe", "O'Brian"));
            repository.save(new Person("Kim", "Bauer"));
            repository.save(new Person("David", "Palmer"));
            repository.save(new Person("Michelle", "Dessler"));

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (Person user : repository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual user by ID
            Person user = repository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by last name
            log.info("User found with findByLastName('Bauer'):");
            log.info("--------------------------------------------");
            for (Person bauer : repository.findByLastName("Bauer")) {
                log.info(bauer.toString());
            }

            // save a couple of ideas
            ideaRepository.save(new Idea("idea1", "Bauer"));
            ideaRepository.save(new Idea("idea2", "O'Brian"));
            ideaRepository.save(new Idea("idea3", "Bauer"));
            ideaRepository.save(new Idea("idea4", "Palmer"));
            ideaRepository.save(new Idea("idea5", "Dessler"));

            // fetch all ideas
            log.info("Ideas found with findAll():");
            log.info("-------------------------------");
            for (Idea idea : ideaRepository.findAll()) {
                log.info(idea.toString());
            }
            log.info("");

            // fetch an individual idea by ID
            Idea idea = ideaRepository.findOne(1L);
            log.info("Idea found with findOne(1L):");
            log.info("--------------------------------");
            log.info(idea.toString());
            log.info("");

            voteRepository.save(new Vote(user, idea));

            // fetch an individual vote by ID
            Vote vote = voteRepository.findOne(1L);
            log.info("Idea found with findOne(1L):");
            log.info("--------------------------------");
            log.info(vote.toString());
            log.info("");
        };
    }



}
