package com.sinyee.bab.fffffrrraaggmemnnts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.sinyee.bab.databinding.FragmentSeeecBinding
import kotlinx.coroutines.delay
import kotlin.random.Random

class SeeecFragment : Fragment() {

    private val names = listOf(
        "Sasha",
        "Grom",
        "Tor",
        "Loki",
        "Bros",
        "Lomo",
    ).shuffled()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        seeecBinding = FragmentSeeecBinding.inflate(inflater, container, false)
        return binding.root
    }

    private var seeecBinding: FragmentSeeecBinding? = null
    private val binding get() = seeecBinding ?: throw RuntimeException("FragmentSeeecBinding = null")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            lifecycleScope.launchWhenCreated {
                val num = Random.nextInt(from = 10, until = 100)
                Toast.makeText(requireContext(), "You team is ${names.random()}.Earned $num points", Toast.LENGTH_SHORT).show()
                delay(2500)
                hkyhykhkykhy()
            }

        } catch (e: Exception){
            efrfrgtgttg5()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        seeecBinding = null
        super.onDestroy()
    }

    private fun efrfrgtgttg5() {
        Toast.makeText(
            requireContext(),
            "Error 999...",
            Toast.LENGTH_SHORT
        ).show()
        hkyhykhkykhy()
    }

    private fun hkyhykhkykhy() {
        requireActivity().onBackPressed()
    }
}