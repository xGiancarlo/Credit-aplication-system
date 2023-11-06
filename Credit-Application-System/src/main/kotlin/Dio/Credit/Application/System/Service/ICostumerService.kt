package Dio.Credit.Application.System.Service

import Dio.Credit.Application.System.Entity.Costumer
import java.util.*

interface ICostumerService {
    fun save(costumer: Costumer):Costumer
    fun findById(Id: Long):Costumer
    fun delete(Id: Long)



}