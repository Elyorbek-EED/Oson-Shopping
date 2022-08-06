package online_shop_jar.service;

import lombok.RequiredArgsConstructor;
import online_shop_jar.mapper.Mapper;
import online_shop_jar.respository.AbstractRepository;
import online_shop_jar.validator.Validator;

@RequiredArgsConstructor
public abstract class AbstractService <R extends AbstractRepository,M extends Mapper, V extends Validator>{
protected final R repository;
protected final M mapper;
protected final V validator;

}
