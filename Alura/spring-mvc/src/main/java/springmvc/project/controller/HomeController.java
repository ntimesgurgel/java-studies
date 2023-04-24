package springmvc.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springmvc.project.model.OrderStatus;
import springmvc.project.model.ProductOrder;
import springmvc.project.repository.ProductOrderRepository;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ProductOrderRepository productOrderRepository;

    @GetMapping("/home")
    @RequestMapping("/home")
    public ModelAndView home(){

        List<ProductOrder> productOrders = productOrderRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("orders", productOrders);

       return modelAndView;
    }

    @GetMapping("/{status}")
    public ModelAndView status(@PathVariable("status") String status){

        List<ProductOrder> productOrders = productOrderRepository.findByStatus(OrderStatus.valueOf(status.toUpperCase()));
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("orders", productOrders);
        System.out.println(productOrders);
        modelAndView.addObject("status", status);
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }
}
