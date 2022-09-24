package com.make.deve.mytestapp.ui.popularMovies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.make.deve.mytestapp.R
import com.make.deve.mytestapp.databinding.FragmentHomeBinding
import com.make.deve.mytestapp.databinding.ItemHomeBinding
import com.make.deve.mytestapp.ui.base.BaseFragment
import me.ibrahimyilmaz.kiel.adapterOf
import me.ibrahimyilmaz.kiel.core.RecyclerViewHolder

class HomeFragment:BaseFragment() {
    override val showTitle: Boolean
        get() = false

    lateinit var binding: FragmentHomeBinding
    val vm:HomeViewModel by viewModels()


    private val adapter = adapterOf<CompanyItem> {
        register(
            viewHolder = ::ViewHolder,
            layoutResource = R.layout.item_home,
            onBindViewHolder = { vh, pos, item ->
                vh.bind(item, pos)
            })
    }

    inner class ViewHolder(view: View) : RecyclerViewHolder<CompanyItem>(view) {
        val binding: ItemHomeBinding = ItemHomeBinding.bind(view)
        var item = CompanyItem()

        init {

        }

        fun bind(item: CompanyItem, position: Int) {
            this.item = item
            binding.run {
                Glide.with(requireContext()).load("https://image.tmdb.org/t/p/w500/"+item.poster_path)
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
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.items.adapter = adapter

        binding.swipe.setOnRefreshListener {
            binding.swipe.isRefreshing = false
        }

        observeLoading(vm.loading)
        vm.listofPopularMovies.observe(viewLifecycleOwner) {
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