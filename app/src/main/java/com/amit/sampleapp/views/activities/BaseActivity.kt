package com.amit.sampleapp.views.activities

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amit.sampleapp.R
import com.amit.sampleapp.SampleApp
import com.google.android.material.snackbar.Snackbar
import com.zl.reik.dilatingdotsprogressbar.DilatingDotsProgressBar

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SampleApp.setAppContext(this)
    }

    override fun onRestart() {
        super.onRestart()
        SampleApp.setAppContext(this)
    }

    override fun onResume() {
        super.onResume()
        SampleApp.setAppContext(this)
    }

    fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

    fun customSnackBar(containerLayout: View, context: Context, message: String?) {
        // Create the Snackbar
        val snackbar = Snackbar.make(containerLayout, "", Snackbar.LENGTH_LONG)
        // Get the Snackbar's layout view
        val layout = snackbar.view as Snackbar.SnackbarLayout
        // Hide the text
        val textView =
            layout.findViewById(com.google.android.material.R.id.snackbar_text) as TextView
        textView.visibility = View.INVISIBLE
        val layoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        // Inflate our custom view
        val snackView = layoutInflater.inflate(R.layout.custom_snack_bar_view, null)
        // Configure the view
        /*val imageView = snackView.findViewById(R.id.image) as ImageView
        imageView.setImageBitmap(image)*/
        val textViewTop = snackView.findViewById(R.id.tv_sanck_title) as TextView
        textViewTop.setText(message)
        //textViewTop.setTextColor(Color.WHITE)

        //If the view is not covering the whole snackbar layout, add this line
        layout.setPadding(0, 0, 0, 0)

        // Add the view to the Snackbar's layout
        layout.addView(snackView, 0)
        // Show the Snackbar
        snackbar.show()
    }

    fun showHideProgressBar(viewProgress: DilatingDotsProgressBar, progressStatus: Boolean) {
        if (progressStatus) {
            viewProgress.showNow()
            getWindow()?.setFlags(
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            )
        } else {
            viewProgress.hideNow()
            getWindow()?.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
        }
    }
}