package es.uniovi.asw.controller;

import es.uniovi.asw.Voting.Voting;
import es.uniovi.asw.model.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import es.uniovi.asw.model.Option;

import java.util.Arrays;
import java.util.List;


/**
 * Created by takit on 03/05/2016.
 */
@RestController
public class RestService {

    @Autowired
    private Option parties;

    @Autowired
    private Voting voteService;

    @RequestMapping("/voting/candidates")
    public Iterable<Option> options() {
        List<Option> array = Arrays.asList(parties.values());

        return array;
    }


    @RequestMapping("/voting/vote")
    public Vote vote(@RequestParam(value="option", defaultValue = "Trump") String option, @RequestParam(value="id", defaultValue = "0") Long id) {
        return voteService.vote(option, id);
    }
}
