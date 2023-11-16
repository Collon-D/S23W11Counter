package kr.ac.kumoh.ce.s20190757.s23w11counter.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {  // view model은 singleton 객체이다.
    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun onAdd() {
        _count.value = _count.value!!.plus(1)
    }

    fun onSub() {
        if (_count.value!! > 0)
            _count.value = _count.value!!.minus(1)
    }
}