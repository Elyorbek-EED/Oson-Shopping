package online_shop_jar.mapper;

import online_shop_jar.dtos.Dto;
import online_shop_jar.dtos.GenericDTO;
import online_shop_jar.entity.BaseEntity;

import java.util.List;


public interface GenericMapper<
        CD extends Dto,
        UD extends GenericDTO,
        D extends GenericDTO,
        E extends BaseEntity> extends Mapper {

    E fromCreateDTO(CD DTO);


    E fromUpdateDTO(UD DTO);


    E fromDTO(D DTO);

    D toDTO(E entity);


    List<D> toListDTO(List<E> entity);

}
