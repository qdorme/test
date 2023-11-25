package mapstruct.dto;

import lombok.Data;

import java.util.List;

@Data
public class PersonDto {
    private String firstName;
    private String lastName;
    private List<AddressDto> addresses;
}
