package com.imeepwni.android.criminalintent.app

import android.os.*
import android.support.v4.app.*
import android.support.v7.app.*
import com.imeepwni.android.criminalintent.*

/**
 * Create by guofeng on 2017/7/1.
 */
abstract class SingleFragmentActivity : AppCompatActivity() {

    protected abstract fun createFragment(): Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        supportFragmentManager.run {
            var fragment = findFragmentById(R.id.container)
            if (fragment==null) {
                fragment = createFragment()
                beginTransaction()
                        .add(R.id.container, fragment)
                        .commit()
            }
        }
    }
}