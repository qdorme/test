package pour.test.mapper;

import java.util.function.Consumer;

public class ToDoFunctionnal {

    public static TargetDTO from(Consumer<TargetDTO> cons){
        TargetDTO targetDTO = new TargetDTO();
        cons.accept(targetDTO);
        return targetDTO;
    }
}
