package tech.rishit.makecode_android

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mahfa.dnswitch.DayNightSwitch

class MainActivity : AppCompatActivity() {

    private lateinit var dayNightSwitch: DayNightSwitch
    private lateinit var backgroundView: View
    private lateinit var myWebView: WebView
    private lateinit var github: FloatingActionButton
    private lateinit var projectName: TextView
    private lateinit var footer: TextView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dayNightSwitch = findViewById(R.id.dayNight)
        backgroundView = findViewById(R.id.background_view)
        myWebView = findViewById(R.id.webview)
        github = findViewById(R.id.github)
        projectName = findViewById(R.id.project_name)
        footer = findViewById(R.id.footer)

        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.domStorageEnabled = true
        myWebView.webViewClient = WebViewClient()

        myWebView.loadUrl("https://arcade.makecode.com/---codeembed#pub:S78527-42633-44120-54871")

        dayNightSwitch.setDuration(450)

        dayNightSwitch.setListener { is_night ->
            if (is_night) {
                Toast.makeText(this@MainActivity, "Night Mode!", Toast.LENGTH_SHORT).show()
                projectName.setTextColor(Color.WHITE)
                footer.setTextColor(Color.WHITE)
                backgroundView.alpha = 1f
            } else {
                Toast.makeText(this@MainActivity, "Day Mode!", Toast.LENGTH_SHORT).show()
                projectName.setTextColor(Color.DKGRAY)
                footer.setTextColor(Color.DKGRAY)
                backgroundView.alpha = 0f
            }
        }

        github.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.github_project_url))
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.author_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.credits) {
            val intent = Intent(this, Credits::class.java)
            startActivity(intent)
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}
