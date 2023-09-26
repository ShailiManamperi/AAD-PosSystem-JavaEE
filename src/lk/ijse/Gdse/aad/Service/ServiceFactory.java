package lk.ijse.Gdse.aad.Service;


import lk.ijse.Gdse.aad.Service.Custom.Impl.CustomerServiceImpl;
import lk.ijse.Gdse.aad.Service.Custom.Impl.ItemServiceImpl;
import lk.ijse.Gdse.aad.Service.Custom.Impl.OrderDetailServiceImpl;
import lk.ijse.Gdse.aad.Service.Custom.Impl.OrderServiceImpl;

public class ServiceFactory {

    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance(){
        return serviceFactory==null?(serviceFactory=new ServiceFactory()):serviceFactory;
    }

    public <T extends SuperService> T getService(ServiceTypes serviceTypes){
        switch (serviceTypes){
            case CUSTOMER:
                return (T)new CustomerServiceImpl();
            case ORDER:
                return (T) new OrderServiceImpl();
            case ITEM:
                return (T) new ItemServiceImpl();
            case ORDERDETAIL:
                return (T) new OrderDetailServiceImpl();
            default:
                return null;
        }
    }

}
