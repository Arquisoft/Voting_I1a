package es.uniovi.asw.controller;

import es.uniovi.asw.counting.VoteCounter;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.model.VoteCount;
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

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    VoteCountRepository voteCountRepository;

    @RequestMapping("/")
    public ModelAndView landing(Model model) {
    LOG.info("Landing page access");
    return new ModelAndView("landing");
    }

    @RequestMapping("/count")
    public ModelAndView updateCount() {
        new VoteCounter(voteRepository, voteCountRepository).count();
        return new ModelAndView("count");
    }

    @RequestMapping("/results")
    public ModelAndView results() {
        return new ModelAndView("results");
    }

    @RequestMapping("/seed")
    public ModelAndView seed() {
        voteCountRepository.save(new VoteCount("Trump"));
        voteCountRepository.save(new VoteCount("Wojak"));
        voteCountRepository.save(new VoteCount("Pepe"));

        voteRepository.save(new Vote("Trump"));
        voteRepository.save(new Vote("Wojak"));
        voteRepository.save(new Vote("Pepe"));
        voteRepository.save(new Vote("Trump"));

        return new ModelAndView("landing");
    }
}