package com.gunder.myflexiblefragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = supportFragmentManager
        val mHomeFragment = HomeFragment()
        val fragment = mFragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragment !is HomeFragment) {
            Log.d("MyFlexibleFragment", "Fragment name :" + HomeFragment::class.java.simpleName)
            mFragmentManager
//                    .beginTransaction() untuk memulai proses perubahan.
                .beginTransaction()
//                    Metode add() akan menambahkan objek fragment ke dalam layout container
                .add(R.id.frame_container, mHomeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }

    }
}