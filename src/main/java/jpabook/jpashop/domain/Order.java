package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name="orders")
public class Order {

    @Id @GeneratedValue
    @Column(name="order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    // 지연로딩 LAZY를 사용해서 프록시로 조회해야함 (즉시로딩은 성능 문제가 생길 수 있음)
    // ManyToOne과 OneToOne은 디폴트가 즉시로딩임
    @JoinColumn(name = "member_id")
    // N:1 관계 매핑, 연관관계의 주인은 외래 키가 있는 order (Order.member와 ORDERS.MEMBER_ID 외래 키)
    // 연관관계의 주인만이 외래 키를 관리(등록, 수정, 삭제) 할 수 있음 (성능 면에서도 좋다)
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    // cascade 옵션은 영속성 전이. 엔티티에 상태변화가 생기면 연관된 엔티티의 상태도 변화시켜줌
    private List<OrderItem> orderItems = new ArrayList<>(); // 실제로 필요?

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)    // 1:1 관계의 외래 키는 더 많이 쓰는 쪽에
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // LocalDateTime 클래스로 시간

    @Enumerated(EnumType.STRING)    // EnumType.ORDINAL은 int형
    private OrderStatus status;

}
