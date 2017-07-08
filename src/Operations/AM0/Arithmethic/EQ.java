package Operations.AM0.Arithmethic;

import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class EQ extends AM0operation {

    public EQ(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
        this.name = "EQ";
    }

    @Override
    public void run(Integer arg) {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x == y ? 1 : 0);

        increment();
    }
}
