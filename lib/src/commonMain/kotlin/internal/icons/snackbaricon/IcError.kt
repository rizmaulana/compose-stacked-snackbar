package com.astro.stockopname.view.fragment.sync.snackbaricon

import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import com.astro.stockopname.view.fragment.sync.SnackbarIcon
import internal.SnackbarColor

public val SnackbarIcon.IcError: ImageVector
    get() {
        if (_icError != null) {
            return _icError!!
        }
        _icError =
            Builder(
                name = "IcError", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 512.0f, viewportHeight = 512.0f,
            ).apply {
                path(
                    fill = SolidColor(SnackbarColor.Error), stroke = SolidColor(SnackbarColor.Error),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd,
                ) {
                    moveTo(256.0f, 42.667f)
                    curveTo(373.61f, 42.667f, 469.333f, 138.39f, 469.333f, 256.0f)
                    curveTo(469.333f, 373.61f, 373.61f, 469.333f, 256.0f, 469.333f)
                    curveTo(138.39f, 469.333f, 42.667f, 373.61f, 42.667f, 256.0f)
                    curveTo(42.667f, 138.39f, 138.39f, 42.667f, 256.0f, 42.667f)
                    close()
                    moveTo(256.0f, 85.333f)
                    curveTo(161.541f, 85.333f, 85.333f, 161.541f, 85.333f, 256.0f)
                    curveTo(85.333f, 350.459f, 161.541f, 426.667f, 256.0f, 426.667f)
                    curveTo(350.459f, 426.667f, 426.667f, 350.459f, 426.667f, 256.0f)
                    curveTo(426.667f, 161.541f, 350.459f, 85.333f, 256.0f, 85.333f)
                    close()
                    moveTo(256.0f, 314.709f)
                    curveTo(271.238f, 314.709f, 282.667f, 325.973f, 282.667f, 341.333f)
                    curveTo(282.667f, 356.693f, 271.238f, 367.957f, 256.0f, 367.957f)
                    curveTo(240.416f, 367.957f, 229.333f, 356.693f, 229.333f, 340.992f)
                    curveTo(229.333f, 325.973f, 240.762f, 314.709f, 256.0f, 314.709f)
                    close()
                    moveTo(277.333f, 128.0f)
                    lineTo(277.333f, 277.333f)
                    lineTo(234.667f, 277.333f)
                    lineTo(234.667f, 128.0f)
                    lineTo(277.333f, 128.0f)
                    close()
                }
            }
                .build()
        return _icError!!
    }

private var _icError: ImageVector? = null
