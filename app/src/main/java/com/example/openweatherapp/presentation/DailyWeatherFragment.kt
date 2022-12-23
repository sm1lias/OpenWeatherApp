package com.example.openweatherapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.openweatherapp.common.Resource
import com.example.openweatherapp.common.Utils
import com.example.openweatherapp.databinding.FragmentDailyWeatherBinding
import com.jakewharton.rxbinding4.widget.queryTextChanges
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class DailyWeatherFragment : Fragment() {
    private val compositeDisposable = CompositeDisposable()

    private var _binding: FragmentDailyWeatherBinding? = null
    private val viewModel: DailyWeatherFragmentViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentDailyWeatherBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.data.observe(viewLifecycleOwner) { data ->
            when (data) {
                is Resource.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.apply {
                        txtStatus.text = data.data?.weatherPerDay?.status?.get(0) ?: ""
                        txtCurrentTemp.text = data.data?.temperature.toString()
                        progressBar.visibility = View.INVISIBLE
                    }
                }
                is Resource.Error -> {
                    Toast.makeText(requireContext(), data.message, Toast.LENGTH_LONG).show()
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }

        binding.btnSearch
            .queryTextChanges()
            .debounce(500, TimeUnit.MILLISECONDS)
            .filter { chars -> chars.length > 3 }
            .subscribeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { compositeDisposable.add(it) }
            .subscribe { charSequence ->
                val text = charSequence.toString()
                if (text.isNotEmpty() && Utils.isInternetConnected(requireContext())) {
                    Utils.getLatLonFromLocation(requireContext(), text)?.let { coordinates ->
                        viewModel.getWeather(coordinates)
                    }
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        compositeDisposable.clear()
    }
}