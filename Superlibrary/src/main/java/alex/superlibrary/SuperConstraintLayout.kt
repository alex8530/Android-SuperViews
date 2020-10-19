package alex.superlibrary

import android.annotation.SuppressLint
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.TriangleEdgeTreatment
import com.superlibrary.R


@SuppressLint("RestrictedApi")
class SuperConstraintLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    companion object {
        var Round = CornerFamily.ROUNDED
        var Cut = CornerFamily.CUT

        var Inside =0
        var OutSide =1
    }

    private var materialShapeDrawableSuper: MaterialShapeDrawable

    private var shadowElevationSuper = 0f
    private var shadowColorSuper = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
    private var fillColorSuper = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
   private var strokeColorSuper = ContextCompat.getColor(
        context,
        R.color.colorPrimary
    )
    private var strokeWidthSuper = 0f

    private var bottomLeftCornerRadiusSuper = 0f
    private var bottomRightCornerRadiusSuper = 0f
    private var topLeftCornerRadiusSuper = 0f
    private var topRightCornerRadiusSuper = 0f

    private var bottomLeftCornerFamilySuper =
        Round
    private var bottomRightCornerFamilySuper =
        Round
    private var topLeftCornerFamilySuper =
        Round
    private var topRightCornerFamilySuper =
        Round


    private var topEdgeRadiusSuper = 0f
    private var bottomEdgeRadiusSuper = 0f
    private var leftEdgeRadiusSuper = 0f
    private var rightEdgeRadiusSuper = 0f

    private var topEdgeDirectionSuper = 0// 0 means inside ,1 means outside
    private var bottomEdgeDirectionSuper = 0// 0 means inside ,1 means outside
    private var leftEdgeDirectionSuper = 0// 0 means inside ,1 means outside
    private var rightEdgeDirectionSuper= 0// 0 means inside ,1 means outside


    init {
        val attributeSet =
            context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.SuperButton, 0, 0
            )

        fillColorSuper = attributeSet.getColor(
            R.styleable.SuperButton_alex_fillColor,
            ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
        )
        strokeColorSuper = attributeSet.getColor(
            R.styleable.SuperButton_alex_strokeColor,
            ContextCompat.getColor(
                context,
                R.color.colorPrimary
            )
        )
        strokeWidthSuper = attributeSet.getFloat(R.styleable.SuperButton_alex_strokeWidth, 0f)

        //corner radius
        bottomLeftCornerRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomLeftCornerRadius, 0f)
        bottomRightCornerRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomRightCornerRadius, 0f)
        topLeftCornerRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topLeftCornerRadius, 0f)
        topRightCornerRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topRightCornerRadius, 0f)

        //corner family
        bottomLeftCornerFamilySuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomLeftCornerFamily,
                Round
            )
        bottomRightCornerFamilySuper=
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomRightCornerFamily,
                Round
            )
        topLeftCornerFamilySuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topLeftCornerFamily,
                Round
            )
        topRightCornerFamilySuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topRightCornerFamily,
                Round
            )

        //shadow
        shadowColorSuper =
            attributeSet.getColor(
                R.styleable.SuperButton_alex_shadowColor, ContextCompat.getColor(
                    context,
                    R.color.colorPrimary
                )
            )
        shadowElevationSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_shadowElevation, 0f)


        //edge
        topEdgeRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_topEdgeRadius, 0f)
           bottomEdgeRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_bottomEdgeRadius, 0f)
           leftEdgeRadiusSuper =
            attributeSet.getFloat(R.styleable.SuperButton_alex_leftEdgeRadius, 0f)
           rightEdgeRadiusSuper=
            attributeSet.getFloat(R.styleable.SuperButton_alex_rightEdgeRadius, 0f)


        topEdgeDirectionSuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_topEdgeDirection,
                Inside
            )
        bottomEdgeDirectionSuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_bottomEdgeDirection,
                Inside
            )
        leftEdgeDirectionSuper =
            attributeSet.getInt(
                R.styleable.SuperButton_alex_leftEdgeDirection,
                Inside
            )
        rightEdgeDirectionSuper=
            attributeSet.getInt(
                R.styleable.SuperButton_alex_rightEdgeDirection,
                Inside
            )


        val shapeAppearanceModel = ShapeAppearanceModel.Builder()
            .setBottomLeftCorner(bottomLeftCornerFamilySuper, bottomLeftCornerRadiusSuper)
            .setBottomRightCorner(bottomRightCornerFamilySuper, bottomRightCornerRadiusSuper)
            .setTopLeftCorner(topLeftCornerFamilySuper, topLeftCornerRadiusSuper)
            .setTopRightCorner(topRightCornerFamilySuper, topRightCornerRadiusSuper)
            .setTopEdge(TriangleEdgeTreatment(topEdgeRadiusSuper,getBoolValueOfEdgeDirection(topEdgeDirectionSuper)))
            .setBottomEdge(TriangleEdgeTreatment(bottomEdgeRadiusSuper,getBoolValueOfEdgeDirection(bottomEdgeDirectionSuper)))
            .setLeftEdge(TriangleEdgeTreatment(leftEdgeRadiusSuper,getBoolValueOfEdgeDirection(leftEdgeDirectionSuper)))
            .setRightEdge(TriangleEdgeTreatment(rightEdgeRadiusSuper,getBoolValueOfEdgeDirection(rightEdgeDirectionSuper)))
        .build()

        materialShapeDrawableSuper = MaterialShapeDrawable(shapeAppearanceModel)
        materialShapeDrawableSuper.fillColor = ColorStateList.valueOf(fillColorSuper)
        materialShapeDrawableSuper.strokeColor = ColorStateList.valueOf(strokeColorSuper)
        materialShapeDrawableSuper.strokeWidth = strokeWidthSuper

        materialShapeDrawableSuper.elevation = shadowElevationSuper
        materialShapeDrawableSuper.setShadowColor(shadowColorSuper)


        materialShapeDrawableSuper.paintStyle = Paint.Style.FILL_AND_STROKE
        materialShapeDrawableSuper.shadowCompatibilityMode =
            MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS

        background = materialShapeDrawableSuper

    }

    private fun getBoolValueOfEdgeDirection(direction: Int): Boolean {
        return direction == Inside

    }
}
