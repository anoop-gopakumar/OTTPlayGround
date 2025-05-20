package com.example.myapplication.widget

import android.content.Context
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.Dimension
import com.example.myapplication.R

class PieChart(context: Context, attrs: AttributeSet) : View(context, attrs) {

    var mShowText: Boolean
    var textPos: Int
    var paint: Paint

    private val data = mutableListOf<Item>() // A list of items that are displayed.

    private var shadowBounds = RectF()       // Calculated in onSizeChanged.
    private var pointerRadius: Float = 2f    // Obtained from styled attributes.
    private var pointerX: Float = 0f         // Calculated in onSizeChanged.
    private var pointerY: Float = 0f         // Calculated in onSizeChanged.
    private var textX: Float = 400f            // Calculated in onSizeChanged.
    private var textY: Float = 700f            // Calculated in onSizeChanged.
    private var bounds = RectF()             // Calculated in onSizeChanged.
    private var currentItem: Int = 0         // The index of the currently selected item.

    @Dimension
    private var textHeight = 100f// Obtained from style attributes.
    private var textWidth = 100f// Obtained from style attributes.

    private val textPaint = Paint(ANTI_ALIAS_FLAG).apply {

        textSize = textHeight

    }

    private val piePaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = resources.getColor(R.color.teal_700)
        textSize = 0f
        isDither = true
    }

    private val shadowPaint = Paint(0).apply {
        color = 0x101010
        maskFilter = BlurMaskFilter(8f, BlurMaskFilter.Blur.NORMAL)
    }


    init {
        context.theme.obtainStyledAttributes(
            attrs,
            R.styleable.PieChart,
            0, 0
        ).apply {
            try {
                mShowText = getBoolean(R.styleable.PieChart_showText, false)
                textPos = getInteger(R.styleable.PieChart_labelPosition, 0)
                paint = Paint()
            } finally {
                recycle()
            }
        }

        shadowBounds.top = 400f;
        shadowBounds.left = 800f
        shadowBounds.right = 500f


        val shader = android.graphics.Shader().apply {

        }

        data.add(Item("hello", 20f, resources.getColor(R.color.teal_700), 30f, 30f, shader))
        data.add(Item("hello2", 20f, resources.getColor(R.color.teal_700), 30f, 30f, shader))
        data.add(Item("hello3", 20f, resources.getColor(R.color.teal_700), 30f, 30f, shader))

    }


    fun isShowText(): Boolean {
        return mShowText
    }

    fun setShowText(showText: Boolean) {
        mShowText = showText
        invalidate()
        requestLayout()
    }

    override fun onDraw(canvas: Canvas) {
        //super.onDraw(canvas)

        canvas.drawOval(shadowBounds, piePaint)

        data.forEach {
            canvas.drawText(it.label, textX, textY, textPaint)
            textY += 110 // Increments the y position to display properly...
        }

        //canvas.drawText(data[currentItem].label, textX, textY, textPaint)

        canvas.drawLine(200f, 100f, 200f, 400f, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        // Account for padding.
        var xpad = (paddingLeft + paddingRight).toFloat()
        val ypad = (paddingTop + paddingBottom).toFloat()

        // Account for the label.
        if (isShowText()) xpad += textWidth.toFloat()
        val ww = w.toFloat() - xpad
        val hh = h.toFloat() - ypad

        // Figure out how big you can make the pie.
        val diameter = Math.min(ww, hh)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        // Try for a width based on your minimum.
        val minw: Int = paddingLeft + paddingRight + suggestedMinimumWidth
        val w: Int = View.resolveSizeAndState(minw, widthMeasureSpec, 1)

        // Whatever the width is, ask for a height that lets the pie get as big as
        // it can.
        val minh: Int = View.MeasureSpec.getSize(w) - textWidth.toInt() + paddingBottom + paddingTop
        val h: Int = View.resolveSizeAndState(minh, heightMeasureSpec, 0)

        setMeasuredDimension(w, h)
    }

    private data class Item(
        var label: String,
        var value: Float = 0f,

        @ColorInt
        var color: Int = 0,

        // Computed values.
        var startAngle: Float = 0f,
        var endAngle: Float = 0f,

        var shader: android.graphics.Shader
    )

}