package Dio.Credit.Application.System.DTO

import Dio.Credit.Application.System.Entity.Address
import Dio.Credit.Application.System.Entity.Costumer
import java.math.BigDecimal

data class CostumerDTO (
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val password: String,
    val zipCode: String,
    val street: String
){
    fun toEntity(): Costumer = Costumer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )

}

