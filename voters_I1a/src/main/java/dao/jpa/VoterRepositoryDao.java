package dao.jpa;

import dao.VoterDao;
import model.Voter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VoterRepositoryDao implements VoterDao {

    @Autowired
    private VoterRepository repository;

    public VoterRepositoryDao(VoterRepository repository) {
//        this.repository = repository;
    }

    @Override
    public void createVoter(Voter voter) {
        repository.save(voter);
    }

    @Override
    public Voter getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Voter getById(long id) {
        return repository.findOne(id);
    }

    @Override
    public List<Voter> getAll() {
        List<Voter> voters = new ArrayList<>();

        for (Voter voter: repository.findAll())
            voters.add(voter);

        return voters;
    }

    @Override
    public void updateVoter(Voter voter) {
        repository.save(voter);
    }

    @Override
    public void removeVoter(Voter voter) {
        repository.delete(voter);
    }
}
