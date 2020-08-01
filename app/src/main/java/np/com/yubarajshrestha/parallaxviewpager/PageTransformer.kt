package np.com.yubarajshrestha.parallaxviewpager

import android.support.v4.view.ViewPager
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class PageTransformer: ViewPager.PageTransformer {

    /**
     * This code makes viewpager parallax
     */
    override fun transformPage(page: View, position: Float) {
        val pageWidth = page.width
        val image = page.findViewById<ImageView>(R.id.image_one)
        val text = page.findViewById<TextView>(R.id.titleText)
        image.translationX = -position * (pageWidth / 2)
        text.translationX = position * (pageWidth / 2)
    }

}