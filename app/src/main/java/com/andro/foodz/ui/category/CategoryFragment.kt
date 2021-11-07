package com.andro.foodz.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.MainPage
import com.andro.foodz.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {
    lateinit var fragmentcategory : FragmentCategoryBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {


        return fragmentcategory.root
    }
}