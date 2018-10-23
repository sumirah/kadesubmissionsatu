package id.go.lombokbaratkab.sumirah.sumirahsubmissionsatu

import android.graphics.Typeface
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import org.jetbrains.anko.*

class DetailItem : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var itemName = intent.getStringExtra("name")
        var itemImage = intent.getIntExtra("image",0)
        var itemDesc = intent.getStringExtra("desc")

        val detailItem = DetailItemUI()
        detailItem.setContentView(this)

        verticalLayout{
            gravity = Gravity.CENTER_HORIZONTAL

            imageView(itemImage){}
                    .lparams(width = 400, height = 400) {
                        padding = dip(15)
                    }

            textView(itemName){
                textSize = 15f
                gravity = Gravity.CENTER_HORIZONTAL
                typeface = Typeface.DEFAULT_BOLD
            }.lparams(width = wrapContent, height = wrapContent){
                        topMargin = dip(30)
                    }

            textView(itemDesc){
                gravity = Gravity.CENTER_HORIZONTAL
                typeface = Typeface.SANS_SERIF
            }.lparams(width = matchParent, height = wrapContent){
                    }

        }

    }

    class DetailItemUI() : AnkoComponent<DetailItem>{

        override fun createView(ui: AnkoContext<DetailItem>) = with(ui) {
            verticalLayout{
                gravity = Gravity.CENTER_HORIZONTAL
            }
        }

    }
}
