package calculator;

import java.util.ArrayDeque;

public class MemoryRecall implements Operation{

    ArrayDeque<Integer> memory;

    public MemoryRecall(ArrayDeque<Integer> memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return this.memory.pop();
    }

    @Override
    public boolean isCompleted() {
        return !this.memory.isEmpty();
    }
}
