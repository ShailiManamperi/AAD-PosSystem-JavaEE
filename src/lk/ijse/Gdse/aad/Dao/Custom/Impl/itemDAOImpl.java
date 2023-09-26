package lk.ijse.Gdse.aad.Dao.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.ItemDAO;
import lk.ijse.Gdse.aad.Dao.exception.ConstraintViolationException;
import lk.ijse.Gdse.aad.Entity.Item;

import java.util.List;
import java.util.Optional;

public class itemDAOImpl implements ItemDAO {
    @Override
    public Boolean save(Item entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public Boolean update(Item entity) throws ConstraintViolationException {
        return null;
    }

    @Override
    public boolean deleteByPk(String pk) throws ConstraintViolationException {
        return false;
    }

    @Override
    public List<Item> findAll() {
        return null;
    }

    @Override
    public Item findByPk(String pk) {
        return null;
    }

    @Override
    public boolean existByPk(String pk) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }
}
