
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.test.core.app.launchActivity
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.example.restaurantreservationjetpackcompose.MainActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
@MediumTest
class ExampleInstrumentedTest {
    // Create a mock ConnectivityManager object
    private val connectivityManager: ConnectivityManager = mock(ConnectivityManager::class.java)

    @get:Rule
    val hiltRule = HiltAndroidRule(this)
    @Before
    fun setUp() {
        // Configure the mock object to return a specific value when the `getActiveNetworkInfo()` function is called
        val activeNetwork: NetworkInfo = mock(NetworkInfo::class.java)
        `when`(activeNetwork.isConnected).thenReturn(true)
        `when`(connectivityManager.activeNetworkInfo).thenReturn(activeNetwork)
    }

    @Test
    fun testUI() {
        // Launch the activity
        val scenario = launchActivity<MainActivity>()

        // Verify that the UI looks as expected
        scenario.onActivity { activity ->

        }

        // Close the activity
        scenario.close()
    }
}
