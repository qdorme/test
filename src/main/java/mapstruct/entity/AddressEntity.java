package mapstruct.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "having")
public class AddressEntity {

    private int num;
    private String street;
    private String city;
    private boolean principal;
}
