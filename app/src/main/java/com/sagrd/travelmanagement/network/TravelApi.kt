import com.sagrd.travelmanagement.model.Seguimiento
import retrofit2.http.*
import retrofit2.Call

interface TravelApi {

    @POST("Seguimientos")
    fun postSeguimiento(@Body seguimiento: Seguimiento?) : Call<Seguimiento>
}