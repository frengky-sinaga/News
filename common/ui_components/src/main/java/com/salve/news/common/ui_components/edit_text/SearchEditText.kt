package com.salve.news.common.ui_components.edit_text

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.salve.news.common.ui_components.R

internal class SearchEditText : AppCompatEditText, View.OnTouchListener {
    private lateinit var clearImage: Drawable
    private lateinit var searchImage: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun init() {
        clearImage = ContextCompat.getDrawable(context, R.drawable.ic_x) as Drawable
        searchImage = ContextCompat.getDrawable(context, R.drawable.ic_search) as Drawable
        background = ContextCompat.getDrawable(context, R.drawable.background_search_edit_text)
        hideClearButton()
        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                //Do nothing
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().isNotEmpty()) showClearButton() else hideClearButton()
            }

            override fun afterTextChanged(s: Editable) {
                //Do nothing
            }
        })
    }

    private fun showClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(searchImage, null, clearImage, null)
    }

    private fun hideClearButton() {
        setCompoundDrawablesWithIntrinsicBounds(searchImage, null, null, null)
    }

    override fun onTouch(view: View?, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {
            val clearButtonStart: Float
            val clearButtonEnd: Float
            var isClearButtonClicked = false
            when (layoutDirection) {
                View.LAYOUT_DIRECTION_RTL -> {
                    clearButtonEnd = (clearImage.intrinsicWidth + paddingStart).toFloat()
                    when {
                        event.x < clearButtonEnd -> isClearButtonClicked = true
                    }
                }
                else -> {
                    clearButtonStart = (width - paddingEnd - clearImage.intrinsicWidth).toFloat()
                    when {
                        event.x > clearButtonStart -> isClearButtonClicked = true
                    }
                }
            }

            when {
                isClearButtonClicked -> when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        clearImage = ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_x
                        ) as Drawable
                        showClearButton()
                        return true
                    }
                    MotionEvent.ACTION_UP -> {
                        clearImage = ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_x
                        ) as Drawable
                        when {
                            text != null -> text?.clear()
                        }
                        hideClearButton()
                        return true
                    }
                    else -> return false
                }
                else -> return false
            }
        }
        return false
    }
}