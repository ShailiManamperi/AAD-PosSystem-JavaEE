package lk.ijse.Gdse.aad.Service.Custom;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Service.SuperService;
import lk.ijse.Gdse.aad.Service.exception.DuplicateException;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;

import java.util.ArrayList;

public interface ItemService extends SuperService {
    public Boolean saveItem(ItemDto itemDto) throws DuplicateException;

    public Boolean updateItem(ItemDto itemDto) throws NotFoundException;

    public ItemDto searchItem(String id) throws NotFoundException;

    public boolean deleteItem(String id) throws  NotFoundException;

    public ArrayList<ItemDto> getAllItems() throws NotFoundException;
}
