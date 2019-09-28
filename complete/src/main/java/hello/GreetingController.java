package hello;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    private Map<String, Long> counterMap = new HashMap<>();

    @RequestMapping("/greeting/{name}")
    public Greeting getOne(@PathVariable String name) {
        Long counter = counterMap.get(name);
        if (counter == null) {
            throw new NotFoundException();
        }

        return new Greeting(name, counter);
    }

    @PutMapping("/greeting/{name}")
    public Greeting updateCounter(@PathVariable String name, @RequestBody CounterBody body) {
        counterMap.put(name, body.getCounter());

        return new Greeting(name, counterMap.get(name));
    }

    @PostMapping("/greeting")
    public Greeting add(@RequestBody Greeting body) {
        String name = body.getName();
        Long counter = body.getCounter();
        counterMap.put(name, counter);

        return new Greeting(name, counter);
    }

    @DeleteMapping("/greeting/{name}")
    public void deleteGreeting(@PathVariable String name) {
        counterMap.remove(name);
    }

    @GetMapping("/greeting")
    public Map<String, Long> getAll() {
        return counterMap;
    }
}
