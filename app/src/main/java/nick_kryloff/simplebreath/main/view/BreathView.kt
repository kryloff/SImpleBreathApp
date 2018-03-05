package nick_kryloff.simplebreath.main.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import nick_kryloff.simplebreath.R

class BreathView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    private var radius: Float = 10f
    private var lineColor: Int = -1
    private var circleColor: Int = -1

    private val paint: Paint = Paint()

    init {
        attrs?.let { initFromAttrs(context, it) }

        initPaint()
    }

    private fun initPaint() {
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        paint.color = circleColor
    }

    private fun initFromAttrs(context: Context, it: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(it, R.styleable.BreathView)
        radius = typedArray.getFloat(R.styleable.BreathView_radius, 10f)
        lineColor = typedArray.getColor(R.styleable.BreathView_line_color, -1)
        circleColor = typedArray.getColor(R.styleable.BreathView_circle_color, -1)

        typedArray.recycle()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle((measuredWidth / 2).toFloat(), (measuredHeight / 2).toFloat(), radius, paint)

    }
}