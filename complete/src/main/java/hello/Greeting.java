package hello;

public class Greeting {
    private long counter;
    private String content;
    private String name;

    public Greeting(long counter, String content) {
        this.counter = counter;
        this.content = content;
    }

    public Greeting() { }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getCounter() {
        return counter;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
