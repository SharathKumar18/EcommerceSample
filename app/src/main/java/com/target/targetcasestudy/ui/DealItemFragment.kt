package com.target.targetcasestudy.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso

import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.UIItem
import com.target.targetcasestudy.data.dealsdetail.DealDetailResponse
import com.target.targetcasestudy.data.repository.ViewModelRepository
import com.target.targetcasestudy.util.Constants
import com.target.targetcasestudy.util.ViewModelFactory
import com.target.targetcasestudy.viewmodel.DealsDetailViewModel
import kotlinx.android.synthetic.main.fragment_deal_item.*

private const val ARG_ID = "id"

class DealItemFragment : Fragment() {

    private val viewModel: DealsDetailViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(ViewModelRepository.provideDealsDetailViewModel())
        ).get(DealsDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            it.getInt(ARG_ID).let {
                viewModel.loadDetails(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_deal_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDataObservers()
    }

    private fun setDataObservers() {
        viewModel.detailLiveData.observe(this, Observer {
            setUpViews(it)
        })

        viewModel.defaultUiLiveData.observe(this, Observer {
            handleProgressCallbacks(it)
        })
    }

    private fun setUpViews(it: DealDetailResponse) {
        deal_price.text=it.regularPrice?.displayString
        deal_offer_price.text="Reg: " + it.salePrice?.displayString
        deal_title.text=it.title
        deal_description.text=it.description

        Picasso.get().load(it.imageUrl).placeholder(R.drawable.ic_launcher_background).into(deal_image)

    }

    private fun handleProgressCallbacks(uiHelper: UIItem) {
        when (uiHelper.status) {
            Constants.SHOW_PROGRESS -> progress_bar.visibility = View.VISIBLE

            Constants.HIDE_PROGRESS -> progress_bar.visibility = View.GONE
        }
    }
    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            DealItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ID, param1)
                }
            }
    }
}
