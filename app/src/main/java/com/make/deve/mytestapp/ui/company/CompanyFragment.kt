package com.make.deve.mytestapp.ui.company

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.make.deve.mytestapp.R
import com.make.deve.mytestapp.databinding.FragmentCompanyBinding
import com.make.deve.mytestapp.databinding.ItemCompanyBinding
import com.make.deve.mytestapp.ui.base.BaseFragment
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class CompanyFragment:BaseFragment() {
    override val showTitle: Boolean
        get() = false

    lateinit var binding: FragmentCompanyBinding
    val vm:CompanyViewModel by viewModels()


    private val adapter = adapterOf<CompanyItem> {
        register(
            viewHolder = ::ViewHolder,
            layoutResource = R.layout.item_company,
            onBindViewHolder = { vh, pos, item ->
                vh.bind(item, pos)
            })
    }

    inner class ViewHolder(view: View) : RecyclerViewHolder<CompanyItem>(view) {
        val binding: ItemCompanyBinding = ItemCompanyBinding.bind(view)
        var item = CompanyItem()

        init {

        }

        fun bind(item: CompanyItem, position: Int) {
            this.item = item
            binding.run {
                name.text = item.title
                address.text = item.overview

                Glide.with(requireContext()).load(item.poster_path)
                    .error(R.drawable.ic_baseline_cancel_24)
                    .into(binding.imglogo)

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompanyBinding.inflate(inflater, container, false)
        binding.items.adapter = adapter

        binding.swipe.setOnRefreshListener {
            binding.swipe.isRefreshing = false
        }

        observeLoading(vm.loading)
        vm.listofCompany.observe(viewLifecycleOwner) {
            it?.let {
                if (it.error == null) {
                    adapter.submitList(it.items)
                    //adapter.notifyDataSetChanged()
                } else {
                    showErrorMessage(it.error)
                }
            }
        }

        vm.getCompanyUser()

        return binding.root
    }
}