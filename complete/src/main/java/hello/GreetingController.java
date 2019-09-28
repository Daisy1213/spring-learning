package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private Long counterOfParam = 0L;
    private Long counterOfPath = 0L;
    private Map<String, Long> counterMap = new HashMap<>();

    @RequestMapping("/greeting")

    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counterOfParam++,
                String.format(template, name));
    }

    @RequestMapping("/greeting/{name}")
    public Greeting greetingPath(@PathVariable String name) {
        if (counterMap.get(name) == null) {
            counterMap.put(name, 1L);
        } else {
            counterMap.put(name, counterMap.get(name) + 1);
        }
        return new Greeting(counterMap.get(name),
                String.format(template, name));
    }
}
