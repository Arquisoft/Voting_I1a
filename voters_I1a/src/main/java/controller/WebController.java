package controller;

import dao.jpa.VoterRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class WebController {

    @RequestMapping(path = "/")
    public String home() {
        return "index";
    }

}
