package com.example.counterfitx.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.counterfitx.databinding.FragmentTrainBinding
import com.example.counterfitx.ui.TrainFragmentDirections
import kotlin.properties.Delegates


class TrainFragment: Fragment() {

    private lateinit var binding: FragmentTrainBinding
    var counter by Delegates.notNull<Int>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTrainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO code counter decrement
        counter = requireArguments().getInt("counter")
        if(savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter1")
        }
        binding.counterText.text = counter.toString()

        binding.pushButton.setOnClickListener {
            counter--
            binding.counterText.text = counter.toString()

            if(counter == 0) {
                findNavController().navigate(TrainFragmentDirections.actionTrainFragmentToEndFragment())
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter1", counter)
    }
}