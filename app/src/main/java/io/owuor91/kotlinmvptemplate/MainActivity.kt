package io.owuor91.kotlinmvptemplate

import android.os.Bundle
import io.owuor91.kotlinmvptemplate.ui.activities.BaseActivity

class MainActivity : BaseActivity() {
  
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
  }
  
  override fun dispose() {
    //
  }
}
