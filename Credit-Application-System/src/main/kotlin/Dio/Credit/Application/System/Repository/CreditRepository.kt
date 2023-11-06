package Dio.Credit.Application.System.Repository

import Dio.Credit.Application.System.Entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.*
@Repository
interface CreditRepository: JpaRepository<Credit, Long> {

}