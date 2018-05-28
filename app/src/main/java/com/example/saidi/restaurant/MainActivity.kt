package com.example.saidi.restaurant

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        validateButton.setOnClickListener {

            // this = Context
            // deuxième paramètre = Activité à afficher
            val intent = Intent(this, ListActivity::class.java)

            // On demande à Android de démarrer l'activité
            startActivity(intent)

            finish()
        }
    }
}
