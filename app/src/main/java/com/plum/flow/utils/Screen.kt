package com.plum.flow.utils

sealed class Screen(val route: String) {
    object Login:Screen("/login")
    object Tree:Screen("/tree")
}