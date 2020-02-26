package com.osamaaftab.onthebeach.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import coil.api.load
import com.osamaaftab.onthebeach.R
import com.osamaaftab.onthebeach.databinding.FragmentGalleryImageBinding
import kotlinx.android.synthetic.main.fragment_gallery_image.*


class ImageFragment : Fragment() {

    lateinit var fragmentImageBinding: FragmentGalleryImageBinding

    companion object {
        @JvmStatic
        fun newInstance(url: String) = ImageFragment().apply {
            arguments = Bundle().apply {
                putString("url", url)
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentImageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_gallery_image, container, false)
        fragmentImageBinding.galleryImage.load(arguments!!.getString("url"))
        return fragmentImageBinding.root
    }
}