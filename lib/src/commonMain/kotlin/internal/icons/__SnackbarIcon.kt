package com.astro.stockopname.view.fragment.sync

import androidx.compose.ui.graphics.vector.ImageVector
import com.astro.stockopname.view.fragment.sync.snackbaricon.IcError
import com.astro.stockopname.view.fragment.sync.snackbaricon.IcInfo
import com.astro.stockopname.view.fragment.sync.snackbaricon.IcSuccess
import com.astro.stockopname.view.fragment.sync.snackbaricon.IcWarning
import kotlin.collections.List as ____KtList

public object SnackbarIcon

private var __AllIcons: ____KtList<ImageVector>? = null

public val SnackbarIcon.AllIcons: ____KtList<ImageVector>
  get() {
    if (__AllIcons != null) {
      return __AllIcons!!
    }
    __AllIcons= listOf(IcSuccess, IcInfo, IcError, IcWarning)
    return __AllIcons!!
  }
