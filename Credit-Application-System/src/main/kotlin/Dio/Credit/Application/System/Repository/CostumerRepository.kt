package Dio.Credit.Application.System.Repository

import Dio.Credit.Application.System.Entity.Costumer
import Dio.Credit.Application.System.Entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CostumerRepository: JpaRepository<Costumer, Long> {
}