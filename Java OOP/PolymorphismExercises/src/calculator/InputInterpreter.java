package calculator;

import java.util.ArrayDeque;

public class InputInterpreter {
    private CalculationEngine engine;

    ArrayDeque<Integer> memory;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
        this.memory = new ArrayDeque<>();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            engine.pushOperation(this.getOperation(input));
        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if(operation.equals("ms")){
            return new MemoriseOperation(memory);
        } else{
            MemoryRecall mr = new MemoryRecall(memory);
            engine.pushNumber(mr.getResult());
        }

        return null;
    }
}
