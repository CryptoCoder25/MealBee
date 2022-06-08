package com.example.recipebazzar

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recipebazzar.Presentation.Screens.AddEditNote_Page.AddEditNotePage
import com.example.recipebazzar.Presentation.Screens.BMICalculatore_Page.BMICalculatorPage
import com.example.recipebazzar.Presentation.Screens.CheckListNote_Page.CheckListNotePage
import com.example.recipebazzar.Presentation.Screens.Main_Page.MainPage
import com.example.recipebazzar.Presentation.Screens.MealInfo_Page.MealInfoPage
import com.example.recipebazzar.Presentation.Screens.MealsList_Page.MealsListPage
import com.example.recipebazzar.Presentation.Screens.Main_Page.Components.AppBottomItem
import com.example.recipebazzar.Presentation.Screens.OnlineStores_Page.OnlineStorePage
import com.example.recipebazzar.Presentation.ui.theme.RecipeBazzarTheme
import com.example.recipebazzar.Utils.Constants
import com.example.recipebazzar.Utils.Routes

import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val currentScreen= mutableStateOf<AppBottomItem>(AppBottomItem.Home)
        setContent {
            RecipeBazzarTheme {

                val activity = (LocalContext.current as? Activity)
                val systemUiController = rememberSystemUiController()
                val useDarkIcons = MaterialTheme.colors.isLight

                systemUiController.setStatusBarColor(
                    color = Color.White,
                    darkIcons = useDarkIcons
                )
               AppContent(currentScreen, activity)

            }
        }
    }
}

@Composable
fun AppContent( currentScreen : MutableState<AppBottomItem>, activity: Activity?){

    Scaffold() {

        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Routes.MainScreen
        )
        {
            composable(Routes.MainScreen) {
                MainPage(
                    onNavigate = {navController.navigate(it.route)},
                    currentScreen,
                     activity
                )

            }
            composable(route = Routes.MealListScreen + "?category={category}",
                arguments = listOf(
                    navArgument(name = Constants.MealsCategory) {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) {
                MealsListPage(onNavigate = {
                    navController.navigate(it.route)
                }
                )
            }
            composable(route = Routes.MealInfoScreen + "?MEAL_ID={MEAL_ID}",
                arguments = listOf(
                    navArgument(name = Constants.MealsId) {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) {
                MealInfoPage( onPopBackStack = {
                    navController.popBackStack()
                }
                )
            }
            composable(Routes.CheckListNoteScreen) {
                CheckListNotePage(navController)

            }
            composable(route = Routes.AddEditNotePage + "?NOTE_ID={NOTE_ID}&NOTE_COLOR={NOTE_COLOR}",
            arguments = listOf(
                navArgument(name = Constants.NoteId) {
                    type = NavType.IntType
                    defaultValue = -1
                },
                navArgument(name = Constants.NoteColor) {
                    type = NavType.IntType
                    defaultValue = -1
                }

            )
            ) {
                val color = it.arguments?.getInt("noteColor") ?: -1
                AddEditNotePage(navController = navController, color)
        }
            composable(Routes.BMICalculatorScreen) {

                BMICalculatorPage()
            }
            composable(route = Routes.OnlineStoreScreen + "?STORE_CATEGORY={STORE_CATEGORY}",
                arguments = listOf(
                    navArgument(name = Constants.StoreCategory) {
                        type = NavType.StringType
                        defaultValue = ""
                    }
                )
            ) {
                OnlineStorePage(onNavigate = {
                    navController.navigate(it.route)
                }
                )
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RecipeBazzarTheme {
       //RecipeCategory()
    }
}

