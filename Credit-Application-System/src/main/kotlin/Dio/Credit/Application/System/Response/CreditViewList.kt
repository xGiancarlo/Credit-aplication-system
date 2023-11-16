package Dio.Credit.Application.System.Response

import Dio.Credit.Application.System.Entity.Credit
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditViewList(
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val numberOfInstallments:Int,
) {
    constructor(credit: Credit): this(
    creditCode = credit.creditCode,
    creditValue = credit.creditValue,
    numberOfInstallments = credit.numberOfInstallments

    )
}
