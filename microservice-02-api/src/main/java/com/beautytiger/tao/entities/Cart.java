package com.beautytiger.tao.entities;

import java.io.Serializable;
import java.util.Date;

public class Cart implements Serializable {
    private Long id;
    private Long userId;
    private Long productId;
    private Long status;
    private Date createAt;

    public Cart() {
    }

    public Cart(Long productId) {
        this.productId = productId;
    }

    public Cart(Long userId, Long productId) {
        this.userId = userId;
        this.productId = productId;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
