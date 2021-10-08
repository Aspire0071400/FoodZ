package com.andro.foodz.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.andro.foodz.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    lateinit var fragmentcategory : FragmentCategoryBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?
    ): View {
        fragmentcategory = FragmentCategoryBinding.inflate(inflater)
        fragmentcategory.mainCourseImg.setOnClickListener {
            //(activity as MainPage).change(MainCourse())
        }

        fragmentcategory.drinksImg.setOnClickListener {
            //(activity as MainPage).change(Drinks())
        }

        fragmentcategory.fastFoodImg.setOnClickListener {
           // (activity as MainPage).change(FastFood())
        }

        fragmentcategory.sweetsImg.setOnClickListener {
           // (activity as MainPage).change(Sweets())
        }

        fragmentcategory.mainCourse.setOnClickListener {
            //(activity as MainPage).change(MainCourse())
        }

        fragmentcategory.drinks.setOnClickListener {
            //(activity as MainPage).change(Drinks())
        }

        fragmentcategory.fastFood.setOnClickListener {
          //  (activity as MainPage).change(FastFood())
        }

        fragmentcategory.sweets.setOnClickListener {
           // (activity as MainPage).change(Sweets())
        }


        return fragmentcategory.root
    }
}