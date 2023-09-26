package lk.ijse.Gdse.aad.Dao;

import lk.ijse.Gdse.aad.Dao.Custom.Impl.*;


public class DaoFactory {

    private static DaoFactory daoFactory ;
    private DaoFactory() {
    }

    public static DaoFactory getInstance(){
        return daoFactory==null?(daoFactory=new DaoFactory()):daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DaoTypes daoType) {
        switch (daoType){
            case CUSTOMER:
                return (T)new CustomerDaoImpl();
            case ITEM:
                return (T)new itemDAOImpl();
            default:
                return null;

        }

    }
}
