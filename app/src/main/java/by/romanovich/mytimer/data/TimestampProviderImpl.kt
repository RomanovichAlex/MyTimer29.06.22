package by.romanovich.mytimer.data

import by.romanovich.mytimer.domain.TimestampProvider

class TimestampProviderImpl : TimestampProvider {

    override fun getMilliseconds(): Long = System.currentTimeMillis()
}