package lk.ijse.Gdse.aad.Controller;

import lk.ijse.Gdse.aad.Dto.ItemDto;
import lk.ijse.Gdse.aad.Dto.OrderDto;
import lk.ijse.Gdse.aad.Service.Custom.ItemService;
import lk.ijse.Gdse.aad.Service.Custom.OrderService;
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
@WebServlet(urlPatterns = "/orders")
public class OrderServlet extends HttpServlet {
    public OrderService orderService = ServiceFactory.getInstance().getService(ServiceTypes.ORDER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        JsonArrayBuilder orders  = Json.createArrayBuilder();
        PrintWriter writer = resp.getWriter();
        ArrayList<OrderDto> allOrders = orderService.getAllOrders();
        for (OrderDto orderDto : allOrders) {
            JsonObjectBuilder order = Json.createObjectBuilder();
            order.add("id", orderDto.getO_id());
            order.add("cid", orderDto.getC_id());
            order.add("date", orderDto.getDate());
            order.add("total", orderDto.getTotal());
            order.add("discount", orderDto.getDiscount());
            order.add("subtotal", orderDto.getSubtotal());
            orders.add(order.build());
        }
        JsonObjectBuilder response = Json.createObjectBuilder();
        response.add("status", "200");
        response.add("message", "Sucessfully get all orders");
        response.add("data", orders.build());
        writer.print(response.build());
    }
}
