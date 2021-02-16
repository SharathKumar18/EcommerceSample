package com.target.targetcasestudy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.ui.DealItemFragment
import com.target.targetcasestudy.ui.DealListFragment
import com.target.targetcasestudy.ui.payment.PaymentDialogFragment

class MainActivity : AppCompatActivity(), DealListFragment.OnDealsListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadDealListView()
        addBackStackListener()
    }

    private fun addBackStackListener() {
        supportFragmentManager.addOnBackStackChangedListener {
            val backCount = supportFragmentManager.backStackEntryCount
            if (backCount == 0) supportActionBar?.show()
            else supportActionBar?.hide()
        }
    }

    private fun loadDealListView() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DealListFragment())
            .commit()
    }

    private fun loadDealItemView(id: Int) {
        supportFragmentManager.beginTransaction()
            .add(R.id.container, DealItemFragment.newInstance(id))
            .addToBackStack(DealItemFragment::class.java.name)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.credit_card -> {
                PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
                true
            }
            else -> false
        }
    }

    override fun onDealsClicked(id: Int) {
        loadDealItemView(id)
    }
}
