package es.uniovi.asw.controller;

import es.uniovi.asw.voting.Voting;
import es.uniovi.asw.dto.PoliticalPartyDTO;
import es.uniovi.asw.dto.VoteDTO;
import es.uniovi.asw.model.PoliticalParty;
import es.uniovi.asw.model.Vote;
import es.uniovi.asw.persistence.PoliticalPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class RestService {

    @Autowired private Voting voteService;
    @Autowired private PoliticalPartyRepository politicalPartyRepository;

    @RequestMapping("/voting/candidates")
    public Iterable<PoliticalParty> politicalParties() {
        return politicalPartyRepository.findAll();
    }

    @RequestMapping(value = "/voting/vote", method = RequestMethod.POST)
    public ResponseEntity<Vote> vote(@RequestBody VoteDTO vote) {
        Vote result = voteService.vote(vote.getVoterEmail(), vote.getVoterPassword(), vote.getPoliticalPartyId());

        return result != null ?
                new ResponseEntity<>(result, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/admin/political_party", method = RequestMethod.POST)
    public void addPoliticalParty(@RequestBody PoliticalPartyDTO politicalPartyDTO) {
        politicalPartyRepository.save(new PoliticalParty(politicalPartyDTO.getName()));
    }

}
