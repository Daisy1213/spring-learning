package hello;

public class Greeting {

    private final long counter;
    private final String content;

    public Greeting(long counter, String content) {
        this.counter = counter;
        this.content = content;
    }

    public long getCounter() {
        return counter;
    }

    public String getContent() {
        return content;
    }
}
