package by.romanovich.mytimer.domain

interface TimestampProvider {
    fun getMilliseconds(): Long
}