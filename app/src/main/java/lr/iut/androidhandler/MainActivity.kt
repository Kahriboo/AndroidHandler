package lr.iut.androidhandler

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var loopMsgDisplayer = Handler(Looper.getMainLooper());

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLoop(view: View) {
        launchLoop();
    }

    override fun onStop() {
        super.onStop()
        stopLoop()
    }

    fun endLoop(view: View) {
        stopLoop()
    }

    fun quitMeLater(view: View) {
        Handler(Looper.getMainLooper()).postDelayed({
            finish();
        }, 3000)
    }

    // ---------  Loop functions ------

    private fun launchLoop() {
        loopMsgDisplayer.postDelayed({
            changeColor()
            launchLoop()
        }, 3000)
    }

    private fun stopLoop() {
        loopMsgDisplayer.removeCallbacksAndMessages(null);
    }

    private fun changeColor() {
        val rnd = Random()
        val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        findViewById<View>(R.id.colorView).setBackgroundColor(color)
    }
}