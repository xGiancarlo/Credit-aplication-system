package Dio.Credit.Application.System.DTO

import Dio.Credit.Application.System.Entity.Costumer
import java.math.BigDecimal

data class CostumerUpdate (
    val firstName: String,
    val lastName: String,
    val income: BigDecimal,
    val zipCode:String,
    val street: String
){
fun toEntity(costumer: Costumer): Costumer {

    costumer.firstName = this.firstName
    costumer.lastName = this.lastName
    costumer.income = this.income
    costumer.address.zipCode = this.zipCode
    costumer.address.street = this.street
    return costumer
}


}
