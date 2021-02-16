package com.target.targetcasestudy.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.UIItem
import com.target.targetcasestudy.data.dealslist.DealListResponse
import com.target.targetcasestudy.data.repository.ViewModelRepository
import com.target.targetcasestudy.util.Constants
import com.target.targetcasestudy.util.DialogUtil
import com.target.targetcasestudy.util.ViewModelFactory
import com.target.targetcasestudy.viewmodel.DealsListViewModel
import kotlinx.android.synthetic.main.fragment_deal_list.*


class DealListFragment : Fragment() {

    private lateinit var adapter: DealItemAdapter
    private var listener:OnDealsListFragmentInteractionListener?=null

    private val viewModel: DealsListViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelFactory(ViewModelRepository.provideDealsListViewModel())
        ).get(DealsListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_deal_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addDataObservers()
        viewModel.loadDeals()
    }

    private fun addDataObservers() {
        viewModel.dealListLiveData.observe(this, Observer {
            if (it?.products != null) {
                loadRecyclerView(it)
            } else {
                context?.let { it1 ->
                    DialogUtil.showAlertDialog(
                        it1,
                        "Deals error",
                        "Failed to fetch deals.Please try again"
                    ) {
                        viewModel.loadDeals()
                    }
                }
            }
        })

        viewModel.defaultUiLiveData.observe(this, Observer {
            handleProgressCallbacks(it)
        })
    }

    private fun handleProgressCallbacks(uiHelper: UIItem) {
        when (uiHelper.status) {
            Constants.SHOW_PROGRESS -> progress_bar.visibility = View.VISIBLE

            Constants.HIDE_PROGRESS -> progress_bar.visibility = View.GONE
        }
    }

    private fun loadRecyclerView(data: DealListResponse) {
        if (this::adapter.isInitialized) {
            adapter.updateItems(data)
        } else {
            val layoutManager=LinearLayoutManager(requireContext())
            adapter = DealItemAdapter(data) {
                listener?.onDealsClicked(it)
            }
            recycler_view.layoutManager = layoutManager
            recycler_view.adapter = adapter
            val dividerItemDecoration = DividerItemDecoration(
                recycler_view.context,
                layoutManager.orientation
            )
            recycler_view.addItemDecoration(dividerItemDecoration)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnDealsListFragmentInteractionListener) {
            listener = context
        }
    }

    override fun onDetach() {
        listener=null
        super.onDetach()
    }

    interface OnDealsListFragmentInteractionListener {
        fun onDealsClicked(id:Int)
    }
}
