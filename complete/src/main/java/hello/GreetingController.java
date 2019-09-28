package hello;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private Long counterOfParam = 0L;
    private Map<String, Long> counterMap = new HashMap<>();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counterOfParam++,
                String.format(template, name));
    }

    @RequestMapping("/greeting/{name}")
    public Greeting greetingPath(@PathVariable String name) {
        Long counter = counterMap.getOrDefault(name, 0L);
        counterMap.put(name, counter + 1);

        return new Greeting(counter,
                String.format(template, name));
    }

    @PutMapping("/greeting/{name}")
    public Greeting updateCounter(@PathVariable String name, @RequestBody CounterBody body) {
        counterMap.put(name, body.getCounter());

        return new Greeting(counterMap.get(name), String.format(template, name));
    }

    @PostMapping("/greeting")
    public Greeting xx(@RequestBody Greeting body) {
        String name = body.getName();
        Long counter = body.getCounter();
        counterMap.put(name, counter);

        return new Greeting(counter, String.format(template, name));
    }
}
