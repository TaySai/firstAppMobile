package com.example.saidi.restaurant

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import com.example.saidi.restaurant.Model.Restaurant
import com.example.saidi.restaurant.item.Resto
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        val restos = arrayListOf<Restaurant>()

        restos.add(Restaurant("Quick", 1, "excellent"))
        restos.add(Restaurant("KFC", 3, "excellent"))
        restos.add(Restaurant("BurgerKing", 8, "excellent"))
        restos.add(Restaurant("MacDonalds", 9, "excellent"))
        restos.add(Restaurant("Flunch", 1, "excellent"))
        restos.add(Restaurant("O'Tacos", 8, "excellent"))
        restos.add(Restaurant("Bagel", 2, "excellent"))
        restos.add(Restaurant("Epicurien", 2, "excellent"))
        restos.add(Restaurant("Pataterie", 1, "excellent"))
        restos.add(Restaurant("Courtepaille", 1, "excellent"))
        restos.add(Restaurant("Dellarte", 2, "excellent"))
        restos.add(Restaurant("Paul Bocuse", 6, "excellent"))
        restos.add(Restaurant("Au Bureau", 6, "excellent"))
        restos.add(Restaurant("La sandwicherie", 0, "excellent"))
        restos.add(Restaurant("Kodawari", 1, "excellent"))

        val linearLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)

        restoRecyclerView.layoutManager = linearLayoutManager

        // Plusieurs items = tableau
        val itemAdapter = FastItemAdapter<Resto>()



        for(item in restos) {
            // metro -> MetroItem

            // un item = cellule (rattachée plus tard à une cellule graphique -> VH)
            val ajouteResto = Resto(item)

            itemAdapter.add(ajouteResto)
        }

        restoRecyclerView.adapter = itemAdapter
    }
}
