package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.RestaurantId;

import java.util.List;

public class Restaurant extends AggregateRoot<RestaurantId> {
    private final List<Product> products;
    private boolean active;

    private Restaurant(Builder builder) {
        super.setId(builder.restaurantId);
        products = builder.products;
        active = builder.active;
    }


    public boolean isActive() {
        return active;
    }

    public List<Product> getProducts() {
        return products;
    }

    public static final class Builder {
        private RestaurantId restaurantId;
        private final List<Product> products;
        private boolean active;

        private Builder(List<Product> products) {
            this.products = products;
        }

        public static Builder builder(List<Product> products) {
            return new Builder(products);
        }

        public Builder restaurantId(RestaurantId val) {
            restaurantId = val;
            return this;
        }

        public Builder active(boolean val) {
            active = val;
            return this;
        }

        public Restaurant build() {
            return new Restaurant(this);
        }
    }
}
