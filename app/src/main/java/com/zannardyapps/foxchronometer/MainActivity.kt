package com.zannardyapps.foxchronometer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import com.zannardyapps.foxchronometer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var running: Boolean = false
    var pause: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btIniciar.setOnClickListener{
           iniciarCronometro()
        }

        binding.btPausar.setOnClickListener {
            pausarCronometro()
        }

        binding.btZerar.setOnClickListener {
            zerarCronometro()
        }
    }

    private fun iniciarCronometro(){
        if (!running){
            binding.cronometroTempo.base = SystemClock.elapsedRealtime() - pause
            binding.cronometroTempo.start()
            running = true
        }
    }

    private fun pausarCronometro(){
        if (running){
            binding.cronometroTempo.stop()
            pause = SystemClock.elapsedRealtime() - binding.cronometroTempo.base
            running = false
        }
    }

    private fun zerarCronometro(){
        binding.cronometroTempo.base = SystemClock.elapsedRealtime()
        pause = 0
    }
}