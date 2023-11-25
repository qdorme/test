package mapstruct.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder(builderMethodName = "having")
public class PersonEntity {

    private String firstName;
    private String lastName;
    @Singular
    private final List<AddressEntity> addresses;

}
