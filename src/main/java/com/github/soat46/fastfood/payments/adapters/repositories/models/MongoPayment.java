package com.github.soat46.fastfood.payments.adapters.repositories.models;

import com.github.soat46.fastfood.payments.core.entities.payment.FastfoodPayment;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collation = "payments")
public class MongoPayment {

    @Id
    @Getter
    public String id;

    public static MongoPayment from(final FastfoodPayment payment) {
        return MongoPayment.builder().id(payment.id()).build();
    }

    public FastfoodPayment toDomain() {
        return FastfoodPayment.builder().id(this.id).build();
    }
}
