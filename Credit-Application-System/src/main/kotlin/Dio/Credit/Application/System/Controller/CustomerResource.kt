package Dio.Credit.Application.System.Controller

import Dio.Credit.Application.System.DTO.CostumerDTO
import Dio.Credit.Application.System.DTO.CostumerUpdate
import Dio.Credit.Application.System.DTO.CostumerView
import Dio.Credit.Application.System.Entity.Costumer
import Dio.Credit.Application.System.Service.Impl.CostumerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customer")
class CustomerResource (
    private val costumerService: CostumerService,
) {
    @PostMapping
    fun saveCostumer(@RequestBody costumerDTO: CostumerDTO): ResponseEntity<String> {
        val saveCostumer = this.costumerService.save(costumerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Customer ${saveCostumer.email}saved successfully")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CostumerView>{
        val customer: Costumer = this.costumerService.findById(id)
        return ResponseEntity.status(HttpStatus.OK)
            .body(CostumerView(customer))

    }
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) =
        this.costumerService.delete(id)

    @PatchMapping
    fun updateCostumer(@RequestParam(value = "costumerId") id: Long,
                       @RequestBody costumerUpdate: CostumerUpdate): ResponseEntity<CostumerView>{
       val costumer: Costumer = this.costumerService.findById(id)
        val costumerToUpdate: Costumer = costumerUpdate.toEntity(costumer)
        val costumerUpdated: Costumer = this.costumerService.save(costumerToUpdate)
        return ResponseEntity.status(HttpStatus.OK)
            .body(CostumerView(costumerUpdated))
    }

}