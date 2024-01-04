import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun App() {
    MaterialTheme {
        val radioOptions = listOf(StackedSnackbarAnimation.Bounce, StackedSnackbarAnimation.Slide)
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
        Content(selectedOption, radioOptions, onOptionSelected)
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun Content(
    selectedOption: StackedSnackbarAnimation,
    radioOptions: List<StackedSnackbarAnimation>,
    onOptionSelected: (StackedSnackbarAnimation) -> Unit
) {
    val stackedSnackbarHostState = rememberStackedSnackbarHostState(
        animation = selectedOption,
        maxStack = 5
    )
    Scaffold(
        snackbarHost = {
            StackedSnackbarHost(hostState = stackedSnackbarHostState)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(32.dp)) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Image(
                    painterResource("compose-multiplatform.xml"),
                    null,
                    modifier = Modifier.size(128.dp),
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Animation",
                        style = MaterialTheme.typography.body2.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.weight(1f)
                    )
                    radioOptions.forEach { animation ->
                        Row(
                            Modifier
                                .selectable(
                                    selected = (animation == selectedOption),
                                    onClick = {
                                        onOptionSelected(animation)
                                    }
                                )
                                .padding(horizontal = 8.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            RadioButton(
                                selected = (animation == selectedOption),
                                onClick = { onOptionSelected(animation) }
                            )
                            Text(
                                text = animation.toString(),
                                modifier = Modifier,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                }
                SnackBarButton("Info Snackbar") {
                    stackedSnackbarHostState.showInfoSnackbar(title = "Info Snackbar")
                }
                SnackBarButton("Info Snackbar with Description") {
                    stackedSnackbarHostState.showInfoSnackbar(
                        title = "Info Snackbar",
                        description = "This is sample for style stacked snackbar info with description, we can add long description here",
                    )
                }
                SnackBarButton("Success Snackbar") {
                    stackedSnackbarHostState.showSuccessSnackbar(
                        title = "Success Snackbar",
                        duration = StackedSnackbarDuration.Short
                    )
                }
                SnackBarButton("Warning Snackbar") {
                    stackedSnackbarHostState.showWarningSnackbar(
                        title = "Warning Snackbar",
                        description = "Warning snackbar without action",
                        duration = StackedSnackbarDuration.Short
                    )
                }
                SnackBarButton("Error Snackbar (Description+Action)") {
                    stackedSnackbarHostState.showErrorSnackbar(
                        title = "Error Snackbar",
                        description = "This is sample for style stacked snackbar error with description and action, we can add long description here",
                        actionTitle = "Go to Settings",
                        action = {
                            println("Action button on snackbar clicked!")
                        }
                    )
                }
                SnackBarButton("Custom Snackbar") {
                    stackedSnackbarHostState.showCustomSnackbar(content = { onActionClicked ->
                        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                            Text(
                                text = "This is Custom Stacked Snackbar",
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.body2.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = Color.Black,
                                modifier = Modifier.weight(1f)
                            )
                            Image(
                                Icons.Default.Clear, null,
                                modifier = Modifier.clickable {
                                    onActionClicked.invoke()
                                }
                            )
                        }

                    })
                }
            }
        }

    }
}


@Composable
fun SnackBarButton(title: String, onClick: () -> Unit) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Black),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(title, color = Color.White)
    }
}


