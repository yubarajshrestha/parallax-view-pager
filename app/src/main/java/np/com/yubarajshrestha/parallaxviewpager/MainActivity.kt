package np.com.yubarajshrestha.parallaxviewpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        val photos = ArrayList<Photos>()

        photos.add(Photos("https://78.media.tumblr.com/e4781cfdeac64331c4aa0f0b63f72d52/tumblr_inline_mqa4s83aC51qz4rgp.jpg"))
        photos.add(Photos("https://www.fashiongonerogue.com/wp-content/uploads/2015/03/flowers-fashion-shoot03.jpg"))
        photos.add(Photos("https://orig00.deviantart.net/f573/f/2015/069/7/2/phuong_my_spring_summer_2015_ii_by_zemotion-d8l1ffx.jpg"))

        /** Setup View Pager **/
        parallaxCarousel.adapter = PagerAdapter(photos, supportFragmentManager)
        parallaxCarousel.setPageTransformer(false, PageTransformer())
        setupPageDivider()
        /** Setup Tab Dots **/
        tab_dots.setupWithViewPager(parallaxCarousel, true)
    }

    private fun setupPageDivider() {

        /** below 3 line of codes will make viewpager vertical white border **/
        val px = Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics))
        parallaxCarousel.pageMargin = px
        parallaxCarousel.setPageMarginDrawable(R.color.divider)

        /** below codes will make viewpager partial visible next/previous screen **/
        /*parallaxCarousel.clipToPadding = false
        parallaxCarousel.setPadding(48, 0, 48, 0)*/
    }
}
