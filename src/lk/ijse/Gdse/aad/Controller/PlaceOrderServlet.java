package lk.ijse.Gdse.aad.Controller;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Service.Custom.CustomerService;
import lk.ijse.Gdse.aad.Service.Custom.ItemService;
import lk.ijse.Gdse.aad.Service.Custom.PlaceOrderService;
import lk.ijse.Gdse.aad.Service.ServiceFactory;
import lk.ijse.Gdse.aad.Service.ServiceTypes;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/placeorder")
public class PlaceOrderServlet extends HttpServlet {
    public PlaceOrderService placeOrderService =ServiceFactory.getInstance().getService(ServiceTypes.PLACEORDER);
    public CustomerService customerService =ServiceFactory.getInstance().getService(ServiceTypes.CUSTOMER);
    public ItemService itemService = ServiceFactory.getInstance().getService(ServiceTypes.ITEM);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonArrayBuilder customers  = Json.createArrayBuilder();
        String option = req.getParameter("option");
        PrintWriter writer = resp.getWriter();
        switch (option){
            case "CUSTOMER":
                List<String> allCustomers = customerService.getAllCustomerId();
                for (String id: allCustomers) {
                    JsonObjectBuilder customer = Json.createObjectBuilder();
                    customer.add("id",id);
                    customers.add(customer.build());
                }
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status","200");
                response.add("message" ,"Sucessfully get all customers");
                response.add("data",customers.build());
                writer.print(response.build());
                break;
            case "ITEM":
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
}
