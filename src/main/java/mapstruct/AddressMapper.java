package mapstruct;

import mapstruct.dto.AddressDto;
import mapstruct.entity.AddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto entityToDto(AddressEntity entity);

}
