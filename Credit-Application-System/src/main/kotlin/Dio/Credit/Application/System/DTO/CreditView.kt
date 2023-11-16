package Dio.Credit.Application.System.DTO

import Dio.Credit.Application.System.Entity.Credit
import Dio.Credit.Application.System.Enummeration.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments:Int,
    val status: Status,
    val emailCostumer: String?,
    val incomeCostumer: BigDecimal?
    ) {
    constructor(credit: Credit):this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallments = credit.numberOfInstallments,
        status = credit.status,
        emailCostumer = credit.costumer?.email,
        incomeCostumer = credit.costumer?.income

    )
}
