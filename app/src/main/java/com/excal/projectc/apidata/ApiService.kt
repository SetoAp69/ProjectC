import com.excal.projectc.apidata.Phone
import com.excal.projectc.ui.PhoneData
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Path

interface ApiService {
    @Headers("X-RapidAPI-Key: 97624199aemsh009b07354c282bcp1a7533jsn1a562aa6aaa0",
        "X-RapidAPI-Host: mobile-phone-specs-database.p.rapidapi.com"   )

    @GET("")
    suspend fun getPhones(): Response<List<Phone>>
}