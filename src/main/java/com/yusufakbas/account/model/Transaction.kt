package com.yusufakbas.account.model

import jakarta.persistence.*
import org.hibernate.annotations.GenericGenerator
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Transaction(
    @Id @GeneratedValue(generator = "UUID") @GenericGenerator(
        name = "UUID", strategy = "org.hibernate.id.UUIDGenerator"
    ) val id: String? = null,

    @Enumerated(EnumType.STRING) val transactionType: TransactionType? = TransactionType.INITIAL,

    val amount: BigDecimal? = null,

    val transactionDate: LocalDateTime? = null,

    @ManyToOne(fetch = FetchType.LAZY, optional = false) @JoinColumn(
        name = "account_id", nullable = false
    ) val account: Account? = null
) {
    // Parametresiz default constructor
    constructor() : this(null, TransactionType.INITIAL, null, null, null)

    constructor(amount: BigDecimal, account: Account) : this(
        id = null,
        amount = amount,
        transactionDate = LocalDateTime.now(),
        transactionType = TransactionType.INITIAL,
        account = account
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Transaction

        if (id != other.id) return false
        if (transactionType != other.transactionType) return false
        if (amount != other.amount) return false
        if (transactionDate != other.transactionDate) return false
        if (account != other.account) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id?.hashCode() ?: 0
        result = 31 * result + (transactionType?.hashCode() ?: 0)
        result = 31 * result + (amount?.hashCode() ?: 0)
        result = 31 * result + (transactionDate?.hashCode() ?: 0)
        return result
    }

}

enum class TransactionType {
    INITIAL,
    TRANSFER
}