package lk.ijse.Gdse.aad.Dao;

import lk.ijse.Gdse.aad.Entity.SuperEntity;
import lk.ijse.Gdse.aad.Dao.exception.ConstraintViolationException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface CrudDAO <T extends SuperEntity,ID extends Serializable> extends SuperDAO{

    Boolean save(T entity) throws ConstraintViolationException;

    Boolean update(T entity) throws ConstraintViolationException;

    boolean deleteByPk(ID pk) throws ConstraintViolationException;

    List<T> findAll() ;

    T findByPk(ID pk) ;

    boolean existByPk(ID pk) ;

    long count() ;
}
