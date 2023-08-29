package pour.test.mapper;

import org.mapstruct.Mapper;

@Mapper
public interface ToDTO {
    TargetDTO from(StubEntity stub);
}
