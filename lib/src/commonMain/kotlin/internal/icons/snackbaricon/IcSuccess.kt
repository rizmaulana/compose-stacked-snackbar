package com.astro.stockopname.view.fragment.sync.snackbaricon

import androidx.compose.ui.graphics.Color
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

public val SnackbarIcon.IcSuccess: ImageVector
    get() {
        if (_icSuccess != null) {
            return _icSuccess!!
        }
        _icSuccess = Builder(name = "IcSuccess", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 512.0f, viewportHeight = 512.0f).apply {
            path(fill = SolidColor(SnackbarColor.Success), stroke = SolidColor(SnackbarColor.Success),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(256.0f, 42.667f)
                curveTo(138.18f, 42.667f, 42.667f, 138.18f, 42.667f, 256.0f)
                curveTo(42.667f, 373.82f, 138.18f, 469.333f, 256.0f, 469.333f)
                curveTo(373.82f, 469.333f, 469.333f, 373.82f, 469.333f, 256.0f)
                curveTo(469.333f, 138.18f, 373.82f, 42.667f, 256.0f, 42.667f)
                close()
                moveTo(256.0f, 426.667f)
                curveTo(161.895f, 426.667f, 85.333f, 350.105f, 85.333f, 256.0f)
                curveTo(85.333f, 161.895f, 161.895f, 85.333f, 256.0f, 85.333f)
                curveTo(350.105f, 85.333f, 426.667f, 161.895f, 426.667f, 256.0f)
                curveTo(426.667f, 350.105f, 350.106f, 426.667f, 256.0f, 426.667f)
                close()
                moveTo(336.336f, 179.781f)
                lineTo(366.503f, 209.948f)
                lineTo(234.667f, 342.336f)
                lineTo(155.583f, 263.252f)
                lineTo(185.75f, 233.086f)
                lineTo(234.667f, 282.003f)
                lineTo(336.336f, 179.781f)
                close()
            }
        }
        .build()
        return _icSuccess!!
    }

private var _icSuccess: ImageVector? = null
