package by.romanovich.mytimer.utils

fun Long.format(): String {
    val millisecondsFormatted = (this % CONVERT_MILLISECONDS).pad(3)
    val seconds = this / CONVERT_MILLISECONDS
    val secondsFormatted = (seconds % CONVERT_SECONDS).pad(2)
    val minutes = seconds / CONVERT_SECONDS
    val minutesFormatted = (minutes % CONVERT_MINUTES).pad(2)
    val hours = minutes / CONVERT_MINUTES
    return if (hours > 0) {
        val hoursFormatted = (minutes / CONVERT_MINUTES).pad(2)
        "$hoursFormatted:$minutesFormatted:$secondsFormatted"
    } else {
        "$minutesFormatted:$secondsFormatted:$millisecondsFormatted"
    }
}

fun Long.pad(desiredLength: Int) = this.toString().padStart(desiredLength, '0')


