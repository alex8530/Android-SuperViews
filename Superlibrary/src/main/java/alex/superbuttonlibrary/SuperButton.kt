package alex.superbuttonlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.TriangleEdgeTreatment
import com.superbuttonlibrary.R


@SuppressLint("RestrictedApi")
class SuperButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : MaterialButton(context, attrs, defStyleAttr) {

    companion object {
        var Round = CornerFamily.ROUNDED
        var Cut = CornerFamily.CUT

        var Inside =0
        var OutSide =1
    }

    private var materialShapeDrawable: MaterialShapeDrawable

    private var shadowElevation = 0f
    private var shadowcolor = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
    private var fillColor = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
    private var strokeColor = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
    private var strokeWidth = 0f

    private var bottomLeftCornerRadius = 0f
    private var bottomRightCornerRadius = 0f
    private var topLeftCornerRadius = 0f
    private var topRightCornerRadius = 0f

    private var bottomLeftCornerFamily =
        Round
    private var bottomRightCornerFamily =
        Round
    private var topLeftCornerFamily =
        Round
    private var topRightCornerFamily =
        Round


    private var topEdgeRadius = 0f
    private var bottomEdgeRadius = 0f
    private var leftEdgeRadius = 0f
    private var rightEdgeRadius = 0f

    private var topEdgeDirection = 0// 0 means inside ,1 means outside
    private var bottomEdgeDirection = 0// 0 means inside ,1 means outside
    private var leftEdgeDirection = 0// 0 means inside ,1 means outside
    private var rightEdgeDirection = 0// 0 means inside ,1 means outside


    init {
        val attributeSet =
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.SuperButton, 0, 0
            )

        fillColor = attributeSet.getColor(
            R.styleable.SuperButton_alex_fillColor,
            ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
        )
        strokeColor = attributeSet.getColor(
            R.styleable.SuperButton_alex_strokeColor,
            ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
        )
        strokeWidth = attributeSet.getFloat(R.styleable.SuperButton_alex_strokeWidth, 0f)

        //corner radius
        bottomLeftCornerRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomLeftCornerRadius, 0f)
        bottomRightCornerRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomRightCornerRadius, 0f)
        topLeftCornerRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topLeftCornerRadius, 0f)
        topRightCornerRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topRightCornerRadius, 0f)

        //corner family
        bottomLeftCornerFamily =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomLeftCornerFamily,
                Round
            )
        bottomRightCornerFamily =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomRightCornerFamily,
                Round
            )
        topLeftCornerFamily =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topLeftCornerFamily,
                Round
            )
        topRightCornerFamily =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topRightCornerFamily,
                Round
            )

        //shadow
        shadowcolor =
            attributeSet.getColor(
                R.styleable.SuperButton_alex_shadowColor, ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
        shadowElevation =
            attributeSet.getFloat(R.styleable.SuperButton_alex_shadowElevation, 0f)


        //edge
        topEdgeRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topEdgeRadius, 0f)
           bottomEdgeRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomEdgeRadius, 0f)
           leftEdgeRadius =
            attributeSet.getFloat(R.styleable.SuperButton_alex_leftEdgeRadius, 0f)
           rightEdgeRadius=
            attributeSet.getFloat(R.styleable.SuperButton_alex_rightEdgeRadius, 0f)


        topEdgeDirection =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topEdgeDirection,
                Inside
            )
        bottomEdgeDirection =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomEdgeDirection,
                Inside
            )
        leftEdgeDirection =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_leftEdgeDirection,
                Inside
            )
        rightEdgeDirection=
            attributeSet.getInt(
                R.styleable.SuperButton_alex_rightEdgeDirection,
                Inside
            )


        val shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setBottomLeftCorner(bottomLeftCornerFamily, bottomLeftCornerRadius)
            .setBottomRightCorner(bottomRightCornerFamily, bottomRightCornerRadius)
            .setTopLeftCorner(topLeftCornerFamily, topLeftCornerRadius)
            .setTopRightCorner(topRightCornerFamily, topRightCornerRadius)
            .setTopEdge(TriangleEdgeTreatment(topEdgeRadius,getBoolValueOfEdgeDirection(topEdgeDirection)))
            .setBottomEdge(TriangleEdgeTreatment(bottomEdgeRadius,getBoolValueOfEdgeDirection(bottomEdgeDirection)))
            .setLeftEdge(TriangleEdgeTreatment(leftEdgeRadius,getBoolValueOfEdgeDirection(leftEdgeDirection)))
            .setRightEdge(TriangleEdgeTreatment(rightEdgeRadius,getBoolValueOfEdgeDirection(rightEdgeDirection)))
        .build()

        materialShapeDrawable = MaterialShapeDrawable(shapeAppearanceModel)
        materialShapeDrawable.fillColor = ColorStateList.valueOf(fillColor)
        materialShapeDrawable.strokeColor = ColorStateList.valueOf(strokeColor)
        materialShapeDrawable.strokeWidth = strokeWidth

        materialShapeDrawable.elevation = shadowElevation
        materialShapeDrawable.setShadowColor(shadowcolor)


        materialShapeDrawable.paintStyle = Paint.Style.FILL_AND_STROKE
        materialShapeDrawable.shadowCompatibilityMode =
            MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS

        background = materialShapeDrawable

    }

    private fun getBoolValueOfEdgeDirection(direction: Int): Boolean {
        return direction == Inside

    }
}
