package Dio.Credit.Application.System.Entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
 class Address {
    @Column(nullable = false)var zipcode: String = ""
    @Column(nullable = false)var street: String = ""

}
