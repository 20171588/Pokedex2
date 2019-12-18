package com.example.pokedex2.View

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.pokedex2.Model.CatchModel
import com.example.pokedex2.Model.Pokemon
import com.example.pokedex2.Presenter.CatchPresenter
import com.example.pokedex2.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_catchit.view.*
import kotlinx.android.synthetic.main.pokecatch.view.*

class CatchAdapter(pokes : ArrayList<Pokemon>, context: Context) : BaseAdapter() {


    var pokes = pokes
    var context = context
    var model = CatchModel()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var picasso = Picasso.get()
        var url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${position+1}.png"

        var inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var pokeview = inflater.inflate(R.layout.pokecatch, null)
        picasso.load(url).into(pokeview.imgpoke)

        pokeview.imgpoke.setOnClickListener {

            var intent = Intent(context,CatchItView::class.java)
            intent.putExtra("url",url)
            intent.putExtra("position",position)
            context.startActivity(intent)

        }

        return pokeview
    }

    override fun getItem(position: Int): Any {
        return pokes[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return pokes.size
    }

}