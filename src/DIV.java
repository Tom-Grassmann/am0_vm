public class DIV extends Operation {

    public DIV() {

        this.name = "DIV";
    }

    @Override
    public void run(Integer arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x / y);

        increment();
    }
}
