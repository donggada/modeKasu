package com.dhs.modeKasu.domain.model.lendItem;

import com.dhs.modeKasu.application.dto.request.LendItemRequest;
import com.dhs.modeKasu.domain.model.BaseTimeEntity;
import com.dhs.modeKasu.domain.model.category.Category;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class LendItem extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    private String season;

    private int price;

    private String image;

    private int discount;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "lenditem_size", joinColumns = @JoinColumn(name = "lenditem_id"))
    @Column(name = "size")
    @BatchSize(size = 10)
    private List<String> size;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "lenditem_color", joinColumns = @JoinColumn(name = "lenditem_id"))
    @Column(name = "color")
    @BatchSize(size = 10)
    private List<String> color;

    public String getCategoryName() {
        return category.getName();
    }


    private LendItem(String brand, String name, Category category, String season, int price, String image, int discount, List<String> size, List<String> color) {
        this.brand = brand;
        this.name = name;
        this.category = category;
        this.season = season;
        this.price = price;
        this.image = image;
        this.discount = discount;
        this.size = size;
        this.color = color;
    }

    public static LendItem createLendItem(LendItemRequest request, Category category) {
        return new LendItem(
                request.brand(), request.name(), category,
                request.season(), request.price(), request.image(),
                request.discount(), request.size(), request.color()
        );
    }
}

