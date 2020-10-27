package com.exalt.sprintboot.model;


import lombok.*;
import org.hibernate.validator.constraints.URL;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@RequiredArgsConstructor
@Getter @Setter
@Document(indexName = "my-index",type = "links")
@NoArgsConstructor
public class Link {

    @Id
    @GeneratedValue
    private long id;

    @NonNull
    @NotEmpty (message = "Please Enter a Title")
    private String title;

    @NonNull
    @NotEmpty (message = "Please Enter a URl")
    @URL (message = "Please enter a valid URL")
    private  String url;

    //comments
    @OneToMany(mappedBy = "link")
    private List<Comment> comments = new ArrayList<>();

    //votes
    @OneToMany(mappedBy = "link")
    private List<Vote> votes = new ArrayList<>();
    private int voteCount = 0;

    @ManyToOne
    private User user;


    public  void addComment( Comment comment){
        comments.add(comment);
    }
    public String getDomainName() throws URISyntaxException {
        URI uri = new URI(this.url);
        String domain = uri.getHost();
        return domain.startsWith("www.") ? domain.substring(4) : domain;
    }

    public String getPrettyTime() {
        //PrettyTime pt = BeanUtil.getBean(PrettyTime.class);
        return DateTime.now().toString();
    }
    public DateTime getCreationDate() {
    return DateTime.now();
    }
    private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
        return java.util.Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
    }

}
