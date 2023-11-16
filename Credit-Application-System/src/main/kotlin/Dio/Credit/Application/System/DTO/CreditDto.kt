package Dio.Credit.Application.System.DTO

import Dio.Credit.Application.System.Entity.Costumer
import Dio.Credit.Application.System.Entity.Credit
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto (
    val creditValue:BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments:Int,
    val costumerId:Long
){
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        costumer = Costumer(id = this.costumerId)
    )
}