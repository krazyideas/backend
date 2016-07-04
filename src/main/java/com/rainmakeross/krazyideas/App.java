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

    @Bean
    public CommandLineRunner demo(
            PersonRepository personRepository,
            IdeaRepository ideaRepository,
            VoteRepository voteRepository
    ) {
        //TODO:remove this generation part
        return (args) -> {
            // save a couple of customers
            if (personRepository.findById(1L).size() == 0) {
                Person p = new Person("Admin", "admin@test.com", "admin@github");
                p.setAdminFlag(true);
                personRepository.save(p);
                personRepository.save(new Person("Jack Bauer", "jack@test.com", "100001@github"));
                personRepository.save(new Person("Chloe O'Brian", "chloe@test.com", "100002@github"));
                personRepository.save(new Person("Kim Bauer", "kim@test.com", "100003@guthub"));
                personRepository.save(new Person("David Palmer", "david@test.com", "100004@github"));
                personRepository.save(new Person("Michelle Dessler", "michelle@test.com", "100005@github"));
            }

            // fetch all customers
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (Person user : personRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch an individual user by ID
            Person user = personRepository.findOne(1L);
            log.info("User found with findOne(1L):");
            log.info("--------------------------------");
            log.info(user.toString());
            log.info("");

            // fetch customers by authID
            log.info("User found with findByAuthId():");
            log.info("--------------------------------------------");
            for (Person bauer : personRepository.findByAuthId("100001@github")) {
                log.info(bauer.toString());
            }

            // save a couple of ideas
            if (ideaRepository.findOne(1L) == null) {
                String html1 = "<img src='https://avatars1.githubusercontent.com/u/19335630?v=3&s=200' alt='HTML5 Icon' width='128' height='128'>";
                String html2 = "<img src='http://www.w3schools.com/html/html5.gif' alt='HTML5 Icon' width='128' height='128'>";
                String html3 = " <div style='color:#0000FF'><h3>This is from database</h3><p>html rendering.</p>";
                String html5 = "<table style='width:100%' border='1'> <tr><td>Jill</td><td>Smith</td> <td>aa</td></tr><tr><td>Eve</td><td>Jackson</td> <td>??</td></tr></table>";
                ideaRepository.save(new Idea("idea1", "Bauer", html1));
                ideaRepository.save(new Idea("idea2", "O'Brian", html2));
                ideaRepository.save(new Idea("idea3", "Bauer", html3));
                ideaRepository.save(new Idea("idea4", "Palmer"));
                ideaRepository.save(new Idea("idea5", "Dessler", html5));
            }

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

            if (voteRepository.findOne(1L) == null) {
                voteRepository.save(new Vote(user, idea));
            }

            // fetch an individual vote by ID
            Vote vote = voteRepository.findOne(1L);
            log.info("Idea found with findOne(1L):");
            log.info("--------------------------------");
            log.info(vote.toString());
            log.info("");
        };
    }



}
