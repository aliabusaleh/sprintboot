package com.exalt.sprintboot.controller;


import com.exalt.sprintboot.model.Link;
import com.exalt.sprintboot.model.Vote;
import com.exalt.sprintboot.repository.LinkRepository;
import com.exalt.sprintboot.repository.VoteRepository;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VoteController {
    private VoteRepository voteRepository;
    private LinkRepository linkRepository;

    public VoteController(VoteRepository voteRepository, LinkRepository linkRepository) {
        this.voteRepository = voteRepository;
        this.linkRepository = linkRepository;
    }
    // http://localhost:8080/vote/link/1/direction/-1/5
    //                              /link id/   /up/down/total
    @Secured({"ROLE_USER"})
    @GetMapping("/vote/link/{linkid}/direction/{direction}/votecount/{votecount}")
    public int vote(@PathVariable long linkid, @PathVariable short direction, @PathVariable int votecount){
        Optional<Link> optionalLink = linkRepository.findById(linkid);
        if(optionalLink.isPresent()){
            Link link = optionalLink.get();
            Vote vote = new Vote(direction,link);
            voteRepository.save(vote);
            int updatedVoteCount = votecount+direction;
            link.setVoteCount(updatedVoteCount);
            linkRepository.save(link);
            return  updatedVoteCount;
        }
        else {
        return  votecount;
        }

    }

}
