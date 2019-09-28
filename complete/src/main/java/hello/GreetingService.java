package hello;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingService {
    private Map<String, Long> counterMap = new HashMap<>();

    public Greeting getByName(String name) {
        Long counter = counterMap.get(name);
        if (counter == null) {
            throw new NotFoundException();
        }

        return new Greeting(name, counter);
    }

    public Greeting update(String name, CounterBody body) {
        counterMap.put(name, body.getCounter());

        return new Greeting(name, counterMap.get(name));
    }

    public Greeting add(Greeting body) {
        String name = body.getName();
        Long counter = body.getCounter();
        counterMap.put(name, counter);

        return new Greeting(name, counter);
    }

    public void delete(String name) {
        this.counterMap.remove(name);
    }

    public Map<String, Long> getAll() {
        return counterMap;
    }
}
