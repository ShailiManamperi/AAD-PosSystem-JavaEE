package lk.ijse.Gdse.aad.Controller;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Service.Custom.CustomerService;
import lk.ijse.Gdse.aad.Service.Custom.ItemService;
import lk.ijse.Gdse.aad.Service.ServiceFactory;
import lk.ijse.Gdse.aad.Service.ServiceTypes;
import lk.ijse.Gdse.aad.Util.CRUDUtil;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
@WebServlet(urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    public CustomerService customerService = ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonArrayBuilder customers  = Json.createArrayBuilder();
        String option = req.getParameter("option");
        PrintWriter writer = resp.getWriter();
        switch (option){
            case "GETALL":
                ArrayList<CustomerDto> allCustomers = customerService.getAllCustomers();
                for (CustomerDto customerDto: allCustomers) {
                    JsonObjectBuilder customer = Json.createObjectBuilder();
                    customer.add("id",customerDto.getCustid());
                    customer.add("name",customerDto.getCustname());
                    customer.add("address",customerDto.getCustaddress());
                    customer.add("contact",customerDto.getCustcontact());
                    customers.add(customer.build());
                }
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status","200");
                response.add("message" ,"Sucessfully get all customers");
                response.add("data",customers.build());
                writer.print(response.build());
                break;
            case "SEARCH":
                String cusdID = req.getParameter("CusdID");
                CustomerDto customerDto = customerService.searchCustomer(cusdID);
                JsonObjectBuilder customer1 = Json.createObjectBuilder();
                customer1.add("id",customerDto.getCustid());
                customer1.add("name",customerDto.getCustname());
                customer1.add("address",customerDto.getCustaddress());
                customer1.add("contact",customerDto.getCustcontact());

                JsonObjectBuilder response1 = Json.createObjectBuilder();
                response1.add("status","200");
                response1.add("message" ,"Sucessfully search the customer");
                response1.add("data",customer1.build());
                writer.print(response1.build());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject object = reader.readObject();
        CustomerDto customerDto= new CustomerDto(object.getString("id"),object.getString("name"),object.getString("address"),object.getString("contact"));
        PrintWriter writer= resp.getWriter();
        Boolean saveCustomer = customerService.saveCustomer(customerDto);
        if (saveCustomer){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",200);
            response.add("message" ,"sucessfully added customer");
            response.add("data","");
            writer.print(response.build());
        }else {
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",400);
            response.add("message" ,"something went wrong");
            response.add("data","");
            writer.print(response.build());
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject object = reader.readObject();
        CustomerDto customerDto = new CustomerDto(object.getString("id"),object.getString("name"),object.getString("address"),object.getString("contact"));
        Boolean updated = customerService.updateCustomer(customerDto);
        PrintWriter writer = resp.getWriter();
        if (updated){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",200);
            response.add("message" ,"Sucessfully updated");
            response.add("data","");
            writer.print(response.build());
        }else {
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",400);
            response.add("message" ,"Wrong ID inserted");
            response.add("data","");
            writer.print(response.build());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        String id = req.getParameter("CusdID");
        PrintWriter writer = resp.getWriter();
        boolean deleteCustomer = customerService.deleteCustomer(id);
        if (deleteCustomer){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",200);
            response.add("message" ,"Sucessfully deleted");
            response.add("data","");
            writer.print(response.build());
        }else {
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",400);
            response.add("message" ,"Wrong ID inserted");
            response.add("data","");
            writer.print(response.build());
        }
    }
}
