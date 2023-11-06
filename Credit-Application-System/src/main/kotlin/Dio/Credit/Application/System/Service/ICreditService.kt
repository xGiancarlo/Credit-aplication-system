package Dio.Credit.Application.System.Service

import Dio.Credit.Application.System.Entity.Credit
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit
    fun findAllByCostumer(costumerId: Long):List<Credit>
    fun findByCreditCode(costumerId:Long,creditCode: UUID): Credit
}