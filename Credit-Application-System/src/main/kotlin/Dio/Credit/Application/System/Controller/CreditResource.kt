package Dio.Credit.Application.System.Controller

import Dio.Credit.Application.System.DTO.CreditDto
import Dio.Credit.Application.System.DTO.CreditView
import Dio.Credit.Application.System.Entity.Credit
import Dio.Credit.Application.System.Response.CreditViewList
import Dio.Credit.Application.System.Service.Impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors


@RestController
@RequestMapping("/api/credits")
class CreditResource (
    private val creditService: CreditService
    ) {
    @PostMapping
    fun saveCredit(@RequestBody creditDto: CreditDto): ResponseEntity<String> {
        val credit: Credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credito ${credit.creditCode} - Costumer ${credit.costumer?.firstName} saved")
    }

    @GetMapping
    fun findByCostumerId(@RequestParam(value = "costumerId") costumerId: Long):
            ResponseEntity<List<CreditViewList>> {
        val creditViewList:List<CreditViewList> = this.creditService.findAllByCostumer(costumerId).stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "costumerId") costumerId: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit: Credit = this.creditService.findByCreditCode(costumerId, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))

    }
}