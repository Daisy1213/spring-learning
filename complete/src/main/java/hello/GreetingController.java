package hello;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class GreetingController {
    private GreetingService greetingService;

    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @RequestMapping("/greeting/{name}")
    public Greeting getOne(@PathVariable String name) {
        return greetingService.getByName(name);
    }

    @PutMapping("/greeting/{name}")
    public Greeting updateCounter(@PathVariable String name, @RequestBody CounterBody body) {
        return greetingService.update(name, body);
        }

    @PostMapping("/greeting")
    public Greeting add(@RequestBody Greeting body) {
        return greetingService.add(body);
        }

    @DeleteMapping("/greeting/{name}")
    public void deleteGreeting(@PathVariable String name) {
        greetingService.delete(name);
    }

    @GetMapping("/greeting")
    public Map<String, Long> getAll() {
        return greetingService.getAll();
    }
}
