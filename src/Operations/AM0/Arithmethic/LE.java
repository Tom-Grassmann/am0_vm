package Operations.AM0.Arithmethic;

import Exceptions.InvalidOperationArgumentException;
import Exceptions.StackException;
import Hardware.CommandPointers.CommandPointer;
import Hardware.Heaps.Heap;
import Operations.AM0.AM0operation;
import Hardware.Stacks.Stack;

public class LE extends AM0operation {

    public LE(Heap heap, Stack stack, CommandPointer commandPointer) {

        super(heap, stack, commandPointer);
    }

    @Override
    public void run(String arg) throws InvalidOperationArgumentException, StackException {

        int y = this.stack.pop();
        int x = this.stack.pop();

        this.stack.push(x <= y ? 1 : 0);

        increment();
    }
}
