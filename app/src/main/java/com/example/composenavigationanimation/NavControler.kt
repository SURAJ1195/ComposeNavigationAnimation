package com.example.composenavigationanimation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    launcherScreen: String = Screens.ScreenOne.rout
){
    
    NavHost(navController = navController, startDestination = launcherScreen){
        composable(route = Screens.ScreenOne.rout, enterTransition  = {
            slideIntoContainer(
            AnimatedContentTransitionScope.SlideDirection.Left,
            animationSpec = tween(700)
        )
        }, exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(700)
            )
        }){
            ScreenOne(){
                navController.navigate(Screens.ScreenTwo.rout)
            }
        }

        composable(route = Screens.ScreenTwo.rout,enterTransition  = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Down,
                animationSpec = tween(700)
            )
        }, exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Up,
                animationSpec = tween(700)
            )
        }){
            ScreenTwo(){
                navController.popBackStack()
            }
        }
    }

}


sealed class Screens(val rout:String){
    object ScreenOne:Screens("ScreenOne")
    object ScreenTwo:Screens("ScreenTwo")
}