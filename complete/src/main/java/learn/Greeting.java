package learn;

public class Greeting {
    private String name;
    private Long counter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public Greeting(String name, Long counter) {
        this.name = name;
        this.counter = counter;
    }

    public Greeting() {

    }

}
