package tech.rishit.makecode_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var myWebView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = (
            View.SYSTEM_UI_FLAG_FULLSCREEN
            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        )

        setContentView(R.layout.activity_main)

        myWebView = findViewById(R.id.webview)

        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.domStorageEnabled = true
        myWebView.webViewClient = WebViewClient()

        val projectUrl = """
            <div style="position:relative;height:0;padding-bottom:117.6%;overflow:hidden;">
            <iframe style="position:absolute;top:0;left:0;width:100%;height:100%;"
            src="https://arcade.makecode.com/---run?id=S78527-42633-44120-54871"
            allowfullscreen="allowfullscreen"
            sandbox="allow-popups allow-forms allow-scripts allow-same-origin"
            frameborder="0"></iframe>
            </div>
        """.trimIndent()

        myWebView.loadDataWithBaseURL(
            "https://arcade.makecode.com/",
            projectUrl,
            "text/html",
            "UTF-8",
            null
        )
    }
}
