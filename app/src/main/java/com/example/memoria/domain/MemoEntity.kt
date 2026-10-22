package com.example.memoria.domain

import java.sql.Timestamp

data class MemoEntity(
    val id: Long,
    val projectId: Long,
    val name: String,
    val description: String,
    val status: MemoStatus,
    val startedAt: Timestamp,
    val duration: Timestamp,
    val importance: MemoImportance
)

enum class MemoStatus{
    ACTIVE,
    CLOSING,
    OVERDUE,
}

enum class MemoImportance{
    DEFAULT,
    MEDIUM,
    IMPORTANT,
}