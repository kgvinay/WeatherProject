package com.test.weather.feature.forecast

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.test.weather.R
import com.test.weather.core.extension.inflate
import com.test.weather.feature.forecast.response.ForecastdayItem
import kotlinx.android.synthetic.main.item_forecast.view.*
import javax.inject.Inject
import kotlin.properties.Delegates

class ForecastAdapter
@Inject constructor() : RecyclerView.Adapter<ForecastAdapter.ViewHolder>() {


    internal var collection: List<ForecastdayItem> by Delegates.observable(emptyList()) {
        _, _, _ -> notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(parent.inflate(R.layout.item_forecast))

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) =
            viewHolder.bind(collection[position])

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(forecastdayItem: ForecastdayItem) {
            itemView.tv_forecast_item_day.text = forecastdayItem?.date
            itemView.tv_forecast_item_temp.text = ""+forecastdayItem?.day?.avgtempC+"c"
        }
    }
}