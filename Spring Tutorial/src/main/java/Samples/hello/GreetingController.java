/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Samples.hello;

/**
 *
 * @author jose
 */
import Samples.Tasks.Tareas;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private  List <Greeting> greetings = new ArrayList<>();
    
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @RequestMapping(value = "/greetings", method = RequestMethod.GET)
    public List <Greeting> greetingList() {
        
        greetings.add(new Greeting(counter.incrementAndGet(),
                            String.format(template, "World")));
        
        
        greetings.add(new Greeting(counter.incrementAndGet(),
                            String.format(template, "name")));
        
        return greetings;
    }
    
}