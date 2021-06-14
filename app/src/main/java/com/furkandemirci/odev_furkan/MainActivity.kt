package com.furkandemirci.odev_furkan

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var context : Context = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (checkConnection(context)){
            Toast.makeText(this, "Internet is Connected" ,Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Internet is not Connected",Toast.LENGTH_LONG).show()
        }
    }


    fun checkConnection(context: Context) : Boolean{
        val connectivityManager :ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE)as ConnectivityManager

    val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Inflater
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu,menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about) {
            //AboutActivity
            val intent = Intent(applicationContext, AboutMe::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }

}