package com.hafidmust.myflexiblefragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class CategoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory : Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener {
            val mDetailCategoryFragment = DetailCategoryFragment()
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Kesehatan")
            val description = "Kategori ini akan berisi produk-produk kesehatan"

            mDetailCategoryFragment.arguments = mBundle
            mDetailCategoryFragment.description = description

            val mFragmentManager = parentFragmentManager
            mFragmentManager.beginTransaction().apply {
                replace(R.id.frame_container, mDetailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                addToBackStack(null)
                commit()
            }
        }
    }
}