package com.exalt.sprintboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;
@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comment extends Auditable {
    @Id
    @GeneratedValue
    private  long id;
    @NonNull
    private  String body;

    //link
    @ManyToOne()
    @NonNull
    private Link link;


}
