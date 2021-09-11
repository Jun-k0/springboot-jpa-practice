package jpabook.jpashop.domain.Item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 상속 전략. single_table은 한 테이블에, table_per_class는 각각 테이블 만듬
@DiscriminatorColumn(name = "dtype")    // 단일테이블일때 씀. DTYPE을 넣어줘서 구분하는게 명확하대
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items") // 실무에서는 중개 엔티티 만들고 manytomany 안쓴다
    private List<Category> categories = new ArrayList<Category>();
}
