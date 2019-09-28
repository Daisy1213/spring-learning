package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private Long counterOfParam = 0L;
    private Long counterOfPath = 0L;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counterOfParam++,
                            String.format(template, name));
    }

    @RequestMapping("/greeting/{name}")
    public Greeting greetingPath(@PathVariable String name) {
        return new Greeting(counterOfPath++,
                String.format(template, name));
    }

}
