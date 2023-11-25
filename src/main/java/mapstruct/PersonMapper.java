package mapstruct;

import mapstruct.dto.PersonDto;
import mapstruct.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper // PersonMapperImpl créer les constructeurs de Person et Address
@Mapper(uses = {AddressMapper.class}) // PersonMapperImpl delegue le mapping d'Address à l'autre mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto entityToDto(PersonEntity entity);
    @Mapping(target = "addresses", expression = """
            java(
                entity.getAddresses().stream()
                .filter( AddressEntity::isPrincipal )
                .map( a-> AddressMapper.INSTANCE.entityToDto(a))
                .toList()
            )
            """)
    PersonDto entityToDtoFiltered(PersonEntity entity);

}
