package com.beautytiger.tao.entities;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Long productPrice;
    private Date createAt;

    public Order() {
    }

    public Order(Long productId) {
        this.productId = productId;
    }

    public Order(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public Order(Long userId, Long productId, Long productPrice) {
        this.userId = userId;
        this.productId = productId;
        this.productPrice = productPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Long productPrice) {
        this.productPrice = productPrice;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
