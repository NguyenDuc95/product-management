package kevin.example.dto;

import lombok.Data;

@Data
public class ProductInfo {
    private Long id;
    private String code;
    private String name;
    private String description;
}
