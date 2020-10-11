package com.exalt.sprintboot;
import com.exalt.sprintboot.config.SpringitProparties;
import com.exalt.sprintboot.model.Comment;
import com.exalt.sprintboot.model.Link;
import com.exalt.sprintboot.repository.CommentRepository;
import com.exalt.sprintboot.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties(SpringitProparties.class)
public class SprintbootApplication {
    /**
     * CREATE logger for the application
     * */
    private static final Logger log = LoggerFactory.getLogger(SprintbootApplication.class);
    // the folloing annotation used to map the proparties varibles into this class
    @Autowired
    //private SpringitProparties springitProparties;
   // private ApplicationContext applicationContext; //
    public static void main(String[] args) {
        SpringApplication.run(SprintbootApplication.class, args);
    }
    /*
    * This command liner print in the run command line for debugging ! */
   // @Bean
    /*
    * to change the profile for this command use this annotation where "dev" is the <profile name>
    * */
  //  @Profile("dev")
    CommandLineRunner runner(LinkRepository linkRepository , CommentRepository commentRepository){
        return  args -> {
            /*
            * This line used to print the properties welcome message
            * */
        //   System.out.println( "Welcome message "+ springitProparties.getWelcomeMessage());
            /*
            * this line used to test the profiles annotation
            * */
           // System.out.println("This is something only in dev");

           /* System.out.println("Printing out all the bean names in application context");
            System.out.println("-----------------------------------------------------");
            String[] beans = applicationContext.getBeanDefinitionNames();
            Arrays.sort(beans);
            for( String bean : beans){
                System.out.println(bean);
            }*/
            /*log.error("This is an ERROR log");
            log.warn("this is a WARN log");
            log.info("This is an INFO log");
            log.debug("This is a DEBUG log");
            log.trace("This is a TRACE log");*/
            Link link = new Link("Getting Started with Springboot 2","www.github.com/aliabusaleh");
            linkRepository.save(link);
            Comment comment = new Comment("This is a hard course! ", link);
            commentRepository.save(comment);
            link.addComment(comment);
            System.out.println(linkRepository.findByTitle("Getting Started with Springboot 2").getTitle());
           /* System.out.println(link.toString());
            System.out.println(link.getComments());*/

        };
    }

}
