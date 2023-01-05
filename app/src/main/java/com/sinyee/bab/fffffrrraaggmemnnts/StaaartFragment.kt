package com.sinyee.bab.fffffrrraaggmemnnts

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.sinyee.bab.R
import com.sinyee.bab.databinding.FragmentStaaartBinding


class StaaartFragment : Fragment() {
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
        fragmentStaaartBinding = FragmentStaaartBinding.inflate(inflater, container, false)
        return staaartBinding.root
    }

    private var fragmentStaaartBinding: FragmentStaaartBinding? = null
    private val staaartBinding get() = fragmentStaaartBinding ?: throw RuntimeException("FragmentStaaartBinding = null")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            staaartBinding.imgEl1.setOnClickListener {
                gtkgtkgtktg()
            }
            staaartBinding.imgEl2.setOnClickListener {
                gtkgtkgtktg()
            }

        } catch (e: Exception){
            efrfrgtgttg5()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    private fun gtkgtkgtktg() {
        findNavController().navigate(R.id.action_staaartFragment_to_seeecFragment)
    }

    override fun onDestroy() {
        fragmentStaaartBinding = null
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