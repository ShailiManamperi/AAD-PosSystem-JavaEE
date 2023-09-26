package lk.ijse.Gdse.aad.Controller;

import lk.ijse.Gdse.aad.Dto.CustomerDto;
import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Service.Custom.CustomerService;
import lk.ijse.Gdse.aad.Service.Custom.ItemService;
import lk.ijse.Gdse.aad.Service.ServiceFactory;
import lk.ijse.Gdse.aad.Service.ServiceTypes;

import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet(urlPatterns = "/item")
public class ItemServlet extends HttpServlet {

    public ItemService itemService = ServiceFactory.getInstance().getService(ServiceTypes.ITEM);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonArrayBuilder items  = Json.createArrayBuilder();
        String option = req.getParameter("option");
        PrintWriter writer = resp.getWriter();
        switch (option) {
            case "GETALL":
                ArrayList<ItemDto> allItems = itemService.getAllItems();
                for (ItemDto itemDto : allItems) {
                    JsonObjectBuilder item = Json.createObjectBuilder();
                    item.add("id", itemDto.getItemid());
                    item.add("desc", itemDto.getDescription());
                    item.add("unitprice", itemDto.getUnitprice());
                    item.add("qty", itemDto.getQty());
                    items.add(item.build());
                }
                JsonObjectBuilder response = Json.createObjectBuilder();
                response.add("status", "200");
                response.add("message", "Sucessfully get all items");
                response.add("data", items.build());
                writer.print(response.build());
                break;
            case "SEARCH":
                String id = req.getParameter("itemID");
                ItemDto itemDto = itemService.searchItem(id);
                JsonObjectBuilder item = Json.createObjectBuilder();
                item.add("id",itemDto.getItemid());
                item.add("desc",itemDto.getDescription());
                item.add("price",itemDto.getUnitprice());
                item.add("qty",itemDto.getQty());

                JsonObjectBuilder response1 = Json.createObjectBuilder();
                response1.add("status","200");
                response1.add("message" ,"Sucessfully search the item");
                response1.add("data",item.build());
                writer.print(response1.build());
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonReader reader = Json.createReader(req.getReader());
        JsonObject object = reader.readObject();
        ItemDto itemDto = new ItemDto(object.getString("id"), object.getString("desc"),
                Double.parseDouble(object.getString("price")),Integer.parseInt(object.getString("qty")));
        PrintWriter writer= resp.getWriter();
        Boolean saveItem = itemService.saveItem(itemDto);
        if (saveItem){
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status",200);
            response.add("message" ,"sucessfully added item");
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
}
