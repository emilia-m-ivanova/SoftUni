package calculator;

import java.util.ArrayDeque;

public class MemoriseOperation implements Operation {

    private ArrayDeque<Integer> memory;

    public MemoriseOperation(ArrayDeque<Integer> memory){
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {
        this.memory.push(operand);

    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public int getResult() {
        return this.memory.peek();
    }
}
