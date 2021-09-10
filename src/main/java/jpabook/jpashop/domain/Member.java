package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id") // 굳이 컬럼 이유?
    private Long id;

    private String name;

    @Embedded   // 내장 타입 사용
    private Address address;

    @OneToMany(mappedBy = "member")
    // 1:N 관계 매핑, 연관관계를 설명하기 위해 회원 엔티티에 추가함. 실제론 주문이 회원을 참조하기만 하기 때문에 필요 없다
    private List<Order> orders = new ArrayList<>();

}