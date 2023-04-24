package springmvc.project.controller;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springmvc.project.dto.NewOrderRequest;
import springmvc.project.model.ProductOrder;
import springmvc.project.repository.ProductOrderRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("order")
public class OrderController {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @GetMapping("form")
    public String form(NewOrderRequest newOrderRequest){
        return "order/form";
    }

    @PostMapping("newOrder")
    public String newOrder(@Valid NewOrderRequest newOrderRequest, BindingResult result){
        if(result.hasErrors()){
            return "order/form";
        }

        ProductOrder productOrder = newOrderRequest.toProductOrder();
        productOrderRepository.save(productOrder);

        return "redirect:/home";
    }
}
