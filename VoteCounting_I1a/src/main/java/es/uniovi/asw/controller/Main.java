package es.uniovi.asw.controller;

import es.uniovi.asw.counting.VoteCounter;
import es.uniovi.asw.model.PoliticalParty;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.VoteCount;
import es.uniovi.asw.persistence.PoliticalPartyRepository;
import es.uniovi.asw.persistence.VoteCountRepository;
import es.uniovi.asw.persistence.VoteRepository;
import es.uniovi.asw.results.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Autowired VoteRepository voteRepository;
    @Autowired VoteCountRepository voteCountRepository;
    @Autowired PoliticalPartyRepository politicalPartyRepository;

    @Autowired VoteCounter voteCounter;

    @RequestMapping("/")
    public ModelAndView landing(Model model) {
    LOG.info("Landing page access");
    return new ModelAndView("landing");
    }

    @RequestMapping("/count")
    public ModelAndView updateCount() {
        voteCounter.count();
        return new ModelAndView("count");
    }

    @RequestMapping("/results")
    public ModelAndView results() {
        return new ModelAndView("results");
    }

    @RequestMapping("/seed")
    public ModelAndView seed() {
        PoliticalParty trump = new PoliticalParty("Trump");
        PoliticalParty wojak = new PoliticalParty("Wojak");
        PoliticalParty pepe = new PoliticalParty("Pepe");

        trump = politicalPartyRepository.save(trump);
        wojak = politicalPartyRepository.save(wojak);
        pepe = politicalPartyRepository.save(pepe);

        voteCountRepository.save(new VoteCount(trump));
        voteCountRepository.save(new VoteCount(wojak));
        voteCountRepository.save(new VoteCount(pepe));

        voteRepository.save(new Vote(trump));
        voteRepository.save(new Vote(wojak));
        voteRepository.save(new Vote(pepe));
        voteRepository.save(new Vote(trump));

        return new ModelAndView("landing");
    }
}