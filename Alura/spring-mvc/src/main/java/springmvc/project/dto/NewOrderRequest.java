package springmvc.project.dto;

import org.hibernate.criterion.Order;
import springmvc.project.model.OrderStatus;
import springmvc.project.model.ProductOrder;

import javax.validation.constraints.NotBlank;

public class NewOrderRequest {
    @NotBlank
    private String productName;
    @NotBlank
    private String productUrl;
    @NotBlank
    private String imageUrl;
    private String description;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductOrder toProductOrder() {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setProductName(productName);
        productOrder.setProductUrl(productUrl);
        productOrder.setImageUrl(imageUrl);
        productOrder.setDescription(description);
        productOrder.setStatus(OrderStatus.WAITING);
        return productOrder;
    }
}
