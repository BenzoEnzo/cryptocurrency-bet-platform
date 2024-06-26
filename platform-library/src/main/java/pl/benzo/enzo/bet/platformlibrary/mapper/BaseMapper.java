package pl.benzo.enzo.bet.platformlibrary.mapper;

public interface BaseMapper<ENTITY,DTO>{
    ENTITY mapToEntity(DTO dto);
    DTO mapToDto(ENTITY e);
    void mapToUpdate(DTO dto);
}

