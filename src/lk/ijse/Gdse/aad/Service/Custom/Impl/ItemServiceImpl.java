package lk.ijse.Gdse.aad.Service.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.ItemDAO;
import lk.ijse.Gdse.aad.Dao.DaoFactory;
import lk.ijse.Gdse.aad.Dao.DaoTypes;
import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Entity.Item;
import lk.ijse.Gdse.aad.Service.Custom.ItemService;
import lk.ijse.Gdse.aad.Service.exception.DuplicateException;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;
import lk.ijse.Gdse.aad.Util.Converter;

import java.util.ArrayList;
import java.util.List;

public class ItemServiceImpl implements ItemService {
    private final Converter converter;

    private final ItemDAO itemDAO;

    public ItemServiceImpl(){
        this.converter = new Converter();
        this.itemDAO = DaoFactory.getInstance().getDAO(DaoTypes.ITEM);
    }
    @Override
    public Boolean saveItem(ItemDto itemDto) throws DuplicateException {
        boolean flag = false;
        if (itemDAO.existByPk(itemDto.getItemid())) {
            return flag;
        } else {
            flag = itemDAO.save(converter.toItem(itemDto));
        }
        return flag;
    }

    @Override
    public Boolean updateItem(ItemDto itemDto) throws NotFoundException {
        if (!itemDAO.existByPk(itemDto.getItemid())) {
            throw new NotFoundException("Item not found!");
        } else {
            itemDAO.update(converter.toItem(itemDto));
            return true;
        }
    }

    @Override
    public ItemDto searchItem(String id) throws NotFoundException {
        return converter.fromItem(itemDAO.findByPk(id));
    }

    @Override
    public boolean deleteItem(String id) throws NotFoundException {
        if (!itemDAO.existByPk(id)){
            throw new NotFoundException("This Item id is not found");
        }
        return itemDAO.deleteByPk(id);
    }

    @Override
    public ArrayList<ItemDto> getAllItems() throws NotFoundException {
        List<Item> all = itemDAO.findAll();
        ArrayList<ItemDto> ItemDtolist = new ArrayList<>();
        for (int i = 0; i<all.size(); i++){
            Item item = all.get(i);
            ItemDtolist.add(i,converter.fromItem(item));
        }
        return ItemDtolist;
    }

    @Override
    public List<String> getAllItemsid() throws NotFoundException {
        return itemDAO.findItemIdList();
    }
}
