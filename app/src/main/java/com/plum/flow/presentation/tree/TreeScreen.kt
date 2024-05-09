package com.plum.flow.presentation.tree

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TreeScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier=Modifier.weight(1F))
        Text(text = "Tree Page")
        Spacer(modifier = Modifier.weight(1F))
    }
}