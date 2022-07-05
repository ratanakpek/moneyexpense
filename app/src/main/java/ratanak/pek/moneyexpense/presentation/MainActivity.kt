package ratanak.pek.moneyexpense.presentation

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ratanak.pek.moneyexpense.R
import ratanak.pek.moneyexpense.databinding.ActivityMainBinding
import ratanak.pek.moneyexpense.experiment.service.ACTION_SERVICE_WITH_BROADCAST
import ratanak.pek.moneyexpense.experiment.service.SampleService
import ratanak.pek.moneyexpense.presentation.ui.home.HomeFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        registerBroadcastReceiver()
    }

    fun registerBroadcastReceiver() {
        val intent = Intent(ACTION_SERVICE_WITH_BROADCAST)
        intent.setClass(this@MainActivity, SampleService::class.java)
        startService(intent)
    }

    var receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent) {
            Toast.makeText(
                this@MainActivity,
                intent.getStringExtra("name"),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onStart() {
        super.onStart()
        LocalBroadcastManager.getInstance(this@MainActivity)
            .registerReceiver(receiver, IntentFilter("BroadCastDemo"))
    }

    override fun onStop() {
        super.onStop()
        LocalBroadcastManager.getInstance(this@MainActivity).unregisterReceiver(receiver)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == HomeFragment.REQUEST_SERVICE_CODE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(
                this,
                "result ${data?.getStringExtra("result")}",
                Toast.LENGTH_SHORT
            ).show()
        }

    }
}

