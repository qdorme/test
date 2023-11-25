package mapstruct.dto;

import lombok.Data;

@Data
public class AddressDto {
    private int num;
    private String street;
    private String city;
    private boolean principal;
}
