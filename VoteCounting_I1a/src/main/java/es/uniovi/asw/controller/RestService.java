package es.uniovi.asw.controller;

import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.VoteCountRepository;
import es.uniovi.asw.results.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestService {

    @Autowired
    private Results results;

    @RequestMapping("/api/results")
    public Iterable<VoteCount> results() {
        return results.results();
    }

}
