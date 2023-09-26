package lk.ijse.Gdse.aad.Service.Custom.Impl;

import lk.ijse.Gdse.aad.Dao.Custom.CustomerDAO;
import lk.ijse.Gdse.aad.Dao.DaoFactory;
import lk.ijse.Gdse.aad.Dao.DaoTypes;
import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Entity.Customer;
import lk.ijse.Gdse.aad.Service.Custom.CustomerService;
import lk.ijse.Gdse.aad.Service.exception.DuplicateException;
import lk.ijse.Gdse.aad.Service.exception.NotFoundException;
import lk.ijse.Gdse.aad.Util.Converter;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    private final Converter converter;
    private final CustomerDAO customerDAO;

    public CustomerServiceImpl() {
        converter = new Converter();
        customerDAO = DaoFactory.getInstance().getDAO(DaoTypes.CUSTOMER);

    }
    @Override
    public Boolean saveCustomer(CustomerDto customerDTO) throws DuplicateException {
        boolean flag = false;
        if (customerDAO.existByPk(customerDTO.getCustid())) {
            return flag;
        } else {
            flag = customerDAO.save(converter.toCustomer(customerDTO));
        }
        return flag;
    }

    @Override
    public Boolean updateCustomer(CustomerDto customerDTO) throws NotFoundException {
        if (!customerDAO.existByPk(customerDTO.getCustid())) {
            throw new NotFoundException("Customer not found!");
        } else {
            customerDAO.update(converter.toCustomer(customerDTO));
            return true;
        }
    }

    @Override
    public CustomerDto searchCustomer(String id) throws NotFoundException {
        return converter.fromCustomer(customerDAO.findByPk(id));
    }

    @Override
    public boolean deleteCustomer(String id) throws NotFoundException {
        return false;
    }

    @Override
    public ArrayList<CustomerDto> getAllCustomers() throws NotFoundException {
        List<Customer> all = customerDAO.findAll();
        ArrayList<CustomerDto> customerDtoList = new ArrayList<>();
        for (int i = 0; i<all.size(); i++){
            Customer customer = all.get(i);
            customerDtoList.add(i,converter.fromCustomer(customer));
        }
        return customerDtoList;
    }
}
