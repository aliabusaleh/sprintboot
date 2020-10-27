package com.exalt.sprintboot.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Vote extends Auditable {
    @Id @GeneratedValue
    private  long id;

    private int vote;

    // user
    //link
    @NonNull
    private short direction;

    @NonNull
    @ManyToOne
    private Link link;


}
