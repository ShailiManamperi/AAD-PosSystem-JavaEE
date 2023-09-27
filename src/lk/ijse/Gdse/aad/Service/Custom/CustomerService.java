package lk.ijse.Gdse.aad.Service.Custom;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Service.SuperService;
import lk.ijse.Gdse.aad.Service.exception.DuplicateException;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService extends SuperService {
    public Boolean saveCustomer(CustomerDto customerDTO) throws DuplicateException;

    public Boolean updateCustomer(CustomerDto customerDTO) throws NotFoundException;

    public CustomerDto searchCustomer(String id) throws NotFoundException;

    public boolean deleteCustomer(String id) throws  NotFoundException;

    public ArrayList<CustomerDto> getAllCustomers() throws NotFoundException;

    public List<String> getAllCustomerId() throws NotFoundException;

}
