# Compose Stacked Snackbar 🗂️
Stacked Snackbar for Compose Multiplatform (Android, iOS and Desktop). This library has built-in basic snackbar type (error, warning, success and info) and also able to accept custom composable snackbar 

![alt text](https://raw.githubusercontent.com/rizmaulana/stacked-snackbar/main/readme_images/cover.png)

![GitHub forks](https://img.shields.io/github/forks/rizmaulana/compose-stacked-snackbar.svg)
![GitHub contributors](https://img.shields.io/github/contributors/rizmaulana/compose-stacked-snackbar.svg)
![GitHub top language](https://img.shields.io/github/languages/top/rizmaulana/compose-stacked-snackbar.svg)
![Visitor](https://visitor-badge.laobi.icu/badge?page_id=rizmaulana.compose-stacked-snackbar)


## Interaction and Animation 
Compose Stacked Snackbar support swipe left or right interaction to dismiss the snackbar
Interaction | Animation Type : Bounce | Animation Type : Slide |
| ---- | ---- | ---- |
| <video src="https://github.com/rizmaulana/compose-stacked-snackbar/assets/7193675/a0a6b4a5-265c-4c51-af6f-d9c38598af1b"/>| <video src="https://github.com/rizmaulana/compose-stacked-snackbar/assets/7193675/3a46923c-f419-49df-8d0d-a1d1cbb35636"/> | <video src="https://github.com/rizmaulana/compose-stacked-snackbar/assets/7193675/2d9e836e-022f-403a-8821-0c55c28a0d16"/> |

## Features
- Built-in basic snackbar type for error, warning, info and success
- Support custom composable snackbar
- Swipe left or right to dismiss
- Built-in bounce and slide animation
- Support custom snackbar action
- Auto dismiss with duration (short and long duration)
- Support max stack configuration
- Easy to use and easy to migrate from default compose snackbar

#### Usage Comparison with Default Compose Snackbar
| Deafult Compose Snackbar | Compose Stacked Snackbar |
| ---- | ---- |
| ![carbon (33)](https://github.com/rizmaulana/compose-stacked-snackbar/assets/7193675/59e343ae-fc7f-4e91-8805-c9a1c166ffb6) | ![carbon (32)](https://github.com/rizmaulana/compose-stacked-snackbar/assets/7193675/a5db62d4-5469-4ba6-8720-be61e718e3a8)|

There is no need to add/manage coroutine scopes to launch compose stacked snackbar, because compose stacked snackbar already has internal coroutine scopes.

## Installation

### Compose Multiplatform
Add this line to shared build.gradle
```kotlin
sourceSets {
  commonMain.dependencies {
    implementation("io.github.rizmaulana:compose-stacked-snackbar:1.0.3")
  }
}
```

If your android version `targetSdk` and `compileSdk` <= 33, you need to add this line on project level build.gradle
```kotlin
subprojects {
    project.configurations.configureEach {
        resolutionStrategy {
            force("androidx.emoji2:emoji2-views-helper:1.3.0")
            force("androidx.emoji2:emoji2:1.3.0")
        }
    }
}
```


### Android
Add this line to app level build.gradle
```kotlin
dependencies {
  implementation "io.github.rizmaulana:compose-stacked-snackbar:1.0.3"
}

// If your android version `targetSdk` and `compileSdk` <= 33, you need to add this line
project.configurations.configureEach {
    resolutionStrategy {
        force("androidx.emoji2:emoji2-views-helper:1.3.0")
        force("androidx.emoji2:emoji2:1.3.0")
    }
}
```

## Usage
#### Basic Usage
```kotlin
val stackedSnackbarHostState = rememberStackedSnackbarHostState()

Scaffolf(
  snackbarHost = { StackedSnackbarHost(hostState = stackedSnackbarHostState)  }
){
  Button(onClick = {
    stackedSnackbarHostState.showInfoSnackbar("Info Snackbar")
  }){
    Text("Click Me!")
  }
}
```
#### Snackbar Configuration
```kotlin
val stackedSnackbarHostState = rememberStackedSnackbarHostState(
  maxStack = 5,
  animation = StackedSnackbarAnimation.Slide
)
```

#### Snackbar Type
```kotlin
stackedSnackbarHostState.showInfoSnackbar("Info Snackbar")

stackedSnackbarHostState.showWarningSnackbar("Warning Snackbar")

stackedSnackbarHostState.showErrorSnackbar("Error Snackbar")

stackedSnackbarHostState.showSuccessSnackbar("Success Snackbar")

stackedSnackbarHostState.showCustomSnackbar(content = { dismiss ->
  Row {
    Text("Custom Snackbar")
    Image(painterResource = "close.xml", modifier = Modifier.clickable { dismiss.invoke() })
  }
})
```

#### Built-In Snackbar Parameter
```kotlin
stackedSnackbarHostState.showInfoSnackbar(
  title = "Info Snackbar",
  description = "Description of Info Snackbar",
  actionLabel = "Go To Settings",
  action = {
    println("Action snackbar clicked")
  },
  duration = StackedSnackbarDuration.Short
)
```
Note : Auto dismiss duration (StackedSnackbarDuration.Short and StackedSnackbarDuration.Long) only works if there is only 1 stacked snackbar, if there are more than 1 stacked snackbar, auto dismiss duration will be disable.

## Contributing
Pull requests are welcome

## Credits
- Snackbar Inspiration by [Emil Kowalski](https://twitter.com/emilkowalski_/status/1503372086038962178)
- Compose Multiplatform Library Template by [KevinnZou](https://github.com/KevinnZou/compose-multiplatform-library-template) 
