package training.microservices.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

@Repository
public class SomethingDAO {

    private static final AtomicInteger nextId = new AtomicInteger(1);

    private static final List<Something> store = Collections.synchronizedList(new ArrayList<>());

    public List<Something> getAllSomethings() {
        return new ArrayList<>(store);
    }

    public Integer getNextId() {
        return nextId.getAndIncrement();
    }

    public void addSomething(final Something something) {
        store.add(something);
    }

}
