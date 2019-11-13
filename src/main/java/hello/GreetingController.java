package hello;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GreetingController {

    private ArrayList<Greeting> greetings;

    public GreetingController() {
        greetings = new ArrayList<>();
        greetings.add(new Greeting(23, "sdofjsdof sdoifjisoj"));
        greetings.add(new Greeting(33, "sdofjsdof sdfhkjh sdoifjisoj"));
    }

    @GetMapping("/all")
    public ArrayList<Greeting> getAll() {
        return greetings;
    }

    @GetMapping
    public Greeting getById(@RequestParam int id) {
        Optional<Greeting> greet = greetings.stream().filter(element -> element.getId() == id).findFirst();

        return greet.get();
    }

    @PostMapping
    public ArrayList<Greeting> addGreeting(@RequestBody Greeting newGreeting) {
        greetings.add(newGreeting);
        return greetings;
    }

    @DeleteMapping
    public boolean deleteById(@RequestParam int id) {
        return greetings.removeIf(el->el.getId()==id);
    }
}
