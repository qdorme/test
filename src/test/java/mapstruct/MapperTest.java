package mapstruct;

import mapstruct.dto.PersonDto;
import mapstruct.entity.AddressEntity;
import mapstruct.entity.PersonEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MapperTest {

    public PersonEntity person() {
        return PersonEntity.having()
                .firstName("Quentin").lastName("DORME")
                .address(principalAddress())
                .address(secondaryAddress())
                .build();
    }

    private AddressEntity principalAddress() {
        return AddressEntity.having()
                .num(10).street("Donning Street").city("London").principal(true)
                .build();
    }

    private AddressEntity secondaryAddress() {
        return AddressEntity.having()
                .num(221).street("Backer Street").city("London").principal(false)
                .build();
    }

    @Test
    void shouldMapPersonFully() {

        PersonEntity person = person();

        PersonDto personDto = PersonMapper.INSTANCE.entityToDto(person);

        assertThat(personDto).isNotNull();
        assertThat(personDto.getFirstName()).isEqualTo("Quentin");
        assertThat(personDto.getLastName()).isEqualTo("DORME");
        assertThat(personDto.getAddresses()).isNotEmpty();
        assertThat(personDto.getAddresses()).hasSize(2);
        assertThat(personDto.getAddresses()).contains(
                AddressMapper.INSTANCE.entityToDto(principalAddress()),
                AddressMapper.INSTANCE.entityToDto(secondaryAddress())
        );


    }

    @Test
    void shouldMapPersonPartially() {

        PersonEntity person = person();

        PersonDto personDto = PersonMapper.INSTANCE.entityToDtoFiltered(person);

        assertThat(personDto).isNotNull();
        assertThat(personDto.getFirstName()).isEqualTo("Quentin");
        assertThat(personDto.getLastName()).isEqualTo("DORME");
        assertThat(personDto.getAddresses()).isNotEmpty();
        assertThat(personDto.getAddresses()).hasSize(1);
        assertThat(personDto.getAddresses()).contains(
                AddressMapper.INSTANCE.entityToDto(principalAddress())
        );
        assertThat(personDto.getAddresses()).doesNotContain(
                AddressMapper.INSTANCE.entityToDto(secondaryAddress())
        );

    }


}
