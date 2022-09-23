package com.make.deve.mytestapp.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.make.deve.mytestapp.ui.main.MainActivity
import com.make.deve.mytestapp.ui.main.MainViewModel
import com.make.deve.mytestapp.ui.util.BaseUIDataError
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

abstract class BaseFragment : Fragment() {

    val TAG = "MAKE"

    protected val svm: MainViewModel by sharedViewModel()

    private val loadingObserver: Observer<Boolean> = Observer<Boolean> {
        svm.loading.value = it
    }

    fun observeLoading(loading: MutableLiveData<Boolean>) {
        loading.observe(viewLifecycleOwner, loadingObserver)
    }

    abstract val showTitle: Boolean
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as? MainActivity)?.toggleTitle(showTitle)

    }

    protected fun showErrorMessage(error: BaseUIDataError?) {
        error?.let {
            val dialog = AlertDialog.Builder(requireContext()).apply {
                setTitle(it.title)
                setMessage(it.message)
                setPositiveButton("Ok", null)
                setCancelable(false)
            }.create()
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }
    }

}