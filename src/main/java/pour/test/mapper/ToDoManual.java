package pour.test.mapper;

public class ToDoManual {

    public static TargetDTO from(StubEntity stub){
        TargetDTO targetDTO = new TargetDTO();

        targetDTO.setId(stub.getId());
        targetDTO.setNum(stub.getNum());
        targetDTO.setTexte(stub.getTexte());

        return targetDTO;
    }
}
