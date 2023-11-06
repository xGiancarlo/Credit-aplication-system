package Dio.Credit.Application.System.Service.Impl

import Dio.Credit.Application.System.Entity.Costumer
import Dio.Credit.Application.System.Repository.CostumerRepository
import Dio.Credit.Application.System.Service.ICostumerService
import org.springframework.stereotype.Service

@Service
class CostumerService(
    private val CostumerRepository: CostumerRepository
): ICostumerService {
    override fun save(costumer: Costumer): Costumer =
        this.CostumerRepository.save(costumer)


    override fun findById(id: Long): Costumer =
       this.CostumerRepository.findById(id).orElseThrow{
           throw RuntimeException("Id $id não encontrada")}


    override fun delete(Id: Long)=
        this.CostumerRepository.deleteById(Id)

}