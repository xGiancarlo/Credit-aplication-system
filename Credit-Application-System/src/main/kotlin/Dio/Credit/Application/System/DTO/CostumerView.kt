package Dio.Credit.Application.System.DTO

import Dio.Credit.Application.System.Entity.Costumer
import java.math.BigDecimal

data class CostumerView(
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipcode: String,
    val street: String
) {
constructor(costumer: Costumer): this(
    firstName = costumer.firstName,
    lastName = costumer.lastName,
    cpf = costumer.cpf,
    income = costumer.income,
    email = costumer.email,
    zipcode = costumer.address.zipCode,
    street = costumer.address.street,

)
}
