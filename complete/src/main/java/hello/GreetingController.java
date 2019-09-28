package hello;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private Map<String, Long> counterMap = new HashMap<>();

    @RequestMapping("/greeting/{name}")
    public Greeting greetingPath(@PathVariable String name) {
        Long counter = counterMap.get(name);
        if (counter == null) {
            throw new NotFoundException();
        }

        return new Greeting(counter,
                String.format(template, name));
    }

    @PutMapping("/greeting/{name}")
    public Greeting updateCounter(@PathVariable String name, @RequestBody CounterBody body) {
        counterMap.put(name, body.getCounter());

        return new Greeting(counterMap.get(name), String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting add(@RequestBody Greeting body) {
        String name = body.getName();
        Long counter = body.getCounter();
        counterMap.put(name, counter);

        return new Greeting(counter, String.format(template, name));
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
