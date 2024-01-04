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

public val SnackbarIcon.IcInfo: ImageVector
    get() {
        if (_icInfo != null) {
            return _icInfo!!
        }
        _icInfo = Builder(name = "IcInfo", defaultWidth = 800.0.dp, defaultHeight = 800.0.dp,
                viewportWidth = 512.0f, viewportHeight = 512.0f).apply {
            path(fill = SolidColor(SnackbarColor.Info), stroke = SolidColor(SnackbarColor.Info),
                    strokeLineWidth = 1.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                    strokeLineMiter = 4.0f, pathFillType = EvenOdd) {
                moveTo(256.0f, 42.667f)
                curveTo(138.18f, 42.667f, 42.667f, 138.178f, 42.667f, 256.0f)
                curveTo(42.667f, 373.82f, 138.18f, 469.333f, 256.0f, 469.333f)
                curveTo(373.822f, 469.333f, 469.333f, 373.82f, 469.333f, 256.0f)
                curveTo(469.333f, 138.178f, 373.822f, 42.667f, 256.0f, 42.667f)
                close()
                moveTo(256.0f, 426.667f)
                curveTo(161.895f, 426.667f, 85.333f, 350.105f, 85.333f, 256.0f)
                curveTo(85.333f, 161.895f, 161.895f, 85.333f, 256.0f, 85.333f)
                curveTo(350.107f, 85.333f, 426.667f, 161.895f, 426.667f, 256.0f)
                curveTo(426.667f, 350.105f, 350.107f, 426.667f, 256.0f, 426.667f)
                close()
                moveTo(282.713f, 170.667f)
                curveTo(282.713f, 186.134f, 271.452f, 197.333f, 256.217f, 197.333f)
                curveTo(240.365f, 197.333f, 229.38f, 186.134f, 229.38f, 170.371f)
                curveTo(229.38f, 155.22f, 240.663f, 144.0f, 256.217f, 144.0f)
                curveTo(271.452f, 144.0f, 282.713f, 155.22f, 282.713f, 170.667f)
                close()
                moveTo(234.713f, 234.667f)
                lineTo(277.38f, 234.667f)
                lineTo(277.38f, 362.667f)
                lineTo(234.713f, 362.667f)
                lineTo(234.713f, 234.667f)
                close()
            }
        }
        .build()
        return _icInfo!!
    }

private var _icInfo: ImageVector? = null
