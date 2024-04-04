package com.example.stupa

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.stupa.Constants.SCREEN_ANIMATION_TIME_MILLIS

fun NavGraphBuilder.setComposable(
  route: String,
  arguments: List<NamedNavArgument> = emptyList(),
  content: @Composable (NavBackStackEntry) -> Unit
) {
  return composable(
    route = route,
    arguments = arguments,
    content = content
  )
}