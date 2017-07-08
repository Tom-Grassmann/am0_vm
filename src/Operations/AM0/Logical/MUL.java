package Operations.AM0.Logical;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class MUL extends AM0operation {

    public MUL(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
        this.name = "MUL";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x * y);
        increment();
    }
}
