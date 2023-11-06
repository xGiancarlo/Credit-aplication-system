package Dio.Credit.Application.System.Entity


import Dio.Credit.Application.System.Enummeration.Status
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID
@Entity
@Table(name = "Credito")
data class Credit (
    @Column(nullable = false, unique = true) var creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallments: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne var costumer: Costumer? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null)
