//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import com.excal.projectc.apidata.Phone
//import kotlinx.coroutines.CoroutineScope
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//
//class TopTenPhoneViewModel : ViewModel() {
//    private val _phoneList = MutableLiveData<ArrayList<Phone>>()
//    val phoneList: MutableLiveData<ArrayList<Phone>> = _phoneList
//
//
//
//    // Replace this with your actual network request function
//    private suspend fun yourNetworkRequestFunction(): ArrayList<Phone> {
//        // Perform the network request here and return the data
//        return arrayListOf() // Placeholder
//    }
//}


import android.provider.SyncStateContract.Constants
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.excal.projectc.apidata.Phone
import com.excal.projectc.apidata.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class TopTenPhoneViewModel : ViewModel() {
    private val _phoneList = MutableLiveData<List<Phone>>() // Use List instead of ArrayList for LiveData
    val phoneList = _phoneList

    // Inject the ApiService into the ViewModel
    private val apiService: ApiService = RetrofitClient.apiService// Replace with your Retrofit setup

    // Function to fetch data from the API
    fun fetchDataFromAPI() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = apiService.getPhones() // Replace with your API call
                if (response.code() in 200..299) {
                    val data = response?.body()?: emptyList() // Assuming the response body contains a list of Phone objects
                    if(data!=null){
                        _phoneList.postValue(data) // Update LiveData with the data

                    }

                } else {
                    // Handle API error, e.g., show an error message
                }
            } catch (e: Exception) {
                // Handle network error, e.g., show an error message
            }
        }
    }
}
