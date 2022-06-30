package by.romanovich.mytimer.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import by.romanovich.mytimer.data.ElapsedTimeCalculator
import by.romanovich.mytimer.data.StopwatchStateCalculator
import by.romanovich.mytimer.data.TimestampProviderImpl
import by.romanovich.mytimer.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val timestampProvider = TimestampProviderImpl()
    private lateinit var stopwatchModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        stopwatchModel = MainViewModelFactory(
            stopwatchStateHolder = StopwatchStateHolder(
                StopwatchStateCalculator(
                    timestampProvider,
                    ElapsedTimeCalculator(timestampProvider)
                ),
                ElapsedTimeCalculator(timestampProvider)
            )
        ).create(MainViewModel::class.java)

        stopwatchModel.getLiveData().observe(this) {
            when (it.first) {
                TIMER_1 -> binding.textTime1.text = it.second
                TIMER_2 -> binding.textTime2.text = it.second
            }
        }

        binding.buttonStart1.setOnClickListener {
            stopwatchModel.start(TIMER_1)
        }
        binding.buttonPause1.setOnClickListener {
            stopwatchModel.pause(TIMER_1)
        }
        binding.buttonStop1.setOnClickListener {
            stopwatchModel.stop(TIMER_1)
        }

        binding.buttonStart2.setOnClickListener {
            stopwatchModel.start(TIMER_2)
        }
        binding.buttonPause2.setOnClickListener {
            stopwatchModel.pause(TIMER_2)
        }
        binding.buttonStop2.setOnClickListener { stopwatchModel.stop(TIMER_2) }

    }

    companion object {
        const val TIMER_1 = 1
        const val TIMER_2 = 2
    }
}

