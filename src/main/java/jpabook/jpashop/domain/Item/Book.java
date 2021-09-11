package jpabook.jpashop.domain.Item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B")    // 설정안하면 dtype에 클래스 이름(Book)으로 들어감
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
