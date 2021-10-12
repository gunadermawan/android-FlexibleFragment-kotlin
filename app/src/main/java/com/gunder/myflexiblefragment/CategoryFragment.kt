package com.gunder.myflexiblefragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit

class CategoryFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnDetailCategory: Button = view.findViewById(R.id.btn_detail_category)
        btnDetailCategory.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_detail_category) {
            val mDetailCategoriFragment = DetailCategoryFragment()

//            mengirmkan data dengan objek bundle
            val mBundle = Bundle()
            mBundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            mDetailCategoriFragment.arguments = mBundle
//            mengirimkan data dengan setrer dan getter
            val description = "kateogri ini akan berisikan produk-produk lifestyle"
            mDetailCategoriFragment.descripton = description

            val mFragmentManager = parentFragmentManager
            mFragmentManager.commit {
                addToBackStack(null)
                replace(R.id.frame_container, mDetailCategoriFragment, DetailCategoryFragment::class.java.simpleName)
            }
        }
    }
}