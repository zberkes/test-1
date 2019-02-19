package training.microservices.test1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/something")
public class SomethingController {

    @Autowired
    private SomethingDAO somethingDao;

    @GetMapping(produces = "application/json")
    public List<Something> getSomething() {
        return somethingDao.getAllSomethings();
    }

    @PostMapping(consumes = "application/json")
    public void addSomething(@RequestBody Something something) {
        final Integer id = somethingDao.getNextId();
        something.setId(id);

        somethingDao.addSomething(something);
    }

}
