package com.example.saidi.restaurant.item

import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView
import com.example.saidi.restaurant.Model.Restaurant
import com.example.saidi.restaurant.R
import com.mikepenz.fastadapter.FastAdapter
import com.mikepenz.fastadapter.items.AbstractItem

class Resto(val metro: Restaurant): AbstractItem<Resto, Resto.RestoVIewHolder>() {

    override fun getType(): Int {
        return R.id.nomRestoTextView
    }

    // v = layout chargé à partir de la méthode getLayoutRes()
    // donc v = layout chargé à partir de res/layout/cell_metro.xml
    override fun getViewHolder(v: View?): RestoVIewHolder {
        return RestoVIewHolder(v)
    }

    override fun getLayoutRes(): Int {
        // On retourne la référence au layout de la cellule à charger
        return R.layout.cell_resto
    }

    // Il sera créé environ 10 RestoVIewHolder (car recyclé)
    // Classe UI liée à notre cellule graphique
    class RestoVIewHolder : FastAdapter.ViewHolder<Resto> {

        var nomRestoTextView: TextView? = null
        var distanceRestoTextView: TextView? = null
        var noteRestoTextView: TextView? = null

        // itemView = vue chargée à partir de res/layout/cell_metro.xml
        constructor(itemView: View?) : super(itemView) {
            // On va récupérer les composants de notre cellule

            nomRestoTextView = itemView?.findViewById(R.id.nomRestoTextView)
            distanceRestoTextView = itemView?.findViewById(R.id.distanceRestoTextView)
            noteRestoTextView =
                    itemView?.findViewById(R.id.noteRestoTextView)

        }

        // recyclage -> nettoyage de la cellule, avant une ré-utilisation future
        override fun unbindView(item: Resto?) {
            nomRestoTextView?.text = null
            distanceRestoTextView?.text = null
            noteRestoTextView?.text = null
        }

        // refresh UI: la cellule va être affichée.
        // Au boulot : faut que ça brille !
        override fun bindView(item: Resto?, payloads: MutableList<Any>?) {
            val metro = item?.metro

            if(metro is Restaurant) {
                nomRestoTextView?.text = metro.name

                // On applique la couleur de fond
                distanceRestoTextView?.text = metro.distance.toString()
                noteRestoTextView?.text = metro.note
            }
        }

    }

}