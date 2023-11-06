package Dio.Credit.Application.System.Service.Impl

import Dio.Credit.Application.System.Entity.Credit
import Dio.Credit.Application.System.Repository.CreditRepository
import Dio.Credit.Application.System.Service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val costumerService: CostumerService
): ICreditService {

    override fun save(credit: Credit): Credit {
        credit.apply {
            costumer = costumerService.findById(credit.costumer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCostumer(costumerId: Long): List<Credit> =
        this.creditRepository.findAllByCostumer(costumerId)


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw Exception("Creditcode $creditCode not found"))
        return if (credit.costumer?.id == customerId) credit
        else throw IllegalArgumentException("Contact admin")
    }
}