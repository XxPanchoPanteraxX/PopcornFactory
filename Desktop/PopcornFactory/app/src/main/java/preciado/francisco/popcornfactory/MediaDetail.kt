package preciado.francisco.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_media_detail.*

class MediaDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_detail)

        val bundle = intent.extras

        if (bundle != null) {
            ivMovieImage.setImageResource(bundle.getInt("header"))
            tvMovieName.setText(bundle.getString("title"))
            tvMovieSynopsis.setText(bundle.getString("synopsis"))
        }
    }
}