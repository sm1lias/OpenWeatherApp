package com.example.openweatherapp.common

import android.content.Context
import android.location.Geocoder
import android.net.ConnectivityManager
import com.example.openweatherapp.domain.model.Coordinates
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


object Utils {

    fun getLatLonFromLocation(context: Context, city: String): Coordinates? {
        val geocoder = Geocoder(context).getFromLocationName(city, 1)
        return if (geocoder.isNotEmpty()) {
            val location = geocoder[0]
            Coordinates(location.latitude, location.longitude)
        } else null
    }

    fun isInternetConnected(context: Context): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetwork != null && cm.getNetworkCapabilities(cm.activeNetwork) != null

    }

    fun <T, V, K> tripleListsToTripleIfSameSize(
        list1: List<T>, list2: List<V>, list3: List<K>
    ): List<Triple<T, V, K>> {
        val list = ArrayList<Triple<T, V, K>>()
        if (list1.size == list2.size && list2.size == list3.size) {
            for (i in list1.indices) {
                list.add(Triple(list1[i], list2[i], list3[i]))
            }
        }
        return list
    }

    fun getCurrentTimeInISO8601(): String {
        val tz: TimeZone = TimeZone.getTimeZone("Africa/Cairo")
        val df: DateFormat =
            SimpleDateFormat("yyyy-MM-dd'T'HH:00") // Quoted "Z" to indicate UTC, no timezone offset
        df.timeZone = tz
        return df.format(Date())
    }

}