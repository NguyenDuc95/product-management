package kevin.example.model;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Data
public class PageableInfo {
    private Integer page;
    private Integer pageSize;
    private String sort;
    private String order;

     public Pageable toPageable(){
        return PageRequest.of(page, pageSize, Sort.Direction.fromString(sort.toUpperCase()), order);
     }
     public PageableInfo(Integer page, Integer pageSize, String sort, String order){
         this.setPage(page);
         this.setPageSize(pageSize);
         this.setSort(sort);
         this.setOrder(order);
     }

     @Autowired
     public void setPage(Integer page){
         this.page =  page - 1;
     }
}
