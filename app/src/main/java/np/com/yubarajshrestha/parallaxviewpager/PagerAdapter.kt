package np.com.yubarajshrestha.parallaxviewpager

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class PagerAdapter(private val photos: ArrayList<Photos>, fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return PageFragment.newInstance(position, photos)
    }

    override fun getCount(): Int = photos.size

}