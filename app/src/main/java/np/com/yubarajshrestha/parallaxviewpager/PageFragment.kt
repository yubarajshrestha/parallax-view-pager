package np.com.yubarajshrestha.parallaxviewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class PageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_page, container, false)

        val position = arguments?.getInt("position", 0)
        view.tag = position

        val image = view.findViewById<ImageView>(R.id.image_one)

        Glide.with(this)
                .load(photos[position!!].path)
                .apply(RequestOptions().placeholder(R.drawable.ripple).centerInside())
                .into(image)

        return view;
    }

    companion object {
        var photos = ArrayList<Photos>()
        fun newInstance(position: Int, photos: ArrayList<Photos>): Fragment {
            this.photos = photos
            val bundleArgs = Bundle()
            bundleArgs.putInt("position", position)
            val fragment = PageFragment()
            fragment.arguments = bundleArgs
            return fragment
        }
    }
}
