import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope

@Composable
inline fun rememberStackedSnackbarHostState(
    maxStack: Int = Int.MAX_VALUE,
    animation: StackedSnackbarAnimation = StackedSnackbarAnimation.Bounce,
) = run {
    val scope = rememberCoroutineScope()
    remember {
        StackedSnakbarHostState(animation = animation, maxStack = maxStack, coroutinesScope = scope)
    }
}
