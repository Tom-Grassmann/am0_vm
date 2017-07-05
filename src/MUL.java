public class MUL extends Command {

    public MUL() {

        this.name = "MUL";
    }

    @Override
    public void run(String arg) {

        int x = this.stack.pop();
        int y = this.stack.pop();

        this.stack.push(x * y);
    }
}