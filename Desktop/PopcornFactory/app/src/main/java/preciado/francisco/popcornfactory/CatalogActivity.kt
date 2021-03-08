package preciado.francisco.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_catalog.*
import kotlinx.android.synthetic.main.media_layout.view.*

class CatalogActivity : AppCompatActivity() {
    var moviesAdapter: MediaAdapter? = null
    var seriesAdapter: MediaAdapter? = null
    var lstMovies = ArrayList<Media>()
    var lstSeries = ArrayList<Media>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)

        loadSeries()
        loadMovies()

        seriesAdapter=MediaAdapter(this,lstSeries)
        gvSeries.adapter=seriesAdapter

        moviesAdapter = MediaAdapter(this, lstMovies)
        gvMovies.adapter = moviesAdapter
    }

    private fun loadSeries() {
        lstSeries.add(
            Media(
                "Smallville",
                R.drawable.smallville,
                R.drawable.smallvilleheader,
                getString(R.string.synopsis_smallville)
            )
        )
        lstSeries.add(
            Media(
                "Bones",
                R.drawable.bones,
                R.drawable.bonesheader,
                getString(R.string.synopsis_bones)
            )
        )
        lstSeries.add(
            Media(
                "Dr. House",
                R.drawable.drhouse,
                R.drawable.househeader,
                getString(R.string.synopsis_dr_house)
            )
        )

        lstSeries.add(
            Media(
                "Dr. Who",
                R.drawable.drwho,
                R.drawable.drwhoheader,
                getString(R.string.synopsis_dr_who)
            )
        )
        lstSeries.add(
            Media(
                "Friends",
                R.drawable.friends,
                R.drawable.friendsheader,
                getString(R.string.synopsis_friends)
            )
        )
    }

    private fun loadMovies() {
        
        lstMovies.add(
            Media(
                "Big Hero 6",
                R.drawable.bighero6,
                R.drawable.headerbighero6,
                getString(R.string.synopsis_big_hero_6)
            )
        )
        
        lstMovies.add(
            Media(
                "Inception",
                R.drawable.inception,
                R.drawable.inceptionheader,
                getString(R.string.synopsis_inception)
            )
        )
        lstMovies.add(
            Media(
                "Leap Year",
                R.drawable.leapyear,
                R.drawable.leapyearheader,
                getString(R.string.synopsis_leap_year)
            )
        )
        lstMovies.add(
            Media(
                "Toy Story",
                R.drawable.toystory,
                R.drawable.toystoryheader,
                getString(R.string.synopsis_toy_story)
            )
        )
        
    }
}

class MediaAdapter : BaseAdapter {
    var lstMovies = ArrayList<Media>()
    var context: Context? = null

    constructor(context: Context, lstMovies: ArrayList<Media>) {
        this.context = context
        this.lstMovies = lstMovies
    }

    override fun getCount(): Int {
        return lstMovies.size
    }

    override fun getItem(p0: Int): Any {
        return lstMovies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var movie = lstMovies[p0]
        var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflater.inflate(R.layout.media_layout, null)

        view.ivMovieImage.setImageResource(movie.image)
        view.tvMovieName.setText(movie.title)

        view.ivMovieImage.setOnClickListener {
            var intent = Intent(context, MediaDetail::class.java)

            intent.putExtra("title", movie.title)
            intent.putExtra("image", movie.image)
            intent.putExtra("header", movie.header)
            intent.putExtra("synopsis", movie.synopsis)
            context!!.startActivity(intent)
        }

        return view
    }

}