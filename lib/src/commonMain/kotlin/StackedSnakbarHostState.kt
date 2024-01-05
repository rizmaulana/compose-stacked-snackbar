import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import internal.StackedSnackbar
import internal.StackedSnackbarData
import internal.Type
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@Composable
fun StackedSnackbarHost(
    hostState: StackedSnakbarHostState,
    modifier: Modifier = Modifier,
) {
    val firstItemVisible by hostState.newSnackbarHosted.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(hostState.currentSnackbarData) {
        val data = hostState.currentSnackbarData
        data.firstOrNull()?.let {
            delay(it.showDuration.toMillis())
            if (data.size == 1) {
                hostState.newSnackbarHosted.value = false
                delay(500)
                hostState.currentSnackbarData =
                    hostState.currentSnackbarData.toMutableList().apply {
                        remove(it)
                    }
                hostState.newSnackbarHosted.value = true
            }
        }
    }
    if (hostState.currentSnackbarData.isNotEmpty()) {
        StackedSnackbar(
            snackbarData = hostState.currentSnackbarData.toImmutableList(),
            onSnackbarRemoved = {
                hostState.newSnackbarHosted.value = false
                coroutineScope.launch {
                    delay(500)
                    hostState.currentSnackbarData =
                        hostState.currentSnackbarData.toMutableList().apply {
                            removeLastOrNull()
                        }
                    hostState.newSnackbarHosted.value = true
                }
            },
            firstItemVisibility = firstItemVisible,
            maxStack = hostState.maxStack,
            animation = hostState.animation,
            modifier = modifier
        )
    }
}

@Stable
class StackedSnakbarHostState(
    private val coroutinesScope: CoroutineScope,
    val animation: StackedSnackbarAnimation,
    val maxStack: Int = Int.MAX_VALUE
) {

    internal var currentSnackbarData by mutableStateOf<List<StackedSnackbarData>>(emptyList())
    internal val newSnackbarHosted = MutableStateFlow(false)

    fun showInfoSnackbar(
        title: String,
        description: String? = null,
        actionTitle: String? = null,
        action: (() -> Unit)? = null,
        duration: StackedSnackbarDuration = StackedSnackbarDuration.Indefinite
    ) {
        showSnackbar(
            data = StackedSnackbarData.Normal(
                Type.Info, title, description, actionTitle, action, duration
            )
        )
    }

    fun showSuccessSnackbar(
        title: String,
        description: String? = null,
        actionTitle: String? = null,
        action: (() -> Unit)? = null,
        duration: StackedSnackbarDuration = StackedSnackbarDuration.Indefinite
    ) {
        showSnackbar(
            data = StackedSnackbarData.Normal(
                Type.Success, title, description, actionTitle, action, duration
            )
        )
    }

    fun showWarningSnackbar(
        title: String,
        description: String? = null,
        actionTitle: String? = null,
        action: (() -> Unit)? = null,
        duration: StackedSnackbarDuration = StackedSnackbarDuration.Indefinite
    ) {
        showSnackbar(
            data = StackedSnackbarData.Normal(
                Type.Warning, title, description, actionTitle, action, duration
            )
        )
    }

    fun showErrorSnackbar(
        title: String,
        description: String? = null,
        actionTitle: String? = null,
        action: (() -> Unit)? = null,
        duration: StackedSnackbarDuration = StackedSnackbarDuration.Indefinite
    ) {
        showSnackbar(
            data = StackedSnackbarData.Normal(
                Type.Error, title, description, actionTitle, action, duration
            )
        )
    }

    fun showCustomSnackbar(
        content: @Composable (() -> Unit) -> Unit,
        duration: StackedSnackbarDuration = StackedSnackbarDuration.Indefinite
    ) {
        showSnackbar(
            data = StackedSnackbarData.Custom(content, duration)
        )
    }

    private fun showSnackbar(
        data: StackedSnackbarData
    ) {
        newSnackbarHosted.value = false
        currentSnackbarData = currentSnackbarData.toMutableList().apply {
            add(data)
        }
        coroutinesScope.launch {
            delay(1_00)
            newSnackbarHosted.value = true
        }
    }
}

private fun StackedSnackbarDuration.toMillis(): Long = when (this) {
    StackedSnackbarDuration.Short -> 4000L
    StackedSnackbarDuration.Long -> 10000L
    StackedSnackbarDuration.Indefinite -> Long.MAX_VALUE
}